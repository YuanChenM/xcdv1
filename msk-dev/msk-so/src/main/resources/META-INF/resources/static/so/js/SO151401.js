/**
 * 订单列表JS
 * 
 * @author rwf
 */
var $List_Grid;
var SO151401 = {
	searchButtonId : "SO151401_SEARCH",
	formId:"SO151401Form",
	orderTimeStart:"#orderTimeStart",
	orderTimeEnd:"#orderTimeEnd",
	init : function(){
		$List_Grid = $('#SO251101_list_grid').grid({
			actionHandler:SO151401.actionHandler,
			iDisplayLength : 20,
			fnRowCallback: SO151401.rowCallback,
			fnDrawCallback :SO151401.drawCallback
		});
		//this.searchData();
		this.bindDatePicber(SO151401.orderTimeStart);
		this.bindDatePicber(SO151401.orderTimeEnd);
		SO151401.closeDate();
		this.bindSearchButton();
		this.enterSearchData();
		this.exportData();
		this.exportOrder();
		//#1512 add by sjj 20160808 start
		$("#checkbox-orderStatus").checkboxSelect();
		//#1512 add by sjj 20160808 end
	},

	drawCallback : function(){
		var dataList = $List_Grid.fnGetData();
		if(dataList.length == 0){
			$("#totalQty").html("");
			$("#currentPageQty").html("");
			$("#currentPageAmount").html("");
			$("#totalAmount").html("");
		}
	},

	rowCallback: function(tr, data) {
		if(tr._DT_RowIndex == 0){
			$("#totalQty").html(data.totalQty);
			$("#currentPageQty").html(data.currentPageQty);
			$("#currentPageAmount").html(data.currentPageAmount);
			$("#totalAmount").html(data.totalAmount);
		}
		if (!(data.orderStatus == '已完成' && (data.orderType == '买手囤货订单' || data.orderType == '第三方买手囤货订单'))){
			//Add for Bug#3782 at 2016/11/18 by sun_jiaju Start
			var userAgent = navigator.userAgent.toLowerCase();//取得浏览器的userAgent字符串
			if (userAgent.indexOf("msie") > -1 || userAgent.indexOf("rv:11") > -1) {
				tr.cells[13].childNodes[2].removeNode(true);
			} else {
				tr.cells[13].childNodes[2].remove();
			}
			//Add for Bug#3782 at 2016/11/18 by sun_jiaju End
		}
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
	// 绑定按钮
	bindSearchButton: function () {
			$("#" + SO151401.searchButtonId).click(function () {
				FormUtils.setFormValue(SO151401.formId, "SO151401");
				$List_Grid.fnDraw()
			});
	},
	searchData : function() {
		$("#" + SO151401.searchButtonId).click(function() {
			FormUtils.setFormValue(SO151401.formId,"SO151401");
			$List_Grid.fnDraw()
		});
	},
	exportData:function(){
		$("#SO151401_EXPORT").click(function(){
		    var bp=	$("#SO151401Form").serialize();
			var orderId=$("#orderId").val();
            var orderCode=$("#orderCode").val();
			var orderTimeStart=$("#orderTimeStart").val();
			var orderTimeEnd=$("#orderTimeEnd").val();
			var confirmOrderCode=$("#confirmOrderCode").val();
			var buyersCode=$("#buyersCode").val();
			var buyersName=$("#buyersName").val();
			var returnFlg=$("#returnFlg").val();
			var splitDeliveryFlg=$("#splitDeliveryFlg").val();
			var needInvoice=$("#needInvoice").val();
			var districtName=$("#districtName").val();
			var status=$("#status").val();
			var orderSource=$("#orderSource").val();
			var orderType=$("#orderType").val();
			var orderStatus=$("#orderStatus").val();
			var frozenGoodsHousekeep=$("#frozenGoodsHousekeep").val();
			var dform = $("<form>");   //定义一个form表单
			dform.append('<input type="text" name="orderId" value="'+orderId+'">')
			dform.append('<input type="text" name="orderCode" value="'+orderCode+'">')
			dform.append('<input type="text" name="orderTimeStart" value="'+orderTimeStart+'">')
			dform.append('<input type="text" name="orderTimeEnd" value="'+orderTimeEnd+'">')
			dform.append('<input type="text" name="confirmOrderCode" value="'+confirmOrderCode+'">')
			dform.append('<input type="text" name="buyersCode" value="'+buyersCode+'">')
			dform.append('<input type="text" name="returnFlg" value="'+returnFlg+'">')
			dform.append('<input type="text" name="splitDeliveryFlg" value="'+splitDeliveryFlg+'">')
			dform.append('<input type="text" name="needInvoice" value="'+needInvoice+'">')
			dform.append('<input type="text" name="districtName" value="'+districtName+'">')
			dform.append('<input type="text" name="buyersName" value="'+buyersName+'">')
			dform.append('<input type="text" name="status" value="'+status+'">')
			dform.append('<input type="text" name="orderSource" value="'+orderSource+'">')
			dform.append('<input type="text" name="orderType" value="'+orderType+'">')
			dform.append('<input type="text" name="orderStatus" value="'+orderStatus+'">')
			dform.append('<input type="text" name="frozenGoodsHousekeep" value="'+frozenGoodsHousekeep+'">')
			dform.attr('style', 'display:none');   //在form表单中添加查询参数
			dform.attr('target', '');
			dform.attr('orderTimeStart',$(SO151401.orderTimeStart).val());
			dform.attr('orderTimeEnd',$(SO151401.orderTimeEnd).val());

			dform.attr('method', 'post');
			dform.attr('action', Main.contextPath +"/SO151401/dataExport");
		$('body').append(dform);  //将表单放置在web中
			dform.submit();
		});
	},
	enterSearchData:function(){
		//绑定回车键
		document.onkeydown=function enterDown(e){
			//兼容火狐,chrome和ie的事件对象
			e = e||event;

			if(e.keyCode == 13) {
				FormUtils.setFormValue(SO151401.formId,"SO151401");
				$List_Grid.fnDraw()
			}
			return;
		}
	},
	actionHandler:function(rowdata,coltype,row,col){
		if(coltype=="edit"){
			formData=getFormData($("#"+SO151401.formId));
			// Modify for Bug#2317 at 2016/09/19 by sun_jiaju Start
			var data = new Object();
			data['enterMark'] = "init";
			Main.detailWindow(Main.contextPath + "/SO151402/init/"+rowdata.orderId, data, "订单详情");
			// Modify for Bug#2317 at 2016/09/19 by sun_jiaju End
		}
		// 发货单详细信息页面迁移
		if(coltype=="check"){
			formData=getFormData($("#"+SO151401.formId));
			var data = new Object();
			Main.detailWindow(Main.contextPath + "/SO151410/init/"+rowdata.orderId, data, "发货单详情");
		}
		// 发货单详细信息页面迁移
		if(coltype=="return"){
			formData=getFormData($("#"+SO151401.formId));
			var data = new Object();
			Main.detailWindow(Main.contextPath + "/SO151411/init/"+rowdata.orderId, data, "申请退货");
		}
	},
	exportOrder:function(){
		$("#SO151401_EXPORTORDER").click(function () {
			var bp=	$("#SO151401Form").serialize();
			var orderId=$("#orderId").val();
			var orderCode=$("#orderCode").val();
			var orderTimeStart=$("#orderTimeStart").val();
			var orderTimeEnd=$("#orderTimeEnd").val();
			var confirmOrderCode=$("#confirmOrderCode").val();
			var buyersCode=$("#buyersCode").val();
			var buyersName=$("#buyersName").val();
			var returnFlg=$("#returnFlg").val();
			var splitDeliveryFlg=$("#splitDeliveryFlg").val();
			var needInvoice=$("#needInvoice").val();
			var districtName=$("#districtName").val();
			var status=$("#status").val();
			var orderSource=$("#orderSource").val();
			var orderType=$("#orderType").val();
			var orderStatus=$("#orderStatus").val();
			var frozenGoodsHousekeep=$("#frozenGoodsHousekeep").val();
			var dform = $("<form>");   //定义一个form表单
			dform.append('<input type="text" name="orderId" value="'+orderId+'">')
			dform.append('<input type="text" name="orderCode" value="'+orderCode+'">')
			dform.append('<input type="text" name="orderTimeStart" value="'+orderTimeStart+'">')
			dform.append('<input type="text" name="orderTimeEnd" value="'+orderTimeEnd+'">')
			dform.append('<input type="text" name="confirmOrderCode" value="'+confirmOrderCode+'">')
			dform.append('<input type="text" name="buyersCode" value="'+buyersCode+'">')
			dform.append('<input type="text" name="returnFlg" value="'+returnFlg+'">')
			dform.append('<input type="text" name="splitDeliveryFlg" value="'+splitDeliveryFlg+'">')
			dform.append('<input type="text" name="needInvoice" value="'+needInvoice+'">')
			dform.append('<input type="text" name="districtName" value="'+districtName+'">')
			dform.append('<input type="text" name="buyersName" value="'+buyersName+'">')
			dform.append('<input type="text" name="status" value="'+status+'">')
			dform.append('<input type="text" name="orderSource" value="'+orderSource+'">')
			dform.append('<input type="text" name="orderType" value="'+orderType+'">')
			dform.append('<input type="text" name="orderStatus" value="'+orderStatus+'">')
			dform.append('<input type="text" name="frozenGoodsHousekeep" value="'+frozenGoodsHousekeep+'">')

			dform.attr('style', 'display:none');   //在form表单中添加查询参数
			dform.attr('target', '');
			dform.attr('orderTimeStart',$(SO151401.orderTimeStart).val());
			dform.attr('orderTimeEnd',$(SO151401.orderTimeEnd).val());

			dform.attr('method', 'post');
			dform.attr('action', Main.contextPath +"/SO151401/exportOrder");
			$('body').append(dform);  //将表单放置在web中
			dform.submit();
		});
	}
}


// Modify but#1496 at 2016/07/22 by wang_jianzhou Start.
$(function() {
	SO151401.init();
	//console.log(${districtList});
	// Delete for Bug#2760 at 2016/09/19 by sun_jiaju Start
	//$.core.sleep(3000);
	//$List_Grid.fnDraw();
	// Delete for Bug#2760 at 2016/09/19 by sun_jiaju End
// Modify but#1496 at 2016/07/22 by wang_jianzhou Start.
	// 初始化调用
	var $grid = $("#SO251101_list_grid tbody");
	$grid.after("<tr role='row' style='height: 26px'>" +
		"<td style='border-left: 1px solid #b1b1b1;border-top: 1px solid #b1b1b1;'></td>" +
		"<td style='border-top: 1px solid #b1b1b1;'></td>" +
		"<td style='border-top: 1px solid #b1b1b1;'></td>" +
		"<td style='border-top: 1px solid #b1b1b1;'></td>" +
		"<td style='border-top: 1px solid #b1b1b1;'></td>" +
		"<td style='border-top: 1px solid #b1b1b1;'></td>" +
		"<td style='border-top: 1px solid #b1b1b1;'></td>" +
		"<td style='border-top: 1px solid #b1b1b1;'></td>" +
		"<td style='border-top: 1px solid #b1b1b1;'></td>" +
		"<td class='text' style='border: 1px solid #b1b1b1; background-color: #F5FFFA'>当前页合计:</td>" +
		"<td class='text' name='currentPageQty' id='currentPageQty' style='border: 1px solid #b1b1b1'></td>" +
		"<td class='text' name='currentPageAmount' id='currentPageAmount' style='border: 1px solid #b1b1b1'></td>" +
		"<td style='border-top: 1px solid #b1b1b1;'></td	>" +
		"<td style='border-top: 1px solid #b1b1b1;border-right: 1px solid #b1b1b1;'></td>" +
		"</tr>"+
		"<tr role='row' style='height: 26px'>" +
		"<td style='border-left: 1px solid #b1b1b1;'></td>" +
		"<td></td>" +
		"<td></td>" +
		"<td></td>" +
		"<td></td>" +
		"<td></td>" +
		"<td></td>" +
		"<td></td>" +
		"<td></td>" +
		"<td class='text' style='border: 1px solid #b1b1b1; background-color: #F5FFFA'>总合计:</td>" +
		"<td class='text' name='totalQty' id='totalQty' style='border: 1px solid #b1b1b1'></td>" +
		"<td class='text' name='totalAmount' id='totalAmount' style='border: 1px solid #b1b1b1'></td>" +
		"<td></td>" +
		"<td></td>" +
		"</tr>");
});
