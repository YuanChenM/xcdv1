/**
 * 产品基础数据列表JS
 *
 * @author xhy
 */
var PD14114901 = {
	saveButtonId: "PD14114901_SAVE",
	formId: "PD14114901Form",
	init : function() {
		this.bindDatePicber('#raiseDateString');
		this.bindDatePicber('#fixDateString');
		this.bindSaveButton();
	},
	bindDatePicber: function (orderTimeId) {
		$(orderTimeId).datepicker({
			showButtonPanel: true,
			dateFormat: 'yy-mm-dd',
			changeMonth: true,
			changeYear: true,
		});
	},
	bindSaveButton: function () {
		$("#" + PD14114901.saveButtonId).click(function () {
			var validator = mainValidation($("#" + PD14114901.formId));
			var isValid = validator.form();
			formDatas = getFormData($("#" + PD14114901.formId));
			/*新增*/
			if(formDatas.standardId!=null){
				var tncStdVal = formDatas.tncStdVal;
				if(/^\s*$/.test(tncStdVal)){
					$.alertMessage.info("内容不能为空!");
					return false;
				}
			}
			/*新增*/
			if(formDatas.standardId!=null){
				var raiseDateString = formDatas.raiseDateString;
				if(/^\s*$/.test(raiseDateString)){
					$.alertMessage.info("日期不能为空!");
					return false;
				}
			}
			/*结束日期*/
			if(formDatas.keyId!=null){
				var endTime = formDatas.fixDateString;
				if(/^\s*$/.test(endTime)){
					$.alertMessage.info("结束日期不能为空!");
					return false;
				}
				var startTime = $("#raiseDateShow").val();
				var start=new Date(startTime.replace("-", "/").replace("-", "/"));
				var end=new Date(endTime.replace("-", "/").replace("-", "/"));
				if(start>=end){
					$.alertMessage.info("开始日期不能大于等于结束时间!");
					return false;
				}
			}
			if (isValid) {
				$.alertMessage.confirm("你确定要保存当前数据吗？", function () {
					$.alertMessage.close();
					formData = getFormData($("#" + PD14114901.formId));
					$('#main-content').postUrl(
						$("#" + PD14114901.formId).attr("action"),formData,function(data) {
							$.pdialog.close();
							var divId="#"+data[0].getDivName;
							var value = parseInt(divId.replace(/[^0-9]/ig,""));
							var div="<div margin-right:0px;width:300px' id='divArgMarNeed"+value+"' >";
							div+="<table class='tree dataTable no-footer' style='min-width:250px' width='250px' showAddBtn='true'>";
							div+="<tr style='background:#DBDBDB'><td align='center'>内容 <a class='argTncMar' tncStdItemId='"+data[0].tncStdItemId+"' needId="+value+" id='add' title='添加' href='javascript:void(0);' col='10'><img src='"+Main.contextPath+"/static/core/images/action/add.png' style='width:13px;height:13px'></a></td><td align='center'>提出日</td><td align='center'>结案日</td><td align='center'>操作</td></tr>";
							$(data).each(function(i){
								if(this.discussStatus== "0"){
									div+="<tr><td align='center'>"+this.tncStdVal+"</td><td align='center'>"+this.raiseDateShow+"</td><td align='center'>"+this.fixDateShow+"</td><td width='10px'><a class='argTncMarJan' keyId='"+this.keyId+"' tncStdItemId='"+this.tncStdItemId+"' fixDate='"+this.fixDateShow+"' raiseDate='"+this.raiseDateShow+"' needId="+value+"  title='结案日' href='javascript:void(0);' col='10'><img border='0px' src='"+Main.contextPath+"/static/core/images/action/jiean.png' style='width:13px;height:13px'></a><a class='argTncMarJin' keyId='"+this.keyId+"' tncStdItemId='"+this.tncStdItemId+"' needId="+value+" title='禁止' href='javascript:void(0);' col='10'><img border='0px' src='"+Main.contextPath+"/static/core/images/action/jinzhizhunren.png' style='width:13px;height:13px'></a></td></tr>";
								}else{
									div+="<tr><td align='center'>"+this.tncStdVal+"</td><td align='center'>"+this.raiseDateShow+"</td><td align='center'>"+this.fixDateShow+"</td><td width='10px'></td></tr>";
								}
							});
							$(divId).html(div);
							PD141149.marAdd();
						},{refreshHtml:false});
				});
			}
		});
	},
}
$(document).ready(function() {
	// 初始化调用
	PD14114901.init();
});
