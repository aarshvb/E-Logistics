/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Logic.Function;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import bean.woitemBean;
import javax.servlet.http.HttpSession;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import bean.workorderBean;
/**
 *
 * @author aarsh
 */
public class woservlet extends HttpServlet {

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
        RequestDispatcher rd = null;
        
        try  
        {
            
            
        HttpSession s1=request.getSession(false);
        String uid= s1.getAttribute("uid").toString();
            
        String userid=Function.checkRequestNull(request,"usertypeid");
        String location=Function.checkRequestNull(request,"location");
        String hidden=request.getParameter("key");
        
        //String check=Function.checkRequestNull(request, "check");
        //String item=Function.checkRequestNull(request,"item");
        //String quantity=Function.checkRequestNull(request, "qty");
        //String unit=Function.checkRequestNull(request, "unit");
        
        
        con=Function.getConnection();
        
        java.util.Date dt=new java.util.Date();
         
        
        workorderBean wb =new workorderBean();
        
        wb.setDispatchDate(dt.toString());
        wb.setUserId(Integer.parseInt(userid));
        wb.setGeneratedBy(Integer.parseInt(uid));
        wb.setWoDate(dt.toString());
        wb.setLocationId(Integer.parseInt(location));
        wb.setWoKey(hidden);
        wb.setStatus("open");
        
        
        
        
        
        
         //wib.setItemName(item);
         //wib.setQuantity(Integer.parseInt(quantity));
         //wib.setUnit(unit);
       
         
         wb.insertUser(con);
         
         woitemBean wib =new woitemBean();
         
         
         
         //Connection con=null;
           String wono=wb.workorderid(con);
           
           Enumeration e= request.getParameterNames();
           ArrayList a1=new ArrayList();
           while(e.hasMoreElements())
           {
               a1.add(e.nextElement());
           }
           
           
           for(int i=0;i<a1.size();i++)
           {
               String val=a1.get(i).toString();
               
               if(val.contains("chk"))
               {
                   String ind=val.substring("chk".length());
                   String itemname=request.getParameter("item"+ind);
                   String unit=request.getParameter("unit"+ind);
                   String qty=request.getParameter("qty"+ind);
                   
                   wib.setItemName(itemname);
                   wib.setQuantity(Integer.parseInt(qty));
                   wib.setWoId(Integer.parseInt(wono));
                   wib.setUnit(unit);
                   wib.insertWorkItem(con);
               }
           }
           

           
         
         //wib.setWoId(0);
         //wb.setDispatchDate();
         out.println("testing");
         rd=request.getRequestDispatcher("workordergrid.jsp");
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
