/**
 * Created by yang_chunyan on 2016/3/29.
 */

var $List_Grid;
var BP112211 = {
    formId:"BP112211Form",
    searchButtonId:"BP112211_SEARCH",
    init : function() {
        $List_Grid = $('#BP112211_list_grid').grid({
            actionHandler:BP112211.actionHandler
        });
        FormUtils.init(BP112211.formId,"BP112211");
        this.bindSearchButtonId();
    },

    bindSearchButtonId : function(){
        $("#"+BP112211.searchButtonId).click(function(){
            FormUtils.setFormValue(BP112211.formId, "BP112211");
            $List_Grid.fnDraw()
        });
    },

    actionHandler:function(rowdata,coltype,row,col){
        if(coltype == "check")
        {
            var startDate = $('#startDate').val();
            var endDate = $('#endDate').val();
            var dayAmount = $('#dayAmount').val();
            var cycleCode = $('#cycleCode').val();
            var loginId = $('#loginId').val();
            $('#main-content').postUrl(Main.contextPath + "/BP112212/init/",{
                slCode:rowdata.slCode,
                slName:rowdata.slName,
                pdCode:rowdata.pdCode,
                machining:rowdata.machining,
                feacherName:rowdata.feacherName,
                pdWeight:rowdata.pdWeight,
                pdLevel:rowdata.pdLevel,
                stockWeight:rowdata.stockWeight,
                quotationStatus:rowdata.quotationStatus,
                pricecycleId:rowdata.pricecycleId,
                lgcsName:rowdata.lgcsName,
                lgcsCode:rowdata.lgcsCode,
                pdName:rowdata.pdName,
                startDate:startDate,
                endDate:endDate,
                dayAmount:dayAmount,
                loginId:loginId,
                cycleCode:cycleCode,
                weightVal : rowdata.weightVal
            });
        }
    }
}
$(document).ready(function() {

    var startDate = $('#startDate').val();
    var endDate =$('#endDate').val();
    var dayAmount = $('#dayAmount').val();
    var cycleCode = $('#cycleCode').val();
    var loginId = $('#loginId').val();
    // 初始化调用
    BP112211.init();
    var stimearr=startDate.replace(" ",":").replace(/\:/g,"-").split("-");
    var etimearr=endDate.replace(" ",":").replace(/\:/g,"-").split("-");
    $('#cycle').html("第" + dayAmount + "期  " + stimearr[1]+'月'+stimearr[2]+'日' + "  -  " + etimearr[1]+'月'+ etimearr[2]+'日');
    $('#startDate').attr("value",startDate);
    $('#endDate').attr("value",endDate);
    $('#dayAmount').attr("value",dayAmount);
    $('#cycleCode').attr("value",cycleCode);
    $('#loginId').attr("value",loginId);
    //$.core.sleep(1000);
    //$List_Grid.fnDraw();
});
