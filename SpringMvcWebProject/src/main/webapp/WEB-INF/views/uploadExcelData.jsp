
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <form action="${pageContext.request.contextPath}/excelToDb" method ="POST" enctype="multipart/form-data">
 <input type="file" name="file" accept=".xlsx" required />
 <br>
 <input type="submit" value="submit"/>
 </form>

