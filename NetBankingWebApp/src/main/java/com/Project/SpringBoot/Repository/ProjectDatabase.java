package com.Project.SpringBoot.Repository;

import java.sql.*;

import org.springframework.stereotype.Repository;

@Repository
public class ProjectDatabase 
{
   public Connection con ;
   public Statement s;
   public Statement s1;
   
   
   public ProjectDatabase()
   {
	   try
	   {
		   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebankapp", "root", "kaustubh"); 
		   s=con.createStatement();
		   s1=con.createStatement();
	   }
	   
	   catch(Exception e)
	    {
	      System.out.println(e);
	    } 
   }
   
  
   
  
   
   
  
   
   
   
}
