/**
 * 品种产品目录表表
 *
 * @author xhy
 */

var TSC30001 = {
    TSC30001Grid: null,
    init: function () {
        this.TSC30001Grid = $('#TSC30001_list_grid').grid({
                actionHandler:TSC30001.actionHandler
            }
        );
        this.searchData();
    },
    searchData: function () {
        $("#TSC30001_SEARCH").click(function () {
            TSC30001.TSC30001Grid.fnDraw();
        });
    },
    actionHandler:function(rowdata,coltype,row,col){
        /** 操作按钮 */
        /**查看卖家产品信息*/
        if(coltype == 'search'){
            $('#main-content').postUrl(Main.contextPath + "/TSC30002/init/");
           /* $.alertMessage.info(str, function() {
                $.alertMessage.close();
            });*/
        }
    }
};
$(document).ready(function () {
    // 初始化调用
    TSC30001.init();
});
