import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Scanner; 
public class MySQLHelper {
	
    private Connection connect = null;
    private PreparedStatement statement = null;
   // private t preparedStatement = null;
    private ResultSet resultSet = null;
    private String lastName;
    		
   
    public void readDataBase() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
        	// The MySQL driver is a JAR file that must be in the Build Path
        	
        	
        	
     		
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager.getConnection("jdbc:mysql://localhost/Customers?user=root&password=password");

            // Statements allow to issue SQL queries to the database
            String sql="select * from customers  where `LastName`= ?";
            statement = connect.prepareStatement(sql);
            System.out.println("What is the LastName you are looking for");
        	Scanner sc= new Scanner(System.in);
        	String input =sc.nextLine();
            // Result set get the result of the SQL query
        	customer person = new customer();
        	person.setLastName(input);
        	statement.setString(1,input);
            resultSet = statement.executeQuery();
          

            // PreparedStatements can use variables and are more efficient
            // The primary reason to use prepared statements: More Secure!
            // Secondary reason: you don't have to worry about quotes in your strings!
           
        	
        	
          /*  preparedStatement = connect
                    .prepareStatement("Select * from Customers.customeres where `LastName`= values(?)");
            */
        	
            
           // preparedStatement.executeUpdate();

          //  preparedStatement = connect.prepareStatement("SELECT myuser, webpage, datum, summary, COMMENTS from feedback.comments");
           // resultSet = preparedStatement.executeQuery();
            writeResultSet(resultSet);

            // Remove again the insert comment
//            preparedStatement = connect.prepareStatement("delete from feedback.comments where myuser= ? ; ");
//            preparedStatement.setString(1, "Test");
//            preparedStatement.executeUpdate();
//
//            resultSet = statement.executeQuery("select * from feedback.comments");
            
//            writeMetaData(resultSet);
           
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String FullName = resultSet.getString("FullName");
            String Title = resultSet.getString("Title");
            String FirstName = resultSet.getString("FirstName");
            //Date date = resultSet.getDate("datum");
            String LastName = resultSet.getString("LastName");
            String street = resultSet.getString("StreetAddress");
            String city = resultSet.getString("City");
            String State= resultSet.getString("State");
           // String Email = resultSet.getString("Email");
            String position = resultSet.getString("Position");
            String company = resultSet.getString("company");
            System.out.println("Fullname: " + FullName);
            System.out.println("Title: " + Title);
            System.out.println("Firstname: " + FirstName);
            System.out.println("Lastname: " + LastName);
            System.out.println("Street: " + street);
            System.out.println("city: " + city);
            System.out.println("State: " + State);
         //   System.out.println("Email: " + Email);
            System.out.println("position: " + position);
            System.out.println("company: " + company);
        }
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}