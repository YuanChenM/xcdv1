/**
 * Created by jiang_nan on 16/1/26.
 */
var SO15140801 = {
    LISTGRID : null,
    THISROWDATA : null,
    THISROWINDEX : null,
    init: function () {

        var salePlatform = $('#salePlatform').val();
        if(salePlatform == 1 || salePlatform == 4 || salePlatform == 5){
            $("#SO15140801Form").attr("action", Main.contextPath+"/SO15140801/search");
        }else{
            $("#SO15140801Form").attr("action", Main.contextPath+"/SO15140801/searchSp");
        }

        SO15140801.LISTGRID = $('#SO151408Grid').grid({
            fnRowCallback : SO15140801.rowCallback,
            editCellOnBlurHandler :SO15140801.cellOnBlurHandler
        });
        SO15140801.bindConfirmButton();
    },
    cellOnBlurHandler : function($comp){
        //获得TD
        var $td = $comp.parent();
        //获得TR
        var $tr = $td.parent();
        //获得所有行
        var $trs = $tr.parent();
        //获得当前行
        SO15140801.THISROWINDEX = $trs.children().index($tr);
        //获得当前行数据
        var num=$comp.val();
        SO15140801.THISROWDATA = SO15140801.LISTGRID.fnGetData(SO15140801.THISROWINDEX);
        //$("#hiddenDiv").postUrl(Main.contextPath+"/SO15140801/loadPrice",{pdCode:SO15140801.THISROWDATA.pdCode,orderNum:num}, SO15140801.loadPriceCallback,{refreshHtml:false});
    },
    loadPriceCallback : function(data){
        if(data==null||data==''){
            $.alertMessage.error("当前产品没有价盘信息");
            return;
        }
        //var dataIndex = 0;
        //var orderQty = SO15140801.THISROWDATA.activeQty;
        //$.each(data,function(index,context){
        //    var $netweight = context.netweight;
        //    if(parseInt(orderQty)>$netweight){
        //    }else{
        //        dataIndex = index;
        //        return;
        //    }
        //});
        //var priceData = data[dataIndex];
        //if(priceData==null){
        //    $.alertMessage.error("当前产品没有价盘信息");
        //    return;
        //}
        SO15140801.THISROWDATA.price = data.priceofbox;
        SO15140801.THISROWDATA.priceCyclePeriod = data.pricecyclePeriod;
        SO15140801.THISROWDATA.orderLevelName = data.orderlevelName;
        SO15140801.THISROWDATA.orderLevelCode = data.orderlevelCode;
        SO15140801.LISTGRID.fnUpdate(SO15140801.THISROWDATA,SO15140801.THISROWINDEX,undefined,false,false);
    },
    rowCallback : function(tr,data){
    },
    bindConfirmButton : function(){
        $("#SO15140801_CONFIRM").click(function(){
            var selectProductList = SO15140801.LISTGRID.getChoiceData();
            $(".hiddenData").remove();
            var sumPrice = 0.00;
            $.each(selectProductList,function(index,context){
                var pdName = context["pdName"];
                var pdCode = context["pdCode"];
                var num = context["activeQty"];
                var classesCode = context["classesCode"];
                var classesName = context["classesName"];
                var breedCode = context["breedCode"];
                var breedName = context["breedName"];
                var featureCode = context["featureCode"];
                var featureName = context["featureName"];
                var featureName = context["featureName"];
                var invQty = context["invQty"];

                var gradeCode =  "";
                var gradeName = "";

                var trHtml = "<tr class='hiddenData'>";
                var formInput = "<input class='hidden' type='hidden' name='pdName' value='"+pdName+"'/>";
                formInput += "<input class='hidden' type='hidden' name='pdCode' value='"+pdCode+"'/>";
                formInput += "<input class='hidden' type='hidden' name='classesCode' value='"+classesCode+"'/>";
                formInput += "<input class='hidden' type='hidden' name='classesName' value='"+classesName+"'/>";
                formInput += "<input class='hidden' type='hidden' name='breedCode' value='"+breedCode+"'/>";
                formInput += "<input  class='hidden' type='hidden' name='featureCode' value='"+featureCode+"'/>";
                formInput += "<input class='hidden' type='hidden' name='featureName' value='"+featureName+"'/>";
                //包装
                var normsCode = context["normsCode"];
                formInput += "<input class='hidden' type='hidden' name='normsCode' value='"+normsCode+"'/>";
                var normsName = context["normsName"];
                formInput += "<input class='hidden' type='hidden' name='normsName' value='"+normsName+"'/>";

                formInput += "<input class='hidden' type='hidden' name='pdGradeCode' value='"+gradeCode+"'/>";
                formInput += "<input class='hidden' type='hidden' name='pdGradeName' value='"+gradeName+"'/>";
                var priceCycle = context["priceCyclePeriod"];
                //价盘
                formInput += "<input class='hidden' type='hidden' name='priceCycle' value='"+priceCycle+"'/>";

                formInput += "<input class='hidden' type='hidden' name='orderQty' value='"+num+"'/>";
                var price = context["price"];
                sumPrice += (parseFloat(price)*parseFloat(num));
                formInput += "<input class='hidden' type='hidden' name='price' value='"+price+"'/>";

                var orderDetailLevel = context["orderLevelCode"];
                formInput += "<input class='hidden' type='hidden' name='orderDetailLevel' value='"+orderDetailLevel+"'/>";
                var orderLevelName = context["orderLevelName"];

                var supplierCode = context["supplierCode"];
                formInput += "<input class='hidden' type='hidden' name='supplierCode' value='"+supplierCode+"'/>";

                var supplierName = context["supplierName"];
                formInput += "<input class='hidden' type='hidden' name='supplierName' value='"+supplierName+"'/>";

                if(isNaN(num)){
                    $.alertMessage.info("产品编码"+ pdCode +"下单数量填写格式不正确");
                    return;
                }
                if (parseFloat(num) <= 0){
                    $.alertMessage.info("产品编码"+ pdCode +"下单数量必须大于0");
                    return;
                }

                if(isNaN(price)){
                    $.alertMessage.info("产品编码"+ pdCode +"价格填写格式不正确");
                    return;
                }
                if (parseFloat(price) <= 0){
                    $.alertMessage.info("产品编码"+ pdCode +"价格必须大于0");
                    return;
                }

                if (parseFloat(num) > parseFloat(invQty) ){
                    $.alertMessage.info("产品编码"+ pdCode +"下单数量大于可售库存");
                    return;
                }

                trHtml += "<td id='pdCode'>"+pdCode+"</td>";
                trHtml += "<td id='pdName'>"+breedName+"</td>";
                trHtml += "<td id='price'>"+parseFloat(price)+"</td>";
                trHtml += "<td id='orderQty'>"+parseFloat(num)+"</td>";
                //trHtml += "<td>"+formInput+"<img src='"+Main.contextPath+"/static/core/images/action/delete.png'/></td>";
                trHtml += "</tr>";
                $("#productData").append(trHtml);
                $("#accordionProductData").accordion({ heightStyle: "content" });
                $.pdialog.close();
            });
            $("#orderAmount").val(sumPrice);
        });
    }

}
$(document).ready(function() {
    //初始化调用
    SO15140801.init();
});
