
var DS173211 = {
    DS173211Grid: null,
    initDataGrid: function () {
        DS173211.DS173211Grid = $('#DS173211_Grid').grid({

        });
    }
}
$(document).ready(function () {
    // 初始化调用
    DS173211.initDataGrid();
});