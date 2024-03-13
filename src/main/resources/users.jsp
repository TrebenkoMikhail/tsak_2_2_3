<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>
</head>
<body>
<h1>User List</h1>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
    <tr>
        <td>${user.id}</td>
        <td>${user.firstName}</td>
        <td>${user.lastName}</td>
        <td>
            <a href="/users/edit/${user.id}">Edit</a>
            <a href="/users/delete/${user.id}">Delete</a>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<hr>
<h2>Add User</h2>
<form action="/user/add" method="post">
    <label for="firstName">First Name</label>
    <input type="text" id="firstName" name="firstName" required>
    <br>
    <laber for="lastName">Last Name:</laber>
    <input type="text" id="lastName" name="lastName" required>
    <br>
    <input type="submit" value="Add User">
</form>
</body>
</html>
