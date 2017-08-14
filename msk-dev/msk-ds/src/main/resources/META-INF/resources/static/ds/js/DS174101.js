/**
 * 批次产品列表JS
 * Created by yuan_chen on 16/1/13.
 */
var DS174101 = {
    DS174101Grid: null,
    detailRows:[],
    trIndex: 0,
    initDataGrid: function () {
        DS174101.DS174101Grid = $('#DS174101_Grid').grid({
            actionHandler: DS174101.actionHandler,
            fnRowCallback: DS174101.rowCallback
        });
    },
    bindDatePicber : function(lotId){
        $('#dateInput'+lotId).datepicker({
            showButtonPanel: true,
            dateFormat:'yy-mm-dd',
            changeMonth: true,
            changeYear: true,
            onClose: function(currentDate, inst) {
                if(currentDate!=''){
                    $('#main-content').postUrl(Main.contextPath + "/DS174101/getPriceCycle/"+currentDate,null,function(data){
                        var $trId = "#trId" + lotId;
                        $($trId).children('td').eq(13).html(data.cycleCode);
                    },{refreshHtml:false});
                }
            }
        });
    },
    actionHandler: function (rowdata, coltype, row, col) {
        if (coltype == "edit") {
            $('#main-content').postUrl(Main.contextPath + "/DS174102/init/" + rowdata.lotId);
        }
        if (coltype == "save") {
            var $trId = "#trId" + rowdata.lotId;
            var $lgcsCheck="#lgcsCodeCheck"+rowdata.lotId;
            $('#main-content').postUrl(Main.contextPath + "/DS174101/modify",{
                lgcsCode:$($lgcsCheck).val(),
                lgcsName:$($lgcsCheck).find("option:selected").text(),
                dateCode:$($trId).children('td').eq(13).html(),
                lotId:rowdata.lotId
            });
        }
        if(coltype=="delete"){
            $.alertMessage.confirm("你确定要删除该批次以及批次流水号吗？", function() {
                $.alertMessage.close(); $('#main-content').postUrl(Main.contextPath + "/DS174101/delete",{
                    lotId:rowdata.lotId
                });
            });
        }
    },
    rowCallback: function (tr, data) {
        var $trId = "trId" + data.lotId;
        $(tr).attr("id", $trId);
        //销售区域选择
        var $td = $(tr).children('td').eq(11);
        var lgcsCheckHtml="<select name='lgcsCodeCheck' onchange='DS174101.checkChange(this,\"" + $trId + "\",12)' id='lgcsCodeCheck" + data.lotId + "'>";
        $.each(LOGISTICS_AREA.logisticsAreaList,function(i,logis){
            if(data.lgcsCode==logis.lgcsCode){
                lgcsCheckHtml+="<option selected='selected' value='"+logis.lgcsAreaCode+"'>"+logis.lgcsAreaName+"</option>";
            }else{
                lgcsCheckHtml+="<option value='"+logis.lgcsAreaCode+"'>"+logis.lgcsAreaName+"</option>";
            }
        });
        lgcsCheckHtml+="</select>";
        $td.html(lgcsCheckHtml);
        //日期选择
        $td = $(tr).children('td').eq(12);
        var dateHtml="<input style='width:70px;' type='text' name='dateInput' onMouseOver='DS174101.bindDatePicber("+data.lotId+")' id='dateInput"+data.lotId+"'/>";
        $td.html(dateHtml);
        //半旬选择
        //$td = $(tr).children('td').eq(13);
        //var dateSelectHtml="<select style='width:70px;'  name='dateSelect' id='dateSelect"+data.lotId+"'></select>";
        //$td.html(dateSelectHtml);
        DS174101.detailRows[DS174101.trIndex] = data;
        DS174101.trIndex++;
    }
}
$(document).ready(function () {
    // 初始化调用
    DS174101.initDataGrid();
});