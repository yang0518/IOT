package com.stylefeng.guns.core.common.constant.state;

/**
 * 设备的状态
 *
 * @author allen
 */
public enum DeviceStatus {
	
	TEST_READY("TEST_READY","可测试"),
	ACTIVATED("ACTIVATED","已激活"),
	ACTIVATION_READY("ACTIVATION_READY", "可激活"),
	DEACTIVATED("DEACTIVATED", "已失效"),
	INVENTORY("INVENTORY", "库存"),
	RETIRED("RETIRED", "已停用");
	
    String code;
    String message;

    DeviceStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
