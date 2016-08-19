<%-- 
    Document   : projectajaxdb
    Created on : Feb 23, 2016, 8:59:56 AM
    Author     : aarsh
--%>

<%@page import="Logic.Function"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*" import="java.util.ArrayList"%>
<!DOCTYPE html>
<%
    Connection con=null;
    Statement stmt=null;
    
    
    try  
        {
            String workorder = Function.checkRequestNull(request,"workorder");
            String sp = Function.checkRequestNull(request, "sp");
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/Project";
            con=DriverManager.getConnection(url,"root","root");
            stmt=con.createStatement();
         
            String query="Select * from woitem where woid='"+workorder+"'";
            
            ResultSet rs=stmt.executeQuery( query);
            
            ArrayList al=new ArrayList();
            
            while(rs.next())
            {
                al.add(rs.getString("woitemid")+":"+rs.getString("itemname")+":"+rs.getString("qty")+":"+rs.getString("unit"));
            }
            
            
            query="Select * from vehicle where serviceprovider='"+sp+"'";
            
            rs=stmt.executeQuery(query);
            
            ArrayList a1=new ArrayList();
            
            while(rs.next())
            {
                a1.add(rs.getString("vehicletype"));
            }
            out.println(al+"$"+a1);
        }
        catch (Exception e)
        {
            out.println(e);
        }
%>