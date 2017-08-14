var NUM = {
	"NUM_ZERO" : 0,
	"NUM_ONE" : 1,
	"NUM_TWO" : 2,
	"NUM_THREE" : 3,
	"NUM_FOUR" : 4,
	"NUM_FIVE" : 5,
	"NUM_SIX" : 6,
	"NUM_SEVEN" : 7,
	"NUM_EIGHT" : 8,
	"NUM_NINE" : 9,
	"NUM_TEN" : 10
}
/**
 * 产品基础数据列表JS
 *
 * @author gyh
 */
var BP112212 = {
	$List_Grid: '',
	formId: "BP112212Form",
	saveButtonId: "BP112212_SAVE",
	initDataGrid: function () {
		BP112212.bindSaveButton();
	},
	bindSaveButton: function () {
		$("#" + BP112212.saveButtonId).click(function () {
			var flag = true;
			$('#BP112212Tbody').find('tr').each(function () {
				$(this).find('td').each(function () {
					$(this).find("input").each(function(){
						var color = $(this).css("background-color");
						if(color == 'rgb(255, 0, 0)')
						{
							flag = false;
							return;
						}
					})
					if(!flag)
					{
						return;
					}
				});
				if(!flag)
				{
					return;
				}
			});

			if(!flag)
			{
				alert("请检查参数是否填写正确！！！");
				return;
			}

			var $BP112212Form = $("#BP112212Form");
			var formData = $BP112212Form.serializeArray();//getFormData($("#SO151408Form"));
			$('#main-content').postUrl($("#BP112212Form").attr("action"),formData);
		});
	}
}

/**
 *等级标准(箱下限修改)
 * @param index
 */
function levelStandMinChange()
{
	for(var i = NUM.NUM_ZERO;i <= NUM.NUM_NINE;i++)
	{
		if(!levelStandMinChangeIndex(i))
		{
			alert("修改不符合规则！！！");
			$("#levelStandMin" + i).css("background-color","#FF0000");
			return ;
		}
		$("#levelStandMin" + i).css("background-color","");
	}
}

function levelStandMinChangeIndex(index)
{
	var levelStandMin = $("#levelStandMin" + index).val();
	var reg = /^[1-9]\d*$/;

	if(!reg.test(levelStandMin))
	{
		return false;
	}

	levelStandMin = parseInt(levelStandMin);

	if(index == NUM.NUM_ZERO)
	{
		levelStandMax = $("#levelStandMax" + index).val();
		if(levelStandMax < levelStandMin)
		{
			return false;
		}
	}

	var beforeStandMaxIndex = index - NUM.NUM_ONE;
	if(index >= NUM.NUM_ZERO)
	{
		var beforeLevelStandMin = parseInt($("#levelStandMin" + beforeStandMaxIndex).val());
		if(beforeLevelStandMin <= levelStandMin)
		{
			return false;
		}
	}

	if(index == NUM.NUM_NINE)
	{
		return true;
	}

	var levelStandMaxIndex = index + NUM.NUM_ONE;

	var lastLevelStandMin = parseInt($("#levelStandMin" + levelStandMaxIndex).val());


	if(levelStandMin <= lastLevelStandMin)
	{
		return false;
	}

	var levelStandMax = levelStandMin - NUM.NUM_ONE;
	$("#levelStandMax" + levelStandMaxIndex).val(levelStandMax);
	return true;
}

$(document).ready(function () {
	// 初始化调用
	BP112212.initDataGrid();
});


/**
 * 本期报价变更
 * @param index
 */
