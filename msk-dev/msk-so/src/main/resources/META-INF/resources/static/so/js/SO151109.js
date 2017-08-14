/**
 * 会员卡列表JS
 * @author rwf
 */
var $List_Grid;
var SO151109 = {
	
	init : function() {
		$List_Grid = $('#so151109_list_grid').grid({
			actionHandler:SO151109.actionHandler,
		});
	},
	
	actionHandler:function(rowdata,coltype,row,col){
	}
}
$(document).ready(function() {
	// 初始化调用
	SO151109.init();
});
