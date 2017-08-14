
var SC182205 = {
    SC182205Grid: null,
    searchButtonId: "SC182205_SAVE",
    formId: "SC182205Form",
    initDataGrid: function () {

        SC182205.bindSearchButton();

    },
    bindSearchButton: function () {
        $("#" + SC182205.searchButtonId).click(function () {

            if(document.getElementById("productPrintNum").value==''){
                alert("打印页码不能为空,且必须以','或'-'形式出现：如1,3或1-20");
                return false;
            }else{
                if(window.confirm("确定要打印么？")==true) {
                    var breedName = document.getElementById("breedName").value;
                    var gradeName = document.getElementById("gradeName").value;
                    var proLotNum = document.getElementById("proLotNum").value;
                    var readProLotNum = document.getElementById("readProLotNum").value;
                    var productPrintNum = document.getElementById("productPrintNum").value;
                    //var dateString = new Date().format('yyyyMMddhhmmss').substring(0,12);
                    var dateString = new Date().format('yyyyMMddhhmmss');
                    var fso, f1, ts, s;
                    var ForReading = 1;
                    fso = new ActiveXObject("Scripting.FileSystemObject");
                    f1 = fso.CreateTextFile("D:\\箱标签\\"+proLotNum+dateString+".txt", true);
                    f1.WriteLine(breedName+'|'+gradeName+'|'+proLotNum+'|'+readProLotNum+'|'+productPrintNum);
                    f1.WriteBlankLines(1);
                    f1.Close();

                    var validator = mainValidation($("#" + SC182205.formId));
                    var isValid = validator.form();
                    if (isValid) {
                        formData = getFormData($("#" + SC182205.formId));
                        $('#main-content').postUrl($("#" + SC182205.formId).attr("action"), formData, function(data){
                        });
                    }
                }
            }



        });
    }
}
$(document).ready(function () {
    // 初始化调用
    SC182205.initDataGrid();
});