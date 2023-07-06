<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 



String msg= (String) request.getAttribute("editmsg"); 

if(msg!=null){
	out.print(msg);

}

%>



<form action="editRowServlet" method="get">

<table>

    <thead>
                EditForm
         
    </thead>
    <br>
       
    <tbody>
                  <input name="user_id" placeholder="UserID" type="text" value=${param.user_id} >
                  
                  <input name="name" placeholder="UserName" type="text" value=${param.user_name} >
                           <br>
                  <input name="email" placeholder="Email" type="email" value=${param.user_email} >
                           <br>
         
                  <input name="phone" placeholder="Phone" type="text" value=${param.user_phone} >
                           <br>
         
                  <input name="state" placeholder="State" type="text" value=${param.user_state} >
                           <br>
         
                  <input name="city" placeholder="City" type="text" value= ${param.user_city}>
    </tbody>
    <br>
    <tfoot>
                   <input type="submit" >
                   <br>
                  
    </tfoot>


</table>





</form>
                   <button onclick="location.href='FormPage.jsp'" type="button">
                          Home</button>



</body>
</html>