/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.*;


/**
 *
 * @author aarsh
 */
public class vehicleBean {

private int vehicleno;
private int permitno;
private String vehicletype;
private String serviceprovider;

public void setPermitNo(int perno)
{
    permitno=perno;
}
public void setVehicleType(String vehitype)
{
    vehicletype=vehitype;
}
public void setVehicleNo(int vehino)
{
    vehicleno=vehino;
}
public void serviceProvider(String servicepro)
{
    serviceprovider=servicepro;
}


public int getPermitNo()
{
    return permitno;
}
public String getVehicleType()
{
    return vehicletype;
}
public int getVehicleNo()
{
    return vehicleno;
}
public String getServiceProvider()
{
    return serviceprovider;
}
    
 public void vehicle(Connection con) throws Exception
    {
        PreparedStatement pstmt=null;
        
        String query="insert into vehicle(vehicleno,permitno,vehicletype,serviceprovider) value(?,?,?,?)";
        pstmt=con.prepareStatement(query);
        pstmt.setInt(1, vehicleno);
        pstmt.setInt(2,permitno);
        pstmt.setString(3, vehicletype);
        pstmt.setString(4,serviceprovider);
        
        pstmt.executeUpdate();
        
    }
    
}
