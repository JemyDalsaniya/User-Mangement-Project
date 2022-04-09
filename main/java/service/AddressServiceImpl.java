package service;

import java.sql.SQLException;
import java.util.List;

import dao.AddressDao;
import dao.AddressDaoImpl;
import model.Address;

public class AddressServiceImpl implements AddressService {

	AddressDao addressdao = new AddressDaoImpl();

	@Override
	public void addAddress(int userId, Address address) {
		System.out.println("add address method called inside user service impl..");
		addressdao.addAddress(userId, address);

	}

	@Override
	public void updateAddress(Address address, int id) throws SQLException {
		addressdao.updateAddress(address, id);
	}

	@Override
	public List<Address> getAllAddress(Address address, int userId) throws SQLException {
		List<Address> list = addressdao.getAllAddress(address, userId);
		return list;
	}
}
