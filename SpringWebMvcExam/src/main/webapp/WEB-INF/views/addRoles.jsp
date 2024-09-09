
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<h1> pick the roles from drop down menu<h1>



<form action="http://localhost:8080/SpringWebMvcExam/addRoles" method="post">
<select name="role">
  <option  value="admin">Admin</option>
  <option  value="user">User</option>
  <option value="vendor">Vendor</option>
</select>

<input type="hidden" name="userId" value="${userId}"/>

<input  type="submit" value="submit" />

</form>