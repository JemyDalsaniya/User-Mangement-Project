package model;

public class Address {

	private int addId;
	private int addUserID;
	private String addPincode;
	private String addStreet;
	private String addLandmark;
	private String addCity;
	private String addState;

	public int getAddId() {
		return addId;
	}

	public void setAddId(int addId) {
		this.addId = addId;
	}

	public String getAddPincode() {
		return addPincode;
	}

	public void setAddPincode(String pincode) {
		this.addPincode = pincode;
	}

	public int getAddUserID() {
		return addUserID;
	}

	public void setAddUserID(int addUserID) {
		this.addUserID = addUserID;
	}

	public String getAddStreet() {
		return addStreet;
	}

	public void setAddStreet(String addStreet) {
		this.addStreet = addStreet;
	}

	public String getAddLandmark() {
		return addLandmark;
	}

	public void setAddLandmark(String addLandmark) {
		this.addLandmark = addLandmark;
	}

	public String getAddCity() {
		return addCity;
	}

	public void setAddCity(String addCity) {
		this.addCity = addCity;
	}

	public String getAddState() {
		return addState;
	}

	public void setAddState(String addState) {
		this.addState = addState;
	}

	@Override
	public String toString() {
		return "Address [addId=" + addId + ", addUserID=" + addUserID + ", addPincode=" + addPincode + ", addStreet="
				+ addStreet + ", addLandmark=" + addLandmark + ", addCity=" + addCity + ", addState=" + addState + "]";
	}

}
