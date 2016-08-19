/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import Logic.Function;
import bean.locationBean;
import bean.registrationBean;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.util.*;


/**
 *
 * @author aarsh
 */
public class location extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher rd= null;
        Connection con = null;
        try 
        {
            
            HttpSession s1=request.getSession(false);
            String uid= s1.getAttribute("uid").toString();
            
            out.println("aaaa");
            out.println(uid);
            String address=Function.checkRequestNull(request,"address");
            String city=Function.checkRequestNull(request,"city");
            String state=Function.checkRequestNull(request, "state");
            String zipcode=Function.checkRequestNull(request, "zip");
            String contactp=Function.checkRequestNull(request, "contactperson");
            String contactno=Function.checkRequestNull(request, "contactno");
            
            con=Function.getConnection();
            
            locationBean lob=new locationBean();
            lob.setAddress(address);
            lob.setCity(city);
            lob.setContact(Integer.parseInt(contactno));
            lob.setState(state);             
            lob.setZipCode(Integer.parseInt(zipcode));
            lob.setContactPerson(contactp);
            lob.setUserId(Integer.parseInt(uid));
            lob.location(con);
            
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
