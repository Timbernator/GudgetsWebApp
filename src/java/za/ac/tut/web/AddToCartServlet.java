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
import za.ac.tut.model.business.ProductFacadeLocal;
import za.ac.tut.model.business.Utility;
import static za.ac.tut.model.business.Utility.products;
import za.ac.tut.model.entity.Cart;
import za.ac.tut.model.entity.Product;


/**
 *
 * @author LAB0033APC10
 */
public class AddToCartServlet extends HttpServlet {
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @EJB
    private ProductFacadeLocal productFacade;

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
         
                
        try
        {   
            Cart cart = (Cart)session.getAttribute("cart");
            if(cart==null)
            {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
            
            String code = request.getParameter("productId");
            
            int quantity = Integer.parseInt(request.getParameter(code));
            
            //Utility.pushToCart(code,quantity,session,productFacade,request); 
            products = productFacade.findAll();
            cart =(Cart) session.getAttribute("cart");
            //
            for(Product product : products)
            {
                if(product.getCode().equalsIgnoreCase(code))
                {
                    cart.updateProduct(product, quantity);
                }
            }
            session.setAttribute("cart", cart);
            request.setAttribute("session", session);

            RequestDispatcher disp = request.getRequestDispatcher("ViewProducts.jsp");
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
