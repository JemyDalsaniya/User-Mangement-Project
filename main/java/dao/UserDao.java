package dao;

import java.sql.SQLException;
import java.util.List;

import model.User;

public interface UserDao {

	/**
	 * 
	 * @param user
	 * @return
	 */
	public boolean compareUserLogin(User user);

	/**
	 * 
	 * @param user
	 * @return
	 */
	public int userRegister(User user);

	/**
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public List<User> displayUser(User user) throws SQLException;

	/**
	 * 
	 * @param userId
	 * @throws SQLException
	 */
	public void deleteUser(String userId) throws SQLException;

	/**
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public List<User> displayAdmin(User user) throws SQLException;

	/**
	 * 
	 * @param user
	 * @throws SQLException
	 */
	public void updatePassword(User user) throws SQLException;

	/**
	 * 
	 * @param id
	 * @throws SQLException
	 */
	public void changeRole(String id) throws SQLException;

	/**
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public List<User> displaySpecificUser(User user) throws SQLException;

	/**
	 * 
	 * @param user
	 * @return
	 */
	public int updateProfile(User user);

	/**
	 * 
	 * @param email
	 * @return
	 */
	public boolean checkMail(String email);

	/**
	 * 
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public List<User> getUserDetails(String userId) throws SQLException;

}
