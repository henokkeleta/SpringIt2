package Resumes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class person {
  private int personid;
  private String FirstName;
  private String LastName;
  private String Email;
  private  ArrayList<Job> myjoblists;
 
  private ArrayList<Education> myedulists;
  private ArrayList<Skills> myskilllists;
 
  
	public person(String pfname,String planame,String pemail) 
	{ 
		this.FirstName=pfname;
		this.LastName=planame;
		this.Email=pemail;
		myjoblists=new ArrayList<Job>();
		myedulists=new ArrayList<Education>();
		myskilllists=new ArrayList<Skills>();
	}


	public String getFirstName() {
		return FirstName;
	}


	public void setFirstName(String firstName) {
		FirstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public int getPersonid() {
		return personid;
	}


	public void setPersonid(int personid) {
		this.personid = personid;
	}
	public void addJob(Job current)
	{  
		myjoblists.add(current);
	}
	public void listMyJobs(){ 
	for (Job job:myjoblists){
		System.out.println(job.getJcompany());
	    System.out.println(job.getJtitile());
	  for(String duty: job.getJobDuties())
	  { 
		  System.out.println(duty);
	  }}
	}
	public void addme()
	{ //do this with the database
		  Connection con = null;
	 
	     PreparedStatement stmt = null;
	     ResultSet rs = null;
	     int personID;
	     String isertsql;
	     String getIDSQL;
	     isertsql="insert into persontable(FirstName, LastName,Email) values(?,?,?)";
	     getIDSQL="select * from persontable where email=?";
	     try { 
	    	   Class.forName("com.mysql.jdbc.Driver");
	    	         con=DriverManager.getConnection("jdbc:mysql://localhost/resume?user=root&password=password");
	    	         stmt=con.prepareStatement(isertsql);
	    			 stmt.setString(1, this.FirstName);
	    	         stmt.setString(2, this.LastName);
	    	         stmt.setString(1, this.Email);
	    	         stmt.executeUpdate();
	    	         //we need to prepare another statment
	    	         stmt=con.prepareStatement(getIDSQL);
	    	         stmt.setString(1, this.Email);
	    	         rs.getStatement();
	    	          executeQuery();
	    	         //we need to tell it where to go and fetch that
	    	         rs.next();
	    	         //int interimvariable=rs.getInt("id"); we could do this too
	    	        this.setPersonid( rs.getInt("id"));
	    	         
	     }catch(ClassNotFoundException e)
	     { 
	    	 e.printStackTrace();
	     }catch(SQLException e)
	     { 
	    	 e.printStackTrace();
	     }finally{ 
	    	 
	     }
	}
  }
  
  
  
  
  
 