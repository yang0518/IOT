package com.stylefeng.guns.modular.rate.editor;

import java.beans.PropertyEditorSupport;

import com.alibaba.druid.util.StringUtils;
import com.stylefeng.guns.modular.rate.model.RatePlan;

public class RatePlanEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		System.out.println("----RatePlanEditor---input text:"+text);
		RatePlan plan = new RatePlan();
		if (!StringUtils.isEmpty(text)) {
			String[] items = text.split(":");
			plan.setRatePlan(items[0]);
			plan.setRatePlanId(Integer.parseInt(items[1]));
			plan.setRatePlanName(items[2]);
			plan.setRatePlanCost(Integer.parseInt(String.valueOf(Double.parseDouble(items[3])*100)));
			plan.setRatePlanFlow(Integer.parseInt(items[4]));
			plan.setRatePlanType(Integer.parseInt(items[5]));
			plan.setRatePlanPayType(Integer.parseInt(items[6]));
			plan.setUserId(Integer.parseInt(items[7]));
			
		}
		setValue(plan);
	}
	
	@Override
	public String getAsText() {
		return getValue().toString();
	}   
}