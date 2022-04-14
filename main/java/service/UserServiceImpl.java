package service;

import java.sql.SQLException;
import java.util.List;

import dao.UserDao;
import dao.UserDaoImpl;
import model.User;

public class UserServiceImpl implements UserService {

	UserDao object = new UserDaoImpl();

	@Override
	public boolean compareUserLogin(User user) {
		boolean obj = object.compareUserLogin(user);
		return obj;
	}

	@Override
	public int userRegister(User user) {
		int id = object.userRegister(user);
		return id;
	}

	@Override
	public List<User> displayUser(User user) throws SQLException {
		System.out.println("inside user service impl");

		List<User> list = object.displayUser(user);
		return list;
	}

	@Override
	public void deleteUser(String userId) throws SQLException {
		object.deleteUser(userId);

	}

	@Override
	public List<User> displayAdmin(User user) throws SQLException {
		System.out.println("method called");
		List<User> list = object.displayAdmin(user);
		return list;
	}

	@Override
	public void updatePassword(User user) throws SQLException {
		object.updatePassword(user);
	}

	@Override
	public void changeRole(String id) throws SQLException {
		System.out.println("user service change role method called");
		object.changeRole(id);
	}

	@Override
	public User displaySpecificUser(User user) throws SQLException {

		UserDao obj = new UserDaoImpl();
		System.out.print("in service " + obj.displaySpecificUser(user));
		return obj.displaySpecificUser(user);

	}

	@Override
	public int updateProfile(User user) {
		int id = object.updateProfile(user);
		return id;
	}

	@Override
	public boolean checkMail(String email) {
		boolean obj = object.checkMail(email);
		return obj;
	}

	@Override
	public List<User> getUserDetails(String userId) throws SQLException {
		List<User> list = object.getUserDetails(userId);
		return list;
	}

}
