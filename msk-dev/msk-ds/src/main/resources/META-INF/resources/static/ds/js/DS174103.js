/**
 * 卖家产品列表JS
 * Created by yuan_chen on 16/1/13.
 */
var DS174103 = {
    DS174103Grid: null,
    initDataGrid: function () {
        DS174103.DS174103Grid = $('#DS174103_Grid').grid({
            actionHandler: DS174103.actionHandler
        });
    },
    actionHandler: function (rowdata, coltype, row, col) {
        if (coltype == "add") {
            $('#main-content').postUrl(Main.contextPath + "/DS174103/save/", rowdata);
        }
    }
}
$(document).ready(function () {
    // 初始化调用
    DS174103.initDataGrid();
});