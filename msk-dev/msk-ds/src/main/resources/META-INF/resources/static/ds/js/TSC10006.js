/**
 * 卖家信息列表JS
 * 
 * @author pxg
 */
var TSC10006 = {
	newButtonId : "TSC10006_NEW",
	init : function() {
		$(".group-accordion").accordion({ heightStyle: "'auto'" });
		this.bindSearchButton();
	},
	// 绑定按钮
	bindSearchButton : function() {
		$("#" + TSC10006.newButtonId).click(function() {
			TSC10006.newData();
		});
	}
}
$(document).ready(function() {
	// 初始化调用
	TSC10006.init();
});
