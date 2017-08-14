
var DS173212 = {
    DS173212Grid: null,
    initDataGrid: function () {
        DS173212.DS173212Grid = $('#DS173212_Grid').grid({
            fnRowCallback:DS173212.fnRowCallback
        });
    },
    fnRowCallback:function(tr,data){

    }
}
$(document).ready(function () {
    // 初始化调用
    DS173212.initDataGrid();
});