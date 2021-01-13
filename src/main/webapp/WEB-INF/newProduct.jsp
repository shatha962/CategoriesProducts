<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>New Product</title>

</head>
<body>

<h1>Products</h1>
<c:forEach items="${products}" var="p">
    <h3><a href="/products/${p.id}">${p.name}: ${p.price}</a></h3>
</c:forEach>
<h1>New Product</h1>
<form:form action="/products/new" method="post" modelAttribute="prod">
    <p>
        <form:label path="name">Name :</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="description">Description :</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p>
    <p>
        <form:label path="price">Price :</form:label>
        <form:errors path="price"/>
        <form:input path="price"/>
    </p>
    <input type="submit" value="Create"/>
</form:form>
<a href="/categories">Categories</a>
</body>
</html>
