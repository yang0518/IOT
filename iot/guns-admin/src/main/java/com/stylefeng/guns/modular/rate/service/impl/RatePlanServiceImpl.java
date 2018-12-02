package com.stylefeng.guns.modular.rate.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.stylefeng.guns.modular.devices.model.ModifyDevicesDto;
import com.stylefeng.guns.modular.rate.dao.RatePlanMapper;
import com.stylefeng.guns.modular.rate.model.RatePlan;
import com.stylefeng.guns.modular.rate.model.dto.RatePlanDto;
import com.stylefeng.guns.modular.rate.service.IRatePlanService;

/**
 * 设备列表
 *
 * @author allen
 */
@Service
public class RatePlanServiceImpl extends ServiceImpl<RatePlanMapper, RatePlan> implements IRatePlanService {

	@Autowired
    private GunsProperties gunsProperties;
	
    @Resource
    private RatePlanMapper ratePlanMapper;

    @Override
    public List<Map<String, Object>> ratePlanList(Page<RatePlan> page, String userId, String orderByField, boolean isAsc) {
    	
    	return ratePlanMapper.selectRatePlan(page, userId,orderByField, isAsc);
    }
    
    @Override
	public boolean addRatePlan(RatePlanDto ratePlanDto) {
		boolean rs = false;
		if(ratePlanDto != null && ratePlanDto.getRatePlan() != null){
			RatePlan plan = new RatePlan();
			plan.setRatePlan(ratePlanDto.getRatePlan().trim());
			plan.setRatePlanId(ratePlanDto.getRatePlanId()!=null?Integer.parseInt(ratePlanDto.getRatePlanId().trim()):null);
			plan.setRatePlanName(ratePlanDto.getRatePlanName()!=null?ratePlanDto.getRatePlanName().trim():null);
			plan.setRatePlanCost(ratePlanDto.getRatePlanCost()!=null?Integer.parseInt(String.valueOf((int)(Double.parseDouble(ratePlanDto.getRatePlanCost().trim())*100))):0);
			plan.setRatePlanFlow(ratePlanDto.getRatePlanFlow()!=null?Long.parseLong(ratePlanDto.getRatePlanFlow().trim())*1024*1024:0);
			plan.setRatePlanType(Integer.parseInt(ratePlanDto.getRatePlanType().trim()));
			plan.setRatePlanPayType(Integer.parseInt(ratePlanDto.getRatePlanPayType().trim()));
			plan.setUserId(Integer.parseInt(ratePlanDto.getUserId().trim()));
			plan.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			ratePlanMapper.insert(plan);
			
			rs = true;
		}
		
		return rs;
	}

	@Override
	public boolean edit(int id,String iccid,String status) {
//    	Devices devices = this.devicesMapper.selectById(id);
//    	 
//    	//和现有状态相同 不需要修改  直接返回成功
//    	if(status.equals(devices.getStatus())){
//    		return true;
//    	}
//    	
//    	ModifyDevicesDto modifyDevicesDto = new ModifyDevicesDto();
//    	modifyDevicesDto.setIccid(iccid);
//    	modifyDevicesDto.setStatus(status);
//    	boolean result = modifyDevices(modifyDevicesDto);
//    	if(result){
//    		Devices entityDevices = new Devices();
//    		entityDevices.setId(devices.getId());
//    		entityDevices.setStatus(status);
//    		this.devicesMapper.updateById(entityDevices);
//    		return true;
//    	}
    	
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
