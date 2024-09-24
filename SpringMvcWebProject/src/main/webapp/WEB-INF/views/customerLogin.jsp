
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<h1>Customer login</h1>
<form action="customerLogin" method ="POST">
user Name: <input type="text" name="userName" value=""  />
<br>
user password: <input type="password" name="password" value=""  />
<br>
customer Role: <input type="text" name="role" value="customer" readonly  />
<br>
<input type="submit" value="submit"/>
</form >