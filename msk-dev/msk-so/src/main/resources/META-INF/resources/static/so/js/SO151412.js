/**
 * 订单JS
 * 
 * @author sjj
 */
var SO151412 = {
	formId:"SO151412Form",
	startTime:"#startTime",
	endTime:"#endTime",
	init : function(){
		this.bindDatePicber(SO151412.startTime);
		this.bindDatePicber(SO151412.endTime);
		SO151412.closeDate();
		this.exportOrder();
	},

	bindDatePicber : function(orderTimeId){
		$(orderTimeId).datepicker({
			showButtonPanel: true,
			dateFormat:'yy-mm-dd',
			changeMonth: true,
			changeYear: true,
			closeText: 'Clear'
		});
	},
	closeDate : function(){
		$(document).on("click","button.ui-datepicker-close",function(){
			$.datepicker._clearDate($.datepicker._curInst.input);
		});
	},
	exportOrder:function(){
		$("#SO151412_EXPORT").click(function () {
			var dform = $("<form>");   //定义一个form表单
			dform.append('<input type="text" name="demesne" value="'+$("#demesne").val()+'">')
			dform.append('<input type="text" name="slShowName" value="'+$("#slShowName").val()+'">')
			dform.append('<input type="text" name="pdCode" value="'+$("#pdCode").val()+'">')
			dform.append('<input type="text" name="startTime" value="'+$("#startTime").val()+'">')
			dform.append('<input type="text" name="endTime" value="'+$("#endTime").val()+'">')

			dform.attr('style', 'display:none');   //在form表单中添加查询参数
			dform.attr('target', '');

			dform.attr('method', 'post');
			dform.attr('action', Main.contextPath +"/SO151412/exportOrder");
			$('body').append(dform);  //将表单放置在web中
			dform.submit();
		});
	}
}

$(function() {
	SO151412.init();
});
