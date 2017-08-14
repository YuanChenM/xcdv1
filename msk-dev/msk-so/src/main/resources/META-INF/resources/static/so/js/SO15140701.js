/**
 *JS
 *@author rwf 
 */
var $List_Grid;
var SO25110701 = {
		/*获取form表单信息*/
		formId : "orderChangeForm",
		//定义保存按钮
		SaveButtonId:"SO25110701_SAVE",
		//定义取消按钮
		CancelButtonId:"SO25110701_CANCEL",
		//初始化调用函数
		initDataGrid : function(){
			this.fileButton();
			this.checkNum();
		},
		fileButton:function(){
			$("#" + SO25110701.CancelButtonId).click(function() {
				$.pdialog.close();
			});
			$("#" + SO25110701.SaveButtonId).click(function() {
				SO25110701.saveData();
			});
		},
		//保存执行操作
		saveData : function() {
			var validator = mainValidation($("#" + SO25110701.formId));
			var isValid = validator.form();
		
			if (isValid) {
				$.alertMessage.confirm("你确定要保存当前数据吗？", function() {
					$.alertMessage.close();
					var allNum=parseFloat($("#allNum").val()); //DB数量
					var overNums = parseFloat($("#overNum").val());//新填写数量
					if (allNum < overNums) {
						$.alertMessage.info("取消数量不能大于原退货数量!<br/><font colour = 'red'>退货数量总数为</font>:"+allNum+"箱.");
						return;
					}
					formData = getFormData($("#" +SO25110701.formId));
					$('#main-content').postUrl(
							$("#" + SO25110701.formId).attr("action"), {returnQty:$("#overNum").val(),returnDetailId:$("#returnDetailId").val()},function(data) {
							    if(data != 0){
									$.pdialog.close();
									$('#main-content').postUrl(Main.contextPath + "/SO151407/init/"+$("#returnId").val(),{orderId:$("#orderId").val()},Main.hiddenHeader);
								}else{
									$.alertMessage.info("保存失败！");
								}

							},{refreshHtml:false});
					//	$.pdialog.close();
				});
			}
		},
		checkNum : function(){
			$("#overNum").blur(function(){
				var allNum=parseFloat($("#allNum").val()); //DB数量
				var overNums = parseFloat($("#overNum").val());//新填写数量
				if (allNum < overNums) {
					$.alertMessage.confirm("取消数量不能大于原退货数量!<br/><font colour = 'red'>退货数量总数为</font>:"+allNum+"箱.", function() {
						$("#overNum").html("0");
						$.alertMessage.close();
					});
				}
			});
		}
}
$(document).ready(function() {
	//初始化调用
	SO25110701.initDataGrid();
});