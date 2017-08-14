/**
 * 订单发货详情
 */

var SO151410 = {
		initDataGrid : function(){
			var ORDER_ID=$('#orderId').val();
			$("#baseorder").postUrl(Main.contextPath+"/so/baseorder/init/"+ORDER_ID);
			$("#orderbuyers").postUrl(Main.contextPath+"/so/buyers/init/"+ORDER_ID);
			$("#basedelivery").postUrl(Main.contextPath+"/so/delivery/init/"+ORDER_ID);
			$("#logisticsDetail").postUrl(Main.contextPath+"/so/delivery/actual/init/"+ORDER_ID);
			$("img[name='shipInfo']").bind("click", function() {
				var shipId = $(this).attr("shipId");
				var shipStatus = $(this).attr("shipStatus");
				$.alertMessage.confirm("是否确定取消该发货单？", function() {
					$.alertMessage.close();
					$('#main-content').postUrl(Main.contextPath+"/SO151410/cancel",{shipId:shipId, orderId:$("#orderId").val()},function(){
					});
				});
			});
			$('.tree').treegrid();
	    }
}
function childOrderIdClick(tag)
{
	var orderId=$(tag).attr("value");
	$('#main-content').postUrl(Main.contextPath + "/SO151410/init/"+orderId);
}
$(document).ready(function() {
	// 初始化调用
	SO151410.initDataGrid();
});