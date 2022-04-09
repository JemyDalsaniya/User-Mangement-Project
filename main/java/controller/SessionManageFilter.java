package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class SessionManageFilter
 */
public class SessionManageFilter implements Filter {

	public SessionManageFilter() {
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		// HttpSession session = request.getSession();

		// User user = (User) session.getAttribute("user");

//		if (user != null) {
//			chain.doFilter(request, response);
//		}
	}

	@Override
	public void destroy() {
	}

}
