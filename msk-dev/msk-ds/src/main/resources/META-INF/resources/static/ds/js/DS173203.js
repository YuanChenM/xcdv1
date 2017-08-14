
var DS173203 = {
    DS173203Grid: null,
    initDataGrid: function () {
        DS173203.DS173203Grid = $('#DS173203_Grid').grid({
            //fnRowCallback:DS173203.fnRowCallback
        });
    },
    fnRowCallback:function(tr,data){
        $(tr).children('td').not($(tr).children('td').eq(0)).html("");
        $(tr).children('td').eq(1).html(data.productName);
        $(tr).children('td').eq(2).html(data.productCode);
        $(tr).children('td').eq(3).html(data.productTypeName);
        $(tr).children('td').eq(4).html(data.productFeature);
        $(tr).children('td').eq(5).html(data.productLevel);
        $(tr).children('td').eq(6).html(data.productSpecifical);
        $(tr).children('td').eq(7).html(data.netWeight);
        $(tr).children('td').eq(8).html(data.packageCode);
    }
}
$(document).ready(function () {
    // 初始化调用
    DS173203.initDataGrid();
});