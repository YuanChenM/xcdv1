/**
 * 卖家审批审核列表JS
 * 
 * @author gyh
 */
var $List_Grid;
var GS200001 = {
	searchButtonId : "GS200001_SEARCH",
	formId:"GS200001FormId",
	init : function() {
		$(".group-accordion").accordion({ heightStyle: "center" });
		this.bindSearchButton();
	},
	// 绑定按钮
	bindSearchButton : function() {
		$("#" + GS200001.searchButtonId).click(function() {
			formData = getFormData($("#" +GS200001.formId));
			$("#fieldInfo").postUrl(Main.contextPath + "/GS200001/initSon/",formData);
		});
	},
}
$(document).ready(function() {
	// 初始化调用
	GS200001.init();
});
