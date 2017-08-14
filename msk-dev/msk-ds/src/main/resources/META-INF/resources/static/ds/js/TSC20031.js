/**
 * 卖家信息列表JS
 *
 * @author pxg
 */
var $List_Grid;
var TSC20031 = {
    newButtonId : "TSC20031_NEW",
    init : function() {
        $List_Grid = $('#TSC20031_list_grid').grid({
            actionHandler:TSC20031.actionHandler
        });
        this.bindSearchButton();
        this.newData();
    },
    // 绑定按钮
    bindSearchButton : function() {
        $("#" + TSC20031.newButtonId).click(function() {
            TSC20031.newData();
        });
    },
    actionHandler:function(rowdata,coltype,row,col) {
        /** 操作按钮 */
        /**查看卖家产品信息*/
        if (coltype == 'detail') {
           /* $.pdialog.open("订单合同详情", Main.contextPath + "/TSC20032/init", {
                width: 1100,
                height: 500
            });*/
            $.pdialog.open("发货单详情", Main.contextPath + "/TSC20033/init", {
                width: 1100,
                height: 500
            },{type:2},'test');
        }
    },
    newData:function(){
        $("#TSC20031_NEW").click(function(){
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
    TSC20031.init();
});
