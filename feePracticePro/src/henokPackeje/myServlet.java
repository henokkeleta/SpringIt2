package henokPackeje;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class myServlet
 */
@WebServlet("/myServlet")
public class myServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession mySessionHere=request.getSession();
		//User u=
		 mySessionHere.setAttribute("firstName"," FirstName");//do it for all of them then get it in jsp how?
		String myVariable=request.getParameter("LastName");//i want to display it in jsp   .... set it to variable
		request.setAttribute("LastName", myVariable);//????
		//now we have to forward it
		getServletContext().getRequestDispatcher("/myjsp.jsp").forward(request, response);//go ahead and pass it i want to access this variables
	}
//in sexxion we pass the object like person obj of customer
}
