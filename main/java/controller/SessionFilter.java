package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter {

	public SessionFilter() {
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String path = httpRequest.getServletPath();
		httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = httpRequest.getSession(false);
		chain.doFilter(request, response);

//		User user = null;
//
//		boolean isOtherPage = path.startsWith("/Userlogin") || path.startsWith("/ForgetPassword");
//
//		if (session != null) {
//			user = (User) (session.getAttribute("user"));
//		}
//		if (user != null) {
//			if (!user.getUserStatus()) {
//
//				if (isOtherPage || path.endsWith("UserRegister.jsp")) {
//					httpResponse.sendRedirect("UserHomePage.jsp");
//				} else {
//					chain.doFilter(request, response);
//				}
//			} else {
//				if (isOtherPage) {
//					httpResponse.sendRedirect("AdminHome");
//				} else {
//					chain.doFilter(request, response);
//				}
//			}
//		} else {
//			if (isOtherPage || path.startsWith("/UserRegister")) {
//				chain.doFilter(request, response);
//			} else {
//
//				httpResponse.sendRedirect("Userlogin.jsp");
//			}
//		}
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
