package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserServiceImpl;

public class ChangeRole extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChangeRole() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// to change role of user to admin
		UserService service = new UserServiceImpl();
		String id = request.getParameter("trid");
		try {
			service.changeRole(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
