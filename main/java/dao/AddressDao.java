package dao;

import model.Address;

public interface AddressDao {

	/**
	 * 
	 * @param userId
	 * @param address
	 * @return
	 */
	public void addAddress(int userId, Address address);
}
