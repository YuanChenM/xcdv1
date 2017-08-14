
var DS173213 = {
    initDataGrid: function () {
        this.bindDatePicber('#provideDate');
        this.bindDatePicber('#provideDate2');

    },
    bindDatePicber: function (orderTimeId) {
        $(orderTimeId).datepicker({
            showButtonPanel: true,
            dateFormat: 'yy-mm-dd',
            changeMonth: true,
            changeYear: true,
        });
    }
}
$(document).ready(function () {
    // 初始化调用
    DS173213.initDataGrid();
});