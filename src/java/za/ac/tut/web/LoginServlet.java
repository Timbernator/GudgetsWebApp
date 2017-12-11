/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.tut.web;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.model.business.LoginFacadeLocal;
import za.ac.tut.model.business.PersonFacadeLocal;
import za.ac.tut.model.business.ProductFacadeLocal;
import za.ac.tut.model.business.Utility;
import za.ac.tut.model.entity.Login;
import za.ac.tut.model.entity.Person;
import za.ac.tut.model.entity.Product;

/**
 *
 * @author LAB0040PC057
 */
public class LoginServlet extends HttpServlet {
    @EJB
    private ProductFacadeLocal productFacade;
    @EJB
    private LoginFacadeLocal loginFacade;
    
    


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
        
        HttpSession session = request.getSession(true);
        try
        {
            String username = request.getParameter("Username");
            String password = request.getParameter("Password");
        
            Utility.addToDatabase(productFacade);

            String url = Utility.verifyLogin(username,password,session, loginFacade,productFacade);

            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
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
