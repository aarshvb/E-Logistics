/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.*;

/**
 *
 * @author aarsh
 */
public class woitemBean extends workorderBean
{
    String itemname,unit;
        int woid,woitemid,qantity;
    
    public void setItemName(String in)
    {
        itemname=in;
    }
    public void setUnit(String unt)
    {
        unit=unt;
    }
   
    public void setWoId(int wid)
    {
        woid=wid;
    }
    public void setWoItemId(int wid)
    {
        woitemid=wid;
    }
    public void setQuantity(int qty)
    {
        qantity=qty;
    }
    
    ///////////////////////
    public String getItemName()
    {
        return itemname;
    }
    
    public String getUnit()
    {
        return unit;
    }
    public int getWoId()
    {
        return woid;
    }
    public int getWoItemId()
    {
        return woitemid;
    }
    public int  getQuantity()
    {
        return qantity;
    }
    
    
    public void insertWorkItem(Connection con) throws Exception
    {
        //java.util.Date dt=new java.util.Date();
        PreparedStatement pstmt=null;
        
        String query="insert into woitem (woid,itemname,qty,unit)values(?,?,?,?)";
        pstmt=con.prepareStatement(query);
        pstmt.setInt(1,woid);
        pstmt.setString(2,itemname);
        pstmt.setInt(3,qantity);
        pstmt.setString(4,unit);
       
        
        
        pstmt.executeUpdate();
    
    }
    
    
   public ArrayList editWorkOrder(Connection con) throws Exception
   {
       PreparedStatement pstmt=null;
       
       String query="Select * from woitem where woid=?";
       
       pstmt=con.prepareStatement(query);
       pstmt.setInt(1, woid);
       ResultSet rs=pstmt.executeQuery();
       
       ArrayList al=new ArrayList();
       System.out.println("before");
       while(rs.next())
       {
           
           woitemBean woarr=new woitemBean();
               
           woarr.setItemName(rs.getString("itemname"));
               
           woarr.setWoItemId(Integer.parseInt(rs.getString("woitemid")));
               
           woarr.setQuantity(Integer.parseInt(rs.getString("qty")));
               
           woarr.setUnit(rs.getString("unit"));
               
           al.add(woarr);
       }
           System.out.println("after1");
       return al;
   }
   
   public void updateWorkOrder(Connection con) throws Exception
   {
       String query="update woitem set itemname=?, qty=?, unit=? where woitemid=?";
       PreparedStatement pstmt=con.prepareStatement(query);
       
         pstmt.setString(1,itemname);
        //pstmt.setString(2,itemname);
        pstmt.setInt(2,qantity);
        pstmt.setString(3,unit);
        pstmt.setInt(4,woitemid);
        pstmt.executeUpdate();
   }
           
}
