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
import Logic.Function;
import java.sql.*;
import bean.registrationBean;
import bean.loginBean;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aarsh
 */
public class login extends HttpServlet {

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
            String uname=Function.checkRequestNull(request,"username");
            String password=Function.checkRequestNull(request,"password");
            
            HttpSession s1=request.getSession(true);
            
            
            con=Function.getConnection();
            
            loginBean lb=new loginBean();
            lb.setUserName(uname);
            lb.setPassword(password);
            
            int a=lb.loginUser(con);
            //rb.loginUser(con);    
            if(a==1)
            {
                out.println(lb.getUserId());
                s1.setAttribute("uid",lb.getUserId());
                s1.setAttribute("uname",lb.getUserName());
                s1.setAttribute("utype",lb.getUserTypeId());
                
                rd=request.getRequestDispatcher("adminhome.jsp");
            }
            else
            {
                rd=request.getRequestDispatcher("logincss.jsp?error=not valid");
            }
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
