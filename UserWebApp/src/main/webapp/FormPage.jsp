<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

<% 



String msg= (String) request.getAttribute("msg"); 

if(msg!=null){
	out.print(msg);
}

%>

<form action="user" method="post">

<table>

    <thead>
                UserForm
         
    </thead>
    <br>
       
    <tbody>
                  <input name="name" placeholder="UserName" type="text" >
                           <br>
                  <input name="email" placeholder="Email" type="email" >
                           <br>
         
                  <input name="phone" placeholder="Phone" type="text" >
                           <br>
         
                  <input name="state" placeholder="State" type="text" >
                           <br>
         
                  <input name="city" placeholder="City" type="text" >
    </tbody>
    <br>
    <tfoot>
                   <input type="submit" >
                   <br>
                   <a href="user">View Records</a>
    </tfoot>


</table>





</form>

</body>
</html>