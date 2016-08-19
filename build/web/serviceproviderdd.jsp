<%-- 
    Document   : projectajaxdb
    Created on : Feb 23, 2016, 8:59:56 AM
    Author     : aarsh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*" import="java.util.ArrayList"%>
<!DOCTYPE html>
<%
    Connection con=null;
    Statement stmt=null;
    
    try  
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/Project";
            con=DriverManager.getConnection(url,"root","root");
            stmt=con.createStatement();
         
            String query="Select * from user where usertypeid=3";
            
            ResultSet rs=stmt.executeQuery( query);
            
            ArrayList al=new ArrayList();
            
            while(rs.next())
            {
                al.add(rs.getString("userid")+":"+rs.getString("username"));
            }
            out.println(al);
        }
        catch (Exception e)
        {
            out.println(e);
        }
%>