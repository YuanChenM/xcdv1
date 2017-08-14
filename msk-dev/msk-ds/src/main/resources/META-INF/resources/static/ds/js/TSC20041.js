/**
 * ��ⵥһ��JS
 *
 * @author gyh
 */
var $List_Grid;
var TSC20041 = {
    init: function () {
        $List_Grid = $('#TSC20041_list_grid').grid({
            actionHandler: TSC20041.actionHandler
        });
        this.bindButton();
    },
    actionHandler: function (rowdata, coltype, row, col) {
        /** ������ť */
        if (coltype == 'detail') {
            $('#main-content').postUrl(Main.contextPath + "/TSC20041/initDetail");
        }
    },
    bindButton: function () {
        $('#TSC20041_NEW').click(function () {
            $.pdialog.open("入库单新增", Main.contextPath + "/TSC20021/initOther", {
                width: 1100,
                height: 500
            });
        });
    }
}
$(document).ready(function () {
    // ��ʼ������
    TSC20041.init();
});
