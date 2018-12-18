package in.com.prestige.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class MyFilter
 */
@WebFilter(urlPatterns="/HelloFilter")//here we congigure the servlet where we want to apply filter
//@WebFilter(urlPatterns="/*")//Wild card read All The Servlet
public class MyFilter implements Filter {
	private FilterConfig fConfig = null;

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
	   /* HttpServletRequest req = (HttpServletRequest)request;
	    Enumeration<String> e = req.getParameterNames();
	    while(e.hasMoreElements()){
	    	String name = e.nextElement();
	    	out.print(req.getAttribute(name));
	    }*/
		// Pre processing
		out.println("<h2>Pre Hello</h2>");
		// Call Next Filter or Target Servlet
		chain.doFilter(request, response);  //This calls The Servlet Using XML Filter Mapping
		// Post processing
		out.println("<h2>Post Hello</h2>");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
