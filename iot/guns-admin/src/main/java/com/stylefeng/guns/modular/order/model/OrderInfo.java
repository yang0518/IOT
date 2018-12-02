package com.stylefeng.guns.modular.order.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author allen
 * @since 2018-08-30
 */
@TableName("dev_order_info")
public class OrderInfo extends Model<OrderInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 订单编号
     */
    @TableField("order_id")
    private String orderId;
    /**
     * 卡类型
     */
    private String opn;
    /**
     * 资费计划
     */
    @TableField("rate_plan")
    private String ratePlan;
    /**
     * 采购数量
     */
    @TableField("dev_num")
    private Integer devNum;
    /**
     * 订单状态
     */
    private Integer status;
    /**
     * 收货地址
     */
    private String address;
    /**
     * 联系方式
     */
    private String phone;
    /**
     * 联系邮箱
     */
    private String email;
    /**
     * 备注
     */
    private String remarks;
    @TableField("user_id")
    private Long userId;
    /**
     * 订购时间
     */
    @TableField("create_time")
    private Date createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOpn() {
        return opn;
    }

    public void setOpn(String opn) {
        this.opn = opn;
    }

    public String getRatePlan() {
        return ratePlan;
    }

    public void setRatePlan(String ratePlan) {
        this.ratePlan = ratePlan;
    }

    public Integer getDevNum() {
        return devNum;
    }

    public void setDevNum(Integer devNum) {
        this.devNum = devNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
        "id=" + id +
        ", orderId=" + orderId +
        ", opn=" + opn +
        ", ratePlan=" + ratePlan +
        ", devNum=" + devNum +
        ", status=" + status +
        ", address=" + address +
        ", phone=" + phone +
        ", email=" + email +
        ", remarks=" + remarks +
        ", userId=" + userId +
        ", createTime=" + createTime +
        "}";
    }
}
