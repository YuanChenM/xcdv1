/**
 * Created by jiangnan on 16/1/5.
 */
var MS112101 = {
    MS112101DataGrid:null,
    DataGridId:"MS112101DataGrid",
    uploadButton : "MS112101_UPLOAD",
    searchButtonId : "MS112101_SEARCH",
    formId:"MS112101Form",
    init : function(){
        MS112101.MS112101DataGrid = $('#'+MS112101.DataGridId).grid({
            actionHandler:MS112101.actionHandler,
            fnRowCallback: MS112101.rowCallback

        });
        MS112101.bindUploadButton();
        MS112101.bindSearchButtonId();
        this.bindDatePicber('#startTime');
        this.bindDatePicber('#endTime');
    },
    rowCallback: function (tr, data) {
        var $td = $(tr).children('td').eq(6);
        var theA=$td[0].children[3];
        if(data.isProvide!="发放锁定中"){
            theA.style.visibility="hidden";
        }

    },
    bindDatePicber : function(orderTimeId){
        $(orderTimeId).datepicker({
            showButtonPanel: true,
            dateFormat:'yy-mm-dd',
            changeMonth: true,
            changeYear: true,
        });
    },
    actionHandler : function(rowdata,coltype,row,col){
        if(coltype=="check"){
            $.pdialog.open("会员卡详细信息",Main.contextPath+"/MS112103/init/"+rowdata.msId,{width:500});
        }
        if(coltype=="edit"){
			$.pdialog.open("会员卡信息编辑",Main.contextPath + "/MS11210101/init/"+rowdata.msId,{width:600});
		}
        if(coltype=="detail"){
			$.pdialog.open("会员卡密码修改",Main.contextPath + "/MS11210102/init/"+rowdata.msId,{width:540});
		}
        if(coltype=="print"){
        	formData = getFormData($("#" +MS112101.formId));
        		$.core.downloadUrl(Main.contextPath + "/MS11210103/downExcel/"+rowdata.msId,formData);
		}
    },
    bindUploadButton : function(){
        $("#"+MS112101.uploadButton).click(function(){
            $.pdialog.open("会员卡上传",Main.contextPath+"/MS112102/init",{width:400});
        });
    },
    bindSearchButtonId : function(){
    	$("#"+MS112101.searchButtonId).click(function(){
            MS112101.MS112101DataGrid.fnDraw()
        });
    }
}
$(document).ready(function() {
    MS112101.init();
});
