package service;

import model.Address;

public interface AddressService {

	/**
	 * 
	 * @param userId
	 * @param address
	 * @return
	 */
	public void addAddress(int userId, Address address);

}
