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
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		HttpSession session = request.getSession();
		UserService service = new UserServiceImpl();
		AddressService addService = new AddressServiceImpl();

		try {
			List<User> userData = service.getUserDetails(userId);
			System.out.println("user Data:" + userData);
			User user = userData.get(0);
			System.out.println("value in user object:" + user);
			session.setAttribute("CurrentUser", user);
			List<Address> listAddress = addService.getAllAddress(Integer.parseInt(userId));
			System.out.println("Addresslist:" + listAddress);
			session.setAttribute("AddressList", listAddress);
			RequestDispatcher req = request.getRequestDispatcher("UserRegister.jsp?profile=adminEdit");
			req.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
