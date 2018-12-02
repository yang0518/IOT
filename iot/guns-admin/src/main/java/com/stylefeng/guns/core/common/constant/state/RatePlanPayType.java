package com.stylefeng.guns.core.common.constant.state;

/**
 * 资费计划支付类型
 *
 * @author allen
 * @Date 2017年1月10日 下午9:54:13
 */
public enum RatePlanPayType {

    PAY_MONTH(1, "月付"), PAY_PRE(2, "预付");
    int code;
    String message;

    RatePlanPayType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String valueOf(Integer value) {
        if (value == null) {
            return "";
        } else {
            for (RatePlanPayType ms : RatePlanPayType.values()) {
                if (ms.getCode() == value) {
                    return ms.getMessage();
                }
            }
            return "";
        }
    }
}
