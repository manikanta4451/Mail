<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:choose>
		<c:when test="${name=='home' }">
		<form action="/saveFeedback" method="post">
<INPUT TYPE="TEXT" SIZE="25" MAXLENGTH="40" NAME="email" value="${user.email }"placeholder="Enter the Email">
<input type="submit" value="Submit" onClick="Submit">
</form>
</c:when>
</c:choose>
</body>
</html>