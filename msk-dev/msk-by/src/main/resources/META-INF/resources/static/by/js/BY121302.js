/**
 * 菜场列表JS
 * Created by marshall on 16/3/9.
 */
var BY121302 = {
    saveButtonId:"BY121302_NEW",
    BY121302Grid: null,
    initDataGrid: function () {
        BY121302.BY121302Grid = $('#BY121302_Grid').grid({
            actionHandler: BY121302.actionHandler,
            linkHandler: BY121302.linkHandler
        });
        this.bindSaveButton();
    },
    linkHandler: function (rowdata, coltype, row, col) {
        $('#main-content').postUrl(Main.contextPath + "/BY121303/init/2/" + rowdata.fodMarketId);
    },
    actionHandler: function (rowdata, coltype, row, col) {
        if (coltype == "edit") {
            //跳转到详细页面,修改菜场信息
            $('#main-content').postUrl(Main.contextPath + "/BY121306/init/", {fodMarketId: rowdata.fodMarketId, type:"edit"},{refreshHtml: false});
        }
        if (coltype == "delete") {
            //删除菜场
            $.alertMessage.confirm("你确定要删除这条数据吗？", function() {
                $.alertMessage.close();
                $('#main-content').postUrl(Main.contextPath + "/BY121302/delete/" + rowdata.fodMarketId);
            });
        }
    },

    bindSaveButton:function(){
        $("#" + BY121302.saveButtonId).click(function () {
            //跳转到详细页面,增加菜场信息
            $('#main-content').postUrl(Main.contextPath + "/BY121306/init/", {type:"add"},{refreshHtml: false});
        });
    }
}
$(document).ready(function () {
    // 初始化调用
    BY121302.initDataGrid();
});