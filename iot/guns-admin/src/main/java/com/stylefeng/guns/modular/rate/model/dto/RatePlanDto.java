package com.stylefeng.guns.modular.rate.model.dto;

public class RatePlanDto {
	
	private String ratePlan;//资费计划名称
	private String ratePlanId;//资费计划id
	private String ratePlanName;//资费计划中文名称
	private String ratePlanCost;//计划内每个用户收费，单位分
	private String ratePlanFlow;//计划内流量，单位Bit
	private String ratePlanType;//计划类型
  	private String ratePlanPayType;//付款方式
	private String userId;//所属用户，0表示属于系统
	private String createTime;
	
	public String getRatePlan() {
		return ratePlan;
	}
	public void setRatePlan(String ratePlan) {
		this.ratePlan = ratePlan;
	}
	public String getRatePlanId() {
		return ratePlanId;
	}
	public void setRatePlanId(String ratePlanId) {
		this.ratePlanId = ratePlanId;
	}
	public String getRatePlanName() {
		return ratePlanName;
	}
	public void setRatePlanName(String ratePlanName) {
		this.ratePlanName = ratePlanName;
	}
	public String getRatePlanCost() {
		return ratePlanCost;
	}
	public void setRatePlanCost(String ratePlanCost) {
		this.ratePlanCost = ratePlanCost;
	}
	public String getRatePlanFlow() {
		return ratePlanFlow;
	}
	public void setRatePlanFlow(String ratePlanFlow) {
		this.ratePlanFlow = ratePlanFlow;
	}
	public String getRatePlanType() {
		return ratePlanType;
	}
	public void setRatePlanType(String ratePlanType) {
		this.ratePlanType = ratePlanType;
	}
	public String getRatePlanPayType() {
		return ratePlanPayType;
	}
	public void setRatePlanPayType(String ratePlanPayType) {
		this.ratePlanPayType = ratePlanPayType;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
