<%-- 
    Document   : viewcart
    Created on : Nov 8, 2016, 7:53:06 PM
    Author     : user
--%>

<%@page import="za.ac.tut.model.entities.CD"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.model.entities.DVD"%>
<%@page import="za.ac.tut.model.entities.ShoppingCart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart</title>
    </head>
    <body>
        <h1>View Cart</h1>
        <hr size="3">
        <%
            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
            
            if(cart != null && cart.getDVD().size() != 0 )
            {
                List<DVD> dvds = cart.getDVD();
                
            %>
                <h1>List Of DVD's you ordered</h1>
                <form action="RemoveCartServlet.do" method="POST">
                <table>
                    <tr>
                        <th>Title</th>
                        <th>Price</th>
                        <th>Remove</th>
                    </tr>
                    <%
                        for(DVD dvd: dvds)
                        {
                    %>
                    <tr>
                       
                        <th><%=dvd.getTitle()%></th>
                        <th><%=dvd.getPrice()%></th>
                        <th><button type="submit" value="<%=dvd.getCode()%>" name="dvdid">Remove</button></th>
                    </tr>
                    <%
                        }  
                    %>
                   <tr>
                        <label>Total for DVD's R <%= cart.getDVDTotal() %></label>
                   </tr>
                </table>
                </form>
                    
                
                <hr >
                    <h1>enter Payment details</h1>
                <hr >
                <a href="cart.jsp"><input type="button" value="Continue Shopping"></a>
                <form action="OrderConfirmation.do" method="GET">
                    <input type="submit" value="checkout">
                </form>
            <%
            }
            else
            {
            %>
                <h1>There is nothing on the cart</h1>
                <a href="cart.jsp">Click here to shop</a>
            <%
            }
        %>
    </body>
</html>
