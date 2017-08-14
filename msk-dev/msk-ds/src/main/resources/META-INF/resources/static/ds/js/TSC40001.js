/**
 * 品种产品目录表表
 *
 * @author xhy
 */

var TSC40001 = {
    TSC40001Grid: null,
    init: function () {
        this.TSC40001Grid = $('#TSC40001_list_grid').grid({
                actionHandler:TSC40001.actionHandler
            }
        );
        this.searchData();
    },
    searchData: function () {
        $("#TSC40001_SEARCH").click(function () {
            TSC40001.TSC40001Grid.fnDraw();
        });
    },
    actionHandler:function(rowdata,coltype,row,col){
        /** 操作按钮 */
        /**查看卖家产品信息*/
        if(coltype == 'search'){
            $('#main-content').postUrl(Main.contextPath + "/TSC40002/init/");
        }
    }
};
$(document).ready(function () {
    // 初始化调用
    TSC40001.init();
});
