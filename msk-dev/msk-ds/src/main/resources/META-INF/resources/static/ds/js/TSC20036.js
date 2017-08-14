/**
 * 卖家信息列表JS
 * 
 * @author pxg
 */
var TSC20036 = {
	newButtonId : "TSC20036_SAVE",
	closeButtonId : "TSC20036_BACK",
	init : function() {
		$(".group-accordion").accordion({ heightStyle: "'auto'" });
		this.bindSearchButton();
	},
	// 绑定按钮
	bindSearchButton : function() {
		$("#" + TSC20036.newButtonId).click(function() {
			$.alertMessage.info("添加成功!");
			$.pdialog.close("TSC20036page");
		});
		$("#" + TSC20036.closeButtonId).click(function() {
			$.pdialog.close("TSC20036page");
		});
	}
}
$(document).ready(function() {
	// 初始化调用
	TSC20036.init();
});
