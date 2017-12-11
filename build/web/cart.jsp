<%-- 
    Document   : cart
    Created on : 07 Nov 2016, 7:41:27 PM
    Author     : Programming
--%>

<%@page import="za.ac.tut.model.entity.Item"%>
<%@page import="za.ac.tut.model.business.Utility"%>
<%@page import="za.ac.tut.model.entity.Cart"%>
<%@page import="za.ac.tut.model.entity.Person"%>
<%@page import="java.util.Vector"%>
<%@page import="za.ac.tut.model.entity.Product"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Catalogue </title>
    </head>
    <body>
        <h1> View Catalogue </h1>
        <br>
        <h1>Available and Product's</h1>
            <%
               
                List<Product> products = (List<Product>)session.getAttribute("products");
                //Person person = (Person)session.getAttribute("person");
                
            %>   
    
    <div>
        <p>Cart : Total R<% Cart cart = (Cart) session.getAttribute("cart"); 
        if(cart != null){
            %>
            <%=cart.getTotal() %> : <%=cart.count() %> Items
            <%
        }
        else
        {
            %>0.00<%
        }
            
        %> </p>
    </div>
    
    
     <form action="AddToCartServlet.do" method="post">
            
        <table cellspacing="5" cellpadding="5" border="1">
            <caption> Product's </caption>
            <tr>
                 
                  <th >Code</th>
                <th >Name</th>
                <th >Quantity</th>
                <th >Select</th>
            </tr>

            <%
                Item item = new Item();
                for(int x =0;x<products.size();x++)
                { 
                    
                    String code = products.get(x).getCode();
                    String productName = products.get(x).getName();
                    String image = products.get(x).getImage();
                    double price = products.get(x).getPrice();
                    String description = products.get(x).getDescription();
                
             %>
            <tr>
                
                <td><%=code %></td>
                <td><%=productName%></td>
                <td><%=price%></td>
                <td><input type="number" name="<%=code%>" value="1"></td>
                <td><button type='submit' name="productId" value="<%=code%>">Add to Cart</button></td>
            </tr>
        <%
           }  
        %>   
        </table>
        
    </form> 
        <br>
        <br>
        <br>
        <form action="ViewCartServlet.do" method="POST">
         <input type="submit" value="View cart">
        </form> 
        <br>
        <br>
    </body>
</html>

