package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
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

		User user = new User();
		UserService service = new UserServiceImpl();
		String id = request.getParameter("trid");
		System.out.println("id inside changeRole" + id);

		try {
			service.changeRole(id);
//			RequestDispatcher req = request.getRequestDispatcher("/AdminHomePage.jsp");
//			req.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
