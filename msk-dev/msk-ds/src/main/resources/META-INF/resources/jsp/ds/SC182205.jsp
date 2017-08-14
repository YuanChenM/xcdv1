<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="产品批次明细打印" backTitleArray="" backUrlArray=""></navigation:header>
<div class="page-content list-page">
    <form:form action="${ctx}/SC182205/save" id="SC182205Form" method="post">
    <div class="group-accordion" collapsible="true" active="true" >
        <h3>
            <label>产品批次明细</label>
        </h3>

        <div>
            <%--
            <table class="dataTable no-footer" id="SC182205ProductTable" style="width: 100%">
                <tr>
                    <td colspan="6" align="center" bgcolor="#CCCCCC" style="font-weight:bold">产品属性</td>
                    <td colspan="4" align="center" bgcolor="#CCCCCC" style="font-weight:bold">品质属性</td>
                    <td width="71" rowspan="4" align="center" bgcolor="#CCCCCC" style="font-weight:bold">总箱数</td>
                    <td width="128" rowspan="4" align="center" bgcolor="#CCCCCC" style="font-weight:bold"><p>品牌</p>
                        <p>Logo</p></td>
                    <td width="196" rowspan="2" align="center" bgcolor="#CCCCCC" style="font-weight:bold">条形主码</td>
                </tr>
                <tr>
                    <td width="61" align="center" bgcolor="#CCCCCC" style="font-weight:bold">产品类别</td>
                    <td width="59" align="center" bgcolor="#CCCCCC" style="font-weight:bold">产品名称</td>
                    <td width="96" align="center" bgcolor="#CCCCCC" style="font-weight:bold">配料</td>
                    <td width="80" align="center" bgcolor="#CCCCCC" style="font-weight:bold">规格</td>
                    <td width="76" align="center" bgcolor="#CCCCCC" style="font-weight:bold">净重</td>
                    <td width="74" align="center" bgcolor="#CCCCCC" style="font-weight:bold">产品等级</td>
                    <td width="95" align="center" bgcolor="#CCCCCC" style="font-weight:bold">生产日期</td>
                    <td width="89" align="center" bgcolor="#CCCCCC" style="font-weight:bold">保质期</td>
                    <td width="162" align="center" bgcolor="#CCCCCC" style="font-weight:bold">储存方法</td>
                    <td width="210" align="center" bgcolor="#CCCCCC" style="font-weight:bold">食品生产许可证</td>
                </tr>
                <tr>
                    <td colspan="4" align="center" bgcolor="#CCCCCC" style="font-weight:bold">生产商</td>
                    <td colspan="4" align="center" bgcolor="#CCCCCC" style="font-weight:bold">生产商地址</td>
                    <td align="center" bgcolor="#CCCCCC" style="font-weight:bold">生产商电话</td>
                    <td rowspan="2" align="center" bgcolor="#CCCCCC" style="font-weight:bold">产地</td>
                    <td rowspan="2" align="center" bgcolor="#CCCCCC" style="font-weight:bold">打印页码</td>
                </tr>
                <tr>
                    <td colspan="4" align="center" bgcolor="#CCCCCC" style="font-weight:bold">授权商</td>
                    <td colspan="4" align="center" bgcolor="#CCCCCC" style="font-weight:bold">授权商地址</td>
                    <td align="center" bgcolor="#CCCCCC" style="font-weight:bold">授权商电话</td>
                </tr>



                    <tr>
                        <td>&nbsp;${classesName}</td>
                        <td>&nbsp;${breedName}</td>
                        <td>&nbsp;${machiningName}</td>
                        <td>&nbsp;${featureName}</td>
                        <td>&nbsp;${weightName}</td>
                        <td>&nbsp;${gradeName}</td>
                        <td>&nbsp;${sc182205Bean.manuDate}</td>
                        <td>&nbsp;${sc182205Bean.shelfLife}</td>
                        <td>&nbsp;${sc182205Bean.storCondition}</td>
                        <td>&nbsp;${sc182205Bean.foodManuLicen}</td>
                        <td rowspan="3">&nbsp;${sc182205Bean.sumNewActNum}</td>
                        <td rowspan="3">&nbsp;${sc182205Bean.brandLogo}</td>
                        <td rowspan="2">&nbsp;${sc182205Bean.proLotNum}</td>
                        <input type="hidden" name="classesName" id="classesName" value="${classesName}"/>
                        <input type="hidden" name="breedName" id="breedName" value="${breedName}"/>
                        <input type="hidden" name="machiningName" id="machiningName" value="${machiningName}"/>
                        <input type="hidden" name="featureName" id="featureName" value="${featureName}"/>
                        <input type="hidden" name="weightName" id="weightName" value="${weightName}"/>
                        <input type="hidden" name="gradeName" id="gradeName" value="${gradeName}"/>
                        <input type="hidden" name="manuDate" id="manuDate" value="${sc182205Bean.manuDate}"/>
                        <input type="hidden" name="shelfLife" id="shelfLife" value="${sc182205Bean.shelfLife}"/>
                        <input type="hidden" name="storCondition" id="storCondition" value="${sc182205Bean.storCondition}"/>
                        <input type="hidden" name="foodManuLicen" id="foodManuLicen" value="${sc182205Bean.foodManuLicen}"/>
                        <input type="hidden" name="sumNewActNum" id="sumNewActNum" value="${sc182205Bean.sumNewActNum}"/>
                        <input type="hidden" name="brandLogo" id="brandLogo" value="${sc182205Bean.brandLogo}"/>
                        <input type="hidden" name="proLotNum" id="proLotNum" value="${sc182205Bean.proLotNum}"/>
                    </tr>

              <tr>
                  <td colspan="4">&nbsp;${sc182205Bean.client}</td>
                  <td colspan="4">&nbsp;${sc182205Bean.clientAddr}</td>
                  <td>&nbsp;${sc182205Bean.clientPhone}</td>
                  <td colspan="2" rowspan="2">&nbsp;${sc182205Bean.manuOrigin}</td>
                  <input type="hidden" name="client" id="client" value="${sc182205Bean.client}"/>
                  <input type="hidden" name="clientAddr" id="clientAddr" value="${sc182205Bean.clientAddr}"/>
                  <input type="hidden" name="clientPhone" id="clientPhone" value="${sc182205Bean.clientPhone}"/>
                  <input type="hidden" name="manuOrigin" id="manuOrigin" value="${sc182205Bean.manuOrigin}"/>
              </tr>
              <tr>
                  <td colspan="4">&nbsp;${sc182205Bean.unClient}</td>
                  <td colspan="4">&nbsp;${sc182205Bean.unClientAddr}</td>
                  <td>&nbsp;${sc182205Bean.unClientPhone}</td>
                  <td>&nbsp;<input type="text" name="productPrintNum" id="productPrintNum" value="${sc182205Bean.productPrintNum}" size="55"/></td>
                  <input type="hidden" name="unClient" id="unClient" value="${sc182205Bean.unClient}"/>
                  <input type="hidden" name="unClientAddr" id="unClientAddr" value="${sc182205Bean.unClientAddr}"/>
                  <input type="hidden" name="unClientPhone" id="unClientPhone" value="${sc182205Bean.unClientPhone}"/>
              </tr>
          </table>
          --%>

                <table class="dataTable no-footer" id="SC182204ProductTable" style="width: 100%">
                    <tr>
                        <td width="85" align="center" bgcolor="#CCCCCC" style="font-weight:bold">产品类别</td>
                        <td width="85" align="center" bgcolor="#CCCCCC" style="font-weight:bold">产品名称</td>
                        <td width="85" align="center" bgcolor="#CCCCCC" style="font-weight:bold">配料</td>
                        <td width="85" align="center" bgcolor="#CCCCCC" style="font-weight:bold">规格</td>
                        <td width="85" align="center" bgcolor="#CCCCCC" style="font-weight:bold">净重</td>
                        <td width="85" align="center" bgcolor="#CCCCCC" style="font-weight:bold">产品等级</td>
                        <td width="85" align="center" bgcolor="#CCCCCC" style="font-weight:bold">总箱数</td>
                        <td width="85" align="center" bgcolor="#CCCCCC" style="font-weight:bold">品牌Logo</td>
                        <td width="200" align="center" bgcolor="#CCCCCC" style="font-weight:bold">操作码</td>
                        <td width="200" align="center" bgcolor="#CCCCCC" style="font-weight:bold">阅读码</td>
                        <td width="85" align="center" bgcolor="#CCCCCC" style="font-weight:bold">打印页码</td>
                    </tr>
                    <tr>
                        <td>&nbsp;${classesName}</td>
                        <td>&nbsp;${breedName}</td>
                        <td>&nbsp;${machiningName}</td>
                        <td>&nbsp;${featureName}</td>
                        <td>&nbsp;${weightName}</td>
                        <td>&nbsp;${gradeName}</td>
                        <input type="hidden" name="classesName" id="classesName" value="${classesName}"/>
                        <input type="hidden" name="breedName" id="breedName" value="${breedName}"/>
                        <input type="hidden" name="machiningName" id="machiningName" value="${machiningName}"/>
                        <input type="hidden" name="featureName" id="featureName" value="${featureName}"/>
                        <input type="hidden" name="weightName" id="weightName" value="${weightName}"/>
                        <input type="hidden" name="gradeName" id="gradeName" value="${gradeName}"/>
                        <input type="hidden" name="sumNewActNum" id="sumNewActNum" value="${sc182205Bean.sumNewActNum}"/>
                        <input type="hidden" name="brandLogo" id="brandLogo" value="${sc182205Bean.brandLogo}"/>
                        <input type="hidden" name="proLotNum" id="proLotNum" value="${sc182205Bean.proLotNum}"/>
                        <input type="hidden" name="readProLotNum" id="readProLotNum" value="${sc182205Bean.readProLotNum}"/>
                        <td>&nbsp;${sc182205Bean.sumNewActNum}</td>
                        <td>&nbsp;${sc182205Bean.brandLogo}</td>
                        <td>&nbsp;${sc182205Bean.proLotNum}</td>
                        <td>&nbsp;${sc182205Bean.readProLotNum}</td>
                        <td>&nbsp;<input type="text" name="productPrintNum" id="productPrintNum" value="${sc182205Bean.productPrintNum}"/></td>
                    </tr>
                </table>


          <td align="right"><msk:button buttonValue="打印产品批次明细" name="SC182205.SAVE"  buttonId="SC182205.SAVE" buttonType="button" onclick="" /></td>
            <td>提示:打印页码必须以","或"-"形式出现：如1,3或1-20</td>
      </div>

  </div>
  </form:form>

</div>
<script type="text/javascript">
    function createTxtFile()
    {
        if(window.confirm("确定要打印么？")==true) {
            var breedName = document.getElementById("breedName").value;
            var gradeName = document.getElementById("gradeName").value;
            var proLotNum = document.getElementById("proLotNum").value;
            var productPrintNum = document.getElementById("productPrintNum").value;
            //var dateString = new Date().format('yyyyMMddhhmmss').substring(0,12);
            var dateString = new Date().format('yyyyMMddhhmmss');
            var fso, f1, ts, s;
            var ForReading = 1;
            fso = new ActiveXObject("Scripting.FileSystemObject");
            f1 = fso.CreateTextFile("D:\\箱标签\\"+proLotNum+"_"+dateString+".txt", true);
            f1.WriteLine(breedName+'|'+gradeName+'|'+proLotNum+'|'+productPrintNum);
            f1.WriteBlankLines(1);
            f1.Close();
        }
    }
</script>
<script type="text/javascript" src="${ctx}/js/ds/SC182205.js"></script>
