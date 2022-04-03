package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Address;
import utility.MyConnection;

public class AddressDaoImpl implements AddressDao {

	Connection conn;

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
			PreparedStatement pstmt = conn.prepareStatement(
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

}
