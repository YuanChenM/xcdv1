/**
 * 批发市场列表JS
 * Created by marshall on 16/3/9.
 */
var BY121301 = {
    saveButtonId:"BY121301_NEW",
    BY121301Grid: null,
    initDataGrid: function () {
        BY121301.BY121301Grid = $('#BY121301_Grid').grid({
            actionHandler: BY121301.actionHandler,
            linkHandler: BY121301.linkHandler
        });
        this.bindSaveButton();
    },
    linkHandler: function (rowdata, coltype, row, col) {
        $('#main-content').postUrl(Main.contextPath + "/BY121303/init/1/" + rowdata.terMarketId);
    },
    actionHandler: function (rowdata, coltype, row, col) {
        if (coltype == "edit") {
            //跳转到详细页面,修改批发市场信息
            $('#main-content').postUrl(Main.contextPath + "/BY121305/init/", {terMarketId: rowdata.terMarketId, type:"edit"},{refreshHtml: false});
        }
        if (coltype == "delete") {
            //删除批发市场
            $.alertMessage.confirm("你确定要删除这条数据吗？", function() {
                $.alertMessage.close();
                $('#main-content').postUrl(Main.contextPath + "/BY121301/delete/" + rowdata.terMarketId);
            });
        }
    },
    bindSaveButton:function(){
                $("#" + BY121301.saveButtonId).click(function () {
            //跳转到详细页面,增加批发市场信息
            $('#main-content').postUrl(Main.contextPath + "/BY121305/init/", {type:"add"},{refreshHtml: false});
        });
    }
}
$(document).ready(function () {
    // 初始化调用
    BY121301.initDataGrid();
});