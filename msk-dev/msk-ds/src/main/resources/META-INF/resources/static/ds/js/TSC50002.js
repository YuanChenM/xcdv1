/**
 * 品种产品目录表表
 *
 * @author xhy
 */

var TSC50002 = {
    addButton: "TSC30005_SAVE",
    init: function () {
        this.searchData();
    },
    searchData: function () {
        $("#"+TSC50002.addButton).click(function () {
            $.pdialog.close();
        });
    },


};
$(document).ready(function () {
    // 初始化调用
    TSC50002.init();
});
