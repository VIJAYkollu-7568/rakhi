package com.klef.aoop.StatementDemo;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class StmtCRUDOperations {
  public static void main(String[] args) {
    StmtCRUDOperations obj = new StmtCRUDOperations();
     obj.insertFaculty();
//     obj.viewallfaculty();
//     obj.viewfacultybyid();
//     obj.deletefaculty();
//     obj.updatefaculty();
  }
  
  public void insertFaculty()
  {
    try
    {
      Connection con = null;
      Class.forName("org.postgresql.Driver");
      System.out.println("Driver class Loaded Successfully");
      con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbcproject", "postgres", "VIJAY2005");
      System.out.println("Connection Established Successfully");
      
      Scanner obj = new Scanner(System.in);
      System.out.println("Enter Faculty ID: ");
      int fid = obj.nextInt();
      obj.nextLine(); 
      System.out.println("Enter Faculty Name: ");
      String fname = obj.nextLine();
      System.out.println("Enter Faculty Gender: ");
      String fgender = obj.next();
      System.out.println("Enter Faculty Age: ");
      int fage = obj.nextInt();
      obj.nextLine(); 
      System.out.println("Enter Faculty Department: ");
      String fdept = obj.next();
      System.out.println("Enter Faculty Salary: ");
      double fsal = obj.nextDouble();
      obj.nextLine(); 
      System.out.println("Enter Faculty Contact: ");
      String fcon = obj.next();
      System.out.println("Enter Faculty Email: ");
      String femail = obj.next();
      
      String qry = "insert into faculty values("+fid+",'"+fname+"','"+fgender+"',"+fage+","+fsal+",'"+fdept+"','"+fcon+"','"+femail+"')";
      Statement stmt = con.createStatement();
      int n = stmt.executeUpdate(qry);
      System.out.println(n + " Faculty Record(s) Inserted Successfully");

      stmt.close();
      con.close();
    }
    catch(Exception e)
    {
      System.out.println(e.getMessage());
    }
  }
  
  public void viewallfaculty() 
  {
    try
    {
      Connection con = null;
      Class.forName("org.postgresql.Driver");
      System.out.println("Driver class Loaded Successfully");
      con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbcproject", "postgres", "VIJAY2005");
      System.out.println("Connection Established Successfully");
      
      String qry = "select * from faculty";
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(qry);
      
      System.out.println("---------Faculty Records---------");
      while(rs.next())
      {
        System.out.println("Faculty Record: " + rs.getRow());
        System.out.println("Faculty ID: " + rs.getInt("id"));
        System.out.println("Faculty Name: " + rs.getString(2));
        System.out.println("Faculty Gender: " + rs.getString(3));
        System.out.println("Faculty Age: " + rs.getInt(4));
        System.out.println("Faculty Salary: " + rs.getDouble(5));
        System.out.println("Faculty Department: " + rs.getString(6));
        System.out.println("Faculty Contact: " + rs.getString(7));
        System.out.println("Faculty Email: " + rs.getString(8));
      }
      
      stmt.close();
      con.close();
    }
    catch(Exception e)
    {
      System.out.println(e.getMessage());
    }
  }
  
  public void viewfacultybyid()
  {
    try
    {
      Connection con = null;
      Class.forName("org.postgresql.Driver");
      System.out.println("Driver class Loaded Successfully");
      con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbcproject", "postgres", "VIJAY2005");
      System.out.println("Connection Established Successfully");
      
      Scanner obj = new Scanner(System.in);
      System.out.println("Enter Faculty ID: ");
      int fid = obj.nextInt();
      
      String qry = "select * from faculty where id="+fid;
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(qry);
      
      if(rs.next())
      {      
    	  System.out.println("Faculty Record: " + rs.getRow());
          System.out.println("Faculty ID: " + rs.getInt("id"));
          System.out.println("Faculty Name: " + rs.getString(2));
          System.out.println("Faculty Gender: " + rs.getString(3));
          System.out.println("Faculty Age: " + rs.getInt(4));
          System.out.println("Faculty Salary: " + rs.getDouble(5));
          System.out.println("Faculty Department: " + rs.getString(6));
          System.out.println("Faculty Contact: " + rs.getString(7));
          System.out.println("Faculty Email: " + rs.getString(8));
        }
        else
        {
          System.out.println("Faculty ID Not Found");
        }
        stmt.close();
        con.close();
      }
      catch(Exception e)
      {
        System.out.println(e.getMessage());
      }
      
    }
    
    public void deletefaculty() {
      try
      {
        Connection con = null;
        Class.forName("org.postgresql.Driver");
        System.out.println("Driver class Loaded Successfully");
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbcproject", "postgres", "VIJAY2005");
        System.out.println("Connection Established Successfully");
        
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter Faculty ID: ");
        int fid = obj.nextInt();
        
        String qry = "delete from faculty where id=" + fid;
        Statement stmt = con.createStatement();
        int n = stmt.executeUpdate(qry);
        if(n>0)
        {
          System.out.println("Faculty Record(s) Deleted Successfully");
        }
        else
        {
          System.out.println("Faculty ID Not Found");
        }
        
        stmt.close();
        con.close();
      }
      catch(Exception e)
      {
        System.out.println(e.getMessage());
      }
    }
    
    public void updatefaculty()
    {
      try 
      {
        Connection con = null;
        Class.forName("org.postgresql.Driver");
        System.out.println("Driver class Loaded Successfully");
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbcproject", "postgres", "VIJAY2005");
        System.out.println("Connection Established Successfully");
        
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter Faculty ID: ");
        int id = obj.nextInt();
        obj.nextLine(); 
        System.out.println("Enter Faculty Name: ");
        String fname = obj.nextLine();
//        System.out.println("Enter Faculty Department: ");
//        String dept = obj.next();
//        System.out.println("Enter Faculty Salary: ");
//        double sal = obj.nextDouble();
        
        String qry  = "update faculty set name='"+fname+"' where id="+id;
        
        Statement stmt = con.createStatement();
        int n = stmt.executeUpdate(qry);
        
        if(n>0)
        {
          System.out.println(n + " Faculty Record(s) Updated Successfully");
        }
        else
        {
          System.out.println("Faculty ID Not Found");
        }
        
        stmt.close();
        con.close();
      }
      catch(Exception e)
      {
        System.out.println(e.getMessage());
      }
    }
  }
      