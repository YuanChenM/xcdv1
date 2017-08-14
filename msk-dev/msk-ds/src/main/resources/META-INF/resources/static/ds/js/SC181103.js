/**
 * 发货计划单录入
 */
var SC181103 = {
    SC181103Grid: null,
    searchButtonId: "SC181103_SEARCH",
    formId: "SC181103Form",
    saveButtonId: "SC181103_SAVE",
    //changeButtonId: "SC181103_CHANGE",
    init: function () {
        SC181103.SC181103Grid = $('#SC181103_list_grid').grid({
            //actionHandler:SC181103.actionHandler
        });
        SC181103.bindSelectChange();
        SC181103.bindSaveButton();
        //SC181103.bindChangeButton();

    },
    bindSearchButton: function () {
        $("#" + SC181103.searchButtonId).click(function () {
            //debugger;
            FormUtils.setFormValue(SC181103.formId, "SC181103");
            SC181103.SC181103Grid.fnDraw()
        });
    },
    bindSelectChange:function(){
        $("#lgcsCode").change(function(){
            var lgcsname = $("#lgcsCode").find("option:selected").text();

            $('#lgcsName').val(lgcsname);

            $('#main-content').postUrl(Main.contextPath + "/SC181103/selectChange/", {

            },function(data){
                var suppCode = $("#suppCode");
                suppCode.html('');

                /* suppCode.append("<option value='-1'>--请选择--</option>");*/

                $.each(data,function(i,item){

                    suppCode.append("<option value='" + item.suppCode + "'>"+ item.suppName+ "</option>");
                }),
                FormUtils.setFormValue(SC181103.formId, "SC181103"),
                    SC181103.SC181103Grid.fnDraw()
            },{refreshHtml:false})
        });
        $("#suppCode").change(function(){

            FormUtils.setFormValue(SC181103.formId, "SC181103");
            SC181103.SC181103Grid.fnDraw();

        });
    },

    bindChangeButton: function (){
        changeData.remove();
    },
    bindSaveButton: function (){
        //debugger;
        $("#"+SC181103.saveButtonId).click(function (){
            var changeData = SC181103.SC181103Grid.getChangeData();// 获取改动的数据对象  是数组
            if(changeData.length==0){
                $.alertMessage.confirm("请先编辑要保存的数据再保存！", function() {
                    $.alertMessage.close();
                })
            }else{
                    $.alertMessage.confirm("你确定要保存当前数据吗？", function() {
                    $.alertMessage.close();
                    var json = {};// 创建json 对象
                    for(i=0;i<changeData.length;i++){//  把数组的对象封装到json
                        debugger;
                        if (isNaN(changeData[i].packNum)){
                            $.alertMessage.info("发货数量不合法!");
                            return;
                        } else if (changeData[i].packNum != "0" && changeData[i].packNum != "") {
                            json[i] =changeData[i];
                        }
                    }
                    if (json == null) {
                        $.alertMessage.info("请输入发货数量!");
                    } else {
                        var jsonStr = JSON.stringify(json);//  转成jsonStr
                        $('#main-content').postUrl(Main.contextPath + "/SC181103/save", {"jsonStr":jsonStr},function(data) {
                            $.alertMessage.info("发货计划保存成功，请到发货入库通知单一览页面进行正式发货。");
                            $('#main-content').postUrl(Main.contextPath + "/SC181103/init/")
                        });
                    }

                })
            }
        })
    }
}
$(document).ready(function () {
    // 初始化调用
    SC181103.init();
    //$List_Grid.fnDraw();
});
