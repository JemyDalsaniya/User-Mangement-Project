package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import model.Address;
import utility.MyConnection;

public class AddressDaoImpl implements AddressDao {

	private static Logger logger = Logger.getLogger(UserDaoImpl.class.getName());

	Connection conn;
	PreparedStatement pstmt;

	public AddressDaoImpl() {
		try {
			conn = MyConnection.getInstance().getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	// Add address in database
	@Override
	public void addAddress(int userId, Address address) {
		try {
			pstmt = conn.prepareStatement(
					"insert into address(street,landmark,pincode,city,state,user_id) values(?,?,?,?,?,?)");

			pstmt.setString(1, address.getAddStreet());
			pstmt.setString(2, address.getAddLandmark());
			pstmt.setString(3, address.getAddPincode());
			pstmt.setString(4, address.getAddCity());
			pstmt.setString(5, address.getAddState());
			pstmt.setInt(6, userId);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Address> getAllAddress(int userId) throws SQLException {
		List<Address> list = new ArrayList<Address>();

		pstmt = conn.prepareStatement("select * from address where user_id = ?");

		pstmt.setInt(1, userId);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Address address = new Address();
			address.setAddUserID(rs.getInt("user_id"));
			address.setAddId(rs.getString("address_id"));
			address.setAddStreet(rs.getString("street"));
			address.setAddLandmark(rs.getString("landmark"));
			address.setAddPincode(rs.getString("pincode"));
			address.setAddState(rs.getString("state"));
			address.setAddCity(rs.getString("city"));
			list.add(address);
		}

		return list;

	}

	public void deleteAddress(String addressId[]) {
		try {
			for (int counter = 0; counter < addressId.length; counter++) {
				pstmt = conn.prepareStatement("delete from address where address_id=?");
				pstmt.setString(1, addressId[counter]);
				pstmt.executeUpdate();
			}
		} catch (Exception e) {
			logger.info(e.toString());
		}

	}

	@Override
	public void updateAddress(Address address, int id) throws SQLException {

		// addAddress(id, address);
		// deleteAddress(id);
		if (address.getAddId().isEmpty()) {
			addAddress(id, address);
		}
		// to delete address
		String remove = address.getRemoveAddressId();
		String[] removeId = remove.split(" ");

		if (!remove.isEmpty()) {
			deleteAddress(removeId);
		}

		pstmt = conn.prepareStatement(
				"UPDATE address SET street = ?,landmark=?,pincode =?,city=?,state=? WHERE user_id = ? and address_id=?");
		pstmt.setString(1, address.getAddStreet());
		pstmt.setString(2, address.getAddLandmark());
		pstmt.setString(3, address.getAddPincode());
		pstmt.setString(4, address.getAddCity());
		pstmt.setString(5, address.getAddState());
		pstmt.setInt(6, id);
		pstmt.setString(7, address.getAddId());

		pstmt.executeUpdate();
		// logger.info("updated values inside address dao impl" + address);

	}

}
