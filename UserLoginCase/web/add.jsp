<%--
  Created by IntelliJ IDEA.
  User: g2
  Date: 2020/8/28
  Time: 下午1:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="with=device-width, initial-scale=1"/>
    <title>添加用户</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
    <div class="container">
        <h3 style="text-align: center">添加联系人页面</h3>
        <form action="${pageContext.request.contextPath}/addUserServlet" method="post">
            <div class="form-group">
                <label for="name">姓名：</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
            </div>
            <div class="form-group">
                <label>性别：</label>
                <input type="radio" name="gender" value="男" checked="checked"/>男
                <input type="radio" name="gender" value="女" />女
            </div>
            <div class="form-group">
                <label for="age">年龄：</label>
                <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
            </div>
            <div class="form-group">
                <label for="address">籍贯：</label>
                <select class="form-control" id="address" name="address">
                    <option value="江苏">江苏</option>
                    <option value="北京">北京</option>
                    <option value="上海">上海</option>
                </select>
            </div>
            <div class="form-group">
                <label for="qq">QQ：</label>
                <input type="text" class="form-control" id="qq" name="qq" placeholder="请输入QQ号">
            </div>
            <div class="form-group">
                <label for="email">email：</label>
                <input type="text" class="form-control" id="email" name="email" placeholder="请输入email号">
            </div>
            <div class="form-group" style="text-align: center">
                <input class="btn btn-primary" type="submit" value="提交">
                <input class="btn btn-default" type="reset" value="重置">
                <input class="btn btn-default" type="button" value="返回">
            </div>
        </form>
    </div>

</body>
</html>
