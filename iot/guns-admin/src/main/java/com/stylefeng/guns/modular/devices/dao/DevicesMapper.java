package com.stylefeng.guns.modular.devices.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.modular.devices.model.Devices;
import com.stylefeng.guns.modular.system.model.OperationLog;

/**
 * 角色相关的dao
 *
 */
public interface DevicesMapper  extends BaseMapper<Devices>  {

    /**
     * 根据条件查询设备列表
     *
     * @return
     */
//    List<Map<String, Object>> selectDevices();
    List<Map<String, Object>> selectDevices(@Param("page") Page<Devices> page, @Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("iccid") String iccid, @Param("userId") String userId,@Param("imei") String imei,@Param("imsi") String imsi,@Param("msisdn") String msisdn,@Param("status") String status, @Param("orderByField") String orderByField, @Param("isAsc") boolean isAsc);

    
    
}
