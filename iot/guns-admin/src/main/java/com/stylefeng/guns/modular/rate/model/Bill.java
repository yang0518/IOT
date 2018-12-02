package com.stylefeng.guns.modular.rate.model;

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
@TableName("dev_bill")
public class Bill extends Model<Bill> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 账单所属用户
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 账单设备数量
     */
    @TableField("total_dev_num")
    private Long totalDevNum;
    /**
     * 账单总费用
     */
    @TableField("total_cast_num")
    private Long totalCastNum;
    /**
     * 账单总流量
     */
    @TableField("total_flow_num")
    private Long totalFlowNum;
    /**
     * 账单计费周期
     */
    @TableField("bill_cycle_time")
    private String billCycleTime;
    /**
     * 账单日期
     */
    @TableField("create_time")
    private Date createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTotalDevNum() {
        return totalDevNum;
    }

    public void setTotalDevNum(Long totalDevNum) {
        this.totalDevNum = totalDevNum;
    }

    public Long getTotalCastNum() {
        return totalCastNum;
    }

    public void setTotalCastNum(Long totalCastNum) {
        this.totalCastNum = totalCastNum;
    }

    public Long getTotalFlowNum() {
        return totalFlowNum;
    }

    public void setTotalFlowNum(Long totalFlowNum) {
        this.totalFlowNum = totalFlowNum;
    }

    public String getBillCycleTime() {
        return billCycleTime;
    }

    public void setBillCycleTime(String billCycleTime) {
        this.billCycleTime = billCycleTime;
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
        return "Bill{" +
        "id=" + id +
        ", userId=" + userId +
        ", totalDevNum=" + totalDevNum +
        ", totalCastNum=" + totalCastNum +
        ", totalFlowNum=" + totalFlowNum +
        ", billCycleTime=" + billCycleTime +
        ", createTime=" + createTime +
        "}";
    }
}
