
var DS173201 = {
    DS173201Grid: null,
    initDataGrid: function () {
        DS173201.DS173201Grid = $('#DS173201_Grid').grid({
            actionHandler:DS173201.actionHandler
        });
    },
    actionHandler:function(rowdata,coltype,row,col) {
        if(col == 7){
            $('#main-content').postUrl(Main.contextPath + "/DS173211/init/");
        }else if(col == 6){
            $('#main-content').postUrl(Main.contextPath + "/DS173204/init/");
        }else if(col == 4){
            $('#main-content').postUrl(Main.contextPath + "/DS173202/init/");
        }else if(col == 5){
            $('#main-content').postUrl(Main.contextPath + "/DS173203/init/");
        }else if(col == 9){
            $('#main-content').postUrl(Main.contextPath + "/SC182102/init/");
        }else if(col == 8){
            $('#main-content').postUrl(Main.contextPath + "/DS173208/init/");
        }else if(col == 10){
            $('#main-content').postUrl(Main.contextPath + "/DS173212/init/");
        }else if(col == 11){
            $('#main-content').postUrl(Main.contextPath + "/DS173306/init/");
        }
    }
}
$(document).ready(function () {
    // 初始化调用
    DS173201.initDataGrid();
});