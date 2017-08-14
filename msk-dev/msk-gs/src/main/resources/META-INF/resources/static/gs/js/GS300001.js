/**
 * 报表
 *
 * @author gyh
 */
var $List_Grid;
var GS300001 = {
    init: function () {
        $.pdialog.open("销售趋势图", Main.contextPath + "/GS300002/init", {
            width: 1300,
            height: 800
        });
    }
}
$(document).ready(function () {
    // 初始化调用
    GS300001.init();
});
