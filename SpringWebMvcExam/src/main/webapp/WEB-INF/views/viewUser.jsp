
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">

<table style="border-collapse:collapse;" border="1" >

 <tr>
     <th>id</th>
    <th>name</th>
    <th>email</th>
    <th>mobile</th>
    <th>password</th>
    <th>user Name</th>
 </tr>


<c:forEach var="user" items="${userList}">

<tr>
  <td>  <a href="getRollerId?userId=${user.userId}">${user.userId}</a></td>
<td>${user.userName}</td>
<td>${user.userEmail}</td>
<td>${user.userMobile}</td>
<td>${user.userPassword}</td>
<td>${user.userUserName}</td>
</tr>

</c:forEach>

 </table>