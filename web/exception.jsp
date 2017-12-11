<%-- 
    Document   : exception
    Created on : Apr 23, 2017, 4:22:31 AM
    Author     : Tiisetso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Error Page</title>
    </head>
    <body>
        <h1>Error!</h1>
        <%
            
            String error = (String) session.getAttribute("error");
            
            if(error != null)
            {
                %>
                <h1> <%=error %> </h1>
        <%
            }
        %>
    </body>
</html>
