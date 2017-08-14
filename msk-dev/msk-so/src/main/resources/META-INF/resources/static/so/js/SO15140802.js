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
            $("#SO15140801Form").attr("action", Main.contextPath+"/SO15140801/search2");
        }else{
            $("#SO15140801Form").attr("action", Main.contextPath+"/SO15140801/searchSp2");
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
            var sumPrice = 0.00;

            var parentArr = new Array(); //父页面原有数据条数
            var tempparentArr = new Array();
            var iptRowObj =  $("input[name='pdName']");

            var pidArr = new Array();

            var iptRow = iptRowObj.length;
            for(var i=0;i<iptRow;i++){
                var obj = new Object();
                obj.pdName = $("input[name='pdName']")[i].value;
                var priId =$("input[name='pricecycleId']")[i].value;
                obj.pricecycleId = priId;
                pidArr.push(priId);
                obj.pdCode = $("input[name='pdCode']")[i].value;
                obj.classesCode = $("input[name='classesCode']")[i].value;
                obj.classesName = $("input[name='classesName']")[i].value;
                obj.breedCode = $("input[name='breedCode']")[i].value;
                obj.featureCode = $("input[name='featureCode']")[i].value;
                obj.featureName = $("input[name='featureName']")[i].value;
                obj.normsCode  = $("input[name='normsCode']")[i].value;
                obj.normsName = $("input[name='normsName']")[i].value;
                obj.pdGradeCode = $("input[name='pdGradeCode']")[i].value;
                obj.pdGradeName = $("input[name='pdGradeName']")[i].value;
                obj.priceCycle = $("input[name='priceCycle']")[i].value;
                obj.activeQty = $("input[name='orderQty']")[i].value;
                obj.price = $("input[name='price']")[i].value;
                obj.orderDetailLevel = $("input[name='orderDetailLevel']")[i].value;
                obj.supplierCode = $("input[name='supplierCode']")[i].value;
                obj.supplierName = $("input[name='supplierName']")[i].value;
                parentArr.push(obj)
                tempparentArr.push(obj);
            }

            $(".hiddenData").remove();
            //删除已经选择的数据
            for(var i=0;i<parentArr.length;i++){
                var pid = parentArr[i].pricecycleId;
                for(var j=0;j<selectProductList.length;j++){
                    if(pid == selectProductList[j].pricecycleId){
                        tempparentArr.remove(i);
                    }
                }
             }

            //合并两个list
            $.merge( selectProductList, tempparentArr);

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

                var pricecycleId = context["pricecycleId"];

                var gradeCode =  "";
                var gradeName = "";

                var trHtml = "<tr class='hiddenData'>";
                var formInput = "<input class='hidden' type='hidden' name='pdName' value='"+pdName+"'/>";
                formInput += "<input class='hidden' type='hidden' name='pricecycleId' value='"+pricecycleId+"'/>";
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

                formInput += "<input class='hidden' type='hidden' name='price' value='"+price+"'/>";

                var orderDetailLevel = context["orderLevelCode"];
                formInput += "<input class='hidden' type='hidden' name='orderDetailLevel' value='"+orderDetailLevel+"'/>";
                var orderLevelName = context["orderLevelName"];

                var supplierCode = context["supplierCode"];
                formInput += "<input class='hidden' type='hidden' name='supplierCode' value='"+supplierCode+"'/>";

                var supplierName = context["supplierName"];
                formInput += "<input class='hidden' type='hidden' name='supplierName' value='"+supplierName+"'/>";
                /*单箱体积*/
                var packingVolume = context["packingVolume"];
                formInput += "<input class='hidden' type='hidden' name='packingVolume' value='"+packingVolume+"'/>";
                /*外包装净重*/
                var netWeightOut = context["netWeightOut"];
                formInput += "<input class='hidden' type='hidden' name='netWeightOut' value='"+netWeightOut+"'/>";
                /*重量*/
                var weight = (parseFloat(netWeightOut)*parseFloat(num));
                formInput += "<input class='hidden' type='hidden' name='weight' value='"+weight+"'/>";
                /*体积*/
                var volume = (parseFloat(packingVolume)*parseFloat(num));
                formInput += "<input class='hidden' type='hidden' name='volume' value='"+volume+"'/>";

                sumPrice += (parseFloat(price)*parseFloat(num));

                trHtml += "<td>"+pdCode+"</td>";
                trHtml += "<td>"+pdName+"</td>";
                trHtml += "<td>"+price+"</td>";
                trHtml += "<td>"+num+"</td>";
                trHtml += "<td>"+formInput+"</td>";
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
/**
 *删除数组指定下标或指定对象
 */
Array.prototype.remove=function(obj){
    for(var i =0;i <this.length;i++){
        var temp = this[i];
        if(!isNaN(obj)){
            temp=i;
        }
        if(temp == obj){
            for(var j = i;j <this.length;j++){
                this[j]=this[j+1];
            }
            this.length = this.length-1;
        }
    }
}
$(document).ready(function() {
    //初始化调用
    SO15140801.init();
});
