/**
 * 产品品种维护JS
 *
 * @author gyh
 */
var PD14112405 = {
	formId : "PD14112405Form",
	saveButtonId : "PD14112405_SAVE",
	init : function() {
		this.bindSavebutton();
		this.changeCheckBox();
		this.changeCheckBox2();
	},
	bindSavebutton : function() {
		$("#" + PD14112405.saveButtonId).click(function() {
			PD14112405.saveData();
		});
		$("#" + PD14112405.backButtonId).click(function() {
			$.pdialog.close();
		});
	},
	changeCheckBox: function () {
		$(".codeName").click(function () {
			if ($(this).prop("checked")) {
				$(":checkbox").not($(this)).removeAttr("checked");
				$('#normsCode').removeAttr('disabled');
				$('#normsOut').removeAttr('disabled');
				$('#onlyName').prop('disabled','disabled');
				$('#onlyName').val("");
			} else {
				$(":checkbox").removeAttr("checked");
				$('#normsCode').prop('disabled','disabled');
				$('#normsOut').prop('disabled','disabled');
				$('#onlyName').prop('disabled','disabled');
			}
		});
	},
	changeCheckBox2: function () {
		$(".onlyName").click(function () {
			if ($(this).prop("checked")) {
				$(":checkbox").not($(this)).removeAttr("checked");
				$('#normsCode').prop('disabled','disabled');
				$('#normsOut').prop('disabled','disabled');
				$('#onlyName').removeAttr('disabled');
				$('#normsCode').val("");
				$('#normsOut').val("");
			} else {
				$(":checkbox").removeAttr("checked");
				$('#normsCode').prop('disabled','disabled');
				$('#normsOut').prop('disabled','disabled');
				$('#onlyName').prop('disabled','disabled');
				$('#onlyName').val("");
			}
		});
	},
	saveData : function() {
		var validator = mainValidation($("#" + PD14112405.formId));
		var isValid = validator.form();
		if ($(".onlyName").prop("checked")) {
			var thisValue = $("#onlyName").val();
			if(/^\s*$/.test(thisValue)){
				$.alertMessage.info("输入框值不能为空!");
				return false;
			}
		}

		if ($(".codeName").prop("checked")) {
			var isNull1 = $("#normsOut").val();
			var normsCode = $("#normsCode").val();
			if(/^\s*$/.test(normsCode)){
				$.alertMessage.info("输入框值不能为空!");
				return false;
			}

			if(!/^[0-9][1-9]{1}$/.test(normsCode)){
				$.alertMessage.info('包装编码只能输入两位数值!');
				return false;
			}

			if(/^\s*$/.test(isNull1)){
				$.alertMessage.info("输入框值不能为空!");
				return false;
			}

		}
		if(!$(".codeName").prop("checked") && !$(".onlyName").prop("checked")){
			$.alertMessage.info("请选择录入方式!");
			return false;
		}

		if (isValid) {
			$.alertMessage.confirm("你确定要保存当前数据吗？", function() {
				$.alertMessage.close();
				formData = getFormData($("#" + PD14112405.formId));
				$('#PD14112406Id').postUrl(
					$("#" + PD14112405.formId).attr("action"),
					formData,
					function(data) {
						if(data=='1'){
							/** Modfiy: Bug #2429 : 新产品系统无法新增产品二级分类三级分类等数据   20160905   BY  杨春艳  Start */
							PD14112406.initJsp();
							$.alertMessage.info("数据操作成功!");
							$.pdialog.close();
							/*$('#normsCode').val("");
							 $('#normsOut').val("");
							 $('#onlyName').val("");*/
							/** Modfiy: Bug #2429 : 新产品系统无法新增产品二级分类三级分类等数据   20160905   BY  杨春艳  End */
						}else{
							$.alertMessage.info("数据异常,请修改后添加!");
						}
					});
			});
		}
	}
};
$(document).ready(function() {
	// 初始化调用
	PD14112405.init();
});