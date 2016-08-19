/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.sql.*;
import Logic.Function;
import bean.registrationBean;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author aarsh
 */
public class registration extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher rd = null;
        Connection con= null;
        //RequestDispatcher rd = null;
        try
        {
         String uname= Function.checkRequestNull(request,"username");
         String password= Function.checkRequestNull(request,"password");
         String address= Function.checkRequestNull(request,"address");
         String city= Function.checkRequestNull(request,"city");
         String state= Function.checkRequestNull(request,"state");
         String country= Function.checkRequestNull(request,"country");
         String gender= Function.checkRequestNull(request,"gender");
         String firstname= Function.checkRequestNull(request,"firstname");
         String email= Function.checkRequestNull(request,"email");
         String lastname= Function.checkRequestNull(request,"lastname");
         String contact= Function.checkRequestNull(request,"contact");
         String date=Function.checkRequestNull(request,"dob");
         String utype=Function.checkRequestNull(request,"usertypeid");
         con=Function.getConnection();
         
         registrationBean rb=new registrationBean();
         rb.setUserName(uname);
         rb.setPassword(password);
         rb.setAddress(address);
         rb.setCity(city);
         rb.setCountry(country);
         rb.setState(state);
         rb.setGender(gender);
         rb.setFirstName(firstname);
         rb.setLastName(lastname);
         rb.setEmail(email);
         rb.setContact(Integer.parseInt(contact));
         rb.setDate(date);
         rb.setUserType(utype);
         //out.println("before");
         rb.insertUser(con);
         //out.println("after");
         rd=request.getRequestDispatcher("registrationsuccessful.jsp");
         rd.forward(request, response);
         
           
        }
        catch(Exception e)
        {
            out.println(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
