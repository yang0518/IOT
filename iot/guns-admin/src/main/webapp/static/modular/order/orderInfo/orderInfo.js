/**
 * 订单管理初始化
 */
var OrderInfo = {
    id: "OrderInfoTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
OrderInfo.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
            {title: '订单编号', field: 'orderId', visible: true, align: 'center', valign: 'middle'},
            {title: '卡类型', field: 'opn', visible: true, align: 'center', valign: 'middle'},
            {title: '资费计划', field: 'ratePlan', visible: true, align: 'center', valign: 'middle'},
            {title: '采购数量', field: 'devNum', visible: true, align: 'center', valign: 'middle'},
            {title: '订单状态', field: 'status', visible: true, align: 'center', valign: 'middle'},
            {title: '收货地址', field: 'address', visible: true, align: 'center', valign: 'middle'},
            {title: '联系方式', field: 'phone', visible: true, align: 'center', valign: 'middle'},
            {title: '联系邮箱', field: 'email', visible: true, align: 'center', valign: 'middle'},
            {title: '备注', field: 'remarks', visible: true, align: 'center', valign: 'middle'},
            {title: '用户', field: 'userId', visible: true, align: 'center', valign: 'middle'},
            {title: '订购时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
OrderInfo.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        OrderInfo.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加订单
 */
OrderInfo.openAddOrderInfo = function () {
    var index = layer.open({
        type: 2,
        title: '添加订单',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/order/orderInfo_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看订单详情
 */
OrderInfo.openOrderInfoDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '订单详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/order/orderInfo_update/' + OrderInfo.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除订单
 */
OrderInfo.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/order/delete", function (data) {
            Feng.success("删除成功!");
            OrderInfo.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("orderInfoId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询订单列表
 */
OrderInfo.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    OrderInfo.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = OrderInfo.initColumn();
    var table = new BSTable(OrderInfo.id, "/order/list", defaultColunms);
    table.setPaginationType("client");
    OrderInfo.table = table.init();
});
