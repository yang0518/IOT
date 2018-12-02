package com.stylefeng.guns.modular.rate.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
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
import com.stylefeng.guns.core.page.PageBT;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.util.ToolUtil;
import com.stylefeng.guns.modular.rate.editor.RatePlanEditor;
import com.stylefeng.guns.modular.rate.model.RatePlan;
import com.stylefeng.guns.modular.rate.model.dto.RatePlanDto;
import com.stylefeng.guns.modular.rate.service.IRatePlanService;
import com.stylefeng.guns.modular.rate.warpper.RatePlanWarpper;

/**
 * 资费计划控制器
 * @author allen
 *
 */
@Controller
@RequestMapping("/plan")
public class RatePlanController extends BaseController {

    private static String PREFIX = "/rate/plan/";

    @Autowired
    private IRatePlanService ratePlanService;


    /**
     * 跳转到资费计划列表页面
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "plan.html";
    }
    
    /**
     * 跳转到菜单列表列表页面
     */
    @RequestMapping(value = "/plan_add")
    public String planAdd() {
        return PREFIX + "plan_add.html";
    }


    /**
     * 获取资费计划列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(PageBT pb,@RequestParam(required = false) String userId,
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

		Page<RatePlan> page = new PageFactory<RatePlan>().defaultPage();
        List<Map<String, Object>> result = ratePlanService.ratePlanList(page,userId,page.getOrderByField(), !page.isAsc());
        page.setRecords((List<RatePlan>) new RatePlanWarpper(result).warp());
        return super.packForBT(page);
	}
    
    
//    @Permission(Const.ADMIN_NAME)
//    @BussinessLog(value = "资费计划新增", key = "name", dict = MenuDict.class)
    @RequestMapping(value = "/add")
    @ResponseBody
    public Tip add(@RequestBody RatePlanDto ratePlanDto) {
//        if (result.hasErrors()) {
//        	List<FieldError> list = result.getFieldErrors();
//        	for(FieldError error:list){
//        		System.out.println("-----------errors-------Code:"+error.getCode()+"--Field:"+error.getField()+"---mgs:"+error.getDefaultMessage());
//        	}
//        	
//            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
//        }
        boolean rs = this.ratePlanService.addRatePlan(ratePlanDto);
        if(rs){
        	return SUCCESS_TIP;
        }else{
        	return new ErrorTip(9999, "修改失败");
        }
    }

    
//    @RequestMapping("/devices_edit/{devicesId}")
//    public String DevicesEdit(@PathVariable Integer devicesId, Model model) {
//        if (ToolUtil.isEmpty(devicesId)) {
//            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
//        }
//        Devices devices = this.devicesService.selectById(devicesId);
//        
//        Map<String, Object> devicesMap = BeanKit.beanToMap(devices);
//        devicesMap = (Map<String, Object>)new DevicesWarpper(devicesMap).warp();
//        model.addAttribute("devices", devicesMap);
//        LogObjectHolder.me().set(devices);
//        return PREFIX + "devices_edit.html";
//    }
  
   
    @InitBinder  
    protected void initBinder(WebDataBinder binder) {
    	binder.registerCustomEditor(RatePlan.class, new RatePlanEditor());
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));  
//        binder.registerCustomEditor(boolean.class, new CustomBooleanEditor(true));
//        binder.registerCustomEditor(int.class, new CustomNumberEditor(int.class, true));
//        binder.registerCustomEditor(long.class, new CustomNumberEditor(long.class, true));
//        binder.registerCustomEditor(float.class, new CustomNumberEditor(float.class, true));
//        binder.registerCustomEditor(double.class, new CustomNumberEditor(double.class, true));
//        binder.addValidators(validators);
    } 

}
