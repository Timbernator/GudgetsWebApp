/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.model.entity.Cart;

/**
 *
 * @author Tiisetso
 */
public class ViewCartServlet extends HttpServlet {

        HttpSession session;
        RequestDispatcher  dispatcher;
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try
        {
            session = request.getSession();
            
            Cart cart = (Cart) session.getAttribute("cart");
           
            session.setAttribute("cart", cart);
            request.setAttribute("session", session);
            dispatcher = request.getRequestDispatcher("viewOnCart.jsp");
            dispatcher.forward(request, response);
            
        }
        catch(Exception ex)
        {
            String error = "Error :" + ex.getMessage() +" : Class" + ex.getClass();
            session.setAttribute("error", error);
            request.setAttribute("session", error);
            RequestDispatcher d = request.getRequestDispatcher("exception.jsp");
            d.forward(request, response);
            
        }
    }


}
