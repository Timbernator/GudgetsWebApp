<%-- 
    Document   : added_Person
    Created on : 11 May 2017, 6:42:51 PM
    Author     : LAB0040PC057
--%>

<%@page import="za.ac.tut.model.entity.Login"%>
<%@page import="za.ac.tut.model.entity.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome New Client</title>
        <link rel="stylesheet" type="text/css" href="Style.css">
    </head>
    <body>
        <%
            Person person = (Person)session.getAttribute("person");
            String title = person.getTitle();
            
            Login login = person.getLogin();
            String username = login.getUsername();
            String password = login.getPassword();
        %>
        <div class="container" >
             <section id="content_wrong_id" >
                 <h1>Welcome <%=username%></h1>
                 <h2><%=title%> you are Registered on Ray&Tee online Store</h2>
        
                Please Use the following to log in
                
                <br>
                <table>
                    <tr>
                        <td>Username:</td>
                        <td> <%=username%> </td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td> <%=password%> </td>
                    </tr>
                </table>
                    <br>
        
           
               <a href="index.html" style="float: right"> Login</a>
          
            </section>
        </div>
    </body>
</html>
