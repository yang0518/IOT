/**
 * 设备的单例
 */
var Flow = {
    id: "flowTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Flow.initColumn = function () {
    var columns = [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: 'status', field: 'status', visible: false, align: 'center', valign: 'middle'},
        {title: 'ICCID', field: 'iccid', align: 'center', valign: 'middle'},
        {title: 'SIM卡状态', field: 'statusName', align: 'center', valign: 'middle'},
        {title: '周期累计用量(MB)', field: 'ctdDataUsage', align: 'center', valign: 'middle'},
        {title: '短信条数', field: 'ctdSMSUsage', align: 'center', valign: 'middle'},
        {title: '激活时间', field: 'dateActivated', align: 'center', valign: 'middle'},
        {title: '客户', field: 'customer', align: 'center', valign: 'middle'},
        {title: '创建时间', field: 'dateAdded', align: 'center', valign: 'middle'}]
    
    return columns;
};

/**
 * 检查是否选中
 */
Flow.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
    	Flow.seItem = selected[0];
        return true;
    }
};


/**
 * 搜索用户
 */
Flow.search = function () {
    var queryData = {};
    queryData['iccid'] = $("#iccid").val();
    queryData['imei'] = $("#imei").val();
    queryData['msisdn'] = $("#msisdn").val();
    queryData['imsi'] = $("#imsi").val();
    queryData['userId'] = $("#userId").val();
    queryData['status'] = $("#status").val();
    queryData['beginTime'] = $("#beginTime").val();
    queryData['endTime'] = $("#endTime").val();
    Flow.table.refresh({query: queryData});
}


$(function () {
    var defaultColunms = Flow.initColumn();
    var table = new BSTable(Flow.id, "/flow/list", defaultColunms);
    table.setPaginationType("server");
    table.init();
    Flow.table = table;
});
