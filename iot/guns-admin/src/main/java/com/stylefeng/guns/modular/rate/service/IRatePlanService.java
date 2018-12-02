package com.stylefeng.guns.modular.rate.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.stylefeng.guns.modular.rate.model.RatePlan;
import com.stylefeng.guns.modular.rate.model.dto.RatePlanDto;

/**
 * 资费计划服务
 *
 * @author allen
 */
public interface IRatePlanService extends IService<RatePlan> {

    /**
     * 资费计划列表
     *
     */
	List<Map<String, Object>> ratePlanList(Page<RatePlan> page, String userId, String orderByField, boolean isAsc);

	boolean addRatePlan(RatePlanDto ratePlanDto);
	
	boolean edit(int id,String iccid,String status);
}
