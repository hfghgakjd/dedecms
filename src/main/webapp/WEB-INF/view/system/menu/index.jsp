<%--
  Created by IntelliJ IDEA.
  User: snowfog-shao
  Date: 17-11-22
  Time: 下午10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜单管理</title>
    <link rel="stylesheet" href="/resources/easyui/themes/gray/easyui.css">
    <link rel="stylesheet" href="/resources/css/superGreen.css">
    <link rel="stylesheet" href="/resources/css/snowoa.plugin.css">
    <link href="/resources/css/font-awesome.min.css" rel="stylesheet"/>
    <script src="/resources/easyui/jquery.min.js"></script>
    <script src="/resources/easyui/jquery.easyui.min.js"></script>
    <script src="/resources/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script src="/resources/js/super.js"></script>
</head>
<body>
<div class="contain-fluid">
    <table class="easyui-datagrid" title="Basic DataGrid" style="width:100%;height:100%;"
           data-options="fitColumns: true,singleSelect:true,collapsible:true,url:'/test', method:'POST',pagination:true">
        <thead>
        <tr>
            <th data-options="field:'itemid',width:80">Item ID</th>
            <th data-options="field:'productid',width:100">Product</th>
            <th data-options="field:'listprice',width:80,align:'right'">List Price</th>
            <th data-options="field:'unitcost',width:80,align:'right'">Unit Cost</th>
            <th data-options="field:'attr1',width:250">Attribute</th>
            <th data-options="field:'status',width:130,align:'center'">Status</th>
        </tr>
        </thead>
    </table>
</div>
<script>
    $('#dg').datagrid({
        url: '/test',
        method: "POST",
        fit: true,
        pagination: true,
        fitColumns: true
    });
</script>
</body>
</html>
