<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>首页</title>
    <link rel="stylesheet" href="/resources/easyui/themes/gray/easyui.css">
       <link rel="stylesheet" href="/resources/css/superGreen.css">
    <link rel="stylesheet" href="/resources/css/snowoa.plugin.css">
    <link href="/resources/css/font-awesome.min.css" rel="stylesheet"/>
    <script src="/resources/easyui/jquery.min.js"></script>
    <script src="/resources/easyui/jquery.easyui.min.js"></script>
    <script src="/resources/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script src="/resources/js/super.js"></script>
<body class="easyui-layout">
<div data-options="region:'north',split:false" style="height:50px;line-height: 50px;background:#1abc9c;">
    <span class="head-title">snowsystem 教育管理系统</span>
    <div class="head-tool fr padding2x">
        <ul>
            <li><a>${pageContext.request.remoteUser}</a></li>
        </ul>
    </div>
</div>
<div data-options="region:'south'" style="height:40px;"></div>
<div data-options="region:'west',title:'功能菜单'" style="width:200px;">
    <div id="aa" class="easyui-accordion" style="width:193px;">
    </div>
</div>
<div data-options="region:'center'" style="padding-top: 3px;">
    <!--主要内容-->
    <div id="tabs" class="easyui-tabs" data-options="border:false,fit:true" >
        <div title="首页" data-options="iconCls:'fa fa-home'">

        </div>
    </div>
</div>
<script src="/resources/js/index/main.js"></script>
</body>
</html>
