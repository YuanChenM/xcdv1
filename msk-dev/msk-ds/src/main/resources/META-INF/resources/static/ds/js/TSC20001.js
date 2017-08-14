/**
 * ��ͬ�б�JS
 *
 * @author pxg
 */
var $List_Grid;
var TSC20001 = {
	init : function() {
		$List_Grid = $('#TSC10004_list_grid').grid({
			actionHandler:TSC20001.actionHandler
		});
	},
	actionHandler:function(rowdata,coltype,row,col){
		/** ������ť */
		/**�鿴���Ҳ�Ʒ��Ϣ*/
		if(coltype=='modifyEOLToEOS'){
			$('#main-content').postUrl(Main.contextPath + "/TSC20001/init2/1");
		}
		if(coltype=='revoke'){
			$('#main-content').postUrl(Main.contextPath + "/TSC20001/init2/2");
		}
		if(coltype=='return'){
			//$('#main-content').postUrl(Main.contextPath + "/TSC20001/init2/3");
			$.pdialog.open("交货计划管理详情", Main.contextPath + "/TSC20033/init", {
				width: 1100,
				height: 500
			});
		}
	}
}
$(document).ready(function() {
	// ��ʼ������
	TSC20001.init();
});
