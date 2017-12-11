<%-- 
    Document   : View_Products
    Created on : 16 May 2017, 3:35:12 PM
    Author     : LAB0033BPC35
--%>

<%@page import="za.ac.tut.model.entity.Login"%>
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
        <title>Products Page</title>
        <meta name="viewport" content="width=device-width initial-scale=1">
        <link rel="stylesheet" type="text/css" href="Style.css">
    </head>
    <body>

   
            <%
               
                List<Product> products = (List<Product>)session.getAttribute("products");
                Login login = (Login)session.getAttribute("login");
                Cart cart = (Cart)session.getAttribute("cart");
            %>  
                <div id="header">
                    <div id="cart">
                        <p>
                                Cart  Total R: <%
                                if(cart != null){
                                    %>
                                    <%=cart.getTotal()%> : <%=cart.count()%>Items
                                    <%
                                }
                                else
                                {
                                    %>0.00<%
                                }

                                %> 
                            </p>
                    </div>
                    <ul id="navBar">

                        <li>
                            <div>User:<%=login.getUsername()%></div>
                        </li>
                        <li><a href="InvalidateServlet.do">Log Out</a>
                    </ul>
                </div>
                <br>
                <br>
                <br>
                <br>
                <div>
                    <form action="ViewCartServlet.do" method="POST">
                        <input type="submit" value="View cart"/>
                    </form>
                </div>
                        
                <%
                
                for(int x =0;x<products.size();x++)
                { 
                    
                    String code = products.get(x).getCode();
                    String productName = products.get(x).getName();
                    String image = products.get(x).getImage();
                    double price = products.get(x).getPrice();
                    String description = products.get(x).getDescription();
                
             %>
            <form action="AddToCartServlet.do" method="Post"> 
                <table>
                   <tr>
                     <td>
                         <div class="container" >
                             <section id="product_id" >
                               <h1><%=productName%></h1><br>
                                <img src="<%=image%>" width="80" height="80"><br>
                                <input type="text" name="decription" value="<%=description%>" hidden/>
                                <h2>R<%=price%></h2><br>
                                <input type="number" name="<%=code%>" value="1"> 
                                <button type="submit" name="productId" value="<%=code%>" >Add To Cart</button>                          

                             </section>
                         </div> 

                     </td> 
                 </tr>
            </table>
            </form>     
                    <%
                        }
                    %> 


    </body>
</html>
