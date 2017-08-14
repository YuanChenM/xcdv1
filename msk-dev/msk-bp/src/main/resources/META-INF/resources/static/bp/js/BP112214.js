/**
 * 价盘卖家查看JS
 * 
 * @author cx
 */

var BP112214 = {
	BP112214Grid: null,
	formId : "BP112214Form",
	detailRows: [],
	trIndex: 0,
	initDataGrid: function () {

		BP112214.BP112214Grid = $('#BP112214_Grid').grid({
			fnRowCallback: BP112214.rowCallback
		});
		this.bindOpenEnven();
	},
	bindOpenEnven: function () {
		$('#BP112214_Grid tbody').on('click', 'tr td.details-control', function () {
			var tr = $(this).closest('tr');
			var $trClass = $(tr).attr("class");
			var trSeq = $(this).attr("trIndex");// 指定行数
			if ($trClass.indexOf("details") >= 0) {
				$(tr).removeClass("details");
				$("#appendTrDetail" + trSeq).remove();
			} else {
				var test = BP112214.detailRows[trSeq];

				$('#main-content').postUrl(Main.contextPath + "/BP112214/findOrderLevelList", {
					'filterMap[pdCode]': BP112214.detailRows[trSeq].pdCode,
					'filterMap[logiareaCode]': BP112214.detailRows[trSeq].logiareaCode,
					'filterMap[pricecyclePeriod]': BP112214.detailRows[trSeq].pricecyclePeriod,
					'filterMap[slCode]': BP112214.detailRows[trSeq].slCode
				}, function (data) {
					$(tr).addClass("details");
					$(tr).after(BP112214.appendTrShow(trSeq, data));
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
	appendTr: function (index) {
		var trHtml = "<tr id='appendTrDetail" + index + "'>";
		trHtml += "<td colspan='12'>";
		trHtml += "<table class='tree dataTable no-footer' width='width: 50%' style='float:right'>";
		trHtml += '<tr style="background:#DBDBDB">';
		trHtml += '<td width="20%">一类质量标准指标</td>';
		trHtml += '<td width="20%">优良值</td>'
		+ '<td width="20%">合格值</td>'
		+ '<td width="20%">不合格值</td>'
		+ '<td width="20%">卖家产品质量标准</td>';
		trHtml += '</tr>';
		trHtml += '<tr class="treegrid-200 treegrid-parent-100">';
		trHtml += '<td>菌落总数</td>';
		trHtml += '<td>5*102cfu/g</td>';
		trHtml += '<td>5*102cfu/g</td>';
		trHtml += '<td>5*102cfu/g</td>';
		trHtml += '<td>5*102cfu/g</td>';
		trHtml += '</tr>';
		trHtml += '<tr class="treegrid-201 treegrid-parent-100">';
		trHtml += '<td>大肠菌群</td>';
		trHtml += '<td>5*10 MPN/100g</td>';
		trHtml += '<td>5*10 MPN/100g</td>';
		trHtml += '<td>5*10 MPN/100g</td>';
		trHtml += '<td>5*10 MPN/100g</td>';
		trHtml += '</tr>';
		trHtml += '<tr class="treegrid-202 treegrid-parent-100">';
		trHtml += '<td>沙门氏菌</td>';
		trHtml += '<td>不得检出</td>';
		trHtml += '<td>不得检出</td>';
		trHtml += '<td>不得检出</td>';
		trHtml += '<td>不得检出</td>';
		trHtml += '</tr>';
		trHtml += "</table>";
		trHtml += "</td>";
		trHtml += "</tr>";

		return trHtml;
	},
	rowCallback: function (tr, data) {
		var $trId = "trId" + data.pricecycleId;
		$(tr).attr("id", $trId);
		//$(tr).attr("trIndex",BP112214.trIndex);
		var $td = $(tr).children('td').eq(0);
		$td.attr("trIndex", BP112214.trIndex);
		$td.html("");
		$td.addClass("details-control");
		//$(tr).children('td').eq(4).html('<a title="特征" class="tooltip" href="'+fileSerUrl+'/sl/seller/264050107/1.png" target="_blank" src="'+fileSerUrl+'/sl/seller/264050107/1.png"><img src="'+fileSerUrl+'/sl/seller/264050107/1.png" height="100px" width="100px"/></a>');
		BP112214.detailRows[BP112214.trIndex] = data;
		BP112214.trIndex++;
	}
}
$(document).ready(function () {
	// 初始化调用
	BP112214.initDataGrid();
});