

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReceiveMessageServlet
 */
@WebServlet("/ReceiveMessageServlet")
public class ReceiveMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MailServer ms ;

    public void init(ServletConfig config) {
    	ms = MailServer.newInstance();
    }   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiveMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	      
	      Vector<Message> messageRecu = ms.readMessages((String) request.getSession().getAttribute("login")); 
          out.print("<h1>boîte aux lettres</h1>");
	      for(int i = 0; i < messageRecu.size(); i++){
	    	  out.println("<br> From: " + messageRecu.get(i).getFrom());
	    	  out.println("<br> Subject: " + messageRecu.get(i).getSubject());
	    	  out.println("<br> Message: " + messageRecu.get(i).getMessage());
	      }
		  out.println("<br> <a href=\"http://localhost:8080/WANG_ZHENG/menu.jsp\"> Go back to Meun</a>");
		  out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
