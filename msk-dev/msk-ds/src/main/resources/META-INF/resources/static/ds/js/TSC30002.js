/**
 * 品种产品目录表表
 *
 * @author xhy
 */

var TSC30002 = {
    addButton: "TSC30002_NEW",
    init: function () {
        this.TSC30002Grid = $('#TSC30002_list_grid').grid({
            actionHandler:TSC30002.actionHandler
        });
        this.searchData();
        this.addPlan();
    },
    searchData: function () {
        $("#TSC30002_SEARCH").click(function () {
            TSC30002.TSC30002Grid.fnDraw();
        });
    },
    actionHandler:function(rowdata,coltype,row,col){
        /** 操作按钮 */
        /**查看卖家产品信息*/
        if(coltype == 'edit'){
            $.pdialog.open("更新结算状态", Main.contextPath + "/TSC30004/init", {
                width : 600,
                height : 260
            }, {
            });
        }
    },
    addPlan : function(){
        $("#"+TSC30002.addButton).click(function(){
            $.pdialog.open("新增结算计划", Main.contextPath + "/TSC30003/init", {
                width : 600,
                height : 260
            }, {
            });
        })
    }
};
$(document).ready(function () {
    // 初始化调用
    TSC30002.init();
});
