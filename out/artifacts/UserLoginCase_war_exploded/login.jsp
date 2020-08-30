<%--
  Created by IntelliJ IDEA.
  User: g2
  Date: 2020/8/27
  Time: 下午4:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="with=device-width, initial-scale=1"/>
    <title>首页</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">

    <script src="js/jquery.min.js"></script>
    <script src="text/javascript">
        <%--function refreshCode() {--%>
        <%--    var vcode = document.getElementById("vcode");--%>
        <%--    vcode.src = "${pageContext.request.contextPath}/checkCode?"+new Date().getTime();--%>
        <%--}--%>
    </script>

    <script>
        window.onload = function () {
            var img = document.getElementById("vcode");
            img.onclick = function () {
                var date = new Date().getTime();
                img.src = "${pageContext.request.contextPath}/checkCode?"+date;
            }
        }
    </script>

</head>
<body>

<div class="container" style="text-align: left">
    <h3 style="text-align: center;">管理员登录</h3>
    <form action="${pageContext.request.contextPath}/loginServlet" method="post">
        <div class="form-group">
            <label for="user" style="text-align: left">用户名：</label>
            <input type="text" name="username" class="form-control" id="user" placeholder="请输入用户名"/>
        </div>
        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
        </div>
        <div class="form-inline" style="text-align: center">
            <label for="vcode">验证码：</label>
            <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码" style="text-align: center"/>
            <img src="${pageContext.request.contextPath}/checkCode" title="看不清点击刷新" id="vcode"/>
        </div>
        <hr/>
        <div class="form-group" style="text-align: center">
            <input class="btn btn-default btn-primary" type="submit" value="登录">
        </div>
    </form>

    <div class="alert alert-warning alert-dismissable" role="alert">
        <button type="button" class="close" data-dismiss="alert">
            <span>xxxx</span>
        </button>
        <strong>${login_msg}</strong>
    </div>
</div>

</body>
</html>
