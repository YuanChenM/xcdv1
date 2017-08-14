/**
 * 计划调整JS
 * Created by zhou_yajun.
 */
var SC183101 = {
    saveButtonId: "SC183101_SAVE",
    formId: "SC183101Form",
    initDataGrid: function () {
        SC183101.bindSaveButton()
        SC183101.bindInputChange();
        SC183101.bindSelectChange();
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
    },
    bindSaveButton:function(){
        $("#"+SC183101.saveButtonId).bind("click", function() {
            var validator = mainValidation($("#" + SC183101.formId));
            var isValid = validator.form();
            if (isValid) {
                formData = getFormData($("#" + SC183101.formId));
                $('#main-content').postUrl($("#" + SC183101.formId).attr("action"), formData, function(data){
                        $.pdialog.close();
                        if(data == "1"){
                            $('#main-content').postUrl(Main.contextPath + "/SC181102/init/",
                            {
                                distMonth:$("#distMonth").val(),
                                areaCode:$("#areaCode").val(),
                                supplierCode:$("#supplierCode").val(),
                                productName:$("#productName").val()
                            });
                        } else {
                            $('#main-content').postUrl(Main.contextPath + "/SC183102/init/");
                        }

                    },
                    {refreshHtml:false});
            }
        });
    },
    bindSelectChange:function(){
        $("#planType").change(function(){
            SC183101.selectChange();
        });
        $("#halfCode").change(function(){
            SC183101.selectChange();
        });
        $("a[name='DS173103P']").bind("click", function() {
            $.pdialog.close();
            $('#main-content').postUrl(Main.contextPath + "/SC183102/init/");
        });
    },
    selectChange:function(){
        $('#main-content').postUrl(Main.contextPath + "/SC183101/selectChange/",
            {
                distMonth:$("#distMonth").val(),
                areaCode:$("#areaCode").val(),
                areaName:$("#areaCode option:selected").text(),
                supplierCode:$("#supplierCode").val(),
                supplierName:$("#supplierCode option:selected").text(),
                productName:$("#productFullName").val(),
                entryMark:$("#entryMark").val(),
                halfCode:$("#halfCodeOld").val(),
                planType:$("#planType").val(),
                currentHalfCode:$("#halfCode").val(),
                adjustDate:$("#adjustDate").val()
            },function(data){
                var SC183101Table = $("#SC183101Table");
                SC183101Table.html('');
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
                        var changeBeforeNum = planChangeProductList[j].changeBeforeNum;
                        var changeOverNum = planChangeProductList[j].changeOverNum;
                        var normsCode = planChangeProductList[j].normsCode;
                        var adjustDate = planChangeProductList[j].adjustDateOld;
                        strHtml = strHtml + "<tr>";
                        strHtml = strHtml + "<td style='background:#DBDBDB'>"+productName;
                        strHtml = strHtml + "<input type='hidden' name='productParamList["+j+"].productCode' id='productCode"+productCode+"' value='"+productCode+"'/>";
                        strHtml = strHtml + "<input type='hidden' name='productParamList["+j+"].normsCode' id='normsCode"+productCode+"' value='"+normsCode+"'/>";
                        strHtml = strHtml + "<input type='hidden' name='productParamList["+j+"].adjustDate' id='adjustDate"+productCode+"' value='"+adjustDate+"'/>";
                        strHtml = strHtml + "</td>";
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
                    SC183101Table.html(strHtml);
                });
                SC183101.bindInputChange();
            },{refreshHtml:false}
        );
    }
}
$(document).ready(function () {
    // 初始化调用
    SC183101.initDataGrid();
});
