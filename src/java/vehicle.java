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
import bean.registrationBean;
import bean.vehicleBean;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author aarsh
 */
public class vehicle extends HttpServlet {

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
         Connection con=null;
         RequestDispatcher rd= null;
        try
        {
            String permitno=Function.checkRequestNull(request,"permitno");
            String vtype=Function.checkRequestNull(request, "vehicletype");
            String vno=Function.checkRequestNull(request, "vehicleno");
            String servicep=Function.checkRequestNull(request, "serviceprovider");
            
            con=Function.getConnection();
            
            vehicleBean vb=new vehicleBean();
            vb.serviceProvider(servicep);
            vb.setVehicleNo(Integer.parseInt(vno));
            vb.setPermitNo(Integer.parseInt(permitno));
            vb.setVehicleType(vtype);
            vb.vehicle(con);
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
