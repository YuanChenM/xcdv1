/**
 * 品种产品目录表表
 *
 * @author xhy
 */

var TSC30004 = {
    addButton: "TSC30004_SAVE",
    init: function () {
        this.searchData();
    },
    searchData: function () {
        $("#"+TSC30004.addButton).click(function () {
            $.pdialog.close();
        });
    },


};
$(document).ready(function () {
    // 初始化调用
    TSC30004.init();
});
