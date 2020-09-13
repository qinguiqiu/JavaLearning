<%--
  Created by IntelliJ IDEA.
  User: g2
  Date: 2020/8/26
  Time: 下午4:16
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
    <title>用户信息管理系统</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td,th {
            text-align: center;
        }
    </style>

    <script>
        function deleteUser(id) {
            if(confirm("您确定要删除吗？")){
                location.href="${pageContext.request.contextPath}/delUserServlet?id="+id;
            }
        }

        //删除选中
        window.onload = function(){
            document.getElementById("delServleted").onclick = function(){
                if (confirm("您确定要删除选中条目吗？")){
                    var flag = false;
                    var cbs = document.getElementsByName("uid");
                    for (var i = 0; i < cbs.length; i++){
                        if (cbs[i].checked){
                            flag = true;
                            break;
                        }
                    }
                    if (flag){
                        document.getElementById("form").submit();
                    }
                }
            }

            document.getElementById("firstCb").onclick = function () {
                var cbs = document.getElementsByName("uid");
                for (var i = 0; i < cbs.length; i++){
                    cbs[i].checked = this.checked;
                }
            }
        }

    </script>

</head>
<body>

<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>

    <div style="float: left">
        <form class="form-inline" action="${pageContext.request.contextPath}/findUserByPageServlet" method="post">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" name="name" value="${condition.name[0]}" class="form-control" id="exampleInputName2">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">籍贯</label>
                <input type="text" name="address" value="${condition.address[0]}" class="form-control" id="exampleInputEmail2">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail3">邮箱</label>
                <input type="text" name="email" value="${condition.email[0]}" class="form-control" id="exampleInputEmail3">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>

    <div style="float: right; margin: 5px">
        <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/add.jsp" style="background: blue; color: #ffffff">添加联系人</a></td>
        <a class="btn btn-default btn-sm" href="javascript:void(0);" id="delServleted" style="background: blue; color: #ffffff">删除选中</a></td>
    </div>

    <form id="form" action="${pageContext.request.contextPath}/delSelectedServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox" id="firstCb"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${pb.list}" var="user" varStatus="s">
            <tr>
                <th><input type="checkbox" name="uid" value="${user.id}"></th>
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
                <td>${user.qq}</td>
                <td>${user.email}</td>
                <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.id})">删除</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="9" align="center"><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/add.jsp" style="background: blue; color: white">添加联系人</a></td>
        </tr>
    </table>
    </form>

    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">

                <c:if test="${pb.currentPage == 1}">
                    <li class="disabled">
                        <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage -1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>

                <c:if test="${pb.currentPage != 1}">
                    <li>
                        <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage -1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>

                <c:forEach begin="1" end="${pb.totalPage}" var="i">

                    <c:if test="${pb.currentPage == i}">
                        <li class="active"><a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a></li>
                    </c:if>

                    <c:if test="${pb.currentPage != i}">
                        <li><a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a></li>
                    </c:if>

                </c:forEach>

                <c:if test="${pb.currentPage == pb.totalPage}">
                    <li class="disabled">
                        <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage + 1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>

                <c:if test="${pb.currentPage != pb.totalPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage + 1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <span style="font-size: 25px;margin-left: 5px">
                    共${pb.totalCount}条记录，共${pb.totalPage}页
                </span>
            </ul>
        </nav>
    </div>
</div>

</body>
</html>
