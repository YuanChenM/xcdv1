
var SP171103 = {
    SP171103Grid: null,
    formId : "SP171103Form",
    initDataGrid: function () {

        SP171103.SP171103Grid = $('#SP171103_Grid').grid({
            actionHandler:SP171103.actionHandler
        });

    },
    actionHandler:function(rowdata,coltype,row,col){
        if(coltype=="edit"){
            $('#main-content').postUrl(Main.contextPath + "/SP171104/init", rowdata)
        };

    }

}
$(document).ready(function () {
    // 初始化调用
    SP171103.initDataGrid();
});