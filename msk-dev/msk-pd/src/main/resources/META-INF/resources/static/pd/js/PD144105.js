/**
 * 楼层新增
 *
 * @author cx
 */
var $List_Grid;
var PD144105 = {
    formId: "pd144105FormId",
    searchData: "PD144105_SEARCH",
    saveButton: "PD144105_SAVE",
    init: function () {
        $List_Grid = $('#PD144105_list_grid').grid({
            /*actionHandler: PD144103.actionHandler*/
        });
        this.queryData();
        this.bindSearchButton();
        this.bindConfirmButton();
        this.selectChange();

    },

    // 绑定按钮
    bindSearchButton: function () {
        $("#" + PD144105.searchData).click(function () {
            FormUtils.setFormValue(PD144105.formId, "PD144105");
            $List_Grid.fnDraw();
        });
    },
    queryData: function () {
        $("#" + PD144105.searchData).click(function () {
            formData = getFormData($("#" + PD144105.formId));
            $('#main-content').postUrl(
                $("#" + PD144105.formId).attr("action"), formData, function () {
                    $List_Grid.fnDraw();
                }, {refreshHtml: false});
        });
    },
    selectChange: function () {
        $("#classesCode").change(function () {
            $("#machiningCode").find("option").not(":first").remove();
            $("#breedCode").find("option").not(":first").remove();
            $("#featureCode").find("option").not(":first").remove();
            $("#weightCode").find("option").not(":first").remove();
            var classesCode = $("#classesCode").val();
            console.log("classesCode: " + classesCode);
            $('#main-content').postUrl(Main.contextPath + "/PD144105/queryTwo", {classesCode: classesCode}, function (data) {
                $(data).each(function (i, val) {
                    $("#machiningCode").append($('<option>', {value: val.machiningCode}).text(val.machiningName));
                });
            }, {refreshHtml: false});
        });
        $("#machiningCode").change(function () {
            $("#breedCode").find("option").not(":first").remove();
            $("#featureCode").find("option").not(":first").remove();
            $("#weightCode").find("option").not(":first").remove();
            var classesCode = $("#classesCode").val();
            var machiningCode = $("#machiningCode").val();
            console.log("machiningCode: " + machiningCode);
            $('#main-content').postUrl(Main.contextPath + "/PD144105/queryBreed", {
                classesCode: classesCode,
                machiningCode: machiningCode
            }, function (data) {
                $(data).each(function (i, val) {
                    $("#breedCode").append($('<option>', {value: val.breedCode}).text(val.breedName));
                });
            }, {refreshHtml: false});
        });
        $("#breedCode").change(function () {
            $("#featureCode").find("option").not(":first").remove();
            $("#weightCode").find("option").not(":first").remove();
            var classesCode = $("#classesCode").val();
            var machiningCode = $("#machiningCode").val();
            var breedCode = $("#breedCode").val();
            console.log("breedCode: " + breedCode);
            $('#main-content').postUrl(Main.contextPath + "/PD144105/queryFeature", {
                classesCode: classesCode, machiningCode: machiningCode,
                breedCode: breedCode
            }, function (data) {
                $(data).each(function (i, val) {
                    $("#featureCode").append($('<option>', {value: val.featureCode}).text(val.featureName));
                });
            }, {refreshHtml: false});
        });
        $("#featureCode").change(function () {
            $("#weightCode").find("option").not(":first").remove();
            var classesCode = $("#classesCode").val();
            var machiningCode = $("#machiningCode").val();
            var breedCode = $("#breedCode").val();
            console.log("breedCode: " + breedCode);
            var featureCode = $("#featureCode").val();
            console.log("featureCode: " + featureCode);
            $('#main-content').postUrl(Main.contextPath + "/PD144105/queryWeight", {
                classesCode: classesCode, machiningCode: machiningCode,
                breedCode: breedCode, featureCode: featureCode
            }, function (data) {
                $(data).each(function (i, val) {
                    $("#weightCode").append($('<option>', {value: val.weightCode}).text(val.weightName));
                });
            }, {refreshHtml: false});
        });
    },

    bindConfirmButton: function () {
        $("#" + PD144105.saveButton).click(function () {
            var objs = $List_Grid.getChoiceData();
            if (objs.length == 0) {
                $.alertMessage.warn("请选产品");
                return;
            }

            var floorId = $("#floorId").val();
            var lgcsCode = $("#lgcsCode").val();
            var isEdit = $("#isEdit").val();
            var floorName = $("#floorName").val();
            var color = $("#color").val();
            var lgcsName = $("#lgcsName").text();
            var json = {};// 创建json 对象
            for (var i = 0; i < objs.length; i++) {//  把数组的对象封装到json
                json[i] = {"floorId": floorId, "pdCode": objs[i]["pdCode"], "id": "1"};
            }

            var jsonStr = JSON.stringify(json);
            $.post(Main.contextPath + "/PD144105/save", {param: jsonStr}, function (data) {
                $('#main-content').postUrl(Main.contextPath + "/PD144104/init", {
                    id: floorId,
                    lgcsCode: lgcsCode,
                    isEdit: isEdit,
                    floorName: floorName,
                    color: color,
                    lgcsName: lgcsName
                });
                $.pdialog.close();
            });
        });
    },
    actionHandler: function (rowdata, coltype, row, col) {

    }

}
$(document).ready(function () {
    // 初始化调用
    PD144105.init();
});
