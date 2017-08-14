

/**
 * 实际入力信息JS
 * Created by yuan_chen on 16/1/13.
 */
var $List_Grid;
var TSC10001 = {
    newButtonId : "TSC10001_NEW",
    initDataGrid: function () {
        this.bindSearchButton();
       /* TSC10001.TSC10001Grid = $('#TSC10001_Grid').grid({
            actionHandler:TSC10001.actionHandler
        });*/
        /*$TSC10001Grid=$('#TSC10001_Grid').grid({
            actionHandler:TSC10001.actionHandler
        });*/
        $List_Grid = $('#TSC10001_Grid').grid({
            actionHandler:TSC10001.actionHandler
        });
    },
    actionHandler:function(rowdata,coltype,row,col){
       if(coltype=="detail"){
            $('#main-content').postUrl(Main.contextPath + "/TSC10002/init", rowdata)
        };
        if(coltype=="edit"){
            $.pdialog.open("状态更新",Main.contextPath + "/TSC10003/init",{
                width: 350,
                height: 100
            });
        };
        /* if(coltype=="delete"){
            $.alertMessage.confirm("你确定要删除这条数据吗？", function() {
                $.alertMessage.close();
                $('#main-content').postUrl(Main.contextPath + "/SC182101/delete", rowdata);
            });
        }*/

    },

    bindSearchButton : function() {
        $("#" + TSC10001.newButtonId).click(function() {
            TSC10001.newData();
        });
    },
    newData : function() {
        /*formData = getFormData($("#" +TSC10001.formId));
        $('#main-content').postUrl(Main.contextPath + "/TSC10002/init",{zbid:"0"});*/
        $("#TSC10001_NEW").click(function(){
            $.alertMessage.info("后续开发...");})
    }
}
$(document).ready(function () {
    debugger;
    // 初始化调用
    TSC10001.initDataGrid();
});