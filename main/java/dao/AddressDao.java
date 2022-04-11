package dao;

import java.sql.SQLException;
import java.util.List;

import model.Address;

public interface AddressDao {

	/**
	 * 
	 * @param userId
	 * @param address
	 * @return
	 */
	public void addAddress(int userId, Address address);

	public List<Address> getAllAddress(int userId) throws SQLException;

	public void updateAddress(Address address, int id) throws SQLException;
}
