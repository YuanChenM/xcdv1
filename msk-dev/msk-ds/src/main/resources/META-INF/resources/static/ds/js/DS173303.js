/**
 * 实际入力信息JS
 * Created by yuan_chen on 16/1/13.
 */
var DS173303 = {
    DS173303Grid: null,
    initDataGrid: function () {
        DS173303.DS173303Grid = $('#DS173303_Grid').grid({
        });
    }
}
$(document).ready(function () {
    // 初始化调用
    DS173303.initDataGrid();
});