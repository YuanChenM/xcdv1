/**
 * 卖家信息列表JS
 * 
 * @author gyh
 */
var $List_Grid;
var SL241115 = {
	newButtonId : "SL241115_NEW",
	init : function() {
		$List_Grid = $('#sl241101_list_grid').grid({
			actionHandler:SL241115.actionHandler
		});
		this.bindSearchButton();
	},
	// 绑定按钮
	bindSearchButton : function() {
		$("#" + SL241115.newButtonId).click(function() {
			SL241115.newData();
		});
	},
	newData : function() {
		formData = getFormData($("#" +SL241115.formId));
		$('#main-content').postUrl(Main.contextPath + "/SL241103000/init/",{slCode:formData.slCode,epId:formData.epId});
	},
	actionHandler:function(rowdata,coltype,row,col){
		/** 操作按钮 */
		/**查看卖家产品信息*/
		if(coltype=='detail'){
			$('#main-content').postUrl(Main.contextPath + "/SL241116/init/"+rowdata.slCode);
		}else if(coltype == 'edit'){
			$('#main-content').postUrl(Main.contextPath + "/SL24110100/init/",{slCode:rowdata.slCode,epId:rowdata.epId,slAccount:rowdata.slAccount});
		}else if(coltype == 'search'){
			var str = "卖家ID："+rowdata.slCode+"<br/>"+"卖家编码："+rowdata.slCodeDis+"<br/>"+"账号："+rowdata.slAccount+"<br/>"+"密码："+rowdata.accountPsd+"<br/>"+"手机号："+rowdata.slTel+"<br/>";
			$.alertMessage.info(str, function() {
				$.alertMessage.close();
			});
		}else if(coltype == 'insured'){
			$('#main-content').postUrl(Main.contextPath + "/SL241132/init",{slCode:rowdata.slCode});
		}
	}
}
$(document).ready(function() {
	// 初始化调用
	SL241115.init();
});
