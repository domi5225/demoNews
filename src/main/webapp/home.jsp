<%-- 
    Document   : home
    Created on : Oct 3, 2024, 10:18:19 PM
    Author     : doanm
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Đây là trang tin tức cua chung toi</h1>
        <c:if test="${sessionScope.user == null}">
            <a href="form.jsp">Đăng nhập</a>
        </c:if>
        <c:if test="${sessionScope.user != null}">
            <p>${sessionScope.user.uname}</p>
            <c:if test="${sessionScope.user.ueditor}">
                <a href="tao-bai">Tao bai viet</a>
            </c:if>
            <a href="dang-xuat">Dang xuat</a>
        </c:if>
        
        
        <table border="1">
            <tr>
                <c:forEach var="o" items="${listC}">
                    <td><a href="${pageContext.request.contextPath}/category/${o.cslug}" >${o.cname}</a></td>
                </c:forEach>
            </tr>
        </table>
        <c:if test = "${category != null}">
            <h3>${category}</h3><hr>
        </c:if>
        <c:forEach var="o" items="${listP}">
            <a href="${pageContext.request.contextPath}/post/${o.pslug}">
                <img src="${o.pimage}">
                <h3>${o.ptitle}</h3>
            </a>
            
            <h4>${o.editorName}</h4>
            <h4>${o.ptime}</h4>
            <!--<pre></pre>-->
        </c:forEach>
    </body>
</html>
