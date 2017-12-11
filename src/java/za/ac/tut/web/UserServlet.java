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
import za.ac.tut.model.business.PersonFacadeLocal;
import za.ac.tut.model.entity.Address;
import za.ac.tut.model.entity.Login;
import za.ac.tut.model.entity.Person;

/**
 *
 * @author LAB0007PC45
 */
public class UserServlet extends HttpServlet {
    @EJB
    private PersonFacadeLocal personFacade;
    HttpSession session;

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
            String name = request.getParameter("txtFname");
            String surname = request.getParameter("txtSurname");
            String gender = request.getParameter("txtGender");
            String title = request.getParameter("txtTitle");
            String dob = request.getParameter("txtdate");
            Long id = Long.parseLong(request.getParameter("txtID"));
            String email = request.getParameter("txtEmail");
            String cellNo = request.getParameter("txtTel");
            String streetAddress = request.getParameter("txtAddress1");
            String town = request.getParameter("txtCity");
            String postalCode = request.getParameter("txtPostCode");
            String country = request.getParameter("txtCountry");
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String secQuestion = request.getParameter("securityQuestion");
            String Answer = request.getParameter("securityAnswer");  
            HttpSession session = request.getSession();
            Person person = new Person(id, name, surname, gender, title, dob, cellNo, email,new Login(username, password, secQuestion, Answer), new Address(streetAddress, town, postalCode, country) );

            personFacade.create(person);
            session.setAttribute("person", person);

            RequestDispatcher disp = request.getRequestDispatcher("/added_Person.jsp");
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
