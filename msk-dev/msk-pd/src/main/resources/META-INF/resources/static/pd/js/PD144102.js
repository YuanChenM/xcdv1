var PD144102 = {
    formId: "PD144102Form",
    addButton: "PD144102_SAVE",
    imagePath: "",
    init: function () {
        this.bindAddButton();
    },
    bindChange: function () {
        var img = new Image();//构造JS的Image对象
        img.src = document.PD144102Form.productImgFile.value;//将本地图片赋给image对象
        img.onreadystatechange = function () {
            if (img.readyState == "complete") {
                imagePath = document.getElementById("coverPath").value;
            }
        }

    },
    bindAddButton: function () {
        $("#" + PD144102.addButton).click(function () {
            if (true) {
                var $uploadFile = $("#" + PD144102.formId);
                $.core.uploadForm($uploadFile, true);
            }
            else {
                $.alertMessage.info("请选择图片？")
            }
        });
    }

};
$(document).ready(function () {
    // 初始化调用
    PD144102.init();
});