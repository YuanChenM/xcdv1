/**
 * 物流区产品管理JS
 *
 * @author yuan_chen
 */
var SL131121 = {
    formId: "SL131121Form",
    batchSaveButtonId: "SL131121_BATCHSAVE",
    SL131121Grid: null,
    init: function () {
        $("a[name='selectLgcs']").bind("click", function() {
            $('#main-content').postUrl(Main.contextPath + "/SL131121/init/", {
                'filterMap[sellerCode]' : $(this).attr("selectSlCode"),
                'filterMap[lgcsCode]' : $(this).attr("selectLogistics")
            });
        });
        this.bindSaveButton();
    },
    initDataGrid: function () {
        SL131121.SL131121Grid = $('#SL131121_Grid').grid({
            actionHandler: SL131121.actionHandler,
            can_add: SL131121.canAdd,
            can_delete: SL131121.canDelete
        });
    },
    canAdd: function (rowdata){
        if(rowdata.lgcsId == null){
            return true;
        }
        return false;
    },
    canDelete: function (rowdata){
        if(rowdata.lgcsId == null){
            return false;
        }
        return true;
    },
    actionHandler: function (rowdata, coltype, row, col) {
        if(coltype=="add"){
            $.alertMessage.confirm("你确定要添加这条数据吗？", function() {
                $.alertMessage.close();
                $('#main-content').postUrl(Main.contextPath + "/SL131121/add", rowdata);
            });
        }
        if(coltype=="delete"){
            $.alertMessage.confirm("你确定要删除这条数据吗？", function() {
                $.alertMessage.close();
                $('#main-content').postUrl(Main.contextPath + "/SL131121/delete", rowdata);
            });
        }
    },
    bindSaveButton: function () {
        $("#" + SL131121.batchSaveButtonId).click(function () {
            $.alertMessage.confirm("你确定要添加这些数据吗？", function () {
                $.alertMessage.close();
                formData = getFormData($("#" + SL131121.formId));
                $('#main-content').postUrl($("#" + SL131121.formId).attr("action"), formData);
            });
        });
    }
};
$(document).ready(function () {
    // 初始化调用
    SL131121.init();
    SL131121.initDataGrid();

});