package controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.UserDaoImpl;
import model.Address;
import model.User;
import service.AddressService;
import service.AddressServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import utility.EncryptionFile;

@MultipartConfig
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(UserDaoImpl.class.getName());

	public UpdateProfile() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			// to get address list
			List<Address> addList = (List<Address>) session.getAttribute("AddressList");
			UserService service = new UserServiceImpl();
			AddressService addservice = new AddressServiceImpl();
			User user = new User();
			Address address = new Address();
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
				System.out.println("inside if condition");

				String base64Image = request.getParameter("oldImage");
				InputStream targetStream = new ByteArrayInputStream(base64Image.getBytes());
				InputStream is = Base64.getDecoder().wrap(targetStream);
				user.setUserProfile(is);

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
			int id = service.updateProfile(user);
			logger.info("id" + id);

			/*
			 * int addId[] = new int[addList.size()]; for (int i = 0; i < addList.size();
			 * i++) { addId[i] = addList.get(i).getAddId(); }
			 */
			String[] addressId = request.getParameterValues("addressId[]");
			String[] street = request.getParameterValues("address[]");
			String[] landmark = request.getParameterValues("landmark[]");
			String[] pincode = request.getParameterValues("pincode[]");
			String[] city = request.getParameterValues("city[]");
			String[] state = request.getParameterValues("state[]");

			int count = 0;
			while (count < street.length) {
				// addobj.setAddUserID();
				address.setAddId(addressId[count]);
				address.setAddStreet(street[count]);
				address.setAddLandmark(landmark[count]);
				address.setAddCity(city[count]);
				address.setAddState(state[count]);
				address.setAddPincode(pincode[count]);

				addservice.updateAddress(address, id);
				logger.info("address values inside update servlet" + address);
				// addservice.addAddress(id, addobj);
				count++;
			}

			logger.info("values inside update servlet" + user);
			String uName = (String) session.getAttribute("Name");
			if (uName.equals("adminEdit")) {
				response.sendRedirect("AdminHomePage.jsp");
			} else if (uName.equals("userEdit")) {
				response.sendRedirect("UserHomePage.jsp");
			} else {
				response.sendRedirect("Userlogin.jsp");
			}

//		RequestDispatcher req = request.getRequestDispatcher("/Userlogin.jsp");
//		req.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
