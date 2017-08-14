/**
 * 买手订单详情展示
 *
 */
var $List_Grid;
$(function () {
    $("#tabs").tabs();
});
var SO153302 = {
    SO153302Grid: null,
    formId: "SO153302Form",
    init: function () {
        $List_Grid = $('#SO153302_list_grid').grid({
        });
    }
}
$(document).ready(function () {
    // 初始化调用
    SO153302.init();

    $.core.sleep(1000);
    $List_Grid.fnDraw();
});
