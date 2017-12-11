<%-- 
    Document   : OderConfirmed
    Created on : May 23, 2017, 1:39:51 AM
    Author     : PANGELA
--%>

<%@page import="za.ac.tut.model.entity.Account"%>
<%@page import="za.ac.tut.model.entity.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payement</title>
        <link rel="stylesheet" type="text/css" href="Style.css">
    </head>
    <body>
        <%
            Cart cart = (Cart)session.getAttribute("cart");
            Account account = (Account)session.getAttribute("account");
            String accounNo = account.getAccNum();
        %>
        <div class="container" >
            <section id="content_wrong_id" >
                <h1>Payment Approved</h1>
                <h2>
                    The Amount R<%=cart.getTotal()%> was successfully deducted from Your Account 
                    Thanks You choosing our Online Store
                </h2><br>
                <a href="InvalidateServlet.do" style="float: right">Done</a>
                
            </section>
    </body>
</html>
