/**
 * 合同列表JS
 *
 * @author pxg
 */
var $List_Grid;
var TSC20011 = {
	init : function() {
		this.bindClass();
	},
	bindClass:function(){
		$(".editable1").mouseenter(function(a,b){
			var htmlVal=$(this).html();
			$(this).html('<input type="number" min="0" style="width:60px" value="'+htmlVal+'"/>');
		});
		$(".editable1").mouseleave(function(){
			$(this).html($(this).children('input').val());
		});
	}
}
$(document).ready(function() {
	// 初始化调用
	TSC20011.init();
});
