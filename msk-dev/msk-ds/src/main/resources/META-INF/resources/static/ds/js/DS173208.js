/**
 * 批次编码生成打印单S
 * Created by yuan_chen on 16/1/13.
 */
var DS173208 = {
    DS173208Grid: null,
    initDataGrid: function () {
        DS173208.DS173208Grid = $('#DS173208_Grid').grid({

        });
    }
}
$(document).ready(function () {
    // 初始化调用
    DS173208.initDataGrid();
});