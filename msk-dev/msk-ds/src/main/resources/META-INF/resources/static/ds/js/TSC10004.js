/**
 * 卖家信息列表JS
 * 
 * @author pxg
 */
var $List_Grid;
var TSC10004 = {
	newButtonId : "TSC10004_NEW",
	init : function() {
		$List_Grid = $('#TSC10004_list_grid').grid({
			actionHandler:TSC10004.actionHandler
		});
		this.bindSearchButton();
		this.newData();
	},
	// 绑定按钮
	bindSearchButton : function() {
		$("#" + TSC10004.newButtonId).click(function() {
			TSC10004.newData();
		});
	},
	actionHandler:function(rowdata,coltype,row,col) {
		/** 操作按钮 */
		/**查看卖家产品信息*/
		debugger;
		if (coltype == 'detail') {
			$.pdialog.open("订单合同详情", Main.contextPath + "/TSC10005/init", {
				width: 1100,
				height: 500
			});
		}else if(coltype == 'check'){
			$.pdialog.open("合同状态更改", Main.contextPath + "/TSC10006/init", {
				width: 400,
				height: 200
			});
		}else if(col==9){
			$('#main-content').postUrl(Main.contextPath + "/TSC20001/init2/1", {
				admin:1
			});
		}
		else if(col==10){
			$('#main-content').postUrl(Main.contextPath + "/TSC20001/init2/2", {
				admin:2
			});
		}
		else if(col==11){
			$('#main-content').postUrl(Main.contextPath + "/TSC20038/init", {
			});
		}
		else if(col==12){
			$.pdialog.open("发货单计划详情", Main.contextPath + "/TSC20033/init", {
				width: 1100,
				height: 500
			},{type:2});
		}
		else if(col==13){
			$.pdialog.open("入库单计划详情", Main.contextPath + "/TSC20041/initDetail", {
				width: 1100,
				height: 400
			});
		}
		else if(col==14){
			$.pdialog.open("发货单差异单计划详情", Main.contextPath + "/TSC20052/init", {
				width: 1100,
				height: 500
			});
		}
		else if(col==15){
			$('#main-content').postUrl(Main.contextPath + "/TSC30002/init", {
				admin:1
			});
		}
		else if(col==16){
			$('#main-content').postUrl(Main.contextPath + "/TSC30012/init", {
				admin:1
			});
		}
	},
	newData:function(){
		$("#TSC10004_NEW").click(function(){
			$.alertMessage.info("此功能稍后开发...");
			/*$.pdialog.open("新增订单合同",Main.contextPath + "/TSC10005/init",{
				width: 1400,
				height: 800
			});*/
		});
	}
}
$(document).ready(function() {
	// 初始化调用
	TSC10004.init();
});
