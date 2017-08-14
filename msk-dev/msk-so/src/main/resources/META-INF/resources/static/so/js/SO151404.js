/**
 *JS
 *@author rwf 
 */
var $List_Grid;
var SO151404 = {
		/*获取form表单信息*/
		formId : "orderDetailChangeForm",
		//定义保存按钮
		SaveButtonId:"SO151404_SAVE",
		//定义取消按钮
		CancelButtonId:"SO151404_CANCEL",
		//初始化调用函数
		initDataGrid : function(){
			this.fileButton();
		},
		fileButton:function(){
			$("#" + SO151404.CancelButtonId).click(function() {
				$.pdialog.close();
			});
			$("#" + SO151404.SaveButtonId).click(function() {
				SO151404.saveData();
			});
		},
		//保存执行操作
		saveData : function() {
			var validator = mainValidation($("#" + SO151404.formId));
			var isValid = validator.form();
		
			if (isValid) {
				$.alertMessage.confirm("你确定要保存当前数据吗？", function() {
					$.alertMessage.close();
					formData = getFormData($("#" +SO151404.formId));
					$('#main-content').postUrl(
							$("#" + SO151404.formId).attr("action"), formData,function() {
								$.pdialog.close();
								// Modify for Bug#2317 at 2016/09/19 by sun_jiaju Start
								$('#main-content').postUrl(Main.contextPath + "/SO151402/init/"+formData.orderId,{enterMark:"init"},Main.hiddenHeader);
								// Modify for Bug#2317 at 2016/09/19 by sun_jiaju End
							});
				});
			}
		}

}
$(document).ready(function() {
	//初始化调用
	SO151404.initDataGrid();
});