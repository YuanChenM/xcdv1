/**
 * 确认订单明细
 */

var SO151402 = {
		initDataGrid : function(){
			var ORDER_ID=$('#orderId').val();
			$("#baseorder").postUrl(Main.contextPath+"/so/baseorder/init/"+ORDER_ID);
			$("#orderbuyers").postUrl(Main.contextPath+"/so/buyers/init/"+ORDER_ID);
			$("#basedelivery").postUrl(Main.contextPath+"/so/delivery/init/"+ORDER_ID);
			$("#logisticsDetail").postUrl(Main.contextPath+"/so/delivery/actual/init/"+ORDER_ID);
			$("img[name='SO151402']").bind("click", function() {
				$.pdialog.open("订单详细供应商修改信息",Main.contextPath + "/SO151403/init",{resizable:false, width:500, height:500},{orderDetailAvailabilityId:$(this).attr("orderDetailAvailabilityId")});
			});
			$("img[name='orderDetailInfo']").bind("click", function() {
				$.pdialog.open("订单明细修改信息",Main.contextPath + "/SO151404/init",{resizable:false, width:500, height:300},{orderDetailId:$(this).attr("orderDetailId"),orderId:$("#orderId").val()});
			});
			$('.tree').treegrid();
			this.bindComplete();
	    },
	    bindComplete:function(){
	    	var orderId=$('#orderId').val();
	    	var orderCode=$('#orderCode').val();
			var orderType=$('#orderTypeHidden').val();
			var ver=$('#ver').val();

	    	$("#SO251108_OVER").click(function(){
				$.alertMessage.confirm("是否确定该订单已经完成收货？",function () {
					$.alertMessage.close();
					$('#main-content').postUrl(Main.contextPath+"/SO151402/allReceipt",{orderId:orderId,orderCode:orderCode},{enterMark:"init"},function(){
						/*$('#main-content').postUrl(Main.contextPath + "/SO151402/init/"+orderId)*/
					});
				});

				/*$('#main-content').postUrl(Main.contextPath+"/SO151401/init");*/
	    	});

			$("#SO251108_CHANGE").click(function(){
				$.alertMessage.confirm("是否确定买手已经付款？", function() {
					$.alertMessage.close();
					$('#main-content').postUrl(Main.contextPath+"/SO151402/orderPayment",{orderId:orderId},{enterMark:"init"},function(){
					});
				});
			});

			$("#SO251108_REALDELETE").click(function(){
				$.alertMessage.confirm("订单删除后将无法恢复，是否确定要删除该订单？", function() {
					$.alertMessage.close();
					$('#main-content').postUrl(Main.contextPath+"/SO151402/realDelete",{orderId:orderId},{enterMark:"init"},function(){
					});
				});
			});

			$("#SO251108_CANCEL").click(function(){
				$.alertMessage.confirm("是否确定要取消该订单？", function() {
					$.alertMessage.close();
					$('#main-content').postUrl(Main.contextPath+"/SO151402/cancel",{orderId:orderId,orderType:orderType,ver:ver},{enterMark:"init"},function(){
					});
				});
			});

			$("#SO251108_CONFIRM").click(function(){
				$.alertMessage.confirm("是否手动确认订单？", function() {
					$.alertMessage.close();
					$('#main-content').postUrl(Main.contextPath+"/SO151402/confirm",{orderId:orderId},{enterMark:"init"},function(){
					});
				});
			});
			$("#SO251108_POINT").click(function(){
				$("#point").printArea();
			});
			// #1129 add by sjj 20160712 start
			$("#SO251108_PRINT").click(function(){
				var printUrl = $('#printUrl').val();
				var callBackUrl = $('#callBackUrl').val();
				var dform = $("<form>");   //定义一个form表单
				var printCallBackUrlName = "printCallBackUrl";
				dform.append('<input type="text" name="'+printCallBackUrlName+'" value='+callBackUrl+'>');
				var orderIdVal =  $('#orderId').val();
				var callbackParamJson = "{\"orderId\":"+orderIdVal+"}";
				var callBackParamName = "callBackParam";
				dform.append('<input type="text" name="'+callBackParamName+'" value='+callbackParamJson+'>');
				dform.attr('style', 'display:none');   //在form表单中添加查询参数
				dform.attr('target', 'newWin');
				dform.attr('method', 'post');
				dform.attr('action', printUrl);
				$('body').append(dform);  //将表单放置在web中
				window.open("about:blank","newWin","");//newWin 是上面form的target
				dform.submit();
			});
			// #1129 add by sjj 20160712 end
	    }
}

function childOrderIdClick(tag)
{
	var orderId=$(tag).attr("value");
	$('#main-content').postUrl(Main.contextPath + "/SO151402/init/"+orderId,{enterMark:"init"});
}

$(document).ready(function() {
	// 初始化调用
	SO151402.initDataGrid();
});