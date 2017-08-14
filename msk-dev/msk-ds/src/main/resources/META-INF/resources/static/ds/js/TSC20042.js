/**
 * 入库单详细JS
 *
 * @author gyh
 */
var $List_Grid;
var TSC20042 = {
	init : function() {
		this.bindButton();
	},
	bindButton:function(){
		$('.detail').click(function(){
			$('#main-content').postUrl(Main.contextPath + "/TSC20041/initPrint");
		});
		$('.toOther').click(function(){
			$.pdialog.open("发货单详情", Main.contextPath + "/TSC20033/init", {
				width: 1100,
				height: 500
			},{type:2});
		});

		$('.toOther1').click(function(){
			$.pdialog.open("合同详情", Main.contextPath + "/TSC10005/init", {
				width: 1100,
				height: 500
			},{type:2});
		});
	}
}
$(document).ready(function() {
	// 初始化调用
	TSC20042.init();
});
