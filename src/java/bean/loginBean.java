/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;
import java.sql.*;
import java.util.*;




/**
 *
 * @author aarsh
 */
public class loginBean {
    
    
    private String username,password;
    private int userid,usertypeid;
        
        public void setUserName(String uname)
        {
        username=uname;
        }
        public void setPassword(String pass)
        {
        password=pass;
        }
        public void setUserId(int uid)
        {
            userid=uid;
        }
        public void setUserTypeId(int utid)
        {
            usertypeid=utid;
        }
        
        public String getUserName()
        {   
        return username;
        }
        public String getPassword()
        {
        return password;
        }
        public int getUserId()
        {
            return userid;
        }
        public int getUserTypeId()
        {
            return usertypeid;
        }
    public int loginUser(Connection con) throws Exception
    {
        
        
        PreparedStatement pstmt=null;
        
        String query="Select * from user where username=? and password=? ";
        pstmt=con.prepareStatement(query);
        pstmt.setString(1,username);
        pstmt.setString(2,password);
        
        ResultSet rs=pstmt.executeQuery();
        
        if(rs.next())
        {
            //System.out.println("successful");
            setUserId(Integer.parseInt(rs.getString("userid")));
            setUserName(rs.getString("username"));
            setUserTypeId(Integer.parseInt(rs.getString("usertypeid")));
            return 1;
        }
        else
        {
                //System.out.println("not successful");
            return 0;
        }
    }

    
}
