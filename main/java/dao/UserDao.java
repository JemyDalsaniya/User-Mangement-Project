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
	boolean compareUserLogin(User user);

	/**
	 * 
	 * @param user
	 * @return
	 */
	int userRegister(User user);

	/**
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	List<User> displayUser(User user) throws SQLException;

	/**
	 * 
	 * @param userId
	 * @throws SQLException
	 */
	void deleteUser(String userId) throws SQLException;

	/**
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	List<User> displayAdmin(User user) throws SQLException;

	/**
	 * 
	 * @param user
	 * @throws SQLException
	 */
	void updatePassword(User user) throws SQLException;

	/**
	 * 
	 * @param id
	 * @throws SQLException
	 */
	void changeRole(String id) throws SQLException;

	/**
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	User displaySpecificUser(User user) throws SQLException;

	/**
	 * 
	 * @param user
	 * @return
	 */
	int updateProfile(User user);

	/**
	 * 
	 * @param email
	 * @return
	 */
	boolean checkMail(String email);

	/**
	 * 
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	List<User> getUserDetails(String userId) throws SQLException;

}
