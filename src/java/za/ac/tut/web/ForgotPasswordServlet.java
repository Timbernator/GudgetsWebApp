/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.model.business.PersonFacadeLocal;
import za.ac.tut.model.business.Utility;

/**
 *
 * @author LAB0033BPC03
 */
public class ForgotPasswordServlet extends HttpServlet {
    @EJB
    private PersonFacadeLocal personFacade;

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
        Long id = Long.parseLong(request.getParameter("id"));
        HttpSession session =request.getSession();
        
       // String url = Utility.getPerson(session,id,personFacade);
        
        //RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        //dispatcher.forward(request, response);
                
    }


}
