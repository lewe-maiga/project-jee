package app;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/dashboard/*")

public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
	
	private ServletContext context;
	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		 this.context = fConfig.getServletContext();
	     this.context.log("AuthenticationFilter initialized");
	}
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		// pass the request along the filter chain
		
		
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        System.out.println("filter");
        
        String auth = (String) session.getAttribute("auth");
        
        if (auth == null) {
        	//this.context.log("Unauthorized access request");
            res.sendRedirect(req.getContextPath() + "/index.jsp");
        } else {
            // pass the request along the filter chain
            chain.doFilter(request, response);
        }
		
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	

}
