<%--
  Created by IntelliJ IDEA.
  User: snowfog-shao
  Date: 17-11-22
  Time: 下午10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
    <head>
        <title>菜单管理</title>
        <meta  content='text/html; charset=UTF-8' />
        <link rel="stylesheet" href="/resources/easyui/themes/gray/easyui.css">
        <link rel="stylesheet" href="/resources/css/superGreen.css">
        <link rel="stylesheet" href="/resources/css/snowoa.plugin.css">
        <link href="/resources/css/font-awesome.min.css" rel="stylesheet" />
        <style>
            .easyui-linkbutton .fa-plus {
                color: #0089ff;
            }

            .easyui-linkbutton .fa-trash {
                color: #b11688;
            }
        </style>
    </head>
    <body>
        <div class="contain-fluid">
            <table id="tt" class="easyui-datagrid"
                   title="<a class='padding1x'><i class='fa fa-gear' style='color:#8d31b3;'></i></a>系统菜单管理配置"
                   style="width: 100%; height: 100%;"
                   data-options="fitColumns: true,singleSelect:true,collapsible:true,url:'/menu/listTrees/pagination',method:'POST',pagination:true"
                   toolbar="#tb" rownumbers="true">
            </table>
        </div>
        <div id="tb">
            <a href="#" class="easyui-linkbutton" style="height: 32px;"
               iconCls="fa fa-plus" plain="true" onclick="showAdd();">新增</a> <a
               href="#" class="easyui-linkbutton" style="height: 32px;"
               iconCls="fa fa-trash" plain="true" onclick="javascript:alert('Cut')">删除</a>
        </div>
        <div id="win" class="easyui-window" title="新增菜单"
             style="width: 600px; height: 400px"
             data-options="iconCls:'icon-save',modal:true,closed:true"
             buttons="#dlg-buttons">
            <form id="ff" method="post" class="form-custom"
                  style="height: calc(100% - 60px)">
                <div>
                    <label for="name" class="fl alignLeft">菜单名称:</label> <input
                        class="easyui-validatebox fr" type="text" name="name"
                        data-options="required:true" />
                </div>
                <div>
                    <label for="url" class="fl alignLeft">路径:</label> <input
                        class="easyui-validatebox fr" type="text" name="url" />
                </div>
                <div>
                    <label for="iconCls" class="fl alignLeft">图标样式:</label> <input
                        class="easyui-validatebox fr" type="text" name="iconCls" />
                </div>
                <div>
                    <label for="isLeaf" class="fl alignLeft">是否叶子节点:</label>
                    <select class="easyui-combobox" name="isLeaf">
                        <option value="true">是</option>
                        <option value="false">否</option>
                    </select>
                </div>
                <div>
                    <label for="parentId" class="fl alignLeft">父级菜单:</label> <input
                        class="easyui-validatebox fr" type="text" name="parentId" />
                </div>
                <div>
                    <label for="state" class="fl alignLeft">默认展开:</label>
                    <select class="easyui-combobox" name="state">
                        <option value="true">展开</option>
                        <option value="false">关闭</option>
                    </select>
                </div>
            </form>
            <div id="dlg-buttons">
                <table cellpadding="0" cellspacing="0" style="width: 100%">
                    <tr>
                        <td style="text-align: center"><a href="#"
                                                          class="easyui-linkbutton" iconCls="fa fa-save"
                                                          onclick="save();">保存</a>
                    </tr>
                </table>
            </div>
        </div>

        <script src="/resources/easyui/jquery.min.js"></script>
        <script src="/resources/easyui/jquery.easyui.min.js"></script>
        <script src="/resources/easyui/locale/easyui-lang-zh_CN.js"></script>
        <script src="/resources/js/super.js"></script>
        <script src="/resources/js/menu/main.js">

        </script>
    </body>
</html>
