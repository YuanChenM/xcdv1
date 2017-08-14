/**
 * 实际入力信息JS
 * Created by yuan_chen on 16/1/13.
 */
var DS173102 = {
    DS173102Grid: null,
    initDataGrid: function () {
        DS173102.DS173102Grid = $('#DS173102_Grid').grid({
            actionHandler:DS173102.actionHandler
        });
    },
    actionHandler:function(rowdata,coltype,row,col){
        if(coltype=="search"){
            $('#main-content').postUrl(Main.contextPath + "/DS173103/init/")};
        }
}
$(document).ready(function () {
    // 初始化调用
    DS173102.initDataGrid();
});