<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="msk" uri="/msk" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="ver" value="0101" />
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>${sysName}${systemEnv}</title>
    <style>
        html {display:none;}
        ul.toolbar {
            position:	relative;
            overflow:	hidden;  required to CONTAINER 'floating li' in FF
            height:		auto;
            margin:		0;
            padding:	2px;
            width:		100%;
            list-style:	none;
            text-align: left;
            background: #D6D6D6 0 50% repeat-x;
            border-top: 1px solid #BBB;
        }
        ul.toolbar li {
            font-size: 0.9em;
            margin: 0;
            padding: 2px 7px;
            float: left;
            color: #000;
            border: 1px solid transparent;
            border-right-color: #BBB;
            cursor: pointer;
        }
        ul.toolbar li:hover {
            color: #005;
            border-top-color: #BBB;
            border-bottom-color: #BBB;
        }
        ul.toolbar li.first:hover {
            border-left-color: #BBB;
        }
        ul.toolbar li span {
             icons in toolbar
            width: 			15px;
            height:			15px;
            margin-left:	-3px;
            margin-right:	0.75ex;
            vertical-align:	middle;
            opacity:		0.6;
            filter:			alpha(opacity=60);
            display:		block;
            display:		inline-block;
        }
        ul.toolbar li:hover span {
            opacity: 1;
            filter: alpha(opacity=100);
        }
    </style>
    <link href="${ctx}/static/core/css/jquery-ui.min.css?v=${ver}" type="text/css" rel="stylesheet" />
    <link href="${ctx}/static/core/css/layout-default-latest.css?v=${ver}" type="text/css" rel="stylesheet" />
    <link href="${ctx}/static/core/css/jquery.dataTables.css?v=${ver}" rel="stylesheet" type="text/css" />
    <link href="${ctx}/static/core/css/jquery.loadmask.css?v=${ver}" type="text/css" rel="stylesheet" />
    <link href="${ctx}/static/core/css/core.css?v=${ver}" type="text/css" rel="stylesheet" />
    <link href="${ctx}/static/core/css/coreGrid.css?v=${ver}" rel="stylesheet" type="text/css" />
    <link href="${ctx}/static/core/css/jquery.timepicker.addon.css?v=${ver}" rel="stylesheet" type="text/css" />
    <link href="${ctx}/static/dialog/css/fDialog.css?v=${ver}" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="${ctx}/static/breadcrumb/Styles/BreadCrumb.css" type="text/css"/>

    <script type="text/javascript" src="${ctx}/static/core/js/jquery-1.11.1.min.js?v=${ver}"></script>
    <script type="text/javascript" src="${ctx}/static/core/js/jquery-ui.min.js?v=${ver}"></script>
    <script type="text/javascript" src="${ctx}/static/core/js/jquery.layout-latest.js?v=${ver}"></script>
    <script type="text/javascript" src="${ctx}/static/core/js/jquery.validate.js" ></script>
    <script type="text/javascript" src="${ctx}/static/core/js/jquery.metadata.js" ></script>
    <script type="text/javascript" src="${ctx}/static/core/js/jquery.timepicker.addon.js?v=${ver}"></script>
    <script type="text/javascript" src="${ctx}/static/core/js/jquery.json.min.js?v=${ver}"></script>
    <script type="text/javascript" src="${ctx}/static/core/js/jquery.dataTables.min.js?v=${ver}"></script>
    <script type="text/javascript" src="${ctx}/static/core/js/jquery.loadmask.min.js?v=${ver}"></script>
    <script type="text/javascript" src="${ctx}/static/dialog/jquery.fDialog.min.js?v=${ver}"></script>
    <script type="text/javascript" src="${ctx}/static/dialog/fDialog.plugin.js?v=${ver}"></script>
    <script type="text/javascript" src="${ctx}/static/core/js/messageDef.js?v=${ver}"></script>
    <script type="text/javascript" src="${ctx}/static/core/js/core.js?v=${ver}"></script>
    <script type="text/javascript" src="${ctx}/static/core/js/coreGrid.js?v=${ver}"></script>
    <script type="text/javascript" src="${ctx}/static/hightCharts/highcharts.js?v=${ver}"></scrip>
        <script type="text/javascript" src="${ctx}/static/core/js/jquery.datepicker.localize.js?v=${ver}"></script>
        <script type="text/javascript" src="${ctx}/static/main/js/main.js?v=${ver}"></script>
    <script type="text/javascript" src="${ctx}/static/core/js/FormUtils.js?v=${ver}"></script>
    <script type="text/javascript" src="${ctx}/static/breadcrumb/js/jquery.easing.1.3.js"></script>
    <script type="text/javascript" src="${ctx}/static/breadcrumb/js/jquery.jBreadCrumb.1.1.js"></script>

    <script type="text/javascript">
        Main.contextPath = "${ctx}";
        Main.language = "zh";

        $(document).ready(function () {
            // 防止 Cross Frame Script (跨框架脚本) 攻击
            if(self==top){
                document.documentElement.style.display='block';
            } else {
                top.location=self.location;
            }
            Main.init();
        });

    </script>
</head>
<body>
<div class="main-header" unselectable="on" onselectstart="return false;" style="-moz-user-select:none;">
    <%@ include file="main-header.jspf" %>
    <input type="hidden" id="sysCode" value="${sysCode}">
    <ul class="toolbar">
        <msk:favorites userId="${loginId}" sysCode="${sysCode}"></msk:favorites>
    </ul>
    <%--<ul class="toolbar">--%>
    <%--<c:forEach items="${systemList}" var="systemModel">--%>
    <%--<c:forEach items='${systemModel.pageList}' var="pageData">--%>
    <%--<li style="color: skyblue;" class="last"><a href="${ctx}${pageData.pageUrl}" target="ajax" rel="main-content"><span style="background: url(${ctx}/static/core/images/action/lost.png) no-repeat center;"></span>${pageData.pageName}</a></li>--%>
    <%--</c:forEach>--%>
    <%--</c:forEach>--%>
    <%--</ul>--%>
</div>
<div class="main-menu" >
    <%@ include file="main-menu.jspf" %>
</div>
<div class="main-container">
    <div id="main-content" class="main-content">
        <div style="color: #444444;">
            <H2>推荐浏览器</H2>
            <div style="padding-left: 8px; color: #666666;">
                推荐浏览器：Firefox35及以上、Chrome35及以上。
            </div>
            <H2>系统版本</H2>
            <div style="padding-left: 8px; color: #666666;">
                build ver:${systemVersion}
            </div>
            <H2>注意事项</H2>
            <div style="padding-left: 8px; color: #666666;">
                每天22时到次日4时为系统维护时段，请知悉。
            </div>
        </div>
    </div>
</div>
<div class="main-copyright">Copyright © 2016 鲜驰达. All Rights Reserved.</div>
<div id="pdialogId"></div>
<div id="alertMessageId"></div>
<iframe name='hidden_frame' id="hidden_frame" style='display:none'></iframe>
</body>
</html>

