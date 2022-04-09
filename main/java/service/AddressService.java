package service;

import java.sql.SQLException;
import java.util.List;

import model.Address;

public interface AddressService {

	/**
	 * 
	 * @param userId
	 * @param address
	 * @return
	 */
	public void addAddress(int userId, Address address);

	public List<Address> getAllAddress(Address address, int userId) throws SQLException;

	/**
	 * 
	 * @param address
	 * @param email
	 * @throws SQLException
	 */
	public void updateAddress(Address address, int id) throws SQLException;

}
