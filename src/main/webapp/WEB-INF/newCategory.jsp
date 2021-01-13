<%--
  Created by IntelliJ IDEA.
  User: SYSCOM
  Date: 1/13/2021
  Time: 8:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Categories</title>
</head>
<body>
<h1>Categories</h1>
<c:forEach items="${categories}" var="c">
    <h3><a href="/categories/${c.id}">${c.name}</a></h3>
</c:forEach>
<h1>New Product</h1>
<form:form action="/categories/new" method="post" modelAttribute="cat">
    <p>
        <form:label path="name">Name :</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>

    <input type="submit" value="Create"/>
</form:form>
<a href="/products">products</a>
</body>
</html>
