
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h2>This is add roles page. select the roles from drop down</h2>
<form action="saveRoles" method="post">
userId:<input type="text" readonly name="userId" value="${userId}">
<br>
<select name="roleName" value="">
<option value="customer">customer</option>
<option value="admin">admin</option>
<option value="vendor">vendor</option>
</select>
<br>
<input type="submit" value="submit"/>
</form>