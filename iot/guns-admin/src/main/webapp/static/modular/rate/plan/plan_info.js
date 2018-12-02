/**
 * 设备详情对话框（可用于修改对话框）
 */
var PlanInfoDlg = {
	planInfoData: {},
    validateFields: {
    	ratePlan: {
            validators: {
                notEmpty: {
                    message: '资费计划名称不能为空'
                }
            }
        },
        ratePlanCost: {
            validators: {
                notEmpty: {
                    message: '每个订户收费为空'
                }
            }
        },
        ratePlanFlow: {
            validators: {
                notEmpty: {
                    message: '计划内流量不能为空'
                }
            }
        }
    }
};

/**
 * 清除数据
 */
PlanInfoDlg.clearData = function () {
    this.planInfoData = {};
};

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
PlanInfoDlg.set = function (key, value) {
    if(typeof value == "undefined"){
        if(typeof $("#" + key).val() =="undefined"){
            var str="";
            var ids="";
            $("input[name='"+key+"']:checkbox").each(function(){
                if(true == $(this).is(':checked')){
                    str+=$(this).val()+",";
                }
            });
            if(str){
                if(str.substr(str.length-1)== ','){
                    ids = str.substr(0,str.length-1);
                }
            }else{
                $("input[name='"+key+"']:radio").each(function(){
                    if(true == $(this).is(':checked')){
                        ids=$(this).val()
                    }
                });
            }
            this.planInfoData[key] = ids;
        }else{
            this.planInfoData[key]= $("#" + key).val();
        }
    }

    return this;
};

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
PlanInfoDlg.get = function (key) {
    return $("#" + key).val();
};

/**
 * 关闭此对话框
 */
PlanInfoDlg.close = function () {
    parent.layer.close(window.parent.Plan.layerIndex);
};

/**
 * 点击部门input框时
 *
 * @param e
 * @param treeId
 * @param treeNode
 * @returns
 */
PlanInfoDlg.onClickDept = function (e, treeId, treeNode) {
    $("#citySel").attr("value", instance.getSelectedVal());
    $("#deptid").attr("value", treeNode.id);
};

/**
 * 显示部门选择的树
 *
 * @returns
 */
PlanInfoDlg.showDeptSelectTree = function () {
    var cityObj = $("#citySel");
    var cityOffset = $("#citySel").offset();
    $("#menuContent").css({
        left: cityOffset.left + "px",
        top: cityOffset.top + cityObj.outerHeight() + "px"
    }).slideDown("fast");

    $("body").bind("mousedown", onBodyDown);
};

/**
 * 显示用户详情部门选择的树
 *
 * @returns
 */
PlanInfoDlg.showInfoDeptSelectTree = function () {
    var cityObj = $("#citySel");
    var cityPosition = $("#citySel").position();
    $("#menuContent").css({
        left: cityPosition.left + "px",
        top: cityPosition.top + cityObj.outerHeight() + "px"
    }).slideDown("fast");

    $("body").bind("mousedown", onBodyDown);
};

/**
 * 隐藏部门选择的树
 */
PlanInfoDlg.hideDeptSelectTree = function () {
    $("#menuContent").fadeOut("fast");
    $("body").unbind("mousedown", onBodyDown);// mousedown当鼠标按下就可以触发，不用弹起
};

/**
 * 收集数据
 */
PlanInfoDlg.collectData = function () {
    this.set('ratePlan').set('ratePlanCost').set('ratePlanType').set('ratePlanPayType')
    .set('ratePlanId').set('ratePlanFlow').set('userId');
};

/**
 * 验证两个密码是否一致
 */
PlanInfoDlg.validatePwd = function () {
    var password = this.get("password");
    var rePassword = this.get("rePassword");
    if (password == rePassword) {
        return true;
    } else {
        return false;
    }
};

/**
 * 验证数据是否为空
 */
PlanInfoDlg.validate = function () {
    $('#planInfoForm').data("bootstrapValidator").resetForm();
    $('#planInfoForm').bootstrapValidator('validate');
    return $("#planInfoForm").data('bootstrapValidator').isValid();
};

/**
 * 提交添加资费计划
 */
PlanInfoDlg.addSubmit = function () {

    this.clearData();
    this.collectData();

    if (!this.validate()) {
        return;
    }

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/plan/add", function (data) {
        Feng.success("添加成功!");
        window.parent.Plan.table.refresh();
        PlanInfoDlg.close();
    }, function (data) {
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.setContentType("application/json;charset=UTF-8");
//    ajax.setContentType("application/x-www-form-urlencoded;charset=utf-8");
    ajax.set(this.planInfoData);
    ajax.start();
    
};

/**
 * 提交修改
 */
PlanInfoDlg.editSubmit = function () {

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/plan/edit", function (data) {
        Feng.success("修改成功!");
        if (window.parent.Plan != undefined) {
            window.parent.Plan.table.refresh();
            PlanInfoDlg.close();
        }
    }, function (data) {
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set('id');
    ajax.set('iccid');
    ajax.set('status');
    ajax.start();
};


function onBodyDown(event) {
    if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(
            event.target).parents("#menuContent").length > 0)) {
        PlanInfoDlg.hideDeptSelectTree();
    }
}

$(function () {
    Feng.initValidator("planInfoForm", PlanInfoDlg.validateFields);

    //初始化设备状态选项
//    $("#status").val($("#statusValue").val());

//    var ztree = new $ZTree("treeDemo", "/dept/tree");
//    ztree.bindOnClick(PlanInfoDlg.onClickDept);
//    ztree.init();
//    instance = ztree;

//    // 初始化头像上传
//    var avatarUp = new $WebUpload("avatar");
//    avatarUp.setUploadBarId("progressBar");
//    avatarUp.init();

});
