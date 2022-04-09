package utility;

import java.util.Map;

import model.User;

public class Validation {

	public void validateUserDetails(User user, Map<String, String> messages) {

		if (user.getUserName() == null || user.getUserName().isEmpty()) {
			messages.put("name", "Please enter Name!!");
		} else if (!user.getUserName().matches("^[a-zA-Z\\s]*$")) {
			messages.put("name", "Please enter alphabets only!!");
		}

		if (user.getUserEmail() == null || user.getUserEmail().trim().isEmpty()) {
			messages.put("email", "Please enter Email!!");
		} else if (!user.getUserEmail().matches("^([\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4})?$")) {
			messages.put("email", "Please enter valid emailId!!");
		}
//
//		if (user.getUserPassword() == null || user.getUserPassword().trim().isEmpty()) {
//			messages.put("password", "Please enter password!!");
//		}
//
//		if (!user.getUserGender().equals("male") && !user.getUserGender().equals("female")) {
//			messages.put("gender", "Please select gender!!");
//		}
//
//		if (user.getUserHobby() == null && user.getUserHobby().length() == 0) {
//			messages.put("hobby", "Please select Hobby!!");
//
//		}
//
		if (user.getUserContact() == null || user.getUserContact().trim().isEmpty()) {
			messages.put("contact", "Please enter contact!!");
		} else if (!user.getUserContact().matches("^[0-9]{10}$")) {
			messages.put("contact", "Please enter valid Contact!!");
		}
	}

}
