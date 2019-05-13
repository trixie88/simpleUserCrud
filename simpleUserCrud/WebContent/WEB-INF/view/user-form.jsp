<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-user-style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>User CRUD</h2>
		</div>
	</div>


	<div id="container">

		<h3>Save User</h3>
		<form:form action="saveUser" modelAttribute="user"
			method="POST">
			<form:hidden path="id"/>
			
			<form:input path="firstName" placeholder="FirstName" />
			<br />
			<form:input path="lastName" placeholder="LastName" />

			<br />
			<form:input path="email" placeholder="Email" />
			
			<br />
			<input type="submit" value="Save" />
		</form:form>

		<div style=""></div>
		<p>
			<a href="${pageContext.request.contextPath}/user/list">Back to List</a>
		</p>

	</div>



</body>
</html>