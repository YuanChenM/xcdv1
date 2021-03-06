<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<script type="text/javascript">
    var slCode='${slCode}';
    var epId='${epId}';
</script>
<c:choose>
    <c:when test="${selfFlg==1 and oemFlg==1 and agentFlg==1}">
        <navigation:header title="卖家企业信息详细（自产型/代理型/OEM型）" backTitleArray="产品待审批审核卖家列表" backUrlArray="${ctx}/SL241101/init"></navigation:header>
    </c:when>
    <c:when test="${selfFlg==1 and oemFlg==1}">
        <navigation:header title="卖家企业信息详细（自产型/OEM型）" backTitleArray="产品待审批审核卖家列表" backUrlArray="${ctx}/SL241101/init"></navigation:header>
    </c:when>
    <c:when test="${selfFlg==1 and agentFlg==1}">
        <navigation:header title="卖家企业信息详细（自产型/代理型）" backTitleArray="产品待审批审核卖家列表" backUrlArray="${ctx}/SL241101/init"></navigation:header>
    </c:when>
    <c:when test="${oemFlg==1 and agentFlg==1}">
        <navigation:header title="卖家企业信息详细（代理型/OEM型）" backTitleArray="产品待审批审核卖家列表" backUrlArray="${ctx}/SL241101/init"></navigation:header>
    </c:when>
    <c:when test="${selfFlg==1}">
        <navigation:header title="卖家企业信息详细（自产型）" backTitleArray="产品待审批审核卖家列表" backUrlArray="${ctx}/SL241101/init"></navigation:header>
    </c:when>
    <c:when test="${agentFlg==1}">
        <navigation:header title="卖家企业信息详细（代理型）" backTitleArray="产品待审批审核卖家列表" backUrlArray="${ctx}/SL241101/init"></navigation:header>
    </c:when>
    <c:when test="${oemFlg==1}">
        <navigation:header title="卖家企业信息详细（OEM型）" backTitleArray="产品待审批审核卖家列表" backUrlArray="${ctx}/SL241101/init"></navigation:header>
    </c:when>
    <c:when test="${slMainClass==0}">
        <navigation:header title="卖家企业信息详细（生产商）" backTitleArray="产品待审批审核卖家列表,卖家企业信息详细（OEM型）" backUrlArray="${ctx}/SL241101/init,${ctx}/SL241103/init"></navigation:header>
    </c:when>
