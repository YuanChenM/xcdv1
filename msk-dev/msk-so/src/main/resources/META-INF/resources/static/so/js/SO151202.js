/**
 * 分销正常库存JS
 */
var $List_Grid;
var SO151202 = {
    exprotButtonId:"SO151202_EXPORT",
    searchButtonId: "SO151202_SEARCH",
    formId: "SO151202Form",
    init: function () {
        $List_Grid = $('#SO151202_list_grid').grid({
            actionHandler: SO151202.actionHandler
            /*fnDrawCallback :SO151401.fnDrawCallback*/
        });
        this.searchData();
        this.enterSearchData();
        this.exportButton();
    },
    enterSearchData:function(){
        //绑定回车键
        document.onkeydown=function enterDown(e){
            //兼容火狐,chrome和ie的事件对象
            e = e||event;

            if(e.keyCode == 13) {
                FormUtils.setFormValue(SO151202.formId, "SO151202");
                $List_Grid.fnDraw()
            }
            return;
        }
    },
    exportButton:function(){
      $("#"+SO151202.exprotButtonId).click(function(){
          SO151202.exportData();
      })  ;
    },
    exportData:function(){
       var lgcsCode=$("#lgcsCode").val();
        var warehouseCode=$("#warehouseCode").val();
        var salePlatform=$("#salePlatform").val();
        var slCode=$("#slCode").val();
        var pdCode=$("#pdCode").val();
        var lgcsName=$("#lgcsName").val();
        var warehouseName=$("#warehouseName").val();
        var slName=$("#slName").val();
        var pdName=$("#pdName").val();
        var dform = $("<form>");   //定义一个form表单
        dform.append('<input type="text" name="lgcsCode" value="'+lgcsCode+'">')
        dform.append('<input type="text" name="warehouseCode" value="'+warehouseCode+'">')
        dform.append('<input type="text" name="salePlatform" value="'+salePlatform+'">')
        dform.append('<input type="text" name="slCode" value="'+slCode+'">')
        dform.append('<input type="text" name="pdCode" value="'+pdCode+'">')
        dform.append('<input type="text" name="lgcsName" value="'+lgcsName+'">')
        dform.append('<input type="text" name="warehouseName" value="'+warehouseName+'">')
        dform.append('<input type="text" name="slName" value="'+slName+'">')
        dform.append('<input type="text" name="pdName" value="'+pdName+'">')
        dform.attr('style', 'display:none');   //在form表单中添加查询参数
        dform.attr('target', '');
        dform.attr('method', 'post');
        dform.attr('action', Main.contextPath +"/SO151202/exportStock");
        $('body').append(dform);  //将表单放置在web中
        dform.submit();
    },

    searchData: function () {
        $("#" + SO151202.searchButtonId).click(function () {
            FormUtils.setFormValue(SO151202.formId, "SO151202");
            $List_Grid.fnDraw()
        });
    },
    actionHandler: function (rowdata, coltype, row, col) {
        if (coltype == "save") {
            $('#main-content').postUrl(Main.contextPath + "/SO151202/save/", {
                stockId: rowdata.stockId,
                stockQty: rowdata.stockQty
            },function(data){
                if(data == "S") {
                    $.alertMessage.info("库存量修改成功!");
                } else {
                    $.alertMessage.warn("该数据可能已被删除,请刷新页面再试!");
                }
            },{refreshHtml:false});
        }
    }
}
$(document).ready(function () {
    // 初始化调用
    SO151202.init();
   /* $.core.sleep(1000);
    $List_Grid.fnDraw();*/
});