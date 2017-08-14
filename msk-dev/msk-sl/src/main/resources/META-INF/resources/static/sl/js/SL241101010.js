/**
 * Created by fjm on 2016/1/30.
 */
var SL241101010 = {
    formId: "SL241101010Form",
    saveButton: "SL241101010_SAVE",
    init: function () {
        this.bindDatePicber(".authTermBeginThree");
        this.bindDatePicber(".authTermEndTwo");
        this.saveData();
        this.bindDeletebutton();
    },
    bindDatePicber: function (orderTimeId) {
        $(orderTimeId).datepicker({
            showButtonPanel: true,
            dateFormat: 'yy-mm-dd',
            changeMonth: true,
            changeYear: true
        });
    },
    saveData: function () {
        $("input[name='buttonName']").click(function () {
            var buttonId = $(this).attr("saveId");
            var authTermBeginThree = $("#authTermBeginThree" + buttonId).val();
            if (authTermBeginThree == "" || authTermBeginThree == null) {
                $("input[name='authTermBegin']").remove();
                //$("#authTermBeginThree" + buttonId).val($("#authTermBeginThree" + buttonId).val() + "0000-00-00 00:00:00");
            } else {
                $("#authTermBeginThree" + buttonId).val($("#authTermBeginThree" + buttonId).val() + " 00:00:00");
            }
            var authTermEndTwo = $("#authTermEndTwo" + buttonId).val();
            if (authTermEndTwo == "" || authTermEndTwo == null) {
                $("input[name='authTermEnd']").remove();
                //$("#authTermEndTwo" + buttonId).val($("#authTermEndTwo" + buttonId).val() + "0000-00-00 00:00:00");
            } else {
                $("#authTermEndTwo" + buttonId).val($("#authTermEndTwo" + buttonId).val() + " 00:00:00");
            }
            formData = getFormData($("#" + SL241101010.formId + buttonId));
            $('#main-content').postUrl($("#" + SL241101010.formId + buttonId).attr("action"),
                formData,
                function (data) {
                    if (data == "1") {
                        $.alertMessage.info("更新成功!");
                    } else {
                        $.alertMessage.info("更新失败!");
                    }
                }, {refreshHtml: false});
        });

        $("#SL241101010_ADD").click(function(){
            $.pdialog.open("生产商添加",Main.contextPath + "/SL24110101001/init",{width:800,height:600});
        });
    },
    bindDeletebutton:function(){
        $("input[name='buttonDeleteName']").click(function () {
            var deleteId = $(this).attr("deleteId");
            formData = getFormData($("#SL241101010Form" + deleteId));
            $('#main-content').postUrl(Main.contextPath + "/SL241101010/delete", {slCode:formData.slCode,epId:formData.producerEpId,markFlg:formData.markFlg}, function (data) {
                if (data == "1") {
                    $.alertMessage.info("删除成功!");
                    $('#main-content').postUrl(Main.contextPath + "/SL241101/init");
                } else {
                    $.alertMessage.info("删除失败!");
                }
            });
        });
    }
}

$(document).ready(function() {
    SL241101010.init();
});

