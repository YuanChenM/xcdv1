/**
 * 卖家交易记录
 *
 */
var $List_Grid;
$(function () {
    $("#tabs").tabs();
});
var SO153202 = {
    SO153202Grid: null,
    formId: "SO153202Form",
    selectCode:$("#selectCode").val(),
    init: function () {
        $List_Grid = $('#SO153202_list_grid').grid({
            selectCodeList: SO153202.selectCodeList
        });
    },
    selectCodeList: function()
    {

    }
}
$(document).ready(function () {
    // 初始化调用
    SO153202.init();

    $.core.sleep(1000);
    $List_Grid.fnDraw();
});
