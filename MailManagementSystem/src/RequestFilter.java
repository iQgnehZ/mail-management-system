

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class BeerRequestFilter
 */
@WebFilter("/RequestFilter")
public class RequestFilter implements Filter {
	public static final String loginPage = "/acceuil.jsp" ;
	public static final String signinPage ="/SignIn.jsp";
	public static final String logoutPage = "/aurevoir.jsp";
	private FilterConfig fc;
    /**
     * Default constructor. 
     */
    public RequestFilter() {
        
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest requestH = (HttpServletRequest)request;  
        HttpServletResponse responseH = (HttpServletResponse)response;  
        String currentURL = requestH.getRequestURI();  
        String ctxPath = requestH.getContextPath();  
        //������Ŀ����ʱ����ҳ�浱ǰ·��  
        String targetURL = currentURL.substring(ctxPath.length());  
        HttpSession session = requestH.getSession(false);  
        //�Ե�ǰҳ������жϣ������ǰҳ�治Ϊ��¼ҳ��  
        if(!(loginPage.equals(targetURL)) && !(signinPage.equals(targetURL))){  //�ڲ�Ϊ��½/ע��ҳ��ʱ  
            //�ж���û��session  
            if(session == null || session.getAttribute("login") == null || session.getAttribute("password") == null){  
                responseH.sendRedirect(ctxPath + loginPage);  
                return;  
            }else{
            	///�����ʾ��ȷ������������ҳ����ת
                chain.doFilter(requestH, responseH);  
                return;  
            }  
        }else{  
            //�ڲ�Ϊ��½/ע��ҳ��ʱ  ��������ת
            chain.doFilter(requestH, responseH);  
            return;  
        }  
	}

	/**	
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.fc = fConfig;
	}

}
