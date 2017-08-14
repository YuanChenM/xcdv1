/**
 * 卖家审批审核列表JS
 * 
 * @author gyh
 */
var $List_Grid;
var SL241101 = {
	newButtonId : "SL241101_NEW",
	formId:"sl241101FormId",
	init : function() {
		$List_Grid = $('#sl241101_list_grid').grid({
			actionHandler:SL241101.actionHandler
		});
		this.bindSearchButton();
	},
	// 绑定按钮
	bindSearchButton : function() {
		$("#" + SL241101.newButtonId).click(function() {
			SL241101.newData();
		});
	},
	newData : function() {
		formData = getFormData($("#" +SL241101.formId));
		$('#main-content').postUrl(Main.contextPath + "/SL241103000/init/",{slCode:formData.slCode,epId:formData.epId});
	},
	actionHandler:function(rowdata,coltype,row,col){
		/** 操作按钮 */
		if(col==9){
			$('#main-content').postUrl(Main.contextPath + "/SL241103/init/"+rowdata.epId+"/"+rowdata.slCode+"/");
		}
		if(col==11){
			$('#main-content').postUrl(Main.contextPath + "/SL241105/init/check/1",{slCode:rowdata.slCode,slShowName:rowdata.slShowName});
		}
		if(col==10){
			$('#main-content').postUrl(Main.contextPath + "/SL241105/init/check/2",{slCode:rowdata.slCode,slShowName:rowdata.slShowName});
		}
		if(col==12){
			$('#main-content').postUrl(Main.contextPath + "/SL241127/init/"+rowdata.slCode);
		}
		//if(col==12){
		//	$('#main-content').postUrl(Main.contextPath + "/SL241106/init/",{slCode:rowdata.slCode,slShowName:rowdata.slShowName});
		//}
	}
}
$(document).ready(function() {
	// 初始化调用
	SL241101.init();
});
