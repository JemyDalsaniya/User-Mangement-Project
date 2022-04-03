package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDaoImpl;
import model.User;
import service.UserService;
import service.UserServiceImpl;
import utility.EncryptionFile;

public class Userlogin extends HttpServlet {

	private static Logger logger = Logger.getLogger(UserDaoImpl.class.getName());

	private static final long serialVersionUID = 1L;

	public Userlogin() {
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
		// TODO Auto-generated method stub
		System.out.println("inside do post....");
		UserService service = new UserServiceImpl();
		User user = new User();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		EncryptionFile ee = null;
		try {
			ee = new EncryptionFile();
		} catch (Exception e) {
		}
		String decrypt_pwd = ee.encrypt(request.getParameter("password"));

		user.setUserEmail(request.getParameter("email"));
		user.setUserPassword(decrypt_pwd);

		boolean isValid = service.compareUserLogin(user);

		List<User> list1;
		List<User> list2;

		if (isValid) {
			if (user.getUserStatus()) {
				try {
					list1 = service.displayAdmin(user);
					session.setAttribute("adminList", list1);
					session.setAttribute("admin", user);
					RequestDispatcher req = request.getRequestDispatcher("AdminHomePage.jsp");
					req.forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("inside else part");
				try {
					System.out.println("inside user part...");
					list2 = service.displaySpecificUser(user);
					System.out.println("list2" + list2);
					logger.info("list2" + list2);
					System.out.println("list2" + list2);

					session.setAttribute("specificUserData", list2);
					session.setAttribute("user", user);
					RequestDispatcher req = request.getRequestDispatcher("UserHomePage.jsp");
					req.forward(request, response);
				} catch (SQLException e) {
					// e.printStackTrace();
					logger.info(e.toString());
				}
			}
		}
	}
}
