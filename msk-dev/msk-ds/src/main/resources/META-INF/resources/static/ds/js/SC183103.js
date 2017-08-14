/**
 * 实际录入JS
 * Created by zhou_yajun.
 */
var SC183103 = {
    saveButtonId: "SC183103_SAVE",
    formId:"SC183103Form",
    initDataGrid: function () {
        SC183103.bindSaveButton();
        SC183103.bindInputChange();
        SC183103.bindSelectChange();
    },
    bindInputChange:function(){
        $("input[id *= 'changeNum']").change(function(){
            var id = this.id;
            var productCode = id.substring(9,id.length);
            var changeNum = Number($("#"+id).val().toString());
            var changeBeforeNum = Number($("#changeBeforeNum"+productCode).val().toString());
            $("#changeOverNum"+productCode).val(changeNum + changeBeforeNum);
            /**改变合计的值*/
            var sumChange=0;
            var sumChangeOverNum=0;
            $("input[id *= 'changeNum']").each(function(){
                sumChange += Number($(this).val());
            });
            $("input[id *= 'changeOverNum']").each(function(){
                sumChangeOverNum += Number($(this).val());
            });

            $("#sumChangeNum").val(sumChange);
            $("#sumChangeOverNum").val(sumChangeOverNum);
        });
        $("a[name='SC183103A']").bind("click", function() {
            $.pdialog.close();
            $('#main-content').postUrl(Main.contextPath + "/SC183104/init/");
        });
    },
    bindSaveButton:function(){
        $("#"+SC183103.saveButtonId).bind("click", function() {
            var validator = mainValidation($("#" + SC183103.formId));
            var isValid = validator.form();
            if (isValid) {
                formData = getFormData($("#" + SC183103.formId));
                $('#main-content').postUrl($("#" + SC183103.formId).attr("action"), formData, function(data){
                        $.pdialog.close();
                        if(data =="1"){
                        $('#main-content').postUrl(Main.contextPath + "/SC181102/init/",
                            {
                                distMonth:$("#distMonth").val(),
                                areaCode:$("#areaCode").val(),
                                supplierCode:$("#supplierCode").val(),
                                productName:$("#productName").val()
                            });
                        } else {
                        $('#main-content').postUrl(Main.contextPath + "/SC183104/init/");}
                    },
                    {refreshHtml:false});
            }
        });
    },
    bindSelectChange:function(){
        $("#planType").change(function(){
            $('#main-content').postUrl(Main.contextPath + "/SC183103/selectChange/",
                {
                    distMonth:$("#distMonth").val(),
                    areaCode:$("#areaCode").val(),
                    areaName:$("#areaCode option:selected").text(),
                    supplierCode:$("#supplierCode").val(),
                    supplierName:$("#supplierCode option:selected").text(),
                    productName:$("#productFullName").val(),
                    entryMark:$("#entryMark").val(),
                    planType:$("#planType").val(),
                    currentHalfCode:$("#halfCode").val(),
                    adjustDate:$("#adjustDate").val()
                },function(data){
                    var SC183103Table = $("#SC183103Table");
                    SC183103Table.html('');
                    var strHtml = "";
                    strHtml = strHtml + "<thead>";
                    strHtml = strHtml + "<tr style='background:#DBDBDB'><th>规格</th><th>调整前值</th><th>调整值</th> <th>调整后值</th></tr>";
                    strHtml = strHtml + "</thead>";
                    strHtml = strHtml + "<tbody>";
                    $.each(data, function(i, item) {
                        var planChangeProductList = item.planChangeProductList;
                        for(var j=0;j<planChangeProductList.length;j++){
                            var productName = planChangeProductList[j].productName;
                            var productCode = planChangeProductList[j].productCode;
                            var normsCode = planChangeProductList[j].normsCode;
                            var adjustDate = planChangeProductList[j].adjustDateOld;
                            var changeBeforeNum = planChangeProductList[j].changeBeforeNum;
                            var changeOverNum = planChangeProductList[j].changeOverNum;
                            strHtml = strHtml + "<tr>";
                            strHtml = strHtml + "<td style='background:#DBDBDB'>"+productName;
                            strHtml = strHtml + "<input type='hidden' name='productParamList["+j+"].productCode' id='productCode"+productCode+"' value='"+productCode+"'/>";
                            strHtml = strHtml + "<input type='hidden' name='productParamList["+j+"].normsCode' id='normsCode"+productCode+"' value='"+normsCode+"'/>";
                            strHtml = strHtml + "<input type='hidden' name='productParamList["+j+"].adjustDate' id='adjustDate"+productCode+"' value='"+adjustDate+"'/>";
                            strHtml = strHtml + "</td>"
                            strHtml = strHtml + "<td><input type='text' readonly='readonly' style='background:#DBDBDB' name='productParamList["+j+"].changeBeforeNum' id='changeBeforeNum"+productCode+"' value='"+changeBeforeNum+"'/></td>";
                            strHtml = strHtml + "<td><input type='text' name='productParamList["+j+"].changeNum' id='changeNum"+productCode+"' value='0.00'/></td>";
                            strHtml = strHtml + "<td><input type='text' readonly='readonly' style='background:#DBDBDB' name='productParamList["+j+"].changeOverNum' id='changeOverNum"+productCode+"' value='"+changeBeforeNum+"'/></td>";
                            strHtml = strHtml + "</tr>";
                        }
                        strHtml = strHtml + "<tr>";
                        strHtml = strHtml + "<td style='background:#DBDBDB'>合计</td>";
                        strHtml = strHtml + "<td><input type='text' name='sumChangeBeforeNum' id='sumChangeBeforeNum' value='"+item.sumChangeBeforeNum+"' readonly='readonly' style='background:#DBDBDB'/></td>";
                        strHtml = strHtml + "<td><input type='text' name='sumChangeNum' id='sumChangeNum' value='0.00'  readonly='readonly'  style='background:#DBDBDB'/></td>";
                        strHtml = strHtml + "<td><input type='text' name='sumChangeOverNum' id='sumChangeOverNum' value='"+item.sumChangeBeforeNum+"' readonly='readonly' style='background:#DBDBDB'/></td>";
                        strHtml = strHtml + "</tr>";
                        strHtml = strHtml + "</tbody>";
                        SC183103Table.html(strHtml);
                    });
                    SC183103.bindInputChange();
                },{refreshHtml:false}
            );
        });
    }
}
$(document).ready(function () {
    // 初始化调用
    SC183103.initDataGrid();
});
