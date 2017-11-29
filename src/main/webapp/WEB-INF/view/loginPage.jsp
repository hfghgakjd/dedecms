<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: snowfog-shao
  Date: 17-11-12
  Time: 下午4:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="/resources/css/snowoa.plugin.css">
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid sign-form">
    <form class="form-signin" action="/loginPage" method="post">
        <h3 class="form-signin-heading">请登录</h3>
        <label for="inputUsername" class="sr-only">用户名</label>
        <input type="text" id="inputUsername" class="form-control" name="username" placeholder="用户名" required autofocus>
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="密码" required>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> 记住账户
            </label>
        </div>
        <button class="btn btn-md btn-primary" type="submit">登录</button>
    </form>
</div>
</body>
</html>
