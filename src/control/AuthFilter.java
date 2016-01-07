package control;


import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns={"/Albums/*","/albums/*"},dispatcherTypes={DispatcherType.REQUEST,DispatcherType.FORWARD,DispatcherType.INCLUDE})
public class AuthFilter implements Filter {

	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest req = (HttpServletRequest) request;
		
		Object o  = req.getSession().getAttribute("connectedUser");
		if (o==null) {
			request.setAttribute("requestedPage", req.getRequestURI().substring(req.getContextPath().length()));
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
		else {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
