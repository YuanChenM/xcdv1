/**
 * 卖家信息列表JS
 * 
 * @author pxg
 */
var TSC20034 = {
	newButtonId : "TSC20034_SAVE",
	closeButtonId : "TSC20034_BACK",
	init : function() {
		$(".group-accordion").accordion({ heightStyle: "'auto'" });
		this.bindSearchButton();
	},
	// 绑定按钮
	bindSearchButton : function() {
		$("#" + TSC20034.newButtonId).click(function() {
			$.alertMessage.info("添加成功!");
			$.pdialog.close("TSC20034page");
		});
		$("#" + TSC20034.closeButtonId).click(function() {
			$.pdialog.close("TSC20034page");
		});
	}
}
$(document).ready(function() {
	// 初始化调用
	TSC20034.init();
});
