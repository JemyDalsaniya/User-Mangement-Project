package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Address;
import model.User;
import service.AddressService;
import service.AddressServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import utility.EncryptionFile;
import utility.MyConnection;

@MultipartConfig
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserRegister() {
		super();
	}

	Connection conn;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// create connection
		try {
			conn = MyConnection.getInstance().getConnection();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
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
		Map<String, String> messages = new HashMap<String, String>();
		request.setAttribute("messages", messages);

		EncryptionFile ee = null;
		try {
			ee = new EncryptionFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Part file = request.getPart("img");
		System.out.println("val file:" + file.getSize());
		if (file.getSize() == 0) {

			InputStream fis = new FileInputStream("C:/Users/JEMMY/Desktop/default_profile.jpg");
			System.out.println("value fis:" + fis);
			user.setUserProfile(fis);
		} else {
			InputStream imgContent = file.getInputStream();
			user.setUserProfile(imgContent);
		}

		user.setUserName(request.getParameter("name"));
		user.setUserEmail(request.getParameter("email"));
		user.setUserContact(request.getParameter("contact"));
		user.setUserGender(request.getParameter("gender"));
		user.setUserDOB(request.getParameter("dob"));

		String hobbies = "";
		String[] hobby = request.getParameterValues("options");
		for (int i = 0; i < hobby.length; i++) {
			hobbies += hobby[i] + " ";
		}
		user.setUserHobby(hobbies);

		String encrypt_pwd = ee.encrypt(request.getParameter("password"));
		user.setUserPassword(encrypt_pwd);
		int id = service.userRegister(user);

		String[] street = request.getParameterValues("address[]");
		String[] landmark = request.getParameterValues("landmark[]");
		String[] pincode = request.getParameterValues("pincode[]");
		String[] city = request.getParameterValues("city[]");
		String[] state = request.getParameterValues("state[]");

		int count = 0;
		while (count < street.length) {
			Address addobj = new Address();
			// addobj.setAddUserID();
			addobj.setAddStreet(street[count]);
			addobj.setAddLandmark(landmark[count]);
			addobj.setAddCity(city[count]);
			addobj.setAddState(state[count]);
			addobj.setAddPincode(pincode[count]);

			addservice.addAddress(id, addobj);
			count++;
		}
		RequestDispatcher req = request.getRequestDispatcher("/Userlogin.jsp");
		req.forward(request, response);
	}
}
