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

	/**
	 * 
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public List<Address> getAllAddress(int userId) throws SQLException;

	/**
	 * 
	 * @param address
	 * @param id
	 * @throws SQLException
	 */
	public void updateAddress(Address address, int id) throws SQLException;
}
