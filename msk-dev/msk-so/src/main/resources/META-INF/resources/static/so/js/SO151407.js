/**
 *退货单明细JS
 *@author xhy 
 */
var SO251107 = {
		
	init : function() {
		/* tree结构*/
		$('.tree').treegrid();

		var returnId = $("#returnId").val();
		var orderId = $("#orderId").val();
		$("#baseReturnOrder").postUrl(Main.contextPath+"/so/returnOrder/init/"+returnId);
		$("#returnBuyers").postUrl(Main.contextPath+"/so/buyers/init/"+orderId,null,null,{async:false});
		//$("#returnBuyers").postUrl(Main.contextPath+"/so/buyers/init/"+$("#returnId").val());
		$("img[name='SO251107']").bind("click", function() {
			$.pdialog.open("退货单修改信息",Main.contextPath + "/so/SO15140701/init/",{resizable:false, width:350, height:200},{returnDetailId:$(this).attr("returnDetailId"),pdCode:$(this).attr("pdCode"),pdName:$(this).attr("pdName"),returnQty:$(this).attr("returnQty"),returnId:returnId,orderId:orderId});
		});
		this.bindReturnOver();

	},
	bindReturnOver:function(){
		var returnId = $("#returnId").val();
    	$("#SO151407_OVER").click(function(){
    		$('#main-content').postUrl(Main.contextPath+"/SO151407/allReturn",{returnId:$("#returnId").val(),returnCode:$("#returnCode").val()},function(){
    			$('#main-content').postUrl(Main.contextPath + "/SO151407/init/" + $("#returnId").val());
    		},{refreshHtml:false});
    	});
    }
}
$(document).ready(function() {
	// 初始化调用
	SO251107.init();
	//debugger;
	$("#returnBuyers").children("div").children("h3").children("label").text("退货人信息");

});
