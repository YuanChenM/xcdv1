/**
 * 申请退货
 */

var SO151411 = {
		init : function(){
			var ORDER_ID=$('#orderId').val();
			$("#baseorder").postUrl(Main.contextPath+"/so/baseorder/init/"+ORDER_ID);
			SO151411.bindReturnButton();
	    },
	bindReturnButton: function () {
		$("#SO151411_RETURN").click(function () {
			$.alertMessage.confirm("你确定要保存当前数据吗？", function () {
				$.alertMessage.close();
				var json = {};// 创建json 对象
				var flg = true;
				var jsonLength = 0;
				for(i=0; i<$("#listSize").val(); i++){
					if ($("#returnQty" + i).val() != "" && $("#returnQty" + i).val() != "0"){
						jsonLength = jsonLength + 1;
						var result = new Object();
						result.orderDetailAvailabilityId = $("#orderDetailAvailabilityId" + i).val();
						result.returnQty = $("#returnQty" + i).val();
						result.sellerCode = $("#sellerCode" + i).val();
						result.supplierCode = $("#supplierCode" + i).val();
						result.lgcsCode = $("#lgcsCode" + i).val();
						result.pdCode = $("#pdCode" + i).val();
						result.orderType = $("#orderType" + i).val();
						result.pdPrice = $("#pdPrice" + i).val();
						json[i] = result;
						if (parseFloat($("#returnedQty" + i).val())>0 || parseFloat($("#returnQty" + i).val()) != parseFloat($("#receiveQty" + i).val())){
							flg = false;
						}
					}
				}
				if (jsonLength <= 0){
					$.alertMessage.info("没有输入退货数量！");
					return;
				}
				if (jsonLength != $("#listSize").val()){
					flg = false;
				}
				// 退货模式 1：全退，2:部分退
				var returnMode = "2";
				if (flg){
					returnMode = "1";
				}
				var jsonStr = JSON.stringify(json);//  转成jsonStr
				$('#main-content').postUrl(Main.contextPath + "/SO151411/return", {"jsonStr":jsonStr,"orderId":$('#orderId').val(), "returnMode":returnMode});
			})
		});
	}
}
/**
 * 退货数量
 * @param index
 */
function changeReturnQty(index) {
	var returnQty = $("#returnQty" + index).val();
	var reg = /^\d+$/;
	if(!reg.test(returnQty)){
		$.alertMessage.info("请输入正整数！");
		$("#returnQty" + index).val("0");
		return;
	}
	returnQty = parseFloat(returnQty);
	var receiveQty = parseFloat($("#receiveQty"+ index).val());
	var returnedQty = parseFloat($("#returnedQty"+ index).val());
	if (returnQty > receiveQty - returnedQty){
		$.alertMessage.info("可退货数量应小于收货数量！");
		$("#returnQty" + index).val("0");
		return;
	}
}
$(document).ready(function() {
	// 初始化调用
	SO151411.init();
});