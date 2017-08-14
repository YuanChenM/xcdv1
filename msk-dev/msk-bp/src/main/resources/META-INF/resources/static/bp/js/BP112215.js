
var BP112215 = {
    BP112215Grid: null,
    formId : "BP112215Form",
    detailRows: [],
    trIndex: 0,
    initDataGrid: function () {

        BP112215.BP112215Grid = $('#BP112215_Grid').grid({
            fnRowCallback: BP112215.rowCallback
        });
        this.bindOpenEnven();
    },
    bindOpenEnven: function () {
        $('#BP112215_Grid tbody').on('click', 'tr td.details-control', function () {
            var tr = $(this).closest('tr');
            var $trClass = $(tr).attr("class");
            var trSeq = $(this).attr("trIndex");
            if ($trClass.indexOf("details") >= 0) {
                $(tr).removeClass("details");
                $("#appendTrDetail" + trSeq).remove();
            } else {
                $('#main-content').postUrl(Main.contextPath + "/BP112215/findOrderLevelList", {
                    'filterMap[pdCode]': BP112215.detailRows[trSeq].pdCode,
                    'filterMap[logiareaCode]': BP112215.detailRows[trSeq].logiareaCode,
                    'filterMap[slCode]': BP112215.detailRows[trSeq].slCode,
                    'filterMap[pricecyclePeriod]': BP112215.detailRows[trSeq].pricecyclePeriod
                }, function (data) {
                    $(tr).addClass("details");
                    $(tr).after(BP112215.appendTrShow(trSeq, data));
                    $('.tree').treegrid();
                }, {refreshHtml: false});
            }
        });
    },
    appendTrShow: function (index,data) {
        var trHtml = "<tr id='appendTrDetail" + index + "'>";
        trHtml += "<td colspan='9'></td>";
        trHtml += "<td colspan='3'>";
        if (data != null) {
            trHtml += "<table class='tree dataTable no-footer' width='width: 100%'>";
            trHtml += '<tr style="background:#DBDBDB">';
            trHtml += '<td width="15%">订单等级</td>'
            + '<td width="15%">报价/Kg</td>'
            + '<td width="15%">折扣率</td>';
            trHtml += '</tr>';
            $.each(data, function (i, bpBean) {
                trHtml += '<tr>';
                trHtml += '<td>' + bpBean.orderlevelName + '</td>';
                trHtml += '<td style="white-space:pre;">' + bpBean.priceofkg + '</td>';
                trHtml += '<td style="white-space:pre;">' + bpBean.discount + '</td>';
                trHtml += '</tr>';
            });
            trHtml += "</table>";
        } else {
            trHtml += "无";
        }
        trHtml += "</td>";
        trHtml += "</tr>";

        return trHtml;
    },
    rowCallback: function (tr, data) {
        var $trId = "trId" + data.pricecycleId;
        $(tr).attr("id", $trId);
        var $td = $(tr).children('td').eq(0);
        $td.attr("trIndex", BP112215.trIndex);
        $td.html("");
        $td.addClass("details-control");
        BP112215.detailRows[BP112215.trIndex] = data;
        BP112215.trIndex++;
    }
}
$(document).ready(function () {
    // 初始化调用
    BP112215.initDataGrid();
});