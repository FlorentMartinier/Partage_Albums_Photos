package control;


import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Example of a Filter that acts as a generic Controller
 * It try to matches the different mappings to the path info and then call the corresponding Servlet
 */


@WebFilter(urlPatterns={"/*"},dispatcherTypes={DispatcherType.REQUEST,DispatcherType.FORWARD,DispatcherType.INCLUDE})
public class ControllerFilter implements Filter {
	
	private static final long serialVersionUID = 1L;
    
	/**
	 * Pattern that match the name of named-capturing group with a regular expression.
	 */
	private static final Pattern namedGroups = Pattern.compile("\\(\\?<([a-zA-Z][a-zA-Z0-9]*)>");
	
	
	/**
	 * Maps regular expressions to servlet name
	 * named-capturing group can be used within the path to add attribute to the forwarded request
	 */
	private String[][] mappings = {
			{"/albums/(?<idAlbum>\\d+)","/AlbumDetails"},
			{"/etudiant/(?<idEtudiant>\\d+)","Etudiant"},
			{"/etudiant/(?<idEtudiant>\\d+)/note/(?<nomMatiere>\\w+)","NoteMatiere"}
	};
	
	/**
	 * Pattern created from regular expression given in mappings
	 */
	Pattern[] patterns;
	

	@Override
	public void destroy() {
	}


	@Override
	public void init(FilterConfig config) throws ServletException {
		patterns = new Pattern[mappings.length];
		for (int i =0 ; i<mappings.length; i++) {
			patterns[i]= Pattern.compile(mappings[i][0]);
		}
		
	}


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String path = ((HttpServletRequest) request).getServletPath();
		// parameters are set as request attributes
		for (Map.Entry<String, String[]> p : request.getParameterMap().entrySet()) {
			if (p.getValue().length==1)
				request.setAttribute(p.getKey(), p.getValue()[0]);
			else {
				request.setAttribute(p.getKey(), p.getValue());
			}
		}
		if (path != null) {
			for (int i=0 ; i < patterns.length ; i ++) {
				Matcher m = patterns[i].matcher(path);
				if (m.matches()) {
					Matcher ngm = namedGroups.matcher(mappings[i][0]);
					while (ngm.find()) {
						String attName = ngm.group(1);
						String attValue = m.group(attName);
						request.setAttribute(attName, attValue);
						
					}
					// Use the name of the servlet instead of its path
					RequestDispatcher dispatch = request.getServletContext().getRequestDispatcher(mappings[i][1]);
					dispatch.forward(request, response);
					return;
				}
			}
		}
		chain.doFilter(request, response);
	}

}
