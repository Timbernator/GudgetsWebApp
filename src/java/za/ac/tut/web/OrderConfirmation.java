/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.model.business.AccountFacadeLocal;
import za.ac.tut.model.business.Utility;
import za.ac.tut.model.entity.Cart;

/**
 *
 * @author PANGELA
 */
public class OrderConfirmation extends HttpServlet {

    
    @EJB
    private AccountFacadeLocal accountFacade;
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
        HttpSession session = request.getSession();
        
        try
        {   
            Cart cart = (Cart)session.getAttribute("cart");
            String accountNumber =request.getParameter("bankAcc");
            String bankName =request.getParameter("bankname");
            String branchCode =request.getParameter("branch");
            double amount = cart.getTotal();
           //Account account = new Account(bankName, branchCode, accNum, balance)
            Utility.addAccounts(accountFacade);

            String url = Utility.verifyBank(accountNumber, bankName, branchCode, amount, session, accountFacade);
            session.setAttribute("cart", cart);
            request.setAttribute("session", session);

            RequestDispatcher disp = request.getRequestDispatcher(url);
            disp.forward(request, response);
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
