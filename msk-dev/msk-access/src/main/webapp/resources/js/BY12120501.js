﻿var lgcsAreaCode = localStorage.lgcsAreaCode;
var cityCode = localStorage.cityCode;
var districtCode = localStorage.districtCode;
//批发市场菜场列表
var marketList = [];
var superiorQua = "";
var superiorId = "";
$(function () {
    var localPosition = localStorage.cityName + "市" + localStorage.districtName;
    $("#currentDistrict").text(localPosition);
    // 获取买家类型下拉框
    var buyerTypeList = [];
    var flickerAPI = url + 'api/v1/by/common/master';
    var paramData = {"client": "abcd", "auth": "xxxx", "loginid": "a124", "param": {"constantType": "BuyerType"}};
    $.ajax({
        type: "POST",
        async: false,
        url: flickerAPI,
        timeout: 60,
        dataType: 'json',
        contentType: "application/json",
        data: JSON.stringify(paramData),
        success: function (data) {
            buyerTypeList = data.result;
        },
        error: function () {
            alert("error");
        }
    });

    debugger;
    var flickerAPI = url + 'api/v1/by/buyerInfo/findDetail';
    var buyerId = localStorage.buyerId;
    var buyerTypeCode = "";
    var paramData = {"client": "abcd", "auth": "xxxx", "loginid": "a124", "param": {"buyerId": buyerId}};
    $.ajax({
        type: "POST",
        async: false,
        url: flickerAPI,
        timeout: 60,
        dataType: 'json',
        contentType: "application/json",
        data: JSON.stringify(paramData),
        success: function (data) {
            if (data.status == "S") {
                var basicInfo = data.result;
                buyerTypeCode = basicInfo.superiorType;
                superiorQua = basicInfo.superiorQua;
                superiorId = basicInfo.superiorId;
                findMarketList(basicInfo.superiorType, basicInfo.superiorId, basicInfo.superiorQua, basicInfo.superiorSubType, basicInfo.isMarketFlg);
            }
        },
        error: function () {
            alert("error");
        }
    });
    if (buyerTypeList.length > 0) {
        var buyerType = $("#buyerType");
        for (var i = 0; i < buyerTypeList.length; i++) {
            if (buyerTypeCode == buyerTypeList[i].constantValue) {
                buyerType.append("<option value=" + buyerTypeList[i].constantValue + " selected>" + buyerTypeList[i].constantName + "</option>")
            } else {
                buyerType.append("<option value=" + buyerTypeList[i].constantValue + ">" + buyerTypeList[i].constantName + "</option>")
            }
        }
        buyerType.selectmenu("refresh");
    }
});
/**
 * 买家类型变更
 */
function buyerTypeChange() {
    var buyerType = $("#buyerType option:selected").val();
    findMarketList(buyerType, null, null, null, null);
}
/**
 * 买家类型变更
 */
function isFoodMarketChange() {
    setMessageDivStyle("", "none");
    if ($('#isFoodMarket').is(':checked')) {
        var flickerAPI = url + 'api/v1/by/condition/findMarketFood';
        var marketType = $("#marketType");
        $("#marketName").css("display", "");
        $("#marketName").html("");
        $("#marketTypeDiv").css("display", "");
        $("#marketType").html("");
        $("#marketLevel").css("display", "");
        $("#marketLevelNameDiv").css("display", "");
        $("#marketLevelNameDiv").val("");
        var paramData = {
            "client": "abcd",
            "auth": "xxxx",
            "loginid": "a124",
            "param": {"lgcsAreaCode": lgcsAreaCode, "cityCode": cityCode, "districtCode": districtCode}
        };

        $.ajax({
            type: "POST",
            async: false,
            url: flickerAPI,
            timeout: 60,
            dataType: 'json',
            contentType: "application/json",
            data: JSON.stringify(paramData),
            success: function (data) {
                if (data.status == "S") {
                    marketList = data.result;
                    if (marketList.length > 0) {
                        debugger
                        for (var i = 0; i < marketList.length; i++) {
                            if (marketList[i].terMarketId == superiorId) {
                                marketType.append("<option value=" + marketList[i].fodMarketId + " selected>" + marketList[i].marketName + "</option>")
                            } else {
                                marketType.append("<option value=" + marketList[i].fodMarketId + ">" + marketList[i].marketName + "</option>")
                            }
                            marketType.selectmenu("refresh");
                        }
                        if (superiorQua != null && superiorQua != undefined) {
                            $("#marketLevelName").val(superiorQua);
                        } else {
                            $("#marketLevelName").val(marketList[0].sizeTypeName);
                        }
                    }
                } else {
                    setMessageDivStyle("该地区暂无菜场,请返回更换地区.", "block");
                }
            },
            error: function () {
                alert("error");
            }
        });
    } else {
        $("#marketName").css("display", "none");
        $("#marketTypeDiv").css("display", "none");
        $("#marketLevel").css("display", "none");
        $("#marketLevelNameDiv").css("display", "none");
    }
}
/**
 * 批发市场或菜场选择变更
 */
