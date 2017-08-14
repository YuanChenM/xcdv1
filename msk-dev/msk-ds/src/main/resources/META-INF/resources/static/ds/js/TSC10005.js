/**
 * 卖家信息列表JS
 * 
 * @author pxg
 */
var TSC10005 = {
	newButtonId : "TSC10005_NEW",
	init : function() {
		$(".group-accordion").accordion({ heightStyle: "'auto'" });
		this.bindSearchButton();
		this.btnClick();
	},
	// 绑定按钮
	bindSearchButton : function() {
		$("#" + TSC10005.newButtonId).click(function() {
			TSC10005.newData();
		});
	},
	btnClick:function(){
		$("#TSC10005_ADD").click(function(){
			$.pdialog.open("合同订单信息新建", Main.contextPath + "/TSC20034/init", {
				width: 950,
				height: 420
			},{type:1},"TSC20034page");
		});
		$("input[name='TSC10005_ONENAME']").click(function(){
			$.pdialog.open("合同订单信息编辑", Main.contextPath + "/TSC20034/init", {
				width: 950,
				height: 420
			},{type:1},"TSC20034page");
		});
		$("input[name='TSC10005_ONEDELETE']").click(function(){
			$.alertMessage.info("删除成功!");
		});

		$("#TSC10005_ADD2").click(function(){
			$.pdialog.open("合同包材信息新建", Main.contextPath + "/TSC20034/init", {
				width: 950,
				height: 450
			},{type:2},"TSC20035page");
		});
		$("input[name='TSC10005_TWONAME']").click(function(){
			$.pdialog.open("合同包材信息编辑", Main.contextPath + "/TSC20034/init", {
				width: 950,
				height: 450
			},{type:2},"TSC20035page");
		});
		$("input[name='TSC10005_TWODELETE']").click(function(){
			$.alertMessage.info("删除成功!");
		});

		$("#TSC10005_ADD3").click(function(){
			$.pdialog.open("交货期计划信息新建", Main.contextPath + "/TSC20034/init", {
				width: 950,
				height: 300
			},{type:3},"TSC20036page");
		});
		$("input[name='TSC10005_THREENAME']").click(function(){
			$.pdialog.open("合同包材信息编辑", Main.contextPath + "/TSC20034/init", {
				width: 950,
				height: 300
			},{type:3},"TSC20036page");
		});
		$("input[name='TSC10005_THREEDELETE']").click(function(){
			$.alertMessage.info("删除成功!");
		});
	}
}
$(document).ready(function() {
	// 初始化调用
	TSC10005.init();
});
