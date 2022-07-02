<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
</head>
<style>
.myDiv {
  height: 100px;
  width: 100%;
  background-color: limeGreen;
}
h1 {
  color: white;
  font-family: verdana;
}
td{
 width:150px;
 font-size:20px;
}
</style>
<body>
    <div align="center">
    	<div class="myDiv" ><h1 style="position:relative;top:30%;">CUSTOMER RELATIONSHIP MANAGER</h1></div>
        <h2 >Save Customer</h2>
        <form:form action="saveCustomer" method="post" modelAttribute="customer">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>First Name:</td>
                <td><form:input path="firstName" style="height:20px;width:300px"/></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><form:input path="lastName" style="height:20px;width:300px" /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email" style="height:20px;width:300px" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center" style="height:80px"><input type="submit" style="height:30px;width:100px" value="Save" ></td>
            </tr>
        </table>
        </form:form>
    </div>
    <div>
    <a href="listCustomer" style="font-size:20px;"> Back to List</a>
    </div>
</body>
</html>