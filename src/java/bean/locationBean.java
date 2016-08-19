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
public class locationBean {
    
    private String address,city,state,contactperson;
    private int zipcode,contact,userid;
    
    public void setAddress(String addr)
    {
        address=addr;
    }
    public void setCity(String ct)
    {
        city=ct;
    }
    public void setState(String st)
    {
        state=st;
    }
    public void setContactPerson(String cp)
    {
        contactperson=cp;
    }
    public void setZipCode(int zp)
    {
        zipcode=zp;
    }
    public void setContact(int cont)
    {
        contact=cont;
    }
    public void setUserId(int uid)
    {
        userid=uid;
    }
    
    
    public String getAddress()
    {
        return address;
    }
    public String getCity()
    {
        return city;
    }
    public String getState()
    {
        return state;
    }
    public String getContactPerson()
    {
        return contactperson;
    }
    public int getZipCode()
    {
        return zipcode;
    }
    public int getContact()
    {
        return contact;
    }
    public int getUserId()
    {
        return userid;
    }
    
    
    public void location(Connection con) throws Exception
    {
        PreparedStatement pstmt=null;
        
        String query="insert into location(address,city,state,zipcode,contactperson,contactno,userid) value(?,?,?,?,?,?,?)";
        pstmt=con.prepareStatement(query);
        pstmt.setString(1,address);
        pstmt.setString(2, city);
        pstmt.setString(3,state);
        pstmt.setInt(4,zipcode);
        pstmt.setString(5, contactperson);
        pstmt.setInt(6,contact);
        pstmt.setInt(7,userid);
        
        pstmt.executeUpdate();
    }
    
}
