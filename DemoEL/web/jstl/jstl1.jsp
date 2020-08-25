<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: qinguiqiu
  Date: 2020/8/25
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
    c:if标签
    属性：
    test 必须属性，接受boolean表达式
    如果表达式为true，则显示if标签体内容，如果为false，则不显示标签体内容
    一般情况下，test的属性值会结合el表达式一起使用
    没有else情况
    --%>
    <c:if test="true">
        <h1>我是真....</h1>
    </c:if>
    <br>

    <%
        List list = new ArrayList();
        list.add("aaaaa");
        request.setAttribute("list", list);
    %>

    <c:if test="${not empty list}">
        遍历集合。。。
    </c:if>
</body>
</html>
