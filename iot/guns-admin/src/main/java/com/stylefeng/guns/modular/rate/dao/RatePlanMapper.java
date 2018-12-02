package com.stylefeng.guns.modular.rate.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.modular.devices.model.Devices;
import com.stylefeng.guns.modular.rate.model.RatePlan;

/**
 * 角色相关的dao
 *
 */
public interface RatePlanMapper  extends BaseMapper<RatePlan>  {

    /**
     * 根据条件查询资费计划
     *
     * @return
     */
//    List<Map<String, Object>> selectDevices();
    List<Map<String, Object>> selectRatePlan(@Param("page") Page<RatePlan> page, @Param("userId") String userId, @Param("orderByField") String orderByField, @Param("isAsc") boolean isAsc);

    
    RatePlan selectRatePlanByUserId(@Param("userId") int userId);
}
