/**
 * 卖家信息列表JS
 *
 * @author pxg
 */
var $List_Grid;
var TSC20032 = {
    newButtonId : "TSC20032_NEW",
    init : function() {
        $List_Grid = $('#TSC20032_list_grid').grid({
            actionHandler:TSC20032.actionHandler
        });
        this.bindSearchButton();
        this.newData();
    },
    // 绑定按钮
    bindSearchButton : function() {
        $("#" + TSC20032.newButtonId).click(function() {
            TSC20032.newData();
        });
    },
    actionHandler:function(rowdata,coltype,row,col) {
        /** 操作按钮 */
        /**查看卖家产品信息*/
        if (coltype == 'detail') {
            $.pdialog.open("发货单详情", Main.contextPath + "/TSC20033/init", {
                width: 1100,
                height: 500
            },null,'testgyh');
        }
    },
    newData:function(){
        $("#TSC20032_NEW").click(function(){
            $.alertMessage.info("此功能稍后开发...");
            /*$.pdialog.open("新增订单合同",Main.contextPath + "/TSC10005/init",{
             width: 1400,
             height: 800
             });*/
        });
    }
}
$(document).ready(function() {
    // 初始化调用
    TSC20032.init();
});
