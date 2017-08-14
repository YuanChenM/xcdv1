/**
 * 计划历史一览JS
 * Created by fjm on 16/2/18.
 * @type {{SC183102Grid: null, initDataGrid: Function, actionHandler: Function}}
 */
var SC183102 = {
    SC183102Grid: null,
    initDataGrid: function () {
        SC183102.SC183102Grid = $('#SC183102_Grid').grid({
            actionHandler:SC183102.actionHandler,
            fnRowCallback:SC183102.rowCallback
        });
    },
    actionHandler:function(rowdata,coltype,row,col){
        if(coltype=="edit"){
            $.pdialog.open("供应商产品计划调整申请", Main.contextPath + "/SC183101/init", {
                    width: 800,
                    height: 550
                },
                {
                    entryMark : "2",
                    distMonth : rowdata.distMonth,
                    areaCode : rowdata.lgcsCode,
                    areaName : rowdata.lgcsName,
                    supplierCode : rowdata.suppCode,
                    supplierName : rowdata.suppName,
                    productName : rowdata.classesCode,
                    currentHalfCode : rowdata.halfCodeZ,
                    planType : rowdata.pdStockTypeZ,
                    adjustDate : rowdata.adjustDate,
                    suppDsId : rowdata.suppDsId,
                    virtualStockPlanId : rowdata.planFlowId
                })
        };

        if(coltype=="delete"){
            $('#main-content').postUrl(Main.contextPath + "/SC183102/delete/", {
                suppDsId : rowdata.suppDsId,
                planFlowId : rowdata.planFlowId,
            })};
    },
    rowCallback: function (tr, data) {
        var $td = $(tr).children('td').eq(18);
        var theB=$td[0].children[1];
        var theA=$td[0].children[0];
        //var d = new Date();
        //var str = d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate();
        //var dstr = new Date(str.replace(/-/g, "/"));
        //var a = data.halfCodeA;
        //var astr = new Date(a.replace(/-/g, "/"));
        //
        //var i = data.adjustDate.toString();
        //var istr = new Date(i.replace(/-/g, "/"));
        //if(istr-astr<0 || dstr-istr<0){
        //    theA.style.visibility="hidden";
        //    theB.style.visibility="hidden";
        //}
        var delFlg = data.delFlg;
        if(delFlg == 0){
            theA.style.visibility="hidden";
        }else if(delFlg == 1){
            theB.style.visibility="hidden";
        }else{
            theA.style.visibility="hidden";
            theB.style.visibility="hidden";
        }

    }

}
$(document).ready(function () {
    // 初始化调用
    SC183102.initDataGrid();
});
