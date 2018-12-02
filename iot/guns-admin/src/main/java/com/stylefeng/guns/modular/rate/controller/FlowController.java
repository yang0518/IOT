package com.stylefeng.guns.modular.rate.controller;

import java.util.List;
import java.util.Map;

import javax.naming.NoPermissionException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.base.tips.ErrorTip;
import com.stylefeng.guns.core.base.tips.Tip;
import com.stylefeng.guns.core.common.constant.factory.PageFactory;
import com.stylefeng.guns.core.common.exception.BizExceptionEnum;
import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.core.page.PageBT;
import com.stylefeng.guns.core.support.BeanKit;
import com.stylefeng.guns.core.util.ToolUtil;
import com.stylefeng.guns.modular.devices.model.Devices;
import com.stylefeng.guns.modular.devices.model.ModifyDevicesDto;
import com.stylefeng.guns.modular.devices.service.IDevicesService;
import com.stylefeng.guns.modular.devices.warpper.DevicesWarpper;

/**
 * 设备控制器
 * @author allen
 *
 */
@Controller
@RequestMapping("/flow")
public class FlowController extends BaseController {

    private static String PREFIX = "/rate/flow/";

    @Autowired
    private IDevicesService devicesService;


    /**
     * 跳转到设备列表页面
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "flow.html";
    }

    /**
     * 获取设备列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(PageBT pb,@RequestParam(required = false) String iccid,@RequestParam(required = false) String userId,
    		@RequestParam(required = false) String imei,@RequestParam(required = false) String imsi,
    		@RequestParam(required = false) String msisdn,@RequestParam(required = false) String status,
    		@RequestParam(required = false) String beginTime,@RequestParam(required = false) String endTime) {

		System.out.println("-------------Controller----------list---------");
		System.out.println(pb);

		Page<Devices> page = new PageFactory<Devices>().defaultPage();
        List<Map<String, Object>> result = devicesService.devicesList(page, beginTime, endTime, iccid, userId,imei,imsi,msisdn,status,page.getOrderByField(), !page.isAsc());
        page.setRecords((List<Devices>) new DevicesWarpper(result).warp());
        return super.packForBT(page);
	}
    
  
  
    

}
