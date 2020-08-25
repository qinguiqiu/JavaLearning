<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: qinguiqiu
  Date: 2020/8/25
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>foreach</title>
</head>
<body>
    <%
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        request.setAttribute("list", list);
    %>
    <c:forEach begin="0" end="5" var="i" step="1" varStatus="s">
        ${i} ${s.index} ${s.count}<br>
    </c:forEach>

    <c:forEach items="${list}" var="str" varStatus="s">
        ${str} ${s.index} ${s.count} <br>
    </c:forEach>
</body>
</html>
