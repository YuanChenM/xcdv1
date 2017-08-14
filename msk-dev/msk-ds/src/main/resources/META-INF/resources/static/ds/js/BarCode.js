/**
 * 条形码列表JS
 * Created by marshall on 16/4/29.
 */
var BarCode = {
    printButtonId: "BarCode_PRINT",
    saveButtonId: "BarCode_NEW",
    saveForm: "BarCodeSaveForm",
    BarCodeGrid: null,
    initDataGrid: function () {
        BarCode.BarCodeGrid = $('#BarCode_Grid').grid({
            actionHandler: BarCode.actionHandler,
        });
        this.bindSaveButton();
        this.bindPrintButton();
    },
    actionHandler: function (rowdata, coltype, row, col) {
        if (coltype == "delete") {
            $('#main-content').postUrl(Main.contextPath + "/BarCode/delete", rowdata);
        }
    },
    bindSaveButton: function () {
        $("#" + BarCode.saveButtonId).click(function () {
            $.alertMessage.confirm("你确定要保存当前数据吗？", function () {
                $.alertMessage.close();
                formData = getFormData($("#" + BarCode.saveForm));
                $('#main-content').postUrl($("#" + BarCode.saveForm).attr("action"), formData);
            });
        });
    },
    bindPrintButton: function () {
        $("#" + BarCode.printButtonId).click(function () {
            //var url = {
            //    "siteCode": "SNK",
            //    "auth": "test",
            //    "loginId": "hoperun",
            //    "param": {
            //        "printBarcodeId": $("#printBarcodeId").val()
            //    }
            //};
            //var urlStr = JSON.stringify(url);
            //urlStr = urlStr.replace(/\"/g, "#");
            //urlStr = "snkBarCode://&" + urlStr + "&";

            var urlStr = "snkBarCode://&" + $("#printBarcodeId").val()
                                    + "&" + $("#printTotalCount").val()
                                    + "&" + $("#printEnvironment").val();
            window.open(urlStr);
            //var newPage = window.open('', '');
            //newPage.location.href = urlStr;
            //newPage.close();
        });
    }
}
$(document).ready(function () {
    // 初始化调用
    BarCode.initDataGrid();
});