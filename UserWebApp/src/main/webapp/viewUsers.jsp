<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>UsersDATA</title>
</head>

<body>
<a href="FormPage.jsp">Add Record</a>
<table border="10px" >

<thead  >
<tr>
<td>Sr.no</td>
<td>UserID </td> 
<td> UserName </td>
<td> UserEmail </td>
<td> UserPhone </td>
<td> UserState </td>
<td> UserCity </td>
<td> Action </td>
</thead>

          <tbody>

                <tr>

                  <c:forEach items="${users}" var="user" varStatus="index">

                  <tr>
                    <td>${index.count}</td>
                    <td>${user.user_id } </td>
                    <td>${user.user_name} </td>
                    <td>${user.user_email} </td>
                    <td>${user.user_phone} </td>
                    <td>${user.user_state} </td>
                    <td>${user.user_city} </td>
                    <td>
                          <c:url var="editUrl" value="/editRow.jsp">
                          <c:param name="user_id" value="${user.user_id}" />
                          <c:param name="user_name" value="${user.user_name}" />
                          <c:param name="user_email" value="${user.user_email}" />
                          <c:param name="user_phone" value="${user.user_phone}" />
                          <c:param name="user_state" value="${user.user_state}" />
                          <c:param name="user_city" value="${user.user_city}" />
                          
                          </c:url>
                         <a href="${editUrl}" onclick="return confirm('Are you sure want to Edit Data')">Edit</a>
                                             
                         <a href="rowDeleteServlet?user_id=${user.user_id}" onclick="return confirm('Are you sure want to delete')">Delete</a>
                    </td>
                  </tr>
       
                  </c:forEach>
                  

                 </tbody>
<tfoot>

</tfoot>
</table>


</body>
</html>