</c:choose>
<div class="page-content detail-page" style="margin-top:35px;">
    <div id="SL241103012accordion" class="group-accordion" collapsible="true" active="false">
        <h3>
            <label>卖家基本信息</label>
        </h3>
        <div id="initSL24110301"></div>
    </div>
    <c:choose>
        <%-- // 生产商 --%>
        <c:when test="${slMainClass==0}">
            <div id="SL241103022accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>卖家专业资质</label>
                </h3>
                <div id="initSL24110302"></div>
            </div>
            <div id="SL241103032accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>企业基本能力描述</label>
                </h3>
                <div id="initSL24110303"></div>
            </div>
            <div id="SL241103042accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>企业生产车间、设备、产品工艺流程描述</label>
                </h3>
                <div id="initSL24110304"></div>
            </div>
            <div id="SL241103052accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>企业实验室、检测设备及产品质量控制系统描述</label>
                </h3>
                <div id="initSL24110305"></div>
            </div>
            <div id="SL241103122accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>检测设备描述</label>
                </h3>
                <div id="initSL24110312"></div>
            </div>
            <div id="SL241103062accordion" class="group-accordion" collapsible="true" active="false" >
                <h3>
                    <label>企业管理团队描述</label>
                </h3>
                <div id="initSL24110306"></div>
            </div>
            <div id="SL241103072accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>企业电商团队描述</label>
                </h3>
                <div id="initSL24110307"></div>
            </div>
            <div id="SL241103082accordion" class="group-accordion" collapsible="true" active="false" >
                <h3>
                    <label>企业产品品牌描述</label>
                </h3>
                <div id="initSL24110308"></div>
            </div>
            <%@include file="SL24110309.jsp"%>
            <%@include file="SL24110310.jsp"%>
        </c:when>
        <%-- // 自产性+代理商+OEM性 --%>
        <c:when test="${selfFlg==1 and oemFlg==1 and agentFlg==1}">
            <div id="SL241103022accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>卖家专业资质</label>
                </h3>
                <div id="initSL24110302"></div>
            </div>
            <div id="SL241103032accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>企业基本能力描述</label>
                </h3>
                <div id="initSL24110303"></div>
            </div>
            <div id="SL241103042accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>企业生产车间、设备、产品工艺流程描述</label>
                </h3>
                <div id="initSL24110304"></div>
            </div>
            <div id="SL241103052accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>企业实验室、检测设备及产品质量控制系统描述</label>
                </h3>
                <div id="initSL24110305"></div>
            </div>
            <div id="SL241103122accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>检测设备描述</label>
                </h3>
                <div id="initSL24110312"></div>
            </div>
            <div id="SL241103062accordion" class="group-accordion" collapsible="true" active="false" >
                <h3>
                    <label>企业管理团队描述</label>
                </h3>
                <div id="initSL24110306"></div>
            </div>
            <div id="SL241103072accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>企业电商团队描述</label>
                </h3>
                <div id="initSL24110307"></div>
            </div>
            <div id="SL241103082accordion" class="group-accordion" collapsible="true" active="false" >
                <h3>
                    <label>企业产品品牌描述</label>
                </h3>
                <div id="initSL24110308"></div>
            </div>
            <%@include file="SL24110309.jsp"%>
            <%@include file="SL24110310.jsp"%>
        </c:when>
        <%-- // 代理性+OEM性 --%>
        <c:when test="${agentFlg==1 and oemFlg==1}">
            <div id="SL241103072accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>企业电商团队描述</label>
                </h3>
                <div id="initSL24110307"></div>
            </div>
            <div id="SL241103082accordion" class="group-accordion" collapsible="true" active="false" >
                <h3>
                    <label>企业产品品牌描述</label>
                </h3>
                <div id="initSL24110308"></div>
            </div>
            <%@include file="SL24110309.jsp"%>
            <%@include file="SL24110310.jsp"%>
        </c:when>
        <%-- // 自产性+代理性 --%>
        <c:when test="${selfFlg==1 and agentFlg==1}">
            <div id="SL241103022accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>卖家专业资质</label>
                </h3>
                <div id="initSL24110302"></div>
            </div>
            <div id="SL241103032accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>企业基本能力描述</label>
                </h3>
                <div id="initSL24110303"></div>
            </div>
            <div id="SL241103042accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>企业生产车间、设备、产品工艺流程描述</label>
                </h3>
                <div id="initSL24110304"></div>
            </div>
            <div id="SL241103052accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>企业实验室、检测设备及产品质量控制系统描述</label>
                </h3>
                <div id="initSL24110305"></div>
            </div>
            <div id="SL241103122accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>检测设备描述</label>
                </h3>
                <div id="initSL24110312"></div>
            </div>
            <div id="SL241103062accordion" class="group-accordion" collapsible="true" active="false" >
                <h3>
                    <label>企业管理团队描述</label>
                </h3>
                <div id="initSL24110306"></div>
            </div>
            <div id="SL241103072accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>企业电商团队描述</label>
                </h3>
                <div id="initSL24110307"></div>
            </div>
            <div id="SL241103082accordion" class="group-accordion" collapsible="true" active="false" >
                <h3>
                    <label>企业产品品牌描述</label>
                </h3>
                <div id="initSL24110308"></div>
            </div>
            <%@include file="SL24110309.jsp"%>
            <%@include file="SL24110310.jsp"%>
        </c:when>
        <%-- // 自产性 +OEM性--%>
        <c:when test="${selfFlg==1 and oemFlg==1}">
            <div id="SL241103022accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>卖家专业资质</label>
                </h3>
                <div id="initSL24110302"></div>
            </div>
            <div id="SL241103032accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>企业基本能力描述</label>
                </h3>
                <div id="initSL24110303"></div>
            </div>
            <div id="SL241103042accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>企业生产车间、设备、产品工艺流程描述</label>
                </h3>
                <div id="initSL24110304"></div>
            </div>
            <div id="SL241103052accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>企业实验室、检测设备及产品质量控制系统描述</label>
                </h3>
                <div id="initSL24110305"></div>
            </div>
            <div id="SL241103122accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>检测设备描述</label>
                </h3>
                <div id="initSL24110312"></div>
            </div>
            <div id="SL241103062accordion" class="group-accordion" collapsible="true" active="false" >
                <h3>
                    <label>企业管理团队描述</label>
                </h3>
                <div id="initSL24110306"></div>
            </div>
            <div id="SL241103072accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>企业电商团队描述</label>
                </h3>
                <div id="initSL24110307"></div>
            </div>
            <div id="SL241103082accordion" class="group-accordion" collapsible="true" active="false" >
                <h3>
                    <label>企业产品品牌描述</label>
                </h3>
                <div id="initSL24110308"></div>
            </div>
            <%@include file="SL24110309.jsp"%>
            <%@include file="SL24110310.jsp"%>
        </c:when>
        <%-- // 代理性 --%>
        <c:when test="${agentFlg==1}">
            <div id="SL241103072accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>企业电商团队描述</label>
                </h3>
                <div id="initSL24110307"></div>
            </div>
            <%@include file="SL24110309.jsp"%>
            <%@include file="SL24110310.jsp"%>
        </c:when>
        <%-- // OEM性 --%>
        <c:when test="${oemFlg==1}">
            <div id="SL241103072accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>企业电商团队描述</label>
                </h3>
                <div id="initSL24110307"></div>
            </div>
            <div id="SL241103082accordion" class="group-accordion" collapsible="true" active="false" >
                <h3>
                    <label>企业产品品牌描述</label>
                </h3>
                <div id="initSL24110308"></div>
            </div>
            <%@include file="SL24110309.jsp"%>
            <%@include file="SL24110310.jsp"%>
        </c:when>
        <%-- // 自产性 --%>
        <c:when test="${selfFlg==1}">
            <div id="SL241103022accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>卖家专业资质</label>
                </h3>
                <div id="initSL24110302"></div>
            </div>
            <div id="SL241103032accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>企业基本能力描述</label>
                </h3>
                <div id="initSL24110303"></div>
            </div>
            <div id="SL241103042accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>企业生产车间、设备、产品工艺流程描述</label>
                </h3>
                <div id="initSL24110304"></div>
            </div>
            <div id="SL241103052accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>企业实验室、检测设备及产品质量控制系统描述</label>
                </h3>
                <div id="initSL24110305"></div>
            </div>
            <div id="SL241103122accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>检测设备描述</label>
                </h3>
                <div id="initSL24110312"></div>
            </div>
            <div id="SL241103062accordion" class="group-accordion" collapsible="true" active="false" >
                <h3>
                    <label>企业管理团队描述</label>
                </h3>
                <div id="initSL24110306"></div>
            </div>
            <div id="SL241103072accordion" class="group-accordion" collapsible="true" active="false">
                <h3>
                    <label>企业电商团队描述</label>
                </h3>
                <div id="initSL24110307"></div>
            </div>
            <div id="SL241103082accordion" class="group-accordion" collapsible="true" active="false" >
                <h3>
                    <label>企业产品品牌描述</label>
                </h3>
                <div id="initSL24110308"></div>
            </div>
        </c:when>
    </c:choose>
    <br/><br/>
</div>
<script src="${ctx}/js/sl/SL24110333.js"></script>
