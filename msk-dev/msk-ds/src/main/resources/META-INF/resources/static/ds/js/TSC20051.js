/**
 * 品种产品目录表表
 *
 * @author xhy
 */

var TSC20051 = {
    TSC20051Grid: null,
    init: function () {
        this.TSC20051Grid = $('#TSC20051_list_grid').grid({
                actionHandler:TSC20051.actionHandler
            }
        );
        this.searchData();
    },
    searchData: function () {
        $("#TSC20051_SEARCH").click(function () {
            TSC20051.TSC20051Grid.fnDraw();
        });
    },
    actionHandler:function(rowdata,coltype,row,col){
        if(coltype == 'search'){
            $('#main-content').postUrl(Main.contextPath + "/TSC20052/init/");
        }
    }
};
$(document).ready(function () {
    // 初始化调用
    TSC20051.init();
});
