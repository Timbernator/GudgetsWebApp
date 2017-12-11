<%-- 
    Document   : forgotPassword
    Created on : 17 May 2017, 2:52:57 PM
    Author     : LAB0033BPC14
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password</title>
         <link rel="stylesheet" type="text/css" href="Style.css">
    </head>
    <body>
        <div class="container" >
            <section id="content_forgot_password" >
                <h1>Forgot Password</h1>
                <h2>To Recover Password Answer the Security Question:</h2>
                <table style="alignment-adjust: central">
                    <form action="ForgotPasswordServlet.do" method="Post">
                        <tr>
                            <td>
                                <div class="wrapper" > 
                                    <i class="fa fa-user" ></i>
                                    <input type="text" placeholder="Identity Number" name="id" required/>
                                </div>
                            </td>
                            <td>
                                <div>
                                        <input type="submit" value="Verify" />
                                </div>
                            </td>
                        </tr>
                    </form>
                </table>
            </section>
        </div>
        
    </body>
</html>
