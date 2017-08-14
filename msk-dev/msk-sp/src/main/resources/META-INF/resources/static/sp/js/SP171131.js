
var SP171131 = {
    SP171131Grid: null,
    formId : "SP171131Form",
    detailRows: [],
    trIndex: 0,
    initDataGrid: function () {

        SP171131.SP171131Grid = $('#SP171131_Grid').grid({
            fnRowCallback: SP171131.rowCallback
        });
        this.bindOpenEnven();
    },
    bindOpenEnven: function () {
        $('#SP171131_Grid tbody').on('click', 'tr td.details-control', function () {
            var tr = $(this).closest('tr');
            var $trClass = $(tr).attr("class");
            var trSeq = $(this).attr("trIndex");
            if ($trClass.indexOf("details") >= 0) {
                $(tr).removeClass("details");
                $("#appendTrDetail" + trSeq).remove();
            } else {
                $('#main-content').postUrl(Main.contextPath + "/SP171131/findOrderLevelList", {
                    'filterMap[pdCode]': SP171131.detailRows[trSeq].pdCode,
                    'filterMap[logiareaCode]': SP171131.detailRows[trSeq].logiareaCode,
                    'filterMap[slCode]': SP171131.detailRows[trSeq].slCode,
                    'filterMap[pricecyclePeriod]': SP171131.detailRows[trSeq].pricecyclePeriod
                }, function (data) {
                    $(tr).addClass("details");
                    $(tr).after(SP171131.appendTrShow(trSeq, data));
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
            + '<td width="15%">报价</td>'
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
        $td.attr("trIndex", SP171131.trIndex);
        $td.html("");
        $td.addClass("details-control");
        SP171131.detailRows[SP171131.trIndex] = data;
        SP171131.trIndex++;
    }
}
$(document).ready(function () {
    // 初始化调用
    SP171131.initDataGrid();
});