function marketTypeChange() {
    var buyerType = $("#buyerType option:selected").val();
    var marketId = $("#marketType option:selected").val();
    if (marketList.length > 0) {
        for (var i = 0; i < marketList.length; i++) {
            if (buyerType == "1") {
                if (marketId == marketList[i].terMarketId) {
                    $("#marketLevelName").val(marketList[i].marketLevelName);
                    break;
                }
            } else if (buyerType == "2") {
                if (marketId == marketList[i].fodMarketId) {
                    $("#marketLevelName").val(marketList[i].sizeTypeName);
                    break;
                }
            }
        }
    }
}
/**
 * 二级菜单发生变更
 */
function SubTypeChange() {
    var buyerType = $("#buyerType option:selected").val();
    var superiorSubType = $("#superiorSubType option:selected").val();
    if (buyerType == "8" && superiorSubType == "1") {
        $('#isFoodMarketDiv').show();
    } else {
        $('#isFoodMarketDiv').hide();
    }
}

//查询批发市场数据
function findMarketList(buyerType, marketId, marketLevelName, superiorSubType, isMarketFlg) {
    //查询物流区下的批发市场
    var marketType = $("#marketType");
    var flickerAPI = "";
    setMessageDivStyle("", "none");
    $("#marketName").css("display", "");
    $("#marketName").html("");
    $("#marketTypeDiv").css("display", "");
    $("#marketType").html("");
    $("#superiorSubName").css("display", "");
    $("#superiorSubName").html("");
    $("#marketLevel").css("display", "");
    $("#superiorSubTypeDiv").css("display", "");
    $("#marketLevelNameDiv").css("display", "");
    $("#marketLevelNameDiv").val("");
    $("#superiorSubType").html("");
    if (buyerType == "1") {
        $("#marketName").text("选择批发市场");
        $("#marketLevel").text("批发市场等级");
        $("#superiorSubName").css("display", "none");
        $("#superiorSubTypeDiv").css("display", "none");
        $("#isFoodMarketDiv").css("display", "none");
        flickerAPI = url + 'api/v1/by/condition/findMarketTerminal';
    } else if (buyerType == "2") {
        $("#marketName").text("选择菜场");
        $("#marketLevel").text("菜场等级");
        $("#superiorSubName").css("display", "none");
        $("#superiorSubTypeDiv").css("display", "none");
        $("#isFoodMarketDiv").css("display", "none");
        flickerAPI = url + 'api/v1/by/condition/findMarketFood';
    } else if (buyerType == "5") {
        $("#superiorSubName").text("选择二级分类");
        $("#marketName").css("display", "none");
        $("#marketTypeDiv").css("display", "none");
        $("#marketLevel").css("display", "none");
        $("#marketLevelNameDiv").css("display", "none");
        flickerAPI = url + 'api/v1/by/condition/findBuyerList/chinesFoodType';
    } else if (buyerType == "8") {
        $("#superiorSubName").text("选择二级分类");
        $("#marketName").css("display", "none");
        $("#marketTypeDiv").css("display", "none");
        $("#marketLevel").css("display", "none");
        $("#marketLevelNameDiv").css("display", "none");
        flickerAPI = url + 'api/v1/by/condition/findBuyerList/machiningType';
    } else {
        $("#marketName").css("display", "none");
        $("#marketTypeDiv").css("display", "none");
        $("#marketLevel").css("display", "none");
        $("#marketLevelNameDiv").css("display", "none");
        $("#superiorSubName").css("display", "none");
        $("#superiorSubTypeDiv").css("display", "none");
        $("#isFoodMarketDiv").css("display", "none");
        return false;
    }
    var paramData = {
        "client": "abcd",
        "auth": "xxxx",
        "loginid": "a124",
        "param": {"lgcsAreaCode": lgcsAreaCode, "cityCode": cityCode, "districtCode": districtCode}
    };
    $.ajax({
        type: "POST",
        async: false,
        url: flickerAPI,
        timeout: 60,
        dataType: 'json',
        contentType: "application/json",
        data: JSON.stringify(paramData),
        success: function (data) {
            if (data.status == "S") {
                marketList = data.result;
                if (marketList.length > 0) {
                    for (var i = 0; i < marketList.length; i++) {
                        if (buyerType == "1") {
                            if (marketId != null && marketId != undefined) {
                                if (marketList[i].terMarketId == marketId) {
                                    marketType.append("<option value=" + marketList[i].terMarketId + " selected>" + marketList[i].marketName + "</option>")
                                } else {
                                    marketType.append("<option value=" + marketList[i].terMarketId + ">" + marketList[i].marketName + "</option>")
                                }
                            } else {
                                marketType.append("<option value=" + marketList[i].terMarketId + ">" + marketList[i].marketName + "</option>")
                            }
                            marketType.selectmenu("refresh");
                        } else if (buyerType == "2") {
                            if (marketId != null && marketId != undefined) {
                                if (marketList[i].fodMarketId == marketId) {
                                    marketType.append("<option value=" + marketList[i].fodMarketId + " selected>" + marketList[i].marketName + "</option>")
                                } else {
                                    marketType.append("<option value=" + marketList[i].fodMarketId + ">" + marketList[i].marketName + "</option>")
                                }
                            } else {
                                marketType.append("<option value=" + marketList[i].fodMarketId + ">" + marketList[i].marketName + "</option>")
                            }
                            marketType.selectmenu("refresh");
                        } else if (buyerType == "5" || buyerType == "8") {
                            if (superiorSubType != null && superiorSubType != undefined) {
                                if (marketList[i].fodMarketId == superiorSubType) {
                                    $("#superiorSubType").append("<option value='" + marketList[i].constantValue + "'selected>" + marketList[i].constantName + "</option>");
                                } else {
                                    $("#superiorSubType").append("<option value='" + marketList[i].constantValue + "'>" + marketList[i].constantName + "</option>");
                                }
                            } else {
                                $("#superiorSubType").append("<option value='" + marketList[i].constantValue + "'>" + marketList[i].constantName + "</option>");
                            }
                            $("#superiorSubType").selectmenu("refresh");
                            var superiorSubTypeVal = $("#superiorSubType option:selected").val();
                            if (buyerType == "8" && superiorSubTypeVal == "1") {
                                if (isMarketFlg == "1") {
                                    $("#isFoodMarket").attr("checked", true);
                                } else {
                                    $("#isFoodMarket").attr("checked", false);
                                }
                                $('#isFoodMarketDiv').show();
                            } else {
                                $('#isFoodMarketDiv').hide();
                            }
                        }
                    }
                    marketType.selectmenu("refresh");
                    if (marketLevelName != null && marketLevelName != undefined) {
                        $("#marketLevelName").val(marketLevelName);
                    } else {
                        if (buyerType == "1") {
                            $("#marketLevelName").val(marketList[0].marketLevelName);
                        } else if (buyerType == "2") {
                            $("#marketLevelName").val(marketList[0].sizeTypeName);
                        }
                    }
                }
            } else {
                setMessageDivStyle("该地区暂无批发市场/菜场,请返回更换地区.", "block");
            }
        },
        error: function () {
            alert("error");
        }
    });
}
//买家类型更新
function buyerMarket() {
    var buyerId = localStorage.buyerId;
    var buyerType = $("#buyerType option:selected").val();
    var buyerTypeName = $("#buyerType option:selected").text();
    var superiorSubType = $("#superiorSubType option:selected").val();
    var superiorSubName = $("#superiorSubType option:selected").text();
    var superiorId = "";
    var superiorQua = "";
    var isMarketFlg = "0";
    debugger;
    if (buyerType == "1" || buyerType == "2") {
        superiorId = $("#marketType option:selected").val();
        superiorQua = $("#marketLevelName").val();
    }
    if (buyerType === "8" && superiorSubType == "1") {
        if ($('#isFoodMarket').is(':checked')) {
            isMarketFlg = "1";
            superiorId = $("#marketType option:selected").val();
            superiorQua = $("#marketLevelName").val();
        }
    }
    var flickerAPI = url + 'api/v1/by/buyerInfo/update';
    var paramData = {
        "client": "abcd", "auth": "xxxx", "loginid": "a124", "param": {
            "buyerId": buyerId,
            "superiorType": buyerType,
            "superiorName": buyerTypeName,
            "superiorId": superiorId,
            "superiorQua": superiorQua,
            "superiorSubType": superiorSubType,
            "superiorSubName": superiorSubName,
            "isMarketFlg": isMarketFlg
        }
    };
    $.ajax({
        type: "POST",
        async: false,
        url: flickerAPI,
        timeout: 60,
        dataType: 'json',
        contentType: "application/json",
        data: JSON.stringify(paramData),
        success: function (data) {
            setTimeout(function () {
                if (data.status == "S") {
                    window.location = "BY121206.html";
                } else {
                    alert(data.message);
                }
            }, 0);
        },
        error: function () {
            alert("error");
        }
    });
}
//设置messageDiv样式
function setMessageDivStyle(message, display) {
    $("#message").css("display", display);
    $("#message").text(message);
}
//返回前一个画面
function returnPage() {
    if (localStorage.enterFlg == "edit") {
        window.location = "BY121211.html";
    } else if (localStorage.enterFlg == "view") {
        window.location = "BY121232.html";
    } else {
        window.location = "BY121205.html";
    }
}
//重新选择地区
function reSelectDistrict() {
    window.location = "BY121203.html";
}