/**
 * 实际入力信息JS
 * Created by yuan_chen on 16/1/13.
 */
var SC182101 = {

    SC182101Grid: null,
    exprotButtonId: "SC182101_EXPORT",
    initDataGrid: function () {
        SC182101.SC182101Grid = $('#SC182101_Grid').grid({
            actionHandler:SC182101.actionHandler,
            fnRowCallback: SC182101.rowCallback,
            fnDrawCallback :SC182101.drawCallback
        });
        /** #1931,add by likia on 2016/8/16 start */
        this.exportButton();
        /** #1931,add by likia on 2016/8/16 end */
    },
    /** 应上海需求 #1791添加页面合计 modify by renyi on 2016/8/10 start */
    initToalGrid:function(){
        var $grid = $("#SC182101_Grid tbody");
        $grid.after("<tr role='row' style='height: 26px;'>" +
        "<td style='border-left: 1px solid #b1b1b1;border-top: 1px solid #b1b1b1;'></td>" +
        "<td style='border-top: 1px solid #b1b1b1;'></td>" +
        "<td style='border-top: 1px solid #b1b1b1;'></td>" +
        "<td style='border-top: 1px solid #b1b1b1;'></td>" +
        "<td style='border-top: 1px solid #b1b1b1;'></td>" +
        "<td style='border-top: 1px solid #b1b1b1;'></td>" +
        "<td class='text' style='border: 1px solid #b1b1b1; background-color: #F5FFFA'>当前页合计:</td>" +
        "<td class='text'  name='currentSendPlanNum' id='currentSendPlanNum' style='border: 1px solid #b1b1b1;text-align: left'></td>" +
        "<td class='text' name='currentSendActualNum' id='currentSendActualNum' style='border: 1px solid #b1b1b1;text-align: left'></td>" +
        "<td class='text' name='currentReceiveNum' id='currentReceiveNum' style='border: 1px solid #b1b1b1;text-align: left'></td>" +
        "<td class='text' name='currentSendPlanQty' id='currentSendPlanQty' style='border: 1px solid #b1b1b1;text-align: left'></td>" +
        "<td class='text' name='currentSendActualQty' id='currentSendActualQty' style='border: 1px solid #b1b1b1;text-align: left'></td>" +
        "<td class='text' name='currentRecriveQty' id='currentRecriveQty' style='border: 1px solid #b1b1b1;text-align: left'></td>" +
        "<td class='text' name='currentDifferNum' id='currentDifferNum' style='border: 1px solid #b1b1b1;text-align: left'></td>" +
        "<td class='text' name='currentDifferQty' id='currentDifferQty' style='border: 1px solid #b1b1b1;text-align: left'></td>" +
        "<td style='border-top: 1px solid #b1b1b1;border-right: 1px solid #b1b1b1;'></td>" +
        "<tr role='row' style='height: 26px'>" +
        "<td style='border-left: 1px solid #b1b1b1;'></td>" +
        "<td></td>" +
        "<td></td>" +
        "<td></td>" +
        "<td></td>" +
        "<td></td>" +
        "<td class='text' style='border: 1px solid #b1b1b1; background-color: #F5FFFA'>总合计:</td>" +
        "<td class='text'  name='totalSendPlanNum' id='totalSendPlanNum' style='border: 1px solid #b1b1b1;text-align: left'></td>" +
        "<td class='text' name='totalSendActualNum' id='totalSendActualNum' style='border: 1px solid #b1b1b1;text-align: left'></td>" +
        "<td class='text' name='totalReceiveNum' id='totalReceiveNum' style='border: 1px solid #b1b1b1;text-align: left'></td>" +
        "<td class='text' name='totalSendPlanQty' id='totalSendPlanQty' style='border: 1px solid #b1b1b1;text-align: left'></td>" +
        "<td class='text' name='totalSendActualQty' id='totalSendActualQty' style='border: 1px solid #b1b1b1;text-align: left'></td>" +
        "<td class='text' name='totalRecriveQty' id='totalRecriveQty' style='border: 1px solid #b1b1b1;text-align: left'></td>" +
        "<td class='text' name='totalDifferNum' id='totalDifferNum' style='border: 1px solid #b1b1b1;text-align: left'></td>" +
        "<td class='text' name='totalDifferQty' id='totalDifferQty' style='border: 1px solid #b1b1b1;text-align: left'></td>" +
        "<td></td>" +
        "</tr>");
    },

    formatNumber:function(num,cent,isThousand){
        num = num.toString().replace(/\$|\,/g,'');
        if(isNaN(num))num = "0";
        // 获取符号(正/负数)
        sign = (num == (num = Math.abs(num)));

        num = Math.floor(num*Math.pow(10,cent)+0.50000000001);  // 把指定的小数位先转换成整数.多余的小数位四舍五入
        cents = num%Math.pow(10,cent);              // 求出小数位数值
        num = Math.floor(num/Math.pow(10,cent)).toString();   // 求出整数位数值
        cents = cents.toString();               // 把小数位转换成字符串,以便求小数位长度

        // 补足小数位到指定的位数
        while(cents.length<cent)
            cents = "0" + cents;

        if(isThousand) {
            // 对整数部分进行千分位格式化.
            for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)
                num = num.substring(0,num.length-(4*i+3))+','+ num.substring(num.length-(4*i+3));
        }

        if (cent > 0)return (((sign)?'':'-') + num + '.' + cents);
        else
            return (((sign)?'':'-') + num);


    },
    drawCallback : function(){
        var dataList = SC182101.SC182101Grid.fnGetData();
        if(dataList.length == 0){
            $("#currentSendPlanNum").html("");
            $("#currentSendActualNum").html("");
            $("#currentReceiveNum").html("");
            $("#currentSendPlanQty").html("");
            $("#currentSendActualQty").html("");
            $("#currentRecriveQty").html("");
            $("#currentDifferNum").html("");
            $("#currentDifferQty").html("");
            $("#totalSendPlanNum").html("");
            $("#totalSendActualNum").html("");
            $("#totalReceiveNum").html("");
            $("#totalSendPlanQty").html("");
            $("#totalSendActualQty").html("");
            $("#totalRecriveQty").html("");
            $("#totalDifferNum").html("");
            $("#totalDifferQty").html("");
        }
    },

    rowCallback: function(tr, data) {
        if(tr._DT_RowIndex == 0){

            $("#currentSendPlanNum").html(SC182101.formatNumber(data.currentSendPlanNum,0,1));
            $("#currentSendActualNum").html(SC182101.formatNumber(data.currentSendActualNum,0,1));
            $("#currentReceiveNum").html(SC182101.formatNumber(data.currentReceiveNum,0,1));
            $("#currentSendPlanQty").html(SC182101.formatNumber(data.currentSendPlanQty,2,1));
            $("#currentSendActualQty").html(SC182101.formatNumber(data.currentSendActualQty,2,1));
            $("#currentRecriveQty").html(SC182101.formatNumber(data.currentRecriveQty,2,1));
            $("#currentDifferNum").html(SC182101.formatNumber(data.currentDifferNum,0,1));
            $("#currentDifferQty").html(SC182101.formatNumber(data.currentDifferQty,2,1));
            $("#totalSendPlanNum").html(SC182101.formatNumber(data.totalSendPlanNum,0,1));
            $("#totalSendActualNum").html(SC182101.formatNumber(data.totalSendActualNum,0,1));
            $("#totalReceiveNum").html(SC182101.formatNumber(data.totalReceiveNum,0,1));
            $("#totalSendPlanQty").html(SC182101.formatNumber(data.totalSendPlanQty,2,1));
            $("#totalSendActualQty").html(SC182101.formatNumber(data.totalSendActualQty,2,1));
            $("#totalRecriveQty").html(SC182101.formatNumber(data.totalRecriveQty,2,1));
            $("#totalDifferNum").html(SC182101.formatNumber(data.totalDifferNum,0,1));
            $("#totalDifferQty").html(SC182101.formatNumber(data.totalDifferQty,2,1));

        }
    },
    /** 应上海需求 #1791添加页面合计 modify by renyi on 2016/8/10 end */
    actionHandler:function(rowdata,coltype,row,col){
        if(coltype=="edit"){
            $('#main-content').postUrl(Main.contextPath + "/SC182102/init/true", rowdata)
        };
        if(coltype=="delete"){
            $.alertMessage.confirm("你确定要删除这条数据吗？", function() {
                $.alertMessage.close();
                $('#main-content').postUrl(Main.contextPath + "/SC182101/delete", rowdata);
            });
        }
    },
    /** #1931,add by likia on 2016/8/16 start */
    exportButton:function () {
        $("#"+SC182101.exprotButtonId).click(function () {
            SC182101.exportData();
        });
    },
    exportData:function () {
        $("#SC182101Form").attr("action",Main.contextPath+"/SC182101/exportDeliveryData");
        $("#SC182101Form").submit();
        $("#SC182101Form").attr("action",Main.contextPath+"/SC182101/search");

    }
    /** #1931,add by likia on 2016/8/16 end */

}
$(document).ready(function () {
    // 初始化调用
    SC182101.initDataGrid();
    /** 应上海需求 #1791添加页面合计 modify by renyi on 2016/8/10 start */
    SC182101.initToalGrid();
    /** 应上海需求 #1791添加页面合计 modify by renyi on 2016/8/10 end */
});