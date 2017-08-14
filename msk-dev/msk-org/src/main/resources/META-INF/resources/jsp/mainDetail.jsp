<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="ver" value="0101" />
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>${title}</title>
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
        Main.contextPath = '..';
        Main.language = "zh";
    </script>
	<style>
    html {
    overflow-x: hidden;
    }
    </style>
</head>
<body>
<div class="main-container">
    <div id="main-content" class="main-content;"style="overflow-y:auto;min-height: 900px;">
    </div>
</div>
<div class="main-copyright">Copyright © 2016 鲜驰达. All Rights Reserved.</div>
<div id="pdialogId"></div>
<div id="alertMessageId"></div>
<iframe name='hidden_frame' id="hidden_frame" style='display:none'></iframe>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        // 获取窗口高度
        var winHeight;
        if (window.innerHeight)
            winHeight = window.innerHeight;
        else if ((document.body) && (document.body.clientHeight))
            winHeight = document.body.clientHeight;
        //$('.main-content').first().height( winHeight - 50);
        $("#main-content").postUrl('${url}' , JSON.parse('${data}'),function(){$("#headBreadCrumb").hide()});
    });
</script>
</html>

