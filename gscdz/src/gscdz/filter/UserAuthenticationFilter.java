package gscdz.filter;

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

@WebFilter("/user/*")
public class UserAuthenticationFilter implements Filter {

    public UserAuthenticationFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
         ServletContext sc=request.getServletContext();
         HttpServletRequest req=(HttpServletRequest) request;
         HttpServletResponse res=(HttpServletResponse)response;
         HttpSession session=req.getSession();
         if(session.getAttribute("islogin")==null||session.getAttribute("islogin")!="yes") {
        	 String path=sc.getContextPath();
        	 res.sendRedirect(path+"/NewFile.jsp");
         }
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
