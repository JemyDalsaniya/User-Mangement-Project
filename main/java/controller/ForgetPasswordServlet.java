package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserService;
import service.UserServiceImpl;
import utility.EncryptionFile;

public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ForgetPasswordServlet() {
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
		User user = new User();
		EncryptionFile ee = null;
		try {
			ee = new EncryptionFile();
		} catch (Exception e) {
			e.printStackTrace();
		}

		UserService service = new UserServiceImpl();
		user.setUserEmail(request.getParameter("email"));
		String encrypt_pwd = ee.encrypt(request.getParameter("password"));
		user.setUserPassword(encrypt_pwd);
		try {
			service.updatePassword(user);
			RequestDispatcher req = request.getRequestDispatcher("/Userlogin.jsp");
			req.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
