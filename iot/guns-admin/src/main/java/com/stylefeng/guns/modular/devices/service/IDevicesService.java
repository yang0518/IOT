package com.stylefeng.guns.modular.devices.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.stylefeng.guns.core.base.tips.Tip;
import com.stylefeng.guns.modular.devices.model.Devices;
import com.stylefeng.guns.modular.devices.model.ModifyDevicesDto;

/**
 * 设备服务
 *
 * @author allen
 */
public interface IDevicesService extends IService<Devices> {

    /**
     * 设备列表
     *
     */
	List<Map<String, Object>> devicesList(Page<Devices> page, String beginTime, String endTime, String iccid, String userId,String imei,String imsi,String msisdn,String status, String orderByField, boolean isAsc);

	boolean editStatus(int id,String iccid,String status);
}
