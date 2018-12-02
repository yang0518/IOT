package com.stylefeng.guns.modular.rate.warpper;

import java.util.List;
import java.util.Map;

import com.stylefeng.guns.core.base.warpper.BaseControllerWarpper;
import com.stylefeng.guns.core.common.constant.factory.ConstantFactory;

/**
 * 设备列表的包装类
 *
 * @author allen
 */
public class RatePlanWarpper extends BaseControllerWarpper {

    public RatePlanWarpper(Object list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
    	
    	if(map.get("ratePlanName") == null){
    		map.put("ratePlanName", map.get("ratePlan"));
    	}
    	if(map.get("ratePlanCost") != null){
    		double ratePlanCost = (int)map.get("ratePlanCost");
    		ratePlanCost = ratePlanCost/100;
    		map.put("ratePlanCost", ratePlanCost);
    	}

    	if(map.get("ratePlanFlow") != null){
    		long ratePlanFlow = (long)map.get("ratePlanFlow");
    		ratePlanFlow = (ratePlanFlow/1024/1024);
    		map.put("ratePlanFlow", ratePlanFlow);
    	}
    	
    	if(map.get("userId") != null){
    		int userId = (int)map.get("userId");
    		if(userId == 0 || userId == 1){
    			map.put("userName", "系统");
    		}else {
    			
    			map.put("userName", ConstantFactory.me().getUserNameById(userId));
    		}
    	}
    	
    	String ratePlanTypeName = ConstantFactory.me().getRatePlanTypeName((int) map.get("ratePlanType"));
        map.put("ratePlanTypeName", ratePlanTypeName);
        String ratePlanPayTypeName = ConstantFactory.me().getRatePlanPayTypeName((int) map.get("ratePlanPayType"));
        map.put("ratePlanPayTypeName", ratePlanPayTypeName);
    }

}
