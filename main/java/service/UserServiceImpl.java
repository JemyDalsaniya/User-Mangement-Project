package service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dao.UserDao;
import dao.UserDaoImpl;
import model.User;

public class UserServiceImpl implements UserService {

	UserDao object = new UserDaoImpl();

	// method of userDaoImpl called..
	@Override
	public boolean compareUserLogin(User user) {
		boolean obj = object.compareUserLogin(user);
		return obj;
	}

	// method of userDaoImpl called..
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
	public void validateUserDetails(User user, Map<String, String> messages) {

	}

	@Override
	public List<User> displaySpecificUser(User user) throws SQLException {
		System.out.println("list inside user service impl....");
		List<User> list = object.displaySpecificUser(user);
		System.out.println("list inside user service impl" + list);
		return list;
	}

	@Override
	public void updateProfile(User user) {
		object.updateProfile(user);
	}

}
