/**
 * 账单管理初始化
 */
var Bill = {
    id: "BillTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Bill.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '账单所属用户', field: 'userId', visible: true, align: 'center', valign: 'middle'},
            {title: '账单设备数量', field: 'totalDevNum', visible: true, align: 'center', valign: 'middle'},
            {title: '账单总费用', field: 'totalCastNum', visible: true, align: 'center', valign: 'middle'},
            {title: '账单总流量', field: 'totalFlowNum', visible: true, align: 'center', valign: 'middle'},
            {title: '账单计费周期', field: 'billCycleTime', visible: true, align: 'center', valign: 'middle'},
            {title: '账单日期', field: 'createTime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Bill.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Bill.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加账单
 */
Bill.openAddBill = function () {
    var index = layer.open({
        type: 2,
        title: '添加账单',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/bill/bill_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看账单详情
 */
Bill.openBillDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '账单详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/bill/bill_update/' + Bill.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除账单
 */
Bill.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/bill/delete", function (data) {
            Feng.success("删除成功!");
            Bill.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("billId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询账单列表
 */
Bill.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Bill.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Bill.initColumn();
    var table = new BSTable(Bill.id, "/bill/list", defaultColunms);
    table.setPaginationType("client");
    Bill.table = table.init();
});
