package com.stylefeng.guns.modular.rate.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("dev_rate_plan")
public class RatePlan  extends Model<RatePlan> {
	
	private static final long serialVersionUID = 1L;
	
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	
	@NotBlank
	@TableField(value = "rate_plan")
	private String ratePlan;//资费计划名称
	@TableField(value = "rate_plan_id")
	private int ratePlanId;//资费计划id
	@TableField(value = "rate_plan_name")
	private String ratePlanName;//资费计划中文名称
    @TableField(value = "rate_plan_cost")
	private int ratePlanCost;//计划内每个用户收费，单位分
    @TableField(value = "rate_plan_flow")
	private long ratePlanFlow;//计划内流量，单位Bit
    @TableField(value = "rate_plan_type")
	private int ratePlanType;//计划类型
    @TableField(value = "rate_plan_pay_type")
  	private int ratePlanPayType;//付款方式
    @TableField(value = "user_id")
	private int userId;//所属用户，0表示属于系统
    @TableField(value = "create_time")
	private String createTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRatePlan() {
		return ratePlan;
	}
	public void setRatePlan(String ratePlan) {
		this.ratePlan = ratePlan;
	}
	public int getRatePlanId() {
		return ratePlanId;
	}
	public void setRatePlanId(int ratePlanId) {
		this.ratePlanId = ratePlanId;
	}
	public String getRatePlanName() {
		return ratePlanName;
	}
	public void setRatePlanName(String ratePlanName) {
		this.ratePlanName = ratePlanName;
	}
	public int getRatePlanCost() {
		return ratePlanCost;
	}
	public void setRatePlanCost(int ratePlanCost) {
		this.ratePlanCost = ratePlanCost;
	}
	public long getRatePlanFlow() {
		return ratePlanFlow;
	}
	public void setRatePlanFlow(long ratePlanFlow) {
		this.ratePlanFlow = ratePlanFlow;
	}
	public int getRatePlanType() {
		return ratePlanType;
	}
	public void setRatePlanType(int ratePlanType) {
		this.ratePlanType = ratePlanType;
	}
	public int getRatePlanPayType() {
		return ratePlanPayType;
	}
	public void setRatePlanPayType(int ratePlanPayType) {
		this.ratePlanPayType = ratePlanPayType;
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
	
	
	
}
