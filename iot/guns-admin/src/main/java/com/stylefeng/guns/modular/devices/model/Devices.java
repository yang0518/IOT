package com.stylefeng.guns.modular.devices.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("dev_devices_info")
public class Devices  extends Model<Devices> {
	
	private static final long serialVersionUID = 1L;
	
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	
	@NotBlank
	private String iccid;//设备的 ICCID
	private String status;//设备的 SIM 卡状态
	@TableField(value = "rate_plan")
	private String ratePlan;//资费计划的名称
	@TableField(value = "communication_plan")
	private String communicationPlan;//通信计划的名称
	
	private String imsi;//设备的 IMSI
	private String msisdn;//设备的 MSISDN 或电话号码
	private String imei;//设备的 IMEI。
	private String customer;//客户名称
	private String endConsumerId;//与此设备关联的人员(如果有)的 ID
	private String dateActivated;//首次激活设备的日期
	private String dateUpdated;//上次更新设备信息的日期
	private String dateShipped;//设备 SIM 卡从运营商库存转移到企业账户的日期
	private String dateAdded;//
	private String accountId;//与设备关联的企业账户的 ID
	private String euiccid;//
	private String operatorCustom1;//运营商在 Control Center 中创建的任何自定义设备字段的值 1-5
	private String operatorCustom2;//
	private String operatorCustom3;//
	private String operatorCustom4;//
	private String operatorCustom5;//
	private String globalSimType;//对于利用 Control Center 的全球 SIM 卡功能的企业，该值指示设备是使用主要运营商的主 SIM 卡还是合作伙伴运营商的虚拟订购
	private String customerCustom1;//客户在 Control Center 中创建的任何自定义设备字段的值
	private String customerCustom2;//
	private String customerCustom3;//
	private String customerCustom4;//
	private String customerCustom5;//
	private String modemID;//标识设备用于传输数据的调制解调器
	private String fixedIPAddress;//如果与设备关联的通信计划使用固定 IP 地址，则为与此设备关联的 IP 地址。如果通信计划使用动态 IP 地址，则此字段将为空
	private String deviceID;//账户或客户可为设备分配的可选标识符
	private String accountCustom1;//企业在 Control Center 中创建的任何自定义设备字段的值 1-10
	private String accountCustom2;//
	private String accountCustom3;//
	private String accountCustom4;//
	private String accountCustom5;//
	private String accountCustom6;//
	private String accountCustom7;//
	private String accountCustom8;//
	private String accountCustom9;//
	private String accountCustom10;//
	private String simNotes;//运营商添加的有关设备的信息
	
	
	private long ctdDataUsage;//自计费周期开始后使用的流量(以字节计)
	private int ctdSMSUsage;//自计费周期开始后的移动台始发消息和移动台终止消息的计数
	private String ctdSessionCount;//自计费周期开始后的数据会话数量
	private int ctdVoiceUsage;//自计费周期开始后使用的通话秒数
    private boolean overageLimitReached;//True/False 值，指示设备是否达到资费计划中设置的流量上限
    /*
     * 指示设备能否超过资费计划中指定的流量上限。可能的值有：
		•  DEFAULT。设备不能超过流量上限。
		•  TEMPORARY_OVERRIDE。设备可以使用任何数量的流量，直到当前计费周期结束，此时 Control Center 将开始实施资费计划中设置的流量上限。
		•  PERMANENT_OVERRIDE。设备可以使用任何数量的流量，不考虑资费计划中定义的流量上限。
     */
    private String overageLimitOverride;
	
