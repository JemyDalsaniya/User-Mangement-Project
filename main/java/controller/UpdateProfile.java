package controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
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
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession session = request.getSession();
			// to get address list
			@SuppressWarnings("unchecked")
			List<Address> addList = (List<Address>) session.getAttribute("AddressList");
			UserService service = new UserServiceImpl();
			AddressService addservice = new AddressServiceImpl();
			// User user = new User();
			User user = (User) session.getAttribute("CurrentUser");
			Address address = new Address();

			Part file = request.getPart("img");
			if (file.getSize() == 0) {

				String base64Image = request.getParameter("oldImage");
				InputStream targetStream = new ByteArrayInputStream(base64Image.getBytes());
				InputStream is = Base64.getDecoder().wrap(targetStream);
				user.setUserProfile(is);

			} else {
				InputStream imgContent = file.getInputStream();
				user.setUserProfile(imgContent);
			}
			// to set the updated values
			user.setUserName(request.getParameter("name"));
			user.setUserEmail(request.getParameter("email"));
			user.setUserContact(request.getParameter("contact"));
			user.setUserGender(request.getParameter("gender"));
			user.setUserDOB(request.getParameter("dob"));
			String hobbies = "";
			String[] hobby = request.getParameterValues("options");
			for (int i = 0; i < hobby.length; i++) {
				hobbies += hobby[i] + ",";
			}
			String result = hobbies.substring(0, hobbies.length() - 1);
			user.setUserHobby(result);

			int id = service.updateProfile(user);

			String addrId[] = new String[addList.size()];
			for (int i = 0; i < addList.size(); i++) {
				addrId[i] = addList.get(i).getAddId();

			}
			String[] addressId = request.getParameterValues("addressId[]");
			List<String> addressIdList = Arrays.asList(addressId);
			String remove = "";
			for (int i = 0; i < addrId.length; i++) {
				if (!addressIdList.contains(addrId[i])) {
					remove += addrId[i] + " ";
				}
			}
			// to get the updated values
			String[] street = request.getParameterValues("address[]");
			String[] landmark = request.getParameterValues("landmark[]");
			String[] pincode = request.getParameterValues("pincode[]");
			String[] city = request.getParameterValues("city[]");
			String[] state = request.getParameterValues("state[]");

			int count = 0;
			while (count < street.length) {

				// to set the updated values
				address.setAddId(addressId[count]);
				address.setAddStreet(street[count]);
				address.setAddLandmark(landmark[count]);
				address.setAddCity(city[count]);
				address.setAddState(state[count]);
				address.setAddPincode(pincode[count]);
				address.setRemoveAddressId(remove);

				// update address function called
				addservice.updateAddress(address, id);
				logger.info("address values inside update servlet" + address);
				count++;
			}

			String uName = (String) session.getAttribute("userName");
			if (uName.equals("adminEdit")) {
				response.sendRedirect("AdminHomePage.jsp");

			} else if (uName.equals("userEdit")) {
				User userList = service.displaySpecificUser(user);
				session.setAttribute("specificUserData", userList);
				List<Address> listAddress = addservice.getAllAddress(id);
				session.setAttribute("AddressList", listAddress);
				// session.setAttribute("CurrentUser", user);
				// response.sendRedirect("UserHomePage.jsp");
				RequestDispatcher req = request.getRequestDispatcher("UserHomePage.jsp");
				req.include(request, response);
			} else if (uName.equals("admin")) {
				List<User> adminList = service.displayAdmin(user);
				session.setAttribute("adminList", adminList);
				List<Address> listAddress = addservice.getAllAddress(id);
				session.setAttribute("AddressList", listAddress);
				response.sendRedirect("AdminHomePage.jsp");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
