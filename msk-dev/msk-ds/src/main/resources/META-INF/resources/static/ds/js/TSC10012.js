
var $List_Grid;
var TSC10012 = {
	init : function() {
		$List_Grid = $('#TSC10012_list_grid').grid({
			actionHandler:TSC10012.actionHandler
		});
	},
	actionHandler:function(rowdata,coltype,row,col){
		if(col=='16'){
			$.pdialog.open("付款申请", Main.contextPath + "/TSC10015/init", {
				width: 1100,
				height: 600
			});
		}
	}
}
$(document).ready(function() {
	TSC10012.init();
});
