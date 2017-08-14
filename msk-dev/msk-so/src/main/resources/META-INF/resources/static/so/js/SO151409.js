/**
 * 卖家销售排行JS
 * Created by yang_chunyan on 2016/3/22.
 */


var $List_Grid;
var SO151409 = {
    searchButtonId:"SO151409_SEARCH",
    formId: "SO151409Form",
    init: function () {
        $List_Grid = $('#SO151409_list_grid').grid({
            actionHandler: SO151409.actionHandler
        });
        this.searchData();
        this.enterSearchData();
    },
    enterSearchData:function(){
        //绑定回车键
        document.onkeydown=function enterDown(e){
            //兼容火狐,chrome和ie的事件对象
            e = e||event;

            if(e.keyCode == 13) {
                FormUtils.setFormValue(SO151409.formId, "SO151409");
                $List_Grid.fnDraw()
            }
            return;
        }
    },
    searchData: function () {
        $("#" + SO151409.searchButtonId).click(function () {
            FormUtils.setFormValue(SO151409.formId, "SO151409");
            $List_Grid.fnDraw()
        });
    },
    actionHandler: function (rowdata, coltype, row, col) {
        if (coltype == "save") {
            if(!rowdata.salesRanking && rowdata.salesRanking != 0){
                $.alertMessage.warn("排名不能为空");
            }
            else if(!rowdata.wheelFrequency && rowdata.wheelFrequency != 0){
                $.alertMessage.warn("次数不能为空");
            }
            else
            {
                var salesRanking = rowdata.salesRanking;
                var wheelFrequency = rowdata.wheelFrequency;
                var reg = /^(0|[1-9]\d*)$/;
                if (!reg.test(String(salesRanking))) {
                    $.alertMessage.warn("排名格式不正确，请输入不小于0的整数");
                }
                else if(!reg.test(String(wheelFrequency))) {
                    $.alertMessage.warn("次数格式不正确，请输入不小于0的整数");
                }
                else {
                    $('#main-content').postUrl(Main.contextPath + "/SO151409/save/", {
                        lgcsCode: rowdata.lgcsCode,
                        orderLevel: rowdata.orderLevel,
                        pdCode: rowdata.pdCode,
                        suppCode: rowdata.suppCode,
                        salesRanking: salesRanking,
                        wheelFrequency: wheelFrequency
                    }, function (data) {
                        if (data == "S") {
                            $.alertMessage.info("修改成功!");
                        } else {
                            $.alertMessage.warn("该数据可能已被删除,请刷新页面再试!");
                        }
                    }, {refreshHtml: false});
                }
            }
        }
    }
}
$(document).ready(function () {
    // 初始化调用
    SO151409.init();
    $.core.sleep(1000);
    $List_Grid.fnDraw();
});
