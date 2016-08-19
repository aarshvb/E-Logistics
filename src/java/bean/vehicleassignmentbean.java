/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author aarsh
 */
public class vehicleassignmentbean {
    
    private int woitemid,woid,qty;
    private String vehicleid;
    
    public void setWoItemId(int woii)
    {
        woitemid=woii;
    }
    public void setWoId(int woi)
    {
        woid=woi;
    }
    public void setVehicleId(String vi)
    {
        vehicleid=vi;
    }
    public void setQty(int qt)
    {
        qty=qt;
    }
    
    public int getWoItemId()
    {
        return woitemid;
    }
    public int getWoId()
    {
        return woid;
    }
    public String getVehicleId()
    {
        return vehicleid;
    }
    public int getQty()
    {
        return qty;
    }
    
    public void vehicleassignment(Connection con) throws Exception
    {
        PreparedStatement pstmt=null;
        
        String query="insert into vehicleassignment(woitemid,woid,vehicleid,qty) value(?,?,?,?)";
        pstmt=con.prepareStatement(query);
        pstmt.setInt(1, woitemid);
        pstmt.setInt(2,woid);
        pstmt.setString(3, vehicleid);
        pstmt.setInt(4,qty);
        
        pstmt.executeUpdate();
        
    }
    
}

