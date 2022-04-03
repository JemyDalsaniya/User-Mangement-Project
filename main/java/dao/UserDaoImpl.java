package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Logger;

import model.User;
import utility.MyConnection;

public class UserDaoImpl implements UserDao {

	private static Logger logger = Logger.getLogger(UserDaoImpl.class.getName());

	Connection conn;

	public UserDaoImpl() {
		try {
			conn = MyConnection.getInstance().getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// implementation of user login
	@Override
	public boolean compareUserLogin(User user) {
		logger.info("User Data" + user.toString());
		try {
			PreparedStatement pstmt = conn.prepareStatement("select * from user where email=? and password = ?");
			pstmt.setString(1, user.getUserEmail());
			pstmt.setString(2, user.getUserPassword());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				boolean status = rs.getBoolean(10);
				user.setUserStatus(status);
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("name"));
				user.setUserPassword(rs.getString("password"));
				user.setUserContact(rs.getString("contact"));
				user.setUserGender(rs.getString("gender"));
				user.setUserHobby(rs.getString("hobby"));
				user.setUserDOB(rs.getString("dob"));
				Blob blob = rs.getBlob("profile_img");

				byte[] photo = blob.getBytes(1, (int) blob.length());
				String base64Image = Base64.getEncoder().encodeToString(photo);
				user.setBase64Image(base64Image);

				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// implementation of of user Registration
	@Override
	public int userRegister(User user) {
		int id = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"insert into user(name,email,password,contact,gender,hobby,dob,profile_img,isAdmin)values(?,?,?,?,?,?,?,?,0)");
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserEmail());
			pstmt.setString(3, user.getUserPassword());
			pstmt.setString(4, user.getUserContact());
			pstmt.setString(5, user.getUserGender());
			pstmt.setString(6, user.getUserHobby());
			pstmt.setString(7, user.getUserDOB());
			pstmt.setBlob(8, user.getUserProfile());

			pstmt.executeUpdate();
			PreparedStatement stmt = conn.prepareStatement("select user_id from user");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				id = rs.getInt("user_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;

	}

	// display user details on admin side
	@Override
	public List<User> displayUser(User user) throws SQLException {
		// TODO Auto-generated method stub

		List<User> list = new ArrayList<User>();
		PreparedStatement pstmt = conn.prepareStatement("select * from user where isAdmin=0");
		logger.info("User Data" + user.toString());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			user = new User();
			user.setUserId(rs.getInt("user_id"));
			user.setUserName(rs.getString("name"));
			user.setUserEmail(rs.getString("email"));
			user.setUserContact(rs.getString("contact"));
			user.setUserDOB(rs.getString("dob"));
			user.setUserGender(rs.getString("gender"));
			user.setUserHobby(rs.getString("hobby"));
			Blob blob = rs.getBlob("profile_img");

			byte[] photo = blob.getBytes(1, (int) blob.length());
			String base64Image = Base64.getEncoder().encodeToString(photo);
			user.setBase64Image(base64Image);
			list.add(user);
		}

		return list;
	}

	@Override
	public void deleteUser(String userId) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = conn.prepareStatement("delete from user where user_id=?");
		pstmt.setString(1, userId);
		pstmt.execute();

	}

	@Override
	public List<User> displayAdmin(User user) throws SQLException {
		List<User> list = new ArrayList<User>();
		PreparedStatement pstmt = conn.prepareStatement("select * from user where isAdmin=1");
		logger.info("User Data" + user.toString());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			user = new User();
			user.setUserId(rs.getInt("user_id"));
			user.setUserName(rs.getString("name"));
			user.setUserEmail(rs.getString("email"));
			user.setUserContact(rs.getString("contact"));
			user.setUserDOB(rs.getString("dob"));
			user.setUserGender(rs.getString("gender"));
			user.setUserHobby(rs.getString("hobby"));
			Blob blob = rs.getBlob("profile_img");

			byte[] photo = blob.getBytes(1, (int) blob.length());
			String base64Image = Base64.getEncoder().encodeToString(photo);
			user.setBase64Image(base64Image);
			list.add(user);
		}

		return list;
	}

	@Override
	public void updatePassword(User user) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement("UPDATE user SET password =? WHERE email = ?");
		pstmt.setString(1, user.getUserPassword());
		pstmt.setString(2, user.getUserEmail());
		pstmt.executeUpdate();

	}

	// Enhancement 2. change role of user to Admin
	@Override
	public void changeRole(String id) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = conn.prepareStatement("UPDATE user SET isAdmin = 1 WHERE user_id = ?");
		pstmt.setString(1, id);
		pstmt.executeUpdate();

	}

	@Override
	public List<User> displaySpecificUser(User user) throws SQLException {

		List<User> list = new ArrayList<User>();

		PreparedStatement pstmt = conn.prepareStatement("select * from user where email= ? and password = ?");
		pstmt.setString(1, user.getUserEmail());
		pstmt.setString(2, user.getUserPassword());
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			user = new User();
			user.setUserId(rs.getInt("user_id"));
			user.setUserName(rs.getString("name"));
			user.setUserEmail(rs.getString("email"));
			user.setUserContact(rs.getString("contact"));
			user.setUserDOB(rs.getString("dob"));
			user.setUserGender(rs.getString("gender"));
			Blob blob = rs.getBlob("profile_img");

			byte[] photo = blob.getBytes(1, (int) blob.length());
			String base64Image = Base64.getEncoder().encodeToString(photo);
			user.setBase64Image(base64Image);
			user.setUserHobby(rs.getString("hobby"));
			list.add(user);
		}

		return list;
	}

	@Override
	public void updateProfile(User user) {

		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE user SET name = ?,email=?,contact =?,gender=?,hobby=?,dob=?,profile_img=? WHERE user_id = ?");

			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserEmail());
			pstmt.setString(3, user.getUserContact());
			pstmt.setString(4, user.getUserGender());
			pstmt.setString(5, user.getUserHobby());
			pstmt.setString(6, user.getUserDOB());
			pstmt.setBlob(7, user.getUserProfile());
			pstmt.setInt(8, user.getUserId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
