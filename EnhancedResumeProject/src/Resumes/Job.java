package Resumes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Job {
	 private int jobID; 
	 public int getJobID() {
		return jobID;
	}


	public void setJobID(int jobID) {
		this.jobID = jobID;
	}
	private String jtitile="";
	  private String jcompany="";
	  LocalDateTime sdate;
	  LocalDateTime edate;
	  private ArrayList<String>jduties;
	  
	  
	  public Job()
	  { 
		  this.jduties =new ArrayList<String>();
	  }
	  
	  
	  public void addDuty(String dutyString,int PersonID)
	  { //inseert it in the data
		     String insertSQl="insert into jobduties(jobid,jobduty) values(?,?)";
		 
			
			 PreparedStatement stmt =null;
			 String jDutiesList=null;
			
			
			 Class.forName("com.mysql.jdbc.Driver");
			 java.sql.Connection con =DriverManager.getConnection("jdbc:mysql://localhost/resume?user=root&password=password");
			// PreparedStatement stmt = con.prepareStatement(inserSQL);
			 stmt=con.prepareStatement(insertSQL);
			 stmt.setInt(1,this.getJobID());
			 stmt.setString(2,dutyString);
			 stmt.setInt(3,PersonID);
			 //stmt.setString(4,jDutiesList);
			 
			 stmt.executeUpdate();//we haven't done anything to the person yet
			 
		  this.jduties.add(dutyString+this.jobID);
	  }
    public String getJtitile() {
		return jtitile;
	}
	public void setJtitile(String jtitile) {
		this.jtitile = jtitile;
	}
	public String getJcompany() {
		return jcompany;
	}
	public void setJcompany(String jcompany) {
		this.jcompany = jcompany;
	}
	public LocalDateTime getSdate() {
		return sdate;
	}
	public void setSdate(LocalDateTime sdate) {
		this.sdate = sdate;
	}
	public LocalDateTime getEdate() {
		return edate;
	}
	public void setEdate(LocalDateTime edate) {
		this.edate = edate;
	}
	public ArrayList<String>getJobDuties()
	{ 
		return this.jduties;
	}
 public void addJobtoDb(int personID)//this method send it to db
 {    
	 String inserJobSQL="insert into jobtable(jobtitle,duities,personid)values(?,?,?)";
	 String getCurrentjobID="select id from jobtable where company=? and jobtitle=? and personid=?";
	 ResultSet rs=null;
	 PreparedStatement stmt =null;
	 String jDutiesList=null;
	 for (String aduty:this.jduties)
	 { 
		 jDutiesList+=aduty;
	 }
	 
	 try{
	
	 Class.forName("com.mysql.jdbc.Driver");
	 java.sql.Connection con =DriverManager.getConnection("jdbc:mysql://localhost/resume?user=root&password=password");
	// PreparedStatement stmt = con.prepareStatement(inserSQL);
	 stmt=con.prepareStatement(inserJobSQL);
	 stmt.setString(1,this.jtitile);
	 stmt.setString(2,this.jcompany);
	 stmt.setInt(3,personID);
	 //stmt.setString(4,jDutiesList);
	 
	 stmt.executeUpdate();//we haven't done anything to the person yet
	 stmt =con.prepareStatement(getCurrentjobID);
	 stmt.setString(1,this.getJcompany());
	 stmt.setString(2, this.getJtitile());
	 stmt.setInt(3, personID);
	 rs=stmt.executeQuery();
	 rs.next();
	 this.setJobID(rs.getInt("id"));
	 } catch(Exception e){ 
		 
	 }finally{ 
		 System.out.println("your job and duties successfuly saved in the database");
		
	 }
 }
 
}
