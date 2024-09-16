

<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<form action="addInventory" method="post"  >
inventory category:
<select name="category">
  <option  value="grocery">grocery</option>
  <option  value="cosmetic">cosmetics</option>
  <option value="dairy">dairy</option>
</select>
<br>
inventory name:<input type="text" name="name" value=""/>
<br>
inventory Quantity: <input type="number" name="quantity" value=""/>
<br>
inventory price(per unit) <input type="text" name="price" value=""/>
<br>

image: <input type="file" name="image" value=""/>
<br>

inventory description: <textarea  name="description" value=""/>
<br>
<input type="submit" value="add"/>
</form>