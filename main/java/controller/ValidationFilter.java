package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.validator.routines.EmailValidator;

public class ValidationFilter implements Filter {

	public ValidationFilter() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String mail = request.getParameter("email");
		String password = request.getParameter("pwd");

		boolean valid = EmailValidator.getInstance().isValid(mail);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
