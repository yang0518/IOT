package com.stylefeng.guns.modular.rate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.modular.rate.model.Bill;
import com.stylefeng.guns.modular.rate.service.IBillService;

/**
 * 账单控制器
 *
 * @author fengshuonan
 * @Date 2018-08-30 20:33:49
 */
@Controller
@RequestMapping("/bill")
public class BillController extends BaseController {

    private String PREFIX = "/rate/bill/";

    @Autowired
    private IBillService billService;

    /**
     * 跳转到账单首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "bill.html";
    }

    /**
     * 跳转到添加账单
     */
    @RequestMapping("/bill_add")
    public String billAdd() {
        return PREFIX + "bill_add.html";
    }

    /**
     * 跳转到修改账单
     */
    @RequestMapping("/bill_update/{billId}")
    public String billUpdate(@PathVariable Integer billId, Model model) {
        Bill bill = billService.selectById(billId);
        model.addAttribute("item",bill);
        LogObjectHolder.me().set(bill);
        return PREFIX + "bill_edit.html";
    }

    /**
     * 获取账单列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return billService.selectList(null);
    }

    /**
     * 新增账单
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Bill bill) {
        billService.insert(bill);
        return SUCCESS_TIP;
    }

    /**
     * 删除账单
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer billId) {
        billService.deleteById(billId);
        return SUCCESS_TIP;
    }

    /**
     * 修改账单
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Bill bill) {
        billService.updateById(bill);
        return SUCCESS_TIP;
    }

    /**
     * 账单详情
     */
    @RequestMapping(value = "/detail/{billId}")
    @ResponseBody
    public Object detail(@PathVariable("billId") Integer billId) {
        return billService.selectById(billId);
    }
}