function priceOfKgChange(index)
{
	var priceOfKg = $("#priceOfKg" + index).val();

	var reg = /^\d+(\.\d{1,2})?$/;

	if(!reg.test(priceOfKg))
	{
		alert("请输入正确的数！！！");
		$("#priceOfKg" + index).css("background-color","#FF0000");
		return;
	}
	var level5PriceOfKg =$("#priceOfKg5").val()

	if(!reg.test(level5PriceOfKg))
	{
		alert("请输入正确的数！！！");
		$("#priceOfKg5" + index).css("background-color","#FF0000");
		return;
	}

	level5PriceOfKg = parseFloat(level5PriceOfKg);
	priceOfKg = parseFloat(priceOfKg);

	if(index == NUM.NUM_FIVE )
	{
		editEveryPriceOfKg(priceOfKg);
		$("#priceOfKg" + index).css("background-color","#AA758B");
		$("#currentCoefficient" + index).css("background-color","#AA758B");
		return ;
	}

	if(level5PriceOfKg == NUM.NUM_ZERO)
	{
		alert("请输入正确的数！！！");
		$("#priceOfKg" + index).css("background-color","#FF0000");
		return;
	}

	$("#priceOfKg" + index).css("background-color","#FFFFFF");
	$("#currentCoefficient" + index).css("background-color","#FFFFFF");

	var level5CurrentCoefficient = parseInt($("#currentCoefficient5").val());
	var currentCoefficient = Math.round((priceOfKg/level5PriceOfKg)*level5CurrentCoefficient);

	$("#currentCoefficient" + index).val(currentCoefficient);
}

/**
 * 本期价盘等级系数变更
 * @param index
 */
function currentCoefficientChange(index)
{
	//5级报价
	var level5PriceOfKg = parseFloat($("#priceOfKg5").val());

	//本期系数
	var currentCoefficient = $("#currentCoefficient" + index).val();

	var reg = /^[1-9]\d*$/;
	if(!reg.test(currentCoefficient))
	{
		alert("修改不符合规则！！！");
		$("#currentCoefficient" + index).css("background-color","#FF0000");
		return ;
	}
	currentCoefficient = parseInt(currentCoefficient);

	var level5CurrentCoefficient = parseInt($("#currentCoefficient5").val());
	//本期报价
	var priceOfKg = (parseFloat(level5PriceOfKg)*(parseFloat(currentCoefficient)/level5CurrentCoefficient)).toFixed(2);

	if(priceOfKg > 9999999)
	{
		alert("修改不符合规则！！！");
		$("#currentCoefficient" + index).css("background-color","#FF0000");
		return ;
	}

	$("#currentCoefficient" + index).css("background-color","#FFFFFF");
	$("#priceOfKg" + index).css("background-color","#FFFFFF");
	$("#priceOfKg" + index).val(priceOfKg);
}

function editEveryPriceOfKg(priceOfKg)
{
	var level5CurrentCoefficient = parseInt($("#currentCoefficient5").val());

	for(var i = NUM.NUM_ZERO ;i < NUM.NUM_TEN ; i++)
	{
		var currentCoefficient = parseInt($("#currentCoefficient" + i).val());

		$("#priceOfKg" + i).css("background-color","#FFFFFF");
		$("#currentCoefficient" + i).css("background-color","#FFFFFF");
		var price = parseFloat((priceOfKg/level5CurrentCoefficient)*currentCoefficient).toFixed(2) ;
		$("#priceOfKg"+ i).val(price);
		if(i != NUM.NUM_FIVE)
		{
			priceOfKgChange(i);
		}
	}
}
function isBidderFlgChange(index)
{
	if($("#bidderFlg" + index).attr("checked"))
	{
		$("#bidderFlg" + index).removeAttr("checked");
		$("#isBidderFlg" + index).val(NUM.NUM_ZERO);
		$("#orderLevelName" + index).css("background-color","#DBDBDB");
		$("#orderLevelCodeTd" + index).css("background-color","#DBDBDB");
	}
	else
	{
		$("#bidderFlg" + index).attr("checked","checked");
		$("#isBidderFlg" + index).val(NUM.NUM_ONE);
		$("#orderLevelName" + index).css("background-color","#AA7428");
		$("#orderLevelCodeTd" + index).css("background-color","#AA7428");
	}
}


function disCountChange(index)
{
	var disCount = $("#disCount" + index).val();

	var reg = /^\d+(\.\d{1,2})?$/;
	if(!reg.test(disCount))
	{
		$("#disCount" + index).css("background-color","#FF0000");
		alert("请输入正确的数！！！");
		return ;
	}
	disCount = parseFloat(disCount);
	if(disCount <= NUM.NUM_ZERO || disCount >= NUM.NUM_SIX)
	{
		$("#disCount" + index).css("background-color","#FF0000");
		alert("请输入正确的数！！！");
		return ;
	}

	$("#disCount" + index).css("background-color","#FFFFFF");
}