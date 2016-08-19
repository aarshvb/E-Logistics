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
public class registrationBean 
{
    private int userid,permitno,contact;
    private String username,password,address,city,state,country,gender,firstname,lastname,email,date,usertype,contactperson,zipcode,vehicletype;
    
    public void setUserId(int uid)
    {
        userid=uid;
    }
    public void setPermitNo(int pno)
    {
        permitno=pno;
    }
 
    public void setVehicleType(String vt)
    {
        vehicletype=vt;
    }
    
    public void setZipCode(String zc)
    {
        zipcode=zc;
    }
    public void setContactPerson(String cp)
    {
        contactperson=cp;
    }
    public void setContact(int cont)
    {
        contact=cont;
    }

    public void setUserName(String uname)
    {
        username=uname;
    }
    public void setPassword(String pass)
    {
        password=pass;
    }
    public void setAddress(String addr)
    {
        address=addr;
    }
    public void setCity(String cty)
    {
        city=cty;
    }
    public void setState(String stat)
    {
        state=stat;
    }
    public void setCountry(String cntry)
    {
        country=cntry;
    }
    public void setGender(String gndr)
    {
        gender=gndr;
    }
    public void setFirstName(String fname)
    {
        firstname=fname;
    }
    public void setLastName(String lname)
    {
        lastname=lname;
    }
    public void setEmail(String eml)
    {
        email=eml;
    }
     public void setDate(String dt)
    {
        date=dt;
    }
     public void setUserType(String ut)
     {
         usertype=ut;
     }
    
  ///////////////////////////////////////////////////////  
            
    public String getUserName()
    {
        return username;
    }
    public String getPassword()
    {
        return password;
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
    public String getCountry()
    {
        return country;
    }
    public String getGender()
    {
        return gender;
    }
    public String getFirstName()
    {
        return firstname;
    }
    public String getLastName()
    {
        return lastname;
    }
    public String getEmail()
    {
        return email;
    }
    public int getContact()
    {
        return contact;
    }
    public int getUserId()
    {
        return userid;
    }
    public String getDate()
    {
        return date;
    }
    public String getUserType()
    {
        return usertype;
    }
    public String getZipCode()
    {
        return zipcode;
    }
    public String getContactPerson()
    {
        return contactperson;
    }
    public Integer getPermitNo()
    {
        return permitno;
    }
    public String getVehicleType()
    {
        return vehicletype;
    }
  
    
    
    public void insertUser(Connection con) throws Exception
    {
        //java.util.Date dt=new java.util.Date();
        PreparedStatement pstmt=null;
        
        String query="insert into user(username,password,address,city,state,country,gender,firstname,lastname,email,contactno,dob,usertypeid) value(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        pstmt=con.prepareStatement(query);
        pstmt.setString(1,username);
        pstmt.setString(2,password);
        pstmt.setString(3,address);
        pstmt.setString(4,city);
        pstmt.setString(5,state);
        pstmt.setString(6,country);
        pstmt.setString(7,gender);
        pstmt.setString(8,firstname);
        pstmt.setString(9,lastname);
        pstmt.setString(10,email);
        pstmt.setInt(11,contact);
        pstmt.setString(12, date);
        pstmt.setString(13,usertype);
        
        
        pstmt.executeUpdate();
        
        
    }
    
    public ArrayList userGrid(Connection con) throws Exception
    {
        String query="Select * from user";
        PreparedStatement pstmt = con.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        
        ArrayList a1=new ArrayList();
        while(rs.next())
        {
            registrationBean r1=new registrationBean();
            r1.setUserName(rs.getString("username"));
            r1.setAddress(rs.getString("address"));
            r1.setCity(rs.getString("city"));
            r1.setState(rs.getString("state"));
            r1.setCountry(rs.getString("country"));
            r1.setGender(rs.getString("gender"));
            r1.setFirstName(rs.getString("firstname"));
            r1.setLastName(rs.getString("lastname"));
            r1.setDate(rs.getString("dob"));
            r1.setEmail(rs.getString("email"));
            r1.setContact(rs.getInt("contactno"));
            r1.setUserType(rs.getString("usertypeid"));
            
            a1.add(r1);
        }
        return a1;
    }
    /*public int loginUser(Connection con) throws Exception
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
            setUserType(rs.getString("usertypeid"));
            return 1;
        }
        else
        {
                //System.out.println("not successful");
            return 0;
        }
    }

    public void location(Connection con) throws Exception
    {
        PreparedStatement pstmt=null;
        
        String query="insert into location(address,city,state,zipcode,contactperson,contactno,userid) value(?,?,?,?,?,?,?)";
        pstmt=con.prepareStatement(query);
        pstmt.setString(1,address);
        pstmt.setString(2, city);
        pstmt.setString(3,state);
        pstmt.setString(4,zipcode);
        pstmt.setString(5, contactperson);
        pstmt.setString(6,contact);
        pstmt.setInt(7,userid);
        
        pstmt.executeUpdate();
    }
    
    public void vehicle(Connection con) throws Exception
    {
        PreparedStatement pstmt=null;
        
        String query="insert into vehicle(permitno,vehicletype) value(?,?)";
        pstmt=con.prepareStatement(query);
        pstmt.setInt(1,permitno);
        pstmt.setString(2, vehicletype);
        
        pstmt.executeUpdate();
        
    }
*/
    
    
    
    
}
