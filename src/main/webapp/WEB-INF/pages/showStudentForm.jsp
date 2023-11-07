<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<form: form action="processStudentForm" modelAttribute="student">
First Name:<form:input path="firstName"/>
Last Name:<form:input path="lastName"/>
<input type="submit">
</body>
</html>
