

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final String SUCCESS_VIEW ="SigninSuccess.jsp";
    private final String ERROR_VIEW="SigninError.jsp";
    IdentificationClient idClient = IdentificationClient.newInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String confirmedPassword = request.getParameter("confirmedPassword");
		List<String> errors = new ArrayList<String>();
		if(!isValidUsername(login)){
			errors.add("login vide or existed");
		}
		if(!isValidePassword(password,confirmedPassword)){
			System.out.println("psw: "+password+"\npsw2: "+confirmedPassword);
			errors.add("password invalid");
		}
		String resultPage=ERROR_VIEW;
		if(!errors.isEmpty()){
			request.setAttribute("errors", errors);
		}else{
			resultPage = SUCCESS_VIEW;
			createUserData(login,password);
			System.out.println(idClient.getClients());
		}
		request.getRequestDispatcher(resultPage).forward(request, response);
	}

	private void createUserData(String login, String password) {
		idClient.addClient(login, password);
		
	}

	private boolean isValidePassword(String password, String confirmedPassword) {
		return password.equals(confirmedPassword);
	}

	private boolean isValidUsername(String login) {
		return idClient.getClients().get(login) == null;
	}
}
