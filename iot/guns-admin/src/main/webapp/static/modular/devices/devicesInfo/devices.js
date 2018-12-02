/**
 * 设备的单例
 */
var Devices = {
    id: "devicesTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Devices.initColumn = function () {
    var columns = [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: 'status', field: 'status', visible: false, align: 'center', valign: 'middle'},	
        {title: 'ICCID', field: 'iccid', align: 'center', valign: 'middle'},
        {title: '在线状态', field: 'onOff', align: 'center', valign: 'middle'},
        {title: 'SIM卡状态', field: 'statusName', align: 'center', valign: 'middle'},
        {title: '周期累计用量(MB)', field: 'ctdDataUsage', align: 'center', valign: 'middle'},
        {title: 'IMEI', field: 'imei', align: 'center', valign: 'middle'},
        {title: 'MSISDN', field: 'msisdn', align: 'center', valign: 'middle'},
        {title: 'IMSI', field: 'imsi', align: 'center', valign: 'middle'},
        {title: '激活时间', field: 'dateActivated', align: 'center', valign: 'middle'},
        {title: '用户', field: 'userName', align: 'center', valign: 'middle'},
        {title: '创建时间', field: 'dateAdded', align: 'center', valign: 'middle'}]
    
    return columns;
};

/**
 * 检查是否选中
 */
Devices.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
    	Devices.seItem = selected[0];
        return true;
    }
};

/**
 * 检查设备状态是否失效
 */
Devices.checkStatus = function () {
    if(this.check()){
    	var selected = $('#' + this.id).bootstrapTable('getSelections');
    	var status = selected[0].status;
    	if(status == "DEACTIVATED"){
    		Feng.info("选中的设备状态已经失效，不能在更改了！");
    		return false;
    	}else{
    		return true;
    	}
    }
    return false;
};

/**
 * 点击修改状态按钮时
 * @param userId 管理员id
 */
Devices.editStatus = function () {
    if (this.checkStatus()) {
        var index = layer.open({
            type: 2,
            title: '编辑设备',
            area: ['800px', '450px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/devices/devices_edit_status/' + this.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 点击修改归属用户按钮时
 * @param userId 管理员id
 */
Devices.editUser = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '编辑设备',
            area: ['800px', '450px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/devices/devices_edit_user/' + this.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 点击查看详情按钮时
 * @param userId 管理员id
 */
Devices.detail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '编辑设备',
            area: ['800px', '450px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/devices/devices_detail/' + this.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 发放首冲佣金
 */
Devices.openChangeShouChong = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '修改角色',
            area: ['800px', '450px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/role/role_edit/' + this.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 发放激活佣金
 */
Devices.openChangeJiHuo = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '修改角色',
            area: ['800px', '450px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/role/role_edit/' + this.seItem.id
        });
        this.layerIndex = index;
    }
};


/**
 * 搜索用户
 */
Devices.search = function () {
    var queryData = {};
    queryData['iccid'] = $("#iccid").val();
    queryData['imei'] = $("#imei").val();
    queryData['msisdn'] = $("#msisdn").val();
    queryData['imsi'] = $("#imsi").val();
    queryData['userId'] = $("#userId").val();
    queryData['status'] = $("#status").val();
    queryData['beginTime'] = $("#beginTime").val();
    queryData['endTime'] = $("#endTime").val();
    Devices.table.refresh({query: queryData});
}

/**
 * 导出数据
 */
Devices.exportData = function () {
    var queryData = {};
    queryData['name'] = $("#name").val();
    queryData['deptName'] = $("#deptName").val();
    queryData['joinerName'] = $("#joinerName").val();
    queryData['cardId'] = $("#cardId").val();
    queryData['mobileNum'] = $("mobileNum").val();
    queryData['status'] = $("#status").val();
    queryData['beginTime'] = $("#beginTime").val();
    queryData['endTime'] = $("#endTime").val();
  
    
    var index = layer.load(0, {
    	time: 2000,
    	shade: [0.5,'#fff'] //0.1透明度的白色背景
    });
    
    var param = "";
    if($("#name").val() != ''){
    	if(param != "")
    		param += "&";
    	param += "name="+$("#name").val();
    }
    if($("#deptName").val() != ''){
    	if(param != "")
    		param += "&";
    	param += "deptName="+$("#deptName").val();
    }
    if($("#joinerName").val() != ''){
    	if(param != "")
    		param += "&";
    	param += "joinerName="+$("#joinerName").val();
    }
    if($("#cardId").val() != ''){
    	if(param != "")
    		param += "&";
    	param += "cardId="+$("#cardId").val();
    }
    if($("#status").val() != ''){
    	if(param != "")
    		param += "&";
    	param += "status="+$("#status").val();
    }
    if($("#beginTime").val() != ''){
    	if(param != "")
    		param += "&";
    	param += "beginTime="+$("#beginTime").val();
    }
    if($("#endTime").val() != ''){
    	if(param != "")
    		param += "&";
    	param += "endTime="+$("#endTime").val();
    }
    if(param != "")
		param = "?"+param;
    console.log("-----------"+param);
    window.location.href=Feng.ctxPath + "/devices/export"+param;
//    layer.close(index);
    
}

$(function () {
    var defaultColunms = Devices.initColumn();
    var table = new BSTable(Devices.id, "/devices/list", defaultColunms);
    table.setPaginationType("server");
    table.init();
    Devices.table = table;
});
