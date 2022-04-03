package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.UserService;
import service.UserServiceImpl;

@MultipartConfig
public class ViewUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewUserDetails() {
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

		// object of UserService created
		UserService serviceobj = new UserServiceImpl();

		try {
			List<User> list = serviceobj.displayUser(user);
			HttpSession session = request.getSession();
			session.setAttribute("userList", list);
			RequestDispatcher req = request.getRequestDispatcher("ViewUser.jsp");
			req.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
