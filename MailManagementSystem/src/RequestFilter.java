

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
        //除掉项目名称时访问页面当前路径  
        String targetURL = currentURL.substring(ctxPath.length());  
        HttpSession session = requestH.getSession(false);  
        //对当前页面进行判断，如果当前页面不为登录页面  
        if(!(loginPage.equals(targetURL)) && !(signinPage.equals(targetURL))){  //在不为登陆/注册页面时  
            //判断有没有session  
            if(session == null || session.getAttribute("login") == null || session.getAttribute("password") == null){  
                responseH.sendRedirect(ctxPath + loginPage);  
                return;  
            }else{
            	///这里表示正确，进行正常的页面跳转
                chain.doFilter(requestH, responseH);  
                return;  
            }  
        }else{  
            //在不为登陆/注册页面时  ，正常跳转
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
