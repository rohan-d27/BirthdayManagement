package project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.entities.ServiceProviderInfoTable;
import project.repository.ServiceproviderRepository;

@Repository
public class ServiceProviderDAO {

	@Autowired
	ServiceproviderRepository repo;

	public ServiceProviderInfoTable validateServiceprovider(String uname, String pass) {
		List<ServiceProviderInfoTable> ls = repo.validateServiceProviderQ(uname, pass);

		if (ls.get(0) != null) {
			return ls.get(0);
		} else {
			return null;
		}
	}

	public void insertServiceProvider(ServiceProviderInfoTable obj) {
		repo.save(obj);
	}

	public void updateServiceProvider(int id, String fname, String lname, String mobno, String email, String address,
			String city, int zipcode, String uname, String password) {
		ServiceProviderInfoTable obj = repo.findById(id).get();
		obj.setServiceProviderFname(fname);
		obj.setServiceProviderLname(lname);
		obj.setServiceProviderEmail(email);
		obj.setServiceProviderMobno(mobno);
		obj.setServiceProviderAddress(address);
		obj.setServiceProviderCity(city);
		obj.setServiceProviderZipcode(zipcode);
		obj.setServiceProviderUsername(uname);
		obj.setServiceProviderPassword(password);
		repo.save(obj);
	}

	public List<ServiceProviderInfoTable> findAll() {

		return repo.findAll();
	}

	public ServiceProviderInfoTable getById(Integer id) {

		return repo.getById(id);
	}

	public Optional<ServiceProviderInfoTable> findById(Integer id) {

		return repo.findById(id);
	}

	public void deleteById(Integer id) {
		repo.deleteById(id);

	}

	public void delete(ServiceProviderInfoTable entity) {
		repo.delete(entity);

	}

	public void deleteAll() {
		repo.deleteAll();

	}

	public ServiceProviderInfoTable findbyUsername(String uname) {
		List<ServiceProviderInfoTable> list = repo.findByUsername(uname);
		ServiceProviderInfoTable sp = list.get(0);
		return sp;
	}
}
