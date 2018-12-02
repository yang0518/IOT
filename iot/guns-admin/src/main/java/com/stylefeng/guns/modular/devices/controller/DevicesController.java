package com.stylefeng.guns.modular.devices.controller;

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
import com.stylefeng.guns.core.common.constant.factory.ConstantFactory;
import com.stylefeng.guns.core.common.constant.factory.PageFactory;
import com.stylefeng.guns.core.common.exception.BizExceptionEnum;
import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.core.page.PageBT;
import com.stylefeng.guns.core.shiro.ShiroKit;
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
@RequestMapping("/devices")
public class DevicesController extends BaseController {

    private static String PREFIX = "/devices/devicesInfo/";

    @Autowired
    private IDevicesService devicesService;


    /**
     * 跳转到设备列表页面
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "devices.html";
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
		
		Integer user_Id = ShiroKit.getUser().getId();
        if (ToolUtil.isEmpty(user_Id)) {
            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
        }
        if(1 == user_Id) {
        	userId = null;
        }else {
        	userId = String.valueOf(user_Id);
        }

		Page<Devices> page = new PageFactory<Devices>().defaultPage();
        List<Map<String, Object>> result = devicesService.devicesList(page, beginTime, endTime, iccid, userId,imei,imsi,msisdn,status,page.getOrderByField(), !page.isAsc());
        page.setRecords((List<Devices>) new DevicesWarpper(result).warp());
        return super.packForBT(page);
	}
    
    /**
     * 跳转到编辑设备状态页面
     */
//    @Permission
    @RequestMapping("/devices_edit_status/{devicesId}")
    public String DevicesEditStatus(@PathVariable Integer devicesId, Model model) {
        if (ToolUtil.isEmpty(devicesId)) {
            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
        }
        Devices devices = this.devicesService.selectById(devicesId);
        
        Map<String, Object> devicesMap = BeanKit.beanToMap(devices);
        devicesMap = (Map<String, Object>)new DevicesWarpper(devicesMap).warp();
        model.addAttribute("devices", devicesMap);
        model.addAttribute("userName", ConstantFactory.me().getUserNameById(devices.getUserId()));
        LogObjectHolder.me().set(devices);
        return PREFIX + "devices_edit_status.html";
    }
    
    /**
     * 跳转到编辑设备状态页面
     */
//    @Permission
    @RequestMapping("/devices_edit_user/{devicesId}")
    public String DevicesEditUser(@PathVariable Integer devicesId, Model model) {
        if (ToolUtil.isEmpty(devicesId)) {
            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
        }
        Devices devices = this.devicesService.selectById(devicesId);
        
        Map<String, Object> devicesMap = BeanKit.beanToMap(devices);
        devicesMap = (Map<String, Object>)new DevicesWarpper(devicesMap).warp();
        model.addAttribute("devices", devicesMap);
        model.addAttribute("userName", ConstantFactory.me().getUserNameById(devices.getUserId()));
        LogObjectHolder.me().set(devices);
        return PREFIX + "devices_edit_user.html";
    }
    
    
    /**
     * 跳转到查看设备详情页面
     */
//    @Permission
    @RequestMapping("/devices_detail/{devicesId}")
    public String DevicesDetail(@PathVariable Integer devicesId, Model model) {
        if (ToolUtil.isEmpty(devicesId)) {
            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
        }
        Devices devices = this.devicesService.selectById(devicesId);
        
        Map<String, Object> devicesMap = BeanKit.beanToMap(devices);
        devicesMap = (Map<String, Object>)new DevicesWarpper(devicesMap).warp();
        model.addAttribute("devices", devicesMap);
        model.addAttribute("userName", ConstantFactory.me().getUserNameById(devices.getUserId()));
        LogObjectHolder.me().set(devices);
        return PREFIX + "devices_detail.html";
    }
    
    /**
     * 修改设备状态
     *
     * @throws NoPermissionException
     */
    @RequestMapping("/editStatus")
//    @BussinessLog(value = "修改设备", key = "account", dict = UserDict.class)
    @ResponseBody
    public Tip editStatus(@RequestParam(required = false) Integer id,
    				@RequestParam(required = false) String iccid,
    				@RequestParam(required = false) String status
    				) throws NoPermissionException {
    	
        boolean rs =  this.devicesService.editStatus(id,iccid,status);
        
        if(rs){
        	return SUCCESS_TIP;
        }else{
        	return new ErrorTip(9999, "修改失败");
        }
    }
    
    /**
     * 修改设备归属用户
     *
     * @throws NoPermissionException
     */
    @RequestMapping("/editUser")
//    @BussinessLog(value = "修改设备", key = "account", dict = UserDict.class)
    @ResponseBody
    public Tip editUser(@RequestParam(required = false) Long id,
    				@RequestParam(required = false) String iccid,
    				@RequestParam(required = false) String userid
    				) throws NoPermissionException {
    	
    	boolean rs = false;
    	if(id != 0 && iccid != null && userid != null){
    		int userId = Integer.parseInt(userid);
    		Devices devices = this.devicesService.selectById(id);
    		devices.setUserId(userId);
    		rs =  this.devicesService.updateById(devices);
    	}
        
        if(rs){
        	return SUCCESS_TIP;
        }else{
        	return new ErrorTip(9999, "修改失败");
        }
    }
  
    

}
