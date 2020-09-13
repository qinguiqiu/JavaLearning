<%--
  Created by IntelliJ IDEA.
  User: g2
  Date: 2020/8/26
  Time: 下午3:34
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
  <title>首页</title>

  <link href="css/bootstrap.min.css" rel="stylesheet">

  <script src="js/jquery.min.js"></script>
  <script type="text/javascript"></script>

</head>
<body>

<div>
  ${user.name},欢迎您！
</div>

<div align="center">
  <a
    href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=1&rows=5" style="text-align: center; font-size: 25px">查询所有用户信息
  </a>
</div>
</body>
</html>
