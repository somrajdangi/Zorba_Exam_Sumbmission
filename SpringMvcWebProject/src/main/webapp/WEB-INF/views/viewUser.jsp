
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link href="${pageContext.request.contextPath}/css/viewUserStyle.css" rel="stylesheet" type="text/css"/>


</head>
<body>
<table style="border-collapse:collapse;" border="1">
<tr>
<th>id</th>
<th>name</th>
<th>email</th>
<th>mobile</th>
<th>userName</th>
<th>password</th>
<th>role</th>
</tr>

<c:forEach var="userInfo" items="${userInfoList}">
<tr>
<td><a href="addRoles?userId=${userInfo.userId}">${userInfo.userId}</a></td>
<td>${userInfo.userName} </td>
<td>${userInfo.userEmail} </td>
<td>${userInfo.userMobile} </td>
<td>${userInfo.userUserName} </td>
<td>${userInfo.userPassword} </td>

<td>
<c:if test="${not empty userInfo.roleList}">

<c:forEach var="role" items="${userInfo.roleList}">

<a href="removeRole?roleName=${role.roleName}&userId=${userInfo.userId}"> ${role.roleName}</a>
</c:forEach>
</c:if>
 </td>

</tr>
</c:forEach>
</table>
<br>
<br>
<form action="saveToExcel"  method="get">
<input style="background-color:teal; border-radius=5px" type="submit" value="download"/>
</form>
<br>

</body>
</html>