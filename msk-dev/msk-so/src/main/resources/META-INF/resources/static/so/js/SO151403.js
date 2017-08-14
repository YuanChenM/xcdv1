/**
 *JS
 *@author rwf 
 */
var $List_Grid;
var SO151403 = {
		/*获取form表单信息*/
		formId : "orderChangeForm",
		//定义保存按钮
		SaveButtonId:"SO151403_SAVE",
		//定义取消按钮
		CancelButtonId:"SO151403_CANCEL",
		//初始化调用函数
		initDataGrid : function(){
			this.fileButton();
			this.checkNum();
		},
		fileButton:function(){
			$("#" + SO151403.CancelButtonId).click(function() {
				$.pdialog.close();
			});
			$("#" + SO151403.SaveButtonId).click(function() {
				SO151403.saveData();
			});
		},
		//保存执行操作
		saveData : function() {
			var validator = mainValidation($("#" + SO151403.formId));
			var isValid = validator.form();
		
			if (isValid) {
				$.alertMessage.confirm("你确定要保存当前数据吗？", function() {
					$.alertMessage.close();
					formData = getFormData($("#" +SO151403.formId));
					$('#main-content').postUrl(
							$("#" + SO151403.formId).attr("action"), formData,function() {
								$.pdialog.close();
								// Modify for Bug#2317 at 2016/09/19 by sun_jiaju Start
								$('#main-content').postUrl(Main.contextPath + "/SO151402/init/"+formData.orderId,{enterMark:"init"},Main.hiddenHeader);
								// Modify for Bug#2317 at 2016/09/19 by sun_jiaju End
							});
				});
			}
		},
		checkNum : function(){
			$("#overNum").blur(function(){
				
				var allNum=$("#allNum").val();
				var sendNum=$("#sendNums").val();
				var chaNum = allNum-sendNum;
				var overNums = $("#overNum").val();
				if (chaNum < overNums) {
					$.alertMessage.confirm("取消订单不能大于未发货订单!<br/><font colour = 'red'>未发货</font>订单为:"+chaNum+"箱.", function() {
						$("#overNum").val("0");
						$("#overNum").html("0");
						$.alertMessage.close();
					});
				}
			});
		}
}
$(document).ready(function() {
	//初始化调用
	SO151403.initDataGrid();
});