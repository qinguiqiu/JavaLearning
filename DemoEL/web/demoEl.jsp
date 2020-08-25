<%@ page import="cn.itcast.web.domain.User" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: g2
  Date: 2020/8/25
  Time: 下午4:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    User user = new User();
    user.setName("zhangsan");
    user.setAge(23);
    user.setBirthday( new Date());

    request.setAttribute("u", user);
%>

${requestScope.u}<br>

${requestScope.u.name}<br>
${requestScope.u.age}<br>
${requestScope.u.birthday}<br>
${requestScope.u.birthday.month}<br>
${u.birStr}<br>

</body>
</html>
