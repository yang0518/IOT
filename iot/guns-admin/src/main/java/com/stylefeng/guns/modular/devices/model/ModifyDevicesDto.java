package com.stylefeng.guns.modular.devices.model;

public class ModifyDevicesDto {
	
	private String iccid;//设备iccid
	private String effectiveDate;//修改生效时间  yyyy-MM-ddZ 可选
	/*
	 * SIM 卡状态值 
	 * TEST_READY 测试
	 * INVENTORY  库存
	 * ACTIVATION_READY 可激活	
	 * ACTIVATED 已激活 	
	 * RETIRED	已停用
	 * DEACTIVATED 	已失效
	 */
	private String status;
	private String ratePlan;//资费计划的名称
	private String communicationPlan;//通信计划的名称
	private String customer;//客户的名称
	private String deviceID;//账户或客户可为设备分配的可选标识符	
	private String modemID;//调制解调器 ID 号
	/**
	 * 确定设备在达到资费计划中定义的流量上限时的行为。有效值为：
		•  DEFAULT。设备不能超过流量上限。
		•  TEMPORARY_OVERRIDE。设备可以使用任何数量的流量，直到当前计费周期结束，此时 Control Center 将开始实施资费计划中设置的流量上限。
		•  PERMANENT_OVERRIDE。设备可以使用任何数量的流量，不考虑资费计划中定义的流量上限。
	 */
	private String overageLimitOverride;//通信计划的名称
	
	
	public String getIccid() {
		return iccid;
	}
	public void setIccid(String iccid) {
		this.iccid = iccid;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRatePlan() {
		return ratePlan;
	}
	public void setRatePlan(String ratePlan) {
		this.ratePlan = ratePlan;
	}
	public String getCommunicationPlan() {
		return communicationPlan;
	}
	public void setCommunicationPlan(String communicationPlan) {
		this.communicationPlan = communicationPlan;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getDeviceID() {
		return deviceID;
	}
	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}
	public String getModemID() {
		return modemID;
	}
	public void setModemID(String modemID) {
		this.modemID = modemID;
	}
	public String getOverageLimitOverride() {
		return overageLimitOverride;
	}
	public void setOverageLimitOverride(String overageLimitOverride) {
		this.overageLimitOverride = overageLimitOverride;
	}
	
}
