/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;
import java.sql.*;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author aarsh
 */
public class Function 
{
    public static Connection getConnection() throws Exception
    {
        Connection con=null;
        
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/Project";
        con=DriverManager.getConnection(url,"root","root");
        return con;
    }
    
    public static String checkRequestNull(HttpServletRequest request, String str)
    {
        String val="";
        if(request.getParameter(str)!=null)
        {
            val=request.getParameter(str).toString().trim();
        }
        return val; 
    }
    
}
