/**
 * 分销章程卖家意见列表JS
 *
 * @author gyh
 */
var $List_Grid;
var SL241120 = {
    detailRows: [],
    trIndex: 0,
    init: function () {
        $List_Grid = $('#SL241120_list_grid').grid({
            fnRowCallback: SL241120.rowCallback
        });
        this.bindOpenEnven();
    }, bindOpenEnven: function () {
        $('#SL241120_list_grid tbody').on('click', 'tr td.details-control', function () {
            var tr = $(this).closest('tr');
            var $trClass = $(tr).attr("class");
            var trSeq = $(this).attr("trIndex");
            if ($trClass.indexOf("details") >= 0) {
                $(tr).removeClass("details");
                $("#appendTr" + trSeq).remove();
            } else {
                $('#main-content').postUrl(Main.contextPath + "/SL241120/findSlDistReguSug/"+chapClass, {
                    slCode: SL241120.detailRows[trSeq].slCode,
                }, function (data) {
                    $(tr).addClass("details");
                    $(tr).after(SL241120.appendTrShow(trSeq, data));
                }, {refreshHtml: false});
            }
        });
    },
    appendTrShow: function (index, data) {
        var trHtml = '<tr id="appendTr' + index + '">';
        trHtml += "<td colspan='5'>";
        if(data!=null) {
            trHtml += "<table class='tree dataTable no-footer' style='width: 100%'>";
            trHtml += '<tr style="background:#DBDBDB">';
            trHtml += '<td width="10%">章节</td>'
                + '<td width="30%">标题</td>'
                + '<td width="20%">确认结果</td>'
                + '<td>意见与建议</td>';
            $.each(data, function (i, sl10bean) {
                trHtml += '<tr>';
                trHtml += '<td>' + sl10bean.chapNo + '</td>'
                    + '<td>' + sl10bean.chapTitle + '</td>'
                    + '<td>' + sl10bean.agreeFlgName + '</td>'
                    + '<td style="white-space : normal;">'+ sl10bean.slSug + '</td>'
                trHtml += '</tr>';
            });
            trHtml += "</table>";
            trHtml += "</td>";
            trHtml += "</tr>";
        }

        return trHtml;
    },
    rowCallback: function (tr, data) {
        var $trId = "trId" + data.slPdId;
        $(tr).attr("id", $trId);
        var $td = $(tr).children('td').eq(0);
        $td.attr("trIndex", SL241120.trIndex);
        $td.html("");
        //$(tr).children('td').eq(7).html(data.qltNgReason);
        $td.addClass("details-control");
        SL241120.detailRows[SL241120.trIndex] = data;
        SL241120.trIndex++;
    }
}
$(document).ready(function () {
    // 初始化调用
    SL241120.init();
});
