package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserServiceImpl;

public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteUser() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		doGet(request, response);
		UserService serviceobj = new UserServiceImpl();
		try {
			// to delete the user
			serviceobj.deleteUser(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
