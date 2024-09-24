
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>select items by category</h1>
<form action="filterCustomerDashboard" method="post">
<input type="text" name="inventoryList" value="${inventoryList}" />
<br>
<select required name="category">
  <option  value="grocery">grocery</option>
  <option  value="cosmetics">cosmetics</option>
  <option value="dairy">dairy</option>
</select>
<br>
<input type="submit" value="filter"/>
</form>

<br>
<c:forEach var="inventoryList" items="${inventoryList}" >
<form action="addToCart" method="post">

<input type="hidden" name="itemName" value="${inventoryList.inventoryName}"/>
name:<p> ${inventoryList.inventoryName}</p>

<input type="hidden" name="itemDescription" value="${inventoryList.inventoryDescription}"/>
<p> description: ${inventoryList.inventoryDescription}</p>

<input type="hidden" name="itemQuantity" value="${inventoryList.inventoryQuantity}"/>
<p> quantity: ${inventoryList.inventoryQuantity}</p>

<input type="hidden" name="itemPrice" value="${inventoryList.inventoryPrice}"/>
<p> total price: ${inventoryList.inventoryPrice}</p>

<input type="hidden" name="categoryName" value="${inventoryList.inventoryCategory.categoryName}"/>
<p> category: ${inventoryList.inventoryCategory.categoryName}
<br>
<br>
<input type="submit" value="add to cart"/>

</form>
<hr>
</c:forEach >
