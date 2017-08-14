
var DS173204 = {
    DS173204Grid: null,
    initDataGrid: function () {
        DS173204.DS173204Grid = $('#DS173204_Grid').grid({

        });
    }
}
$(document).ready(function () {
    // 初始化调用
    DS173204.initDataGrid();
});