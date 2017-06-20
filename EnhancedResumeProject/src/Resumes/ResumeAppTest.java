package Resumes;

public class ResumeAppTest {

	public static void main(String[] args) {
  person me = new person("Henok","Berhe","heniken05@yahoo.com");// TODO Auto-generated method stub
  System.out.println("your full name is : "+me.getFirstName()+" "+me.getLastName()+"and your email is "+me.getEmail());
  System.out.println(me.getFirstName()+"is the user id"+me.getPersonid());
		Job job1=new Job();
		job1.setJcompany("mentogomery college");
        job1.setJtitile("techer");
        
        job1.addJobtoDb(me.getPersonid());
        job1.addDuty("was responsible for doing stuff",me.getPersonid());
        job1.addDuty("make money",me.getPersonid());
        job1.addDuty("enjoy",me.getPersonid());
        me.addJob(job1);
        
        Job job2=new Job();
		job2.setJcompany("vcu college");
        job2.setJtitile("engenieer");
        job2.addJobtoDb(me.getPersonid());
        job2.addDuty("was responsible for writing a check",me.getPersonid());
        job2.addDuty("loose money",me.getPersonid());
        job2.addDuty("stuff",me.getPersonid());
         me.addJob(job2);
       
        
        System.out.println(me.getFirstName()+" "+me.getLastName());
        System.out.println("Email:"+me.getEmail());//before we send it to database the person is the object who holds everything
	    System.out.println("\njob:");
	    me.listMyJobs();
	   // System.out.println("Duties:");
	   
     
	
	}

}
