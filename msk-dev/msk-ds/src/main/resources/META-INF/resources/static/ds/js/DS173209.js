/**
 * 实际入力信息JS
 * Created by yuan_chen on 16/1/13.
 */
var DS173209 = {
    DS173209Grid: null,
    initDataGrid: function () {
        DS173209.DS173209Grid = $('#DS173209_Grid').grid({
            actionHandler:DS173209.actionHandler
        });
    },
    actionHandler:function(rowdata,coltype,row,col){
        if(coltype=="search"){
            $('#main-content').postUrl(Main.contextPath + "/DS173103/init/")};
        }
}
$(document).ready(function () {
    // 初始化调用
    DS173209.initDataGrid();
});