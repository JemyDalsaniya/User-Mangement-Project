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
import model.Address;
import model.User;
import service.AddressService;
import service.AddressServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import utility.EncryptionFile;

//@WebServlet("/Userlogin")
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

		UserService service = new UserServiceImpl();
		AddressService addservice = new AddressServiceImpl();

		User user = new User();
		response.setContentType("text/html");
		HttpSession session = request.getSession();

		EncryptionFile ee = null;
		try {
			ee = new EncryptionFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String decrypt_pwd = ee.encrypt(request.getParameter("password"));

		user.setUserEmail(request.getParameter("email"));
		user.setUserPassword(decrypt_pwd);

		boolean isValid = service.compareUserLogin(user);

		List<User> list1;
		// List<User> list2;
		List<Address> listAddress;

		if (isValid) {
			if (user.getUserStatus()) {
				try {
					list1 = service.displayAdmin(user);
					int id = list1.get(0).getUserId();
					listAddress = addservice.getAllAddress(id);
					session.setAttribute("adminList", list1);
					session.setAttribute("CurrentUser", user);
					session.setAttribute("AddressList", listAddress);

					RequestDispatcher req = request.getRequestDispatcher("AdminHomePage.jsp");
					req.forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				try {
					User list2 = service.displaySpecificUser(user);
					System.out.println("user value in userlogin......" + list2);
					// int id = list2.get(0).getUserId();
					int id = list2.getUserId();
					listAddress = addservice.getAllAddress(id);
					System.out.println("listAddress" + listAddress);
					session.setAttribute("specificUserData", list2);
					session.setAttribute("AddressList", listAddress);
					session.setAttribute("CurrentUser", user);
					// session.setAttribute("user", user);
					RequestDispatcher req = request.getRequestDispatcher("UserHomePage.jsp");
					req.forward(request, response);
				} catch (SQLException e) {
					// e.printStackTrace();
					logger.info(e.toString());
				}
			}
		} else {
			RequestDispatcher req = request.getRequestDispatcher("Userlogin.jsp");
			req.forward(request, response);
		}
	}
}
