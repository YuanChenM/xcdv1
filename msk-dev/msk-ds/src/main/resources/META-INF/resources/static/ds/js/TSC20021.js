/**
 * ��ͬ�б�JS
 *
 * @author pxg
 */
var $List_Grid;
var TSC20021 = {
	init : function() {
		$List_Grid = $('#TSC20021_list_grid').grid({
			actionHandler:TSC20021.actionHandler
		});
	},
	actionHandler:function(rowdata,coltype,row,col){
		/** ������ť */
		if(coltype=='detail'){
			//$('#main-content').postUrl(Main.contextPath + "/TSC20021/init2/3");
			$.pdialog.open("发货单计划详情", Main.contextPath + "/TSC20033/init", {
				width: 1100,
				height: 500
			},{type:1});
		}
	}
}
$(document).ready(function() {
	// ��ʼ������
	TSC20021.init();
});
