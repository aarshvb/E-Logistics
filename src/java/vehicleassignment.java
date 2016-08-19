/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Logic.Function;
import bean.vehicleassignmentbean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;


/**
 *
 * @author aarsh
 */
public class vehicleassignment extends HttpServlet {

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
        Connection con= null;
        RequestDispatcher rd= null;
        try
        {
         String woid = Function.checkRequestNull(request, "workorder");
         con = Function.getConnection();
         vehicleassignmentbean vb = new vehicleassignmentbean();
         
         Enumeration e= request.getParameterNames();
           ArrayList a1=new ArrayList();
           while(e.hasMoreElements())
           {
               
               a1.add(e.nextElement());
           }
           out.println("11111");
           
           
           for(int i=0;i<a1.size();i++)
           {
               String val=a1.get(i).toString();
               out.println("22222");
               if(val.contains("chk"))
               {
                   out.println("33333");
                   String ind=val.substring("chk".length());
                   String itemname=request.getParameter(val);
                   String unit=request.getParameter("unit"+ind);
                   String qty=request.getParameter("qty"+ind);
                   
                   
                   out.println("ietmname:"+itemname);
                   out.println("unit:"+unit);
                   out.println("qty:"+qty);
                   
                   
                   
                   vb.setWoItemId(Integer.parseInt(itemname));
                   vb.setWoId(Integer.parseInt(woid));
                   vb.setVehicleId(unit);
                   vb.setQty(Integer.parseInt(qty));
                   vb.vehicleassignment(con);
                   rd=request.getRequestDispatcher("registrationsuccessful.jsp");
                   rd.forward(request, response);
               }
           }
            
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
