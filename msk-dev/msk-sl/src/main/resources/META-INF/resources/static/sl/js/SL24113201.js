/**
 * 卖家货号列表JS
 *
 * @author pxg
 */
var SL24113201 = {
    formId: 'SL24113201Form',
    init: function () {
        this.saveData();
    },
    saveData:function(){
        $("#SL24113201_SAVE").click(function(){
            formData = getFormData($("#" + SL24113201.formId));
            $("#main-content").postUrl($("#"+SL24113201.formId).attr("action"),formData,function(data){
                $.pdialog.close();
                if(data==1){
                    $.alertMessage.info("保存成功");
                    $List_Grid.fnDraw();
                }else{
                    $.alertMessage.info("保存失败");
                    $List_Grid.fnDraw();
                }
            },{refreshHtml:false});
        });
    }
}
$(document).ready(function () {
    // 初始化调用
    SL24113201.init();
});

