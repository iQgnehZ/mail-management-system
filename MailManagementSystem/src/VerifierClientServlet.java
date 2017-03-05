

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class verifierClientServlet
 */
@WebServlet("/VerifierClientServlet")
public class VerifierClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IdentificationClient clientInfo = IdentificationClient.newInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifierClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(50);
		String login = (String)request.getParameter("login");
		String password = (String)request.getParameter("password");
		//on effectue un lien vers la page http://localhost:8080/nom/menu.jsp
		boolean inputExist = login != "" && password != "";
		boolean userExist = clientInfo.getClients().get(login) != null;
		System.out.println("inputExist = "+inputExist);
		System.out.println("userExist = "+userExist);	
		System.out.println(clientInfo.getClients());
		if(inputExist && userExist){
			System.out.println("user exist");
			boolean passwordCorrect = ((String)clientInfo.getClients().get(login)).equals(password);
			System.out.println("password: "+password+"\n"+"getPassword: "+(String)clientInfo.getClients().get(login));
			if(passwordCorrect){
				session.setAttribute("login", request.getParameter("login"));
		    	session.setAttribute("password", request.getParameter("password"));
		    	RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
		    	dispatcher.forward(request, response);
		    	return;
			}
		}
			
	    RequestDispatcher dispatcher = request.getRequestDispatcher("erreur.jsp");
	    dispatcher.forward(request, response);
	    return;
	}

}
