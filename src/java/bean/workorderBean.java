/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author aarsh
 */
public class workorderBean {
    String wodate,wostatus,dispatchdate,wokey;
    int woid,locationid,generatedby,userid,flag;
    
    public void setWoDate(String wd)
    {
        wodate=wd;
    }
    public void setStatus(String sts)
    {
        wostatus=sts;
    }
    public void setDispatchDate(String dd)
    {
        dispatchdate=dd;
    }
    public void setWoId(int wid)
    {
        woid=wid;
    }
    public void setLocationId(int lid)
    {
        locationid=lid;
    }
    public void setWoKey(String wkey)
    {
        wokey=wkey;
    }
    public void setGeneratedBy(int gby)
    {
        generatedby=gby;
    }
    public void setUserId(int uid)
    {
        userid=uid;
    }
    public void setFlag(int flg)
    {
        flag=flg;
    }
    ///////////////////////
    public String getWoDate()
    {
        return wodate;
    }
    public String getStatus()
    {
        return wostatus;
    }
    public String getDispatchDate()
    {
        return dispatchdate;
    }
    public int getWoId()
    {
        return woid;
    }
    public int getLocationId()
    {
        return locationid;
    }
    public String getWoKey()
    {
        return wokey;
    }
    public int getGeneratedBy()
    {
        return generatedby;
    }
    public int getUserId()
    {
        return userid;
    }
    public int getFlag()
    {
        return flag;
    }
    
    public void insertUser(Connection con) throws Exception
    {
        //java.util.Date dt=new java.util.Date();
        PreparedStatement pstmt=null;
        
        String query="insert into workorder(locationid,wodate,dispatchdate,wokey,wostatus,generatedby,userid) value(?,?,?,?,?,?,?)";
        pstmt=con.prepareStatement(query);
        pstmt.setInt(1,locationid);
        pstmt.setString(2,wodate);
        pstmt.setString(3,dispatchdate);
        pstmt.setString(4,wokey);
        pstmt.setString(5,wostatus);
        pstmt.setInt(6,generatedby);
        pstmt.setInt(7,userid);
        
        
        
        pstmt.executeUpdate();
        
        
    }
    public String workorderid(Connection con)throws Exception
    {
        String q1="select max(woid) id from workorder"; 
           PreparedStatement pstmt1=con.prepareStatement(q1);
           ResultSet rs=pstmt1.executeQuery();
           String wono="0";
           if(rs.next())
           {
               wono=rs.getString("id");
           }
           return wono;
    }
    
    public String workorderkey(Connection con) throws Exception
    {
        String q1="select max(woid) id from workorder"; 
           PreparedStatement pstmt1=con.prepareStatement(q1);
           ResultSet rs=pstmt1.executeQuery();
           String wono="0";
           String key;
           if(rs.next())
           {
               wono=rs.getString("id");
               if(wono==null)
               {
                   wono="0";
               }
           
           }
           
           return "wo-"+(Integer.parseInt(wono)+1);
    }
    
    public ArrayList getWorkOrder(Connection con) throws Exception
    {
        
        String query="Select * from workorder";
        PreparedStatement pstmt=con.prepareStatement(query);
        ResultSet rs =pstmt.executeQuery();
        
        ArrayList a1= new ArrayList();
        while(rs.next())
        {
            workorderBean wob= new workorderBean();
            wob.setWoKey(rs.getString("wokey"));
            wob.setWoId(rs.getInt("woid"));
            wob.setLocationId(rs.getInt("locationid"));
            wob.setStatus(rs.getString("wostatus"));
            wob.setUserId(rs.getInt("userid"));
            wob.setFlag(rs.getInt("flag"));
            
            a1.add(wob);
            
            
            
            
            
        }
        return a1;
        
    }
}