    @TableField(value = "flow_num")
	private int flowNum;//该设备套餐流量额度
    @TableField(value = "flow_num_used")
	private int flowNumUsed;//该设备周期使用流量额度
    @TableField(value = "flow_num_real")
	private int flowNumReal;//该设备真实套餐流量额度
    @TableField(value = "user_id")
	private int userId;//该设备所属用户id
    @TableField(value = "date_session_started")
    private String dateSessionStarted;
    @TableField(value = "date_session_ended")
    private String dateSessionEnded;
    @TableField(value = "create_time")
	private String createTime;//该设备入库或者更新的时间
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIccid() {
		return iccid;
	}
	public void setIccid(String iccid) {
		this.iccid = iccid;
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
	public String getImsi() {
		return imsi;
	}
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getEndConsumerId() {
		return endConsumerId;
	}
	public void setEndConsumerId(String endConsumerId) {
		this.endConsumerId = endConsumerId;
	}
	public String getDateActivated() {
		return dateActivated;
	}
	public void setDateActivated(String dateActivated) {
		this.dateActivated = dateActivated;
	}
	public String getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(String dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	public String getDateShipped() {
		return dateShipped;
	}
	public void setDateShipped(String dateShipped) {
		this.dateShipped = dateShipped;
	}
	public String getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getEuiccid() {
		return euiccid;
	}
	public void setEuiccid(String euiccid) {
		this.euiccid = euiccid;
	}
	public String getOperatorCustom1() {
		return operatorCustom1;
	}
	public void setOperatorCustom1(String operatorCustom1) {
		this.operatorCustom1 = operatorCustom1;
	}
	public String getOperatorCustom2() {
		return operatorCustom2;
	}
	public void setOperatorCustom2(String operatorCustom2) {
		this.operatorCustom2 = operatorCustom2;
	}
	public String getOperatorCustom3() {
		return operatorCustom3;
	}
	public void setOperatorCustom3(String operatorCustom3) {
		this.operatorCustom3 = operatorCustom3;
	}
	public String getOperatorCustom4() {
		return operatorCustom4;
	}
	public void setOperatorCustom4(String operatorCustom4) {
		this.operatorCustom4 = operatorCustom4;
	}
	public String getOperatorCustom5() {
		return operatorCustom5;
	}
	public void setOperatorCustom5(String operatorCustom5) {
		this.operatorCustom5 = operatorCustom5;
	}
	public String getGlobalSimType() {
		return globalSimType;
	}
	public void setGlobalSimType(String globalSimType) {
		this.globalSimType = globalSimType;
	}
	public String getCustomerCustom1() {
		return customerCustom1;
	}
	public void setCustomerCustom1(String customerCustom1) {
		this.customerCustom1 = customerCustom1;
	}
	public String getCustomerCustom2() {
		return customerCustom2;
	}
	public void setCustomerCustom2(String customerCustom2) {
		this.customerCustom2 = customerCustom2;
	}
	public String getCustomerCustom3() {
		return customerCustom3;
	}
	public void setCustomerCustom3(String customerCustom3) {
		this.customerCustom3 = customerCustom3;
	}
	public String getCustomerCustom4() {
		return customerCustom4;
	}
	public void setCustomerCustom4(String customerCustom4) {
		this.customerCustom4 = customerCustom4;
	}
	public String getCustomerCustom5() {
		return customerCustom5;
	}
	public void setCustomerCustom5(String customerCustom5) {
		this.customerCustom5 = customerCustom5;
	}
	public String getModemID() {
		return modemID;
	}
	public void setModemID(String modemID) {
		this.modemID = modemID;
	}
	public String getFixedIPAddress() {
		return fixedIPAddress;
	}
	public void setFixedIPAddress(String fixedIPAddress) {
		this.fixedIPAddress = fixedIPAddress;
	}
	public String getDeviceID() {
		return deviceID;
	}
	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}
	public String getAccountCustom1() {
		return accountCustom1;
	}
	public void setAccountCustom1(String accountCustom1) {
		this.accountCustom1 = accountCustom1;
	}
	public String getAccountCustom2() {
		return accountCustom2;
	}
	public void setAccountCustom2(String accountCustom2) {
		this.accountCustom2 = accountCustom2;
	}
	public String getAccountCustom3() {
		return accountCustom3;
	}
	public void setAccountCustom3(String accountCustom3) {
		this.accountCustom3 = accountCustom3;
	}
	public String getAccountCustom4() {
		return accountCustom4;
	}
	public void setAccountCustom4(String accountCustom4) {
		this.accountCustom4 = accountCustom4;
	}
	public String getAccountCustom5() {
		return accountCustom5;
	}
	public void setAccountCustom5(String accountCustom5) {
		this.accountCustom5 = accountCustom5;
	}
	public String getAccountCustom6() {
		return accountCustom6;
	}
	public void setAccountCustom6(String accountCustom6) {
		this.accountCustom6 = accountCustom6;
	}
	public String getAccountCustom7() {
		return accountCustom7;
	}
	public void setAccountCustom7(String accountCustom7) {
		this.accountCustom7 = accountCustom7;
	}
	public String getAccountCustom8() {
		return accountCustom8;
	}
	public void setAccountCustom8(String accountCustom8) {
		this.accountCustom8 = accountCustom8;
	}
	public String getAccountCustom9() {
		return accountCustom9;
	}
	public void setAccountCustom9(String accountCustom9) {
		this.accountCustom9 = accountCustom9;
	}
	public String getAccountCustom10() {
		return accountCustom10;
	}
	public void setAccountCustom10(String accountCustom10) {
		this.accountCustom10 = accountCustom10;
	}
	public String getSimNotes() {
		return simNotes;
	}
	public void setSimNotes(String simNotes) {
		this.simNotes = simNotes;
	}
	public long getCtdDataUsage() {
		return ctdDataUsage;
	}
	public void setCtdDataUsage(long ctdDataUsage) {
		this.ctdDataUsage = ctdDataUsage;
	}
	public int getCtdSMSUsage() {
		return ctdSMSUsage;
	}
	public void setCtdSMSUsage(int ctdSMSUsage) {
		this.ctdSMSUsage = ctdSMSUsage;
	}
	public String getCtdSessionCount() {
		return ctdSessionCount;
	}
	public void setCtdSessionCount(String ctdSessionCount) {
		this.ctdSessionCount = ctdSessionCount;
	}
	public int getCtdVoiceUsage() {
		return ctdVoiceUsage;
	}
	public void setCtdVoiceUsage(int ctdVoiceUsage) {
		this.ctdVoiceUsage = ctdVoiceUsage;
	}
	public boolean isOverageLimitReached() {
		return overageLimitReached;
	}
	public void setOverageLimitReached(boolean overageLimitReached) {
		this.overageLimitReached = overageLimitReached;
	}
	public String getOverageLimitOverride() {
		return overageLimitOverride;
	}
	public void setOverageLimitOverride(String overageLimitOverride) {
		this.overageLimitOverride = overageLimitOverride;
	}
	public int getFlowNum() {
		return flowNum;
	}
	public void setFlowNum(int flowNum) {
		this.flowNum = flowNum;
	}
	public int getFlowNumUsed() {
		return flowNumUsed;
	}
	public void setFlowNumUsed(int flowNumUsed) {
		this.flowNumUsed = flowNumUsed;
	}
	public int getFlowNumReal() {
		return flowNumReal;
	}
	public void setFlowNumReal(int flowNumReal) {
		this.flowNumReal = flowNumReal;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	@Override
	protected Serializable pkVal() {
		return this.id;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	public String getDateSessionStarted() {
		return dateSessionStarted;
	}
	public void setDateSessionStarted(String dateSessionStarted) {
		this.dateSessionStarted = dateSessionStarted;
	}
	public String getDateSessionEnded() {
		return dateSessionEnded;
	}
	public void setDateSessionEnded(String dateSessionEnded) {
		this.dateSessionEnded = dateSessionEnded;
	}
	
	
	
}
