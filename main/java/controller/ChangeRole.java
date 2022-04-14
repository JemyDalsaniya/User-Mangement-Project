package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		// to change role of user to admin
		UserService service = new UserServiceImpl();
		String id = request.getParameter("trid");
		HttpSession session = request.getSession();
		User user = new User();
		try {
			service.changeRole(id);
			List<User> list1 = service.displayAdmin(user);
			session.setAttribute("adminList", list1);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
