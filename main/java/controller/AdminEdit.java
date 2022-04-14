package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Address;
import model.User;
import service.AddressService;
import service.AddressServiceImpl;
import service.UserService;
import service.UserServiceImpl;

public class AdminEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminEdit() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
//		HttpSession session = request.getSession();
//		session.removeAttribute("CurrentUser");
//		RequestDispatcher req = request.getRequestDispatcher("UserRegister.jsp?user=ADD");
//		req.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// String uName = (String) session.getAttribute("userName");
		String userId = request.getParameter("userId");
		UserService service = new UserServiceImpl();
		AddressService addService = new AddressServiceImpl();

		try {
			// to get details of paricular user
			List<User> userData = service.getUserDetails(userId);
			User user = userData.get(0);
			session.setAttribute("CurrentUser", user);
			List<Address> listAddress = addService.getAllAddress(Integer.parseInt(userId));
			session.setAttribute("AddressList", listAddress);
			RequestDispatcher req = request.getRequestDispatcher("UserRegister.jsp?user=adminEdit");
			req.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
