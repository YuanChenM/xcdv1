
var SO153204 = {
    init : function(){
        $('.tree').treegrid();
        $("#SO153205Id").postUrl(Main.contextPath+"/SO153205/init/");
    }
}
$(document).ready(function() {
    // 初始化调用
    SO153204.init();
});
