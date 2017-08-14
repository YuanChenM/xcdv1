
var SP171104 = {
    SP171104Grid: null,
    formId : "SP171104Form",
    saveButtonId : "SP171104_SAVE",
    confirmButtonId : "SP171104_CONFIRM",
    initDataGrid: function () {
        this.bindSaveButton();
        this.bindConfirmButton();

        SP171104.SP171104Grid = $('#SP171104_Grid').grid({
            actionHandler:SP171104.actionHandler
        });
    },
    bindSaveButton : function() {
        $("#" + SP171104.saveButtonId).click(function() {
            //SP171104.saveData();
        });
    },
    bindConfirmButton : function() {
        $("#" + SP171104.confirmButtonId).click(function() {
            //SP171104.modifyData();
        });
    },
    actionHandler:function(rowdata,coltype,row,col){
        if(coltype=="edit"){
            $('#main-content').postUrl(Main.contextPath + "/SP171103/init", rowdata)
        };

    }
}
$(document).ready(function () {
    // 初始化调用
    SP171104.initDataGrid();
});