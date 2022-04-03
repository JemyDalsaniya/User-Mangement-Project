package service;

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
}
