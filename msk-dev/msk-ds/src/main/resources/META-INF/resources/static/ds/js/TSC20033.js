/**
 * 卖家信息列表JS
 * 
 * @author pxg
 */
var TSC20033 = {
	newButtonId : "TSC20033_NEW",
	init : function() {
		$(".group-accordion").accordion({ heightStyle: "'auto'" });
		this.bindSearchButton();
		this.bindClass();
	},
	// 绑定按钮
	bindSearchButton : function() {
		$("#" + TSC20033.newButtonId).click(function() {
			TSC20033.newData();
		});
		$("#TSC20033_SEARCH").click(function() {
			$.pdialog.open("待运期计划详细", Main.contextPath + "/TSC20001/init2/2", {
				width: 1100,
				height: 500
			},null,"pageId");
		});
	},
	bindClass:function(){
		$(".editable").mouseenter(function(a,b){
			var htmlVal=$(this).html();
			$(this).html('<input type="text" min="0" style="width:60px" value="'+htmlVal+'"/>');
		});
		$(".editable").mouseleave(function(){
			$(this).html($(this).children('input').val());
		});
	}
}
$(document).ready(function() {
	// 初始化调用
	debugger;
	TSC20033.init();
});
