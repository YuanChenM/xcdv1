/**
 * 买家列表JS
 * Created by marshall on 16/3/9.
 */
var BY121303 = {
    BY121303Grid: null,
    addButton:"BY121303_ADD",
    initDataGrid: function () {
        this.addHandler();
        this.showHandler();
        BY121303.BY121303Grid = $('#BY121303_Grid').grid({
            //linkHandler: BY121303.linkHandler,
            actionHandler: BY121303.actionHandler
        });
    },
    //linkHandler: function (rowdata, coltype, row, col) {
    //    $('#main-content').postUrl(Main.contextPath + "/BY121304/init/" + rowdata.buyerId);
    //},
    actionHandler: function (rowdata, coltype, row, col) {
        if (coltype == "edit") {
            //跳转到详细页面,修改买家信息
            $('#main-content').postUrl(Main.contextPath + "/BY121304/init/" + rowdata.buyerId);
        }
        if(coltype == "delete"){
            $.alertMessage.confirm("你确定要删除该买家信息吗？", function () {
                $.alertMessage.close();
                $('#main-content').postUrl(Main.contextPath + "/BY121303/delete/" + rowdata.buyerId,null,function () {
                    BY121303.BY121303Grid.fnDraw();
                }, {refreshHtml: false});
            });
        }
    },
    addHandler: function(){
        $("#" + BY121303.addButton).click(function(){
            var telNo = $("#telNo").val();
            if(telNo == ""){
                $.alertMessage.confirm("请输入买家手机号", function () {
                    $.alertMessage.close();
                });
                return false;
            }else if(telNo.length < 11){
                $.alertMessage.confirm("请输入正确的买家手机号", function () {
                    $.alertMessage.close();
                });
                return false;
            }
            $('#main-content').postUrl(Main.contextPath + "/BY121303/register/" + telNo);
        });
    },
    showHandler: function(){
        var message = $("#message").val();
        if(message && message != ""){
            $.alertMessage.confirm(message, function () {
                $.alertMessage.close();
            });
        }
    }
}
$(document).ready(function () {
    // 初始化调用
    BY121303.initDataGrid();
});