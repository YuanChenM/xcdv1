/**
 * 实际历史一览
 * Created by fjm on 16/2/17.
 * @type {{SC183104Grid: null, initDataGrid: Function, actionHandler: Function}}
 */
var SC183104 = {
    SC183104Grid: null,
    initDataGrid: function () {
        SC183104.SC183104Grid = $('#SC183104_Grid').grid({
            actionHandler:SC183104.actionHandler,
            fnRowCallback:SC183104.rowCallback
        });
    },
    actionHandler:function(rowdata,coltype,row,col){
        if(coltype=="edit"){
                $.pdialog.open("供应商产品实际录入", Main.contextPath + "/SC183103/init", {
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
                        productName : rowdata.classesName,
                        currentHalfCode : rowdata.halfCodeZ,
                        planType : rowdata.pdStockTypeZ,
                        adjustDate : rowdata.inputDate,
                        suppDsId : rowdata.suppDsId,
                        virtualStockActualId : rowdata.actualFlowId,
                    })
        };
        if(coltype=="delete"){
            $('#main-content').postUrl(Main.contextPath + "/SC183104/delete/", {
                suppDsId : rowdata.suppDsId,
                actualFlowId : rowdata.actualFlowId,
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
        //var i = data.inputDate.toString();
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
    SC183104.initDataGrid();
});
