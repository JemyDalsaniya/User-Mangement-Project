package model;

import java.io.FileInputStream;
import java.io.InputStream;

public class User {

	private int userId;

	// Name of user
	private String userName;
	// Email of user
	private String userEmail;
	// Password of user
	private String userPassword;
	private String userContact;
	private String userGender;
	private String userHobby;
	private String userDOB;
	private InputStream userProfile;
	private String base64Image;
	private FileInputStream defaultProfile;
	private Boolean userStatus;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserContact() {
		return userContact;
	}

	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserHobby() {
		return userHobby;
	}

	public void setUserHobby(String userHobby) {
		this.userHobby = userHobby;
	}

	public String getUserDOB() {
		return userDOB;
	}

	public void setUserDOB(String userDOB) {
		this.userDOB = userDOB;
	}

	public InputStream getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(InputStream userProfile) {
		this.userProfile = userProfile;
	}

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	public FileInputStream getDefaultProfile() {
		return defaultProfile;
	}

	public void setDefaultProfile(FileInputStream defaultProfile) {
		this.defaultProfile = defaultProfile;
	}

	public Boolean getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Boolean userStatus) {
		this.userStatus = userStatus;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", userContact=" + userContact + ", userGender=" + userGender + ", userHobby="
				+ userHobby + ", userDOB=" + userDOB + ", userProfile=" + userProfile + ", defaultProfile="
				+ defaultProfile + ", userStatus=" + userStatus + "]";
	}

}
