/**
 * 设备详情对话框（可用于修改对话框）
 */
var DevicesInfoDlg = {
	devicesInfoData: {},
	instance : null,
    validateFields: {
        account: {
            validators: {
                notEmpty: {
                    message: '账户不能为空'
                }
            }
        },
        name: {
            validators: {
                notEmpty: {
                    message: '姓名不能为空'
                }
            }
        },
        citySel: {
            validators: {
                notEmpty: {
                    message: '部门不能为空'
                }
            }
        },
        password: {
            validators: {
                notEmpty: {
                    message: '密码不能为空'
                },
                identical: {
                    field: 'rePassword',
                    message: '两次密码不一致'
                },
            }
        },
        rePassword: {
            validators: {
                notEmpty: {
                    message: '密码不能为空'
                },
                identical: {
                    field: 'password',
                    message: '两次密码不一致'
                },
            }
        }
    }
};

/**
 * 清除数据
 */
DevicesInfoDlg.clearData = function () {
    this.devicesInfoData = {};
};

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DevicesInfoDlg.set = function (key, value) {
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
            this.devicesInfoData[key] = ids;
        }else{
            this.devicesInfoData[key]= $("#" + key).val();
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
DevicesInfoDlg.get = function (key) {
    return $("#" + key).val();
};

/**
 * 关闭此对话框
 */
DevicesInfoDlg.close = function () {
    parent.layer.close(window.parent.Devices.layerIndex);
};

/**
 * 点击部门input框时
 *
 * @param e
 * @param treeId
 * @param treeNode
 * @returns
 */
DevicesInfoDlg.onClickUser = function (e, treeId, treeNode) {
    $("#citySel").attr("value", instance.getSelectedVal());
    $("#userid").attr("value", treeNode.id);
};

/**
 * 显示用户选择的树
 *
 * @returns
 */
DevicesInfoDlg.showUserSelectTree = function () {
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
DevicesInfoDlg.showInfoUserSelectTree = function () {
    var cityObj = $("#citySel");
    var cityPosition = $("#citySel").position();
    $("#menuContent").css({
        left: cityPosition.left + "px",
        top: cityPosition.top + cityObj.outerHeight() + "px"
    }).slideDown("fast");

    $("body").bind("mousedown", onBodyDown);
};

/**
 * 隐藏用户选择的树
 */
DevicesInfoDlg.hideUserSelectTree = function () {
    $("#menuContent").fadeOut("fast");
    $("body").unbind("mousedown", onBodyDown);// mousedown当鼠标按下就可以触发，不用弹起
};

/**
 * 收集数据
 */
DevicesInfoDlg.collectData = function () {
    this.set('id').set('iccid').set('status');
};

/**
 * 验证两个密码是否一致
 */
DevicesInfoDlg.validatePwd = function () {
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
DevicesInfoDlg.validate = function () {
    $('#devicesInfoForm').data("bootstrapValidator").resetForm();
    $('#devicesInfoForm').bootstrapValidator('validate');
    return $("#devicesInfoForm").data('bootstrapValidator').isValid();
};

/**
 * 提交添加用户
 */
DevicesInfoDlg.addSubmit = function () {

    this.clearData();
    this.collectData();

    if (!this.validate()) {
        return;
    }

    if (!this.validatePwd()) {
        Feng.error("两次密码输入不一致");
        return;
    }

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/mgr/add", function (data) {
        Feng.success("修改成功!");
        window.parent.Devices.table.refresh();
        DevicesInfoDlg.close();
    }, function (data) {
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.devicesInfoData);
    ajax.start();
    
};

/**
 * 提交状态修改
 */
DevicesInfoDlg.editStatusSubmit = function () {

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/devices/editStatus", function (data) {
        Feng.success("修改成功!");
        if (window.parent.Devices != undefined) {
            window.parent.Devices.table.refresh();
            DevicesInfoDlg.close();
        }
    }, function (data) {
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set('id');
    ajax.set('iccid');
    ajax.set('status');
    ajax.start();
};

/**
 * 提交归属用户修改
 */
DevicesInfoDlg.editUserSubmit = function () {

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/devices/editUser", function (data) {
        Feng.success("修改成功!");
        if (window.parent.Devices != undefined) {
            window.parent.Devices.table.refresh();
            DevicesInfoDlg.close();
        }
    }, function (data) {
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set('id');
    ajax.set('iccid');
    ajax.set('userid');
    ajax.start();
};


function onBodyDown(event) {
    if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(
            event.target).parents("#menuContent").length > 0)) {
        DevicesInfoDlg.hideUserSelectTree();
    }
}

$(function () {
    Feng.initValidator("devicesInfoForm", DevicesInfoDlg.validateFields);

    //初始化设备状态选项
    $("#status").val($("#statusValue").val());

    var ztree = new $ZTree("treeDemo", "/mgr/tree");
    ztree.bindOnClick(DevicesInfoDlg.onClickUser);
    ztree.init();
    instance = ztree;

//    // 初始化头像上传
//    var avatarUp = new $WebUpload("avatar");
//    avatarUp.setUploadBarId("progressBar");
//    avatarUp.init();

});
