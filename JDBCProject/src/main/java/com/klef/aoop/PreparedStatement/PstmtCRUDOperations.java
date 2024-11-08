package com.klef.aoop.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PstmtCRUDOperations 
{
  public static void main(String[] args) {
    PstmtCRUDOperations obj = new PstmtCRUDOperations();
     obj.insertstudent();
//     obj.viewallstudents();
    // obj.viewstudentbyid();
//     obj.deletestudent();
  }
  
  public void insertstudent()
  {
    try
    {
      Connection con = null;
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver class Loaded Successfully");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbcproject", "postgres", "VIJAY2005");
            System.out.println("Connection Established Successfully");
            
            Scanner obj = new Scanner(System.in);
      System.out.println("Enter Student ID: ");
      int sid = obj.nextInt();
      obj.nextLine(); 
      System.out.println("Enter Student Name: ");
      String sname = obj.nextLine();
      System.out.println("Enter Student Gender: ");
      String sgender = obj.next();
      System.out.println("Enter Student Age: ");
      int sage = obj.nextInt();
      obj.nextLine(); 
      System.out.println("Enter Student Department: ");
      String sdept = obj.next();
      System.out.println("Enter Student Contact: ");
      String scon = obj.next();
      System.out.println("Enter Student Email: ");
      String semail = obj.next();
      
      PreparedStatement pstmt = con.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
      pstmt.setInt(1, sid);
      pstmt.setString(2, sname);
      pstmt.setString(3, sgender);
      pstmt.setInt(4, sage);
      pstmt.setString(5, sdept);
      pstmt.setString(6, scon);
      pstmt.setString(7, semail);
      
      int n = pstmt.executeUpdate();
      System.out.println(n + " Student Records Inserted Successfully");
      
      pstmt.close();
      con.close();
    }
    catch(Exception e)
    {
      System.out.println(e.getMessage());
    }
  }
  
  public void viewallstudents()
  {
    try
    {
      Connection con = null;
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver class Loaded Successfully");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbcproject", "postgres", "VIJAY2005");
            System.out.println("Connection Established Successfully");
            
            PreparedStatement pstmt = con.prepareStatement("select * from student");
            ResultSet rs = pstmt.executeQuery();
            
            int i = 1;
            System.out.println("******Student Records******");
            while(rs.next())
            {
              // System.out.println("Student Record: " + rs.getRow());
              System.out.println("Student Record: " + i);
        System.out.println("Student ID: " + rs.getInt("id"));
        System.out.println("Student Name: " + rs.getString(2));
        System.out.println("Student Gender: " + rs.getString(3));
        System.out.println("Student Age: " + rs.getInt(4));
        System.out.println("Student Department: " + rs.getString(5));
        System.out.println("Student Contact: " + rs.getString(6));
        System.out.println("Student Email: " + rs.getString(7));
        
        i++;
            }
            
            pstmt.close();
            con.close();
    }
    catch(Exception e)
    {
      System.out.println(e.getMessage());
    }
  }
  
  public void viewstudentbyid()
  {
    try
    {
      Connection con = null;
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver class Loaded Successfully");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbcproject", "postgres", "VIJAY2005");
            System.out.println("Connection Established Successfully");
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Student ID:");
            int sid = sc.nextInt();
            PreparedStatement pstmt = con.prepareStatement("select name,department,contact from student where id=?");
            pstmt.setInt(1, sid);
            ResultSet rs = pstmt.executeQuery();
            
            int i = 1;
            System.out.println("******Student Details based on condition******");
            if(rs.next())
            {
        System.out.println("Student Name: " + rs.getString(1));
        System.out.println("Student Department: " + rs.getString(2));
        System.out.println("Student Contact: " + rs.getString(3));
            }
            
            else
            {
              System.out.println("Student ID Not Found");
            }
            
            pstmt.close();
            con.close();
    }
    catch(Exception e)
    {
      System.out.println(e.getMessage());
    }
  }
  
  public void deletestudent()
  {
    try
    {
      Connection con = null;
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver class Loaded Successfully");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbcproject", "postgres", "VIJAY2005");
            System.out.println("Connection Established Successfully");
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Student ID:");
            int sid = sc.nextInt();
            
            PreparedStatement pstmt = con.prepareStatement("delete from student where id=?");
            pstmt.setInt(1, sid);
            int n  = pstmt.executeUpdate();
            
            if(n>0)
            {
        System.out.println("Student Record Deleted Successfully");
        viewallstudents();
            }
            
            else
            {
              System.out.println("Student ID Not Found");
            }
            
            pstmt.close();
            con.close();
    }
    catch(Exception e)
    {
      System.out.println(e.getMessage());
    }
  }
  
  public void updatestudent()
  {
    try
    {
      Connection con = null;
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver class Loaded Successfully");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbcproject", "postgres", "VIJAY2005");
            System.out.println("Connection Established Successfully");
            
            Scanner obj = new Scanner(System.in);
      System.out.println("Enter Student ID: ");
      int sid = obj.nextInt();
      obj.nextLine(); 
      System.out.println("Enter Student Name: ");
      String sname = obj.nextLine();
      obj.nextLine(); 
      System.out.println("Enter Student Department: ");
      String sdept = obj.next();
      System.out.println("Enter Student Email: ");
      String semail = obj.next();
            PreparedStatement pstmt = con.prepareStatement("update student set name=?,department=?,email=? where id=?");
            pstmt.setString(1, sname);
            pstmt.setString(2, sdept);
            pstmt.setString(3, semail);
            pstmt.setInt(4, sid);
            
            int n = pstmt.executeUpdate();
            
            if(n>0)
            {
        System.out.println("Student Record Updated Successfully");
            }
            
            else
            {
              System.out.println("Student ID Not Found");
            }
            
            pstmt.close();
            con.close();
    }
    catch(Exception e)
    {
      System.out.println(e.getMessage());
    }
  }
}