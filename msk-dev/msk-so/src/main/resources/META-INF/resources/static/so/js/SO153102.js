/**
 * 买家订单详情展示
 *
 */
var $List_Grid;
$(function () {
    $("#tabs").tabs();
});
var SO153102 = {
    SO153102Grid: null,
    formId: "SO153102Form",
    init: function () {
        $List_Grid = $('#SO153102_list_grid').grid({
        });
    }
}
$(document).ready(function () {
    // 初始化调用
    SO153102.init();

    $.core.sleep(1000);
    $List_Grid.fnDraw();
});
