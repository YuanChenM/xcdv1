/**
 * 买手店列表JS
 *
 * @author cx
 */
var $List_Grid;
var BS2101103 = {
    formId: "bs2101103FormId",
    init: function () {
        $List_Grid = $('#bs2101103_list_grid').grid({
            actionHandler: BS2101103.actionHandler
        });
        this.changeSelect();
        this.queryData();
    },
    actionHandler: function (rowdata, coltype, row, col) {
        /** 操作按钮 */

        if (coltype == 'add') {
            $.alertMessage.confirm("解除当前专属会员操作，会删除删除当前管家下的该会员，你确定要解除当前专属会员吗？", function () {
                $.alertMessage.close();
                $('#main-content').postUrl(Main.contextPath + "/BS2101103/relievePelation/", {
                    slCode: rowdata.slCode,
                    houseCode: rowdata.houseCode,
                    buyerId: rowdata.buyerId
                }, function () {
                    $List_Grid.fnDraw();
                    $.alertMessage.info("解除成功!");
                }, {refreshHtml: false});
            })
        }
        if (coltype == 'edit') {
            $('#main-content').postUrl(Main.contextPath + "/BS2101103/buildPelation", {
                slCode: rowdata.slCode,
                houseCode: rowdata.houseCode,
                buyerId: rowdata.buyerId
            }, function () {
                $List_Grid.fnDraw();
            }, {refreshHtml: false});
        }

    },
    changeSelect: function () {
        var citySelect = $('#city_select');
        var districtSelect = $('#district_select');
        $('#province_select').change(function () {
            $("#city_select").find("option").not(":first").remove();
            $("#district_select").find("option").not(":first").remove();
            var provinceCode = $('#province_select').val();
            if (provinceCode != 0) {
                $('#main-content').postUrl(Main.contextPath + '/SL241103000/findCity', {provinceCode: provinceCode},
                    function (data) {
                        $.each(data, function (i, item) {
                            citySelect.append("<option value='" + item.cityCode + "'>" + item.cityName + "</option>");
                        });
                    }, {refreshHtml: false});
            }
        });
        $('#city_select').change(function () {
            $("#district_select").find("option").not(":first").remove();
            var cityCode = $("#city_select").val();
            if (cityCode != 0) {
                $('#main-content').postUrl(Main.contextPath + '/SL241103000/findDistrict', {cityCode: cityCode}, function (data2) {
                    $.each(data2, function (i, item) {
                        districtSelect.append("<option value='" + item.districtCode + "'>" + item.districtName + "</option>");
                    });
                }, {refreshHtml: false})
            }
        });
    },
    queryData: function () {
        $("#" + BS2101103.searchData).click(function () {
            formData = getFormData($("#" + BS2101103.formId));
            $('#main-content').postUrl(
                $("#" + BS2101103.formId).attr("action"), formData, function () {
                    $List_Grid.fnDraw();
                }, {refreshHtml: false});
        });
    }
}
$(document).ready(function () {
    // 初始化调用
    BS2101103.init();
});
