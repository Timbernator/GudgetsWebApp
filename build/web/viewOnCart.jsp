<%-- 
    Document   : viewCart
    Created on : 18 May 2017, 2:22:16 PM
    Author     : LAB0033APC10
--%>

<%@page import="za.ac.tut.model.entity.Login"%>
<%@page import="java.util.Vector"%>
<%@page import="za.ac.tut.model.entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.model.entity.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Item(s) on Cart</title>
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
                        <li><a href="Invalidate.do">Log Out</a>
                    </ul>
                </div>
                <br>
        <div class="container" >
            <section id="content_confirm_cart" >
            <%

                if(cart!=null && cart.getProducts().size()!=0)
                {    
                     products = cart.getProducts();

                 %>  

                 <form action="RemoveFromCartServlet.do" method="Post">

                 <%
                    for(int x = 0 ;x< products.size();x++)
                    {

                        String code = products.get(x).getCode();
                        String name = products.get(x).getName();
                        String image =products.get(x).getImage();
                        double price = products.get(x).getPrice();


                        %>
                        <table>
                            <tr>
                                <td><%=name%></td>
                                <td><img src="<%=image%>" width="100" height="100"></td>
                                <td>R<%=price%></td>
                                <td>
                                    <button type="submit" value="<%=code%>" name="productId">Remove</button>
                                    
                                </td>
                            </tr>
                            <%
                                }
                            %>
                        </table>
                 </form>
                 <br>
                 <form action="ShoppingServlet.do" method="Get">
                     <input type="submit" value="Add More">
                 </form>
                 
                 <br>
                 <hr >
                        <h1>Enter Payment details</h1>
                 <hr >
                 <form action="OrderConfirmation.do" method="Post">
                    <div class="wrapper">
                        <input type="text" name="bankAcc" placeholder="Account Number"/>
                   </div>
                   <select  name="bankname">
                       <option value="capitec">CAPITEC BANK</option>
                       <option value="standard">STANDARD BANK</option>
                       <option value="nedbank">NEDBANK</option>
                       <option value="fnb">FNB</option>
                       <option value="absa">ABSA</option>
                   </select>
                    <div class="wrapper">
                        <input type="text" name="branch" placeholder="branchCode">
                    </div>
                    <br>

                     <input type="submit" value="checkout">
                 </form>
                <%
                }
                else
                {
                %>
                    <h1>There is nothing on the cart</h1>
                    <a href="ViewProducts.jsp">Click here to shop</a>
                <%
                }
            %>  
            </section>
        </div>
    </body>
</html>
