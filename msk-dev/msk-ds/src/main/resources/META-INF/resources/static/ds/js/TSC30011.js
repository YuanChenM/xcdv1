/**
 */
var TSC30011 = {
    TSC30011Grid: null,
    initDataGrid: function () {
        TSC30011.TSC30011Grid = $('#TSC30011_Grid').grid({
            actionHandler:TSC30011.actionHandler
        });
    },
    actionHandler:function(rowdata,coltype,row,col){
        if (coltype =="export") {
            $('#main-content').postUrl(Main.contextPath + "/TSC30012/init/", {
            });
        }
    }
}
$(document).ready(function () {
    // 初始化调用
    TSC30011.initDataGrid();
});
