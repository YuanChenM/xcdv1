/**
 * Created by jiang_nan on 16/1/26.
 */
var SO151408 = {
    init: function () {
        /*$("#buyersType").selectmenu({width:"135px"});*/
        $("#vicFlg").selectmenu({width:"135px"});
        /*$("#lgcsId").selectmenu({width:"135px",change:SO151408.bindLgcChange});
        $("#city").selectmenu({width:"135px"});*/
        $("#districtCode").selectmenu({width:"135px"});
        /*$("#orderType").selectmenu({width:"135px",change:SO151408.bindOrderTypeChange});*/
        SO151408.bindSearchProduct();
        SO151408.bindSaveOrder();
    },
    /*bindLgcChange : function(){
       alert(1);
    },*/
    bindOrderTypeChange:function(){
        var orderType = $("#orderType").val();
        if(orderType == 1 || orderType == 4 || orderType == 5){
            $("#sellerCode").val("0000000");
            $("#sellerCode").attr('readonly','readonly');
            $("#sellerName").val("神农客实业有限公司");
            $("#sellerName").attr('readonly','readonly');
        }else{
            $("#sellerCode").val("");
            $("#sellerCode").removeAttr('readonly');
            $("#sellerName").val("");
            $("#sellerName").removeAttr('readonly');
        }
    },
    bindSearchProduct : function(){
        $("#SO151408_SEARCH").click(function(){
            $.pdialog.open("卖家产品选择",Main.contextPath+"/SO15140801/init",{width:"80%"},
                {
                    lgcsCode : $("#districtCode").val(),
                    slCode : $("#sellerCode").val(),
                    salePlatform : "4"
                });
        });
        /**选择价格*/
        $("#SO151408_SEARCHPRICE").click(function(){
            $.pdialog.open("卖家产品选择",Main.contextPath+"/SO15140801/init2",{width:"80%"},
                {
                    lgcsCode : $("#districtCode").val(),
                    slCode : $("#sellerCode").val(),
                    salePlatform : $("#orderType").val(),
                    pricecycleId : $("#pricecycleIds").val()
                });
        });

    },
    bindSaveOrder : function(){
        $("#SO151408_SAVE").click(function(){
            $.alertMessage.confirm("你确定要保存当前数据吗？", function() {
                $.alertMessage.close();
                var data = {};
                data.siteCode = "401";
                data.auth = "MSK00001";
                data.loginId = "msk01";
                var param = {};
                param.districtCode = $("#districtCode").val().trim();
                param.buyersName = $("#buyersName").val().trim();
                param.buyersType = "9";
                param.sellerCode = $("#sellerCode").val().trim();
                param.sellerName = $("#sellerName").val().trim();
                param.needInvoice = $("#needInvoice").val().trim();
                param.orderAmount = $("#orderAmount").val().trim();
                param.paymentType = $("#paymentType").val().trim();
                var receiverInfo = {};
                if(!$("#buyersName").val().trim()){
                    $.alertMessage.info("买手名称不能为空");
                    return;
                }
                if(!$("#receiverProvince").val().trim()){
                    $.alertMessage.info("收货地址省不能为空");
                    return;
                }
                if(!$("#receiverCity").val().trim()){
                    $.alertMessage.info("收货地址市不能为空");
                    return;
                }
                if(!$("#receiverDistrict").val().trim()){
                    $.alertMessage.info("收货地址区不能为空");
                    return;
                }
                receiverInfo.receiverProvince = $("#receiverProvince").val().trim();
                receiverInfo.receiverCity = $("#receiverCity").val().trim();
                receiverInfo.receiverDistrict = $("#receiverDistrict").val().trim();
                var deliveryReq = {};
                deliveryReq.vicFlg = $("#vicFlg").val();
                param.receiverInfo = receiverInfo;
                param.deliveryReq = deliveryReq;
                var products = [];
                $("#productData").find("tr").each(function () {
                    var tdArr = $(this).children();
                    var product = {};
                    var pdCode = tdArr.eq(0).text();
                    var pdName = tdArr.eq(1).text();
                    var orderPrice = tdArr.eq(2).text();
                    var orderQty = tdArr.eq(3).text();
                    product.pdCode = pdCode;
                    product.pdName = pdName;
                    product.orderPrice = orderPrice;
                    product.orderQty = orderQty;
                    products.push(product);
                });
                if (products.length == 0){
                    $.alertMessage.info("下单产品不能为空");
                    return;
                }
                param.products = products;
                param.toString();
                data.param = param;
                var jsonData = JSON.stringify(data);
                $.ajax({
                    url : Main.contextPath + "/api/v1/so/sdo/buyer/create",
                    data : jsonData,
                    type : 'POST',
                    contentType : "application/json",
                    dataType : "json",
                    success : function (data1) {
                        if (data1.status == "F"){
                            $.alertMessage.info(data1.message);
                        }else {
                            $('#main-content').postUrl(Main.contextPath + "/SO151401/init");
                        }
                    }
                });
            });
        });
    }
}
$(document).ready(function() {
    //初始化调用
    SO151408.init();
});
