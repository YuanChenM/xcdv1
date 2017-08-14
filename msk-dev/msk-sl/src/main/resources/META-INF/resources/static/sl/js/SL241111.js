/**
 *JS
 *@author puxigui
 */
var $List_Grid;
var SL241111 = {
    fileButtonId: "file",
    formId: "SL241111Form",
    SaveButtonId: "PD141111_SUB",
    initDataGrid: function () {
        this.fileButton();
    },
    fileButton: function () {
        $("#" + SL241111.fileButtonId).change(function () {
            SL241111.fileData();
        });
        $("#" + SL241111.SaveButtonId).click(function () {
            SL241111.saveData();
        });
    },
    fileData: function () {
        $("#con").val($("#file").val());
        $("#file").html();
    },
    saveData: function () {
        var validator = mainValidation($("#" + SL241111.formId));
        var isValid = validator.form();
        if (isValid) {
            $.alertMessage.confirm("你确定要保存当前数据吗？", function () {
                $.alertMessage.close();
                formData = getFormData($("#" + SL241111.formId));
                $('#main-content').postUrl($("#" + SL241111.formId).attr("action"),
                    formData,
                    function () {
                        $('#main-content').postUrl(
                            Main.contextPath + "/SL241109/init/"+chapClass);
                        $.pdialog.close();
                    });

            });
        }
    }
}
$(document).ready(function () {
    //初始化调用
    SL241111.initDataGrid();
});