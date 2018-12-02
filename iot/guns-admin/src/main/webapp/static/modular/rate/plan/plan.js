/**
 * 设备的单例
 */
var Plan = {
    id: "planTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Plan.initColumn = function () {
    var columns = [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: 'ratePlan', field: 'ratePlan', visible: false, align: 'center', valign: 'middle'},
        {title: '  资费计划名称    ', field: 'ratePlanName', align: 'center', valign: 'middle'},
        {title: '每个用户收费(元)', field: 'ratePlanCost', align: 'center', valign: 'middle'},
        {title: '计划内流量(MB)', field: 'ratePlanFlow', align: 'center', valign: 'middle'},
        {title: '计划类型', field: 'ratePlanTypeName', align: 'center', valign: 'middle'},
        {title: '用户', field: 'userName', align: 'center', valign: 'middle'},
        {title: '创建时间', field: 'createTime', align: 'center', valign: 'middle'}]
    
    return columns;
};

/**
 * 检查是否选中
 */
Plan.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
    	Plan.seItem = selected[0];
        return true;
    }
};


/**
 * 搜索用户
 */
Plan.search = function () {
    var queryData = {};
    queryData['iccid'] = $("#iccid").val();
    queryData['imei'] = $("#imei").val();
    queryData['msisdn'] = $("#msisdn").val();
    queryData['imsi'] = $("#imsi").val();
    queryData['userId'] = $("#userId").val();
    queryData['status'] = $("#status").val();
    queryData['beginTime'] = $("#beginTime").val();
    queryData['endTime'] = $("#endTime").val();
    Plan.table.refresh({query: queryData});
}

/**
 * 点击添加菜单
 */
Plan.openAddPlan = function () {
    var index = layer.open({
        type: 2,
        title: '添加资费计划',
        area: ['830px', '450px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/plan/plan_add'
    });
    this.layerIndex = index;
};


$(function () {
    var defaultColunms = Plan.initColumn();
    var table = new BSTable(Plan.id, "/plan/list", defaultColunms);
    table.setPaginationType("server");
    table.init();
    Plan.table = table;
});
