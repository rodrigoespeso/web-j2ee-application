package org.respeso.webapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/*
 * Performs the filter actions when URL matches with *.do
 */
@WebFilter(urlPatterns = "*.do")
public class LoginRequiredFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		// Show what the request is
		System.out.println(request.getRequestURL());
		// If "user" variable is informed, then let it continue
		if (null != request.getSession().getAttribute("user")) {
			chain.doFilter(servletRequest, servletResponse);
		}else{
			// Else case, re-direct to login page
			request.getRequestDispatcher("/login.do").forward(servletRequest, servletResponse);;
		}
	}

	@Override
	public void init(FilterConfig fc) throws ServletException {
		
	}

}
