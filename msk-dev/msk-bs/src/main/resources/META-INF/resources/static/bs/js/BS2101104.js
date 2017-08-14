/**
 * 买手店列表JS
 *
 * @author cx
 */
var $List_Grid;
var BS2101104 = {
    formId: "BS2101104FormId",
    searchData: "BS2101104_search",
    init: function () {

        $List_Grid = $('#bs2101104_list_grid').grid({
            fnRowCallBack: BS2101104.rowCallback,
            actionHandler: BS2101104.actionHandler
        });
        this.changeSelect();
        //this.queryData();
    },

    actionHandler: function (rowdata, coltype, row, col) {
        //成为专属买家
        if (col == 11) {
            $.alertMessage.confirm("你确定要申请成为专属会员吗？", function () {
                $.alertMessage.close();
                $('#main-content').postUrl(Main.contextPath + "/BS2101104/SlApply", {
                    slCode: rowdata.slCode,
                    houseAccount: rowdata.houseAccount,
                    houseCode: rowdata.houseCode,
                    buyerId: rowdata.buyerId,
                    flge: 5
                }, function () {
                    $List_Grid.fnDraw();
                }, {refreshHtml: false});
            });
        }
        //买家申请成为专属会员
        if (col == 12) {
            $.alertMessage.confirm("你确定要申请成为专属会员吗？", function () {
                $.alertMessage.close();
                $('#main-content').postUrl(Main.contextPath + "/BS2101104/SlApply", {
                    slCode: rowdata.slCode,
                    houseAccount: rowdata.houseAccount,
                    houseCode: rowdata.houseCode,
                    buyerId: rowdata.buyerId,
                    flge: 6
                }, function () {
                    $List_Grid.fnDraw();
                }, {refreshHtml: false});
            });
        }
        //冻品管家申请成为专属会员
        if (col == 13) {
            $.alertMessage.confirm("你确定要申请成为专属会员吗?", function () {
                $.alertMessage.close();
                $('#main-content').postUrl(Main.contextPath + "/BS2101104/SlApply", {
                    slCode: rowdata.slCode,
                    houseAccount: rowdata.houseAccount,
                    houseCode: rowdata.houseCode,
                    buyerId: rowdata.buyerId,
                    flge: 7
                }, function () {
                    $List_Grid.fnDraw();
                },{refreshHtml: false});
            });
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
        $("#" + BS2101104.searchData).click(function () {
            formData = getFormData($("#" + BS2101104.formId));
            $('#main-content').postUrl(
                $("#" + BS2101104.formId).attr("action"), formData, function () {
                    $List_Grid.fnDraw();
                }, {refreshHtml: false});
        });
    }
}
$(document).ready(function () {
    // 初始化调用
    BS2101104.init();
});
