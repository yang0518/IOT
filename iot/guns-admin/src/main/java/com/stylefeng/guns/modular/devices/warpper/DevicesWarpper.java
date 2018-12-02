package com.stylefeng.guns.modular.devices.warpper;

import java.util.List;
import java.util.Map;



import com.stylefeng.guns.core.base.warpper.BaseControllerWarpper;
import com.stylefeng.guns.core.common.constant.factory.ConstantFactory;
import com.stylefeng.guns.core.util.Utils;

/**
 * 设备列表的包装类
 *
 * @author allen
 */
public class DevicesWarpper extends BaseControllerWarpper {

    public DevicesWarpper(Object list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
    	String statusName = ConstantFactory.me().getDeviceStatusName((String) map.get("status"));
        map.put("statusName", statusName);
        String userName ="--";
        if(map.get("userId") != null){
        	userName = ConstantFactory.me().getUserNameById((int)map.get("userId"));
        }
        map.put("userName", userName);
        
        String ratePlanName = (String)map.get("ratePlan");
        int userId = (int)map.get("userId");
        if(userId != 0 && userId != 1) {
        	ratePlanName = ConstantFactory.me().getRatePlanNameByUserId(userId);
        }
        map.put("ratePlanName", ratePlanName);
        
        double ctdDataUsage = (long)map.get("ctdDataUsage");
        ctdDataUsage = ctdDataUsage/1024/1024;
        String ctdDataUsageStr = "0";
        if(ctdDataUsage > 0) {
        	ctdDataUsageStr = String.format("%.3f",ctdDataUsage);
        }
		map.put("ctdDataUsage", ctdDataUsageStr);
		
		String dateSessionEnded = (String)map.get("dateSessionEnded");
		if(dateSessionEnded == null || "".equals(dateSessionEnded.trim()) || "null".equals(dateSessionEnded.trim())) {
			map.put("onOff", "在线");
			map.put("sessionTime", "设备当前在线");
		}else {
			map.put("onOff", "离线");
			String dateSessionStarted = (String)map.get("dateSessionStarted");
			map.put("sessionTime", Utils.getStrTimeForString(dateSessionStarted) +" —— "+Utils.getStrTimeForString(dateSessionEnded));
		}
		
		if(map.get("dateActivated") != null) {
			map.put("dateActivated", Utils.getStrTimeForString((String)map.get("dateActivated")));
		}
        
		if(map.get("dateAdded") != null) {
			map.put("dateAdded", Utils.getStrTimeForString((String)map.get("dateAdded")));
		}
		
    }

}
