
var $List_Grid;
var TSC10011 = {
	init : function() {
		$List_Grid = $('#TSC10011_list_grid').grid({
			actionHandler:TSC10011.actionHandler
		});
	},
	actionHandler:function(rowdata,coltype,row,col){

		if(col=='9'){
			$.pdialog.open("发货单明细", Main.contextPath + "/TSC10013/init", {
				width: 1200,
				height: 700
			});
		}
			if(col=='12'){
				$.pdialog.open("运输单", Main.contextPath + "/TSC10016/init", {
					width: 1000,
					height: 600
				});
			}
	}
}
$(document).ready(function() {
	TSC10011.init();
});

