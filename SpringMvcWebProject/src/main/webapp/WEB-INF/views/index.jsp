
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<h1>register user information form</h1>
<div class="register"  >
<form action="saveUserInfo" method="get">

userName: <input type="text" name="userName" value ="" placeholder="name"  />
<br>
user Email:<input type="email" name="userEmail" value=""   placeholder="Email" />
<br>
user Password:<input type="password" name="userPassword" value=""   placeholder="Password" />
<br>
user UserName:<input type="text" name="userUserName" value=""  placeholder="UserName"/>
    <br>
    user phone:<input type="number" name="userMobile" value="" placeholder="mobile"   />
        <br>
<input type="submit" value="register"/>

</form>

<a href="customerLogin">customer login</a>
<br>
<br>
<a href="vendorLogin">vendor login</a>
