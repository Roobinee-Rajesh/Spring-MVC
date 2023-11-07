<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous" defer></script>
</head>
<body>

<form:form action="registerAddUser" method="POST" modelAttribute="user">
    <div class="container w-75 pt-4">
        <h2 class="text-center d-flex justify-content-center">Register</h2>
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <form:input type="text" class="form-control" id="name" path="name" />
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <form:input type="email" class="form-control" id="email" path="email" />
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <form:input type="password" class="form-control" id="password" path="password" />
        </div>
        <div class="mb-3">
            <label for="cPassword" class="form-label">Confirm Password</label>
            <form:input type="password" class="form-control" id="cPassword" path="cPassword" />
        </div>
        <div class="mb-3">
            <label for="gender" class="form-label">Gender</label>
            Male <form:radiobutton path="gender" value="Male" />
            Female <form:radiobutton path="gender" value="Female" />
        </div>
        <div class="mb-3">
            <label for="language" class="form-label">Language</label>
            Tamil <form:checkbox path="language" value="Tamil" />
            English <form:checkbox path="language" value="English" />
            Hindi <form:checkbox path="language" value="Hindi" />
            Telugu <form:checkbox path="language" value="Telugu" />
        </div>
        <div class="mb-3">
            <label for="state" class="form-label">State  </label>
            <form:select path="state">
            <form:option value=" " label="--Select--" />
                <form:option value="Tamil Nadu" label="Tamil Nadu" />
                <form:option value="Kerala" label="Kerala" />
                <form:option value="Andhra Pradesh" label="Andhra Pradesh" />
                <form:option value="Karnataka" label="Karnataka" />
            </form:select>
        </div>

        	<div class="mb-3">
        			<label for="qualification" class="form-label">Qualification</label>
        			<form:select path="qualification">
        				<form:options items="${user.qualification}" />
        			</form:select>
        		</div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </div>
</form:form>


</body>
</html>
