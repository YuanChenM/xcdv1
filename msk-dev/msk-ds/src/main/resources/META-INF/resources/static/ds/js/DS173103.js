
var DS173103 = {
    DS173103Grid:null,
    initDataGrid: function () {
        $("a[name='DS173103P']").bind("click", function() {
            $('#main-content').postUrl(Main.contextPath + "/SC183101/init/");
        });
        $("a[name='DS173103A']").bind("click", function() {
            $('#main-content').postUrl(Main.contextPath + "/SC183103/init/");
        });
        $('.tree').treegrid();
    }
}
$(document).ready(function () {
    // 初始化调用
    DS173103.initDataGrid();
});