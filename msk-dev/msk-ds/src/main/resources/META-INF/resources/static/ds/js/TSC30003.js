/**
 * 品种产品目录表表
 *
 * @author xhy
 */

var TSC30003 = {
    addButton: "TSC30003_SAVE",
    init: function () {
        this.searchData();
    },
    searchData: function () {
        $("#"+TSC30003.addButton).click(function () {
            $.pdialog.close();
        });
    },


};
$(document).ready(function () {
    // 初始化调用
    TSC30003.init();
});
