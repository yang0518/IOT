package com.stylefeng.guns.modular.devices.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.config.properties.GunsProperties;
import com.stylefeng.guns.core.util.OkHttpUtil;
import com.stylefeng.guns.modular.devices.dao.DevicesMapper;
import com.stylefeng.guns.modular.devices.model.Devices;
import com.stylefeng.guns.modular.devices.model.ModifyDevicesDto;
import com.stylefeng.guns.modular.devices.service.IDevicesService;

/**
 * 设备列表
 *
 * @author allen
 */
@Service
public class DevicesServiceImpl extends ServiceImpl<DevicesMapper, Devices> implements IDevicesService {

	@Autowired
    private GunsProperties gunsProperties;
	
    @Resource
    private DevicesMapper devicesMapper;

    @Override
    public List<Map<String, Object>> devicesList(Page<Devices> page, String beginTime, String endTime, String iccid, String userId,String imei,String imsi,String msisdn,String status, String orderByField, boolean isAsc) {
    	if(status == null || "ALL".equals(status)){
    		status = "";
    	}
    	
    	return devicesMapper.selectDevices(page, beginTime, endTime, iccid, userId, imei, imsi, msisdn, status, orderByField, isAsc);
    }
    
    @Override
	public boolean editStatus(int id,String iccid,String status) {
    	Devices devices = this.devicesMapper.selectById(id);
    	 
    	//和现有状态相同 不需要修改  直接返回成功
    	if(status.equals(devices.getStatus())){
    		return true;
    	}
    	
    	ModifyDevicesDto modifyDevicesDto = new ModifyDevicesDto();
    	modifyDevicesDto.setIccid(iccid);
    	modifyDevicesDto.setStatus(status);
    	boolean result = modifyDevices(modifyDevicesDto);
    	if(result){
    		devices.setStatus(status);
    		this.devicesMapper.updateById(devices);
    		return true;
    	}
    	
		return false;
	}
    
    private boolean modifyDevices(ModifyDevicesDto modifyDevicesDto){
    	String url = gunsProperties.getIotapiBaseUrl()+"modifyDevices";
    	String jsonParams = JSON.toJSONString(modifyDevicesDto);
    	String result = OkHttpUtil.postJsonParams(url, jsonParams);
    	JSONObject jsonResult = JSON.parseObject(result);
    	if("0000".equals(jsonResult.getString("respCode"))){
    		return true;
    	}
    	
    	return false;
    }


	public static void main(String[] args) {
//		new DevicesServiceImpl().devicesList();
	}
    
}
