<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- //gia to href thelw to actual name of the app pou to vriskw me to pagecontect.request klpa kai meta kanw append to actual location of the css file -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div="header">
			<h2>List of Users</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<button
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button">Add User</button>
			<table>
				<thead>
					<tr>
						<th>Firstname</th>
						<th>LastName</th>
						<th>email</th>
						<th>Action</th>
					</tr>

				</thead>

				<tbody >
					<c:forEach var="user" items="${users}">
						<c:url var="updateLink" value="/user/showFormForUpdate">
							<c:param name="userId" value="${user.id}"></c:param>
						</c:url>
						<c:url var="deleteLink" value="/user/deleteUser">
							<c:param name="userId" value="${user.id}"></c:param>
						</c:url>
						<tr>
							<td>${user.firstName}</td>
							<td>${user.lastName}</td>
							<td>${user.email}</td>
							<td>
							 <a href="${updateLink}">Update</a> |
							 <a  onclick="return deleteLink()" class="deleteLink" href="${deleteLink}">Delete</a> 
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>

	<script>
		function deleteLink(){
			if (! (confirm("Are you sure?")) ) {
				return false;
				}
		}
	</script>
</body>
</html>