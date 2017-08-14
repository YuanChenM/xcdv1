/**
 * 品种产品目录表表
 *
 * @author xhy
 */

var TSC50001 = {
    TSC50001Grid: null,
    init: function () {
        this.TSC50001Grid = $('#TSC50001_list_grid').grid({
                actionHandler:TSC50001.actionHandler
            }
        );
        this.searchData();
    },
    searchData: function () {
        $("#TSC50001_SEARCH").click(function () {
            TSC50001.TSC50001Grid.fnDraw();
        });
    },
    actionHandler:function(rowdata,coltype,row,col){
        /** 操作按钮 */
        /**查看卖家产品信息*/
        if(coltype == 'search'){
            $.pdialog.open("角色详细信息", Main.contextPath + "/TSC50002/init", {
                width : 600,
                height : 260
            }, {
            });
        }
    }
};
$(document).ready(function () {
    // 初始化调用
    TSC50001.init();
});
