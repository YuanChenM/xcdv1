/**
 * 卖家信息列表JS
 * 
 * @author pxg
 */
var TSC20035 = {
	newButtonId : "TSC20035_SAVE",
	closeButtonId : "TSC20035_BACK",
	init : function() {
		$(".group-accordion").accordion({ heightStyle: "'auto'" });
		this.bindSearchButton();
	},
	// 绑定按钮
	bindSearchButton : function() {
		$("#" + TSC20035.newButtonId).click(function() {
			$.alertMessage.info("添加成功!");
			$.pdialog.close("TSC20035page");
		});
		$("#" + TSC20035.closeButtonId).click(function() {
			$.pdialog.close("TSC20035page");
		});
	}
}
$(document).ready(function() {
	// 初始化调用
	TSC20035.init();
});
