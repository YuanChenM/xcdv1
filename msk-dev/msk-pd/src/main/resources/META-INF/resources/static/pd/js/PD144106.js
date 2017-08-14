/**
 * 产品上下架
 *
 * @author yangchunyan
 */
var $List_Grid;
var PD144106 = {
    formId: "PD144106Form",
    searchButton:"PD144106_SEARCH",
    addButton:"PD144106_ADD",
    onButton:"PD144106_ON",
    offButton:"PD144106_OFF",
    init: function () {
        $List_Grid = $('#PD144106_Grid').grid({
            actionHandler: PD144106.actionHandler,
            can_on:PD144106.canOn,
            can_off:PD144106.canOff
        });
        this.bindSelectButton();
        this.bindAddButton();
        FormUtils.setFormValue(PD144106.formId, "PD144106");
        //FormUtils.init(PD144106.formId, "PD144106");
    },
    canOn: function (rowdata){
    if(rowdata.status == '已下架'){
        return true;
    }
    return false;
    },
    canOff: function (rowdata){
        if(rowdata.status == '已上架'){
            return true;
        }
        return false;
    },
    actionHandler: function (rowdata, coltype, row, col) {
        if (coltype == "edit") {
            $('#main-content').postUrl(Main.contextPath + "/PD144107/init/", rowdata)
        }
        if (coltype == "upload") {
            $.alertMessage.confirm("确定上架？", function () {
                rowdata.status = "0";
                rowdata.delFlg = "0";
                $.alertMessage.close();
                $('#main-content').postUrl(Main.contextPath + "/PD144106/update", rowdata,function(data){
                    $List_Grid.fnDraw();
                },{refreshHtml:false},function(){
                    alert("操作失败")
                });
            });
        }
        if (coltype == "download") {
            $.alertMessage.confirm("确定下架？", function () {
                rowdata.status = "1";
                rowdata.delFlg = "0";
                $.alertMessage.close();
                $('#main-content').postUrl(Main.contextPath + "/PD144106/update", rowdata,function(data){
                    $List_Grid.fnDraw();
                },{refreshHtml:false},function(){
                    alert("操作失败")
                });
            });
        }
    },
    bindSelectButton: function () {
    $("#" + PD144106.searchButton).click(function () {
        var formData = getFormData($("#" + PD144106.formId));
        $List_Grid.fnDraw();
    });
   },
    bindAddButton: function () {
        $("#" + PD144106.addButton).click(function () {
            $('#main-content').postUrl(Main.contextPath + "/PD144107/init/", {})
    });
   }
};
$(document).ready(function () {
    // 初始化调用
    PD144106.init();
});