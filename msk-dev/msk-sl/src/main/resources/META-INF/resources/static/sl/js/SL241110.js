/**
 * 分销章程卖家意见列表JS
 * 
 * @author gyh
 */
var $List_Grid;
var SL241110 = {
	init : function() {
		$List_Grid = $('#SL241110_list_grid').grid({
			fnRowCallback: SL241110.rowCallback
		});
	},
	rowCallback: function (tr, data) {
		var $td = $(tr).children('td').eq(2);
		$td.css('white-space','normal');
	}
}
$(document).ready(function() {
	// 初始化调用
	SL241110.init();
});
