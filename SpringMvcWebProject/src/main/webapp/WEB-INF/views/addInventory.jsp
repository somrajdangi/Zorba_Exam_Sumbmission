
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<form action="addInventory" method="post"  >
inventory category:
<input type="text" required name="role" readonly  value="${role}"/>
<select required name="category">
  <option  value="grocery">grocery</option>
  <option  value="cosmetics">cosmetics</option>
  <option value="dairy">dairy</option>
</select>
<br>
inventory name:<input required type="text" name="name" value=""/>
<br>
inventory Quantity: <input required type="number" name="quantity" value=""/>
<br>
inventory price(per unit) <input  required type="text" name="price" value=""/>
<br>

inventory description:  <textarea required name="description"></textarea>
<br>
<input type="submit" value="submit"/>
</form>
