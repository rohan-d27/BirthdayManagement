package project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.entities.CustomerInfoTable;
import project.repository.CustomerRepository;

@Repository
public class CustomerDAO {
	@Autowired
	CustomerRepository repo;

	public CustomerInfoTable validateCustomer(String uname, String pass) {
		List<CustomerInfoTable> ls = repo.validateCustomerQ(uname, pass);

		if (ls.get(0) != null) {
			return ls.get(0);
		} else {
			return null;
		}
	}

	public void insertCustomer(CustomerInfoTable obj) {
		repo.save(obj);
	}

	public void updateCustomer(int id, String fname, String lname, String mobno, String email, String address,
			String city, int zipcode, String uname, String password) {
		CustomerInfoTable obj = repo.findById(id).get();
		obj.setCustomerFname(fname);
		obj.setCustomerLname(lname);
		obj.setCustomerMobno(mobno);
		obj.setCustomerEmail(email);
		obj.setCustomerAddress(address);
		obj.setCustomerCity(city);
		obj.setCustomerZipcode(zipcode);
		obj.setCustomerUsername(uname);
		obj.setCustomerPassword(password);
		repo.save(obj);
	}

	public List<CustomerInfoTable> findAll() {

		return repo.findAll();
	}

	public CustomerInfoTable getById(Integer id) {

		return repo.getById(id);
	}

	public Optional<CustomerInfoTable> findById(Integer id) {

		return repo.findById(id);
	}

	public void deleteById(Integer id) {
		repo.deleteById(id);

	}

	public void delete(CustomerInfoTable entity) {
		repo.delete(entity);

	}

	public void deleteAll() {
		repo.deleteAll();

	}

	public CustomerInfoTable findbyUsername(String uname) {
		List<CustomerInfoTable> list = repo.findBycustomerUsername(uname);
		CustomerInfoTable cs = list.get(0);
		return cs;
	}

	public CustomerInfoTable findbyEmail(String email) {
		List<CustomerInfoTable> list = repo.findBycustomerEmail(email);
		CustomerInfoTable cs = list.get(0);
		return cs;
	}
}
