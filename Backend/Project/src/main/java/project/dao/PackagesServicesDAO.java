package project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.entities.PackagesServicesTable;
import project.entities.PackagesServicesTablePK;
import project.repository.PackagesServicesRepository;

@Repository
public class PackagesServicesDAO {

	@Autowired
	PackagesServicesRepository repo;

	public List<PackagesServicesTable> findAll() {

		return repo.findAll();
	}

	public void insertPackagesServices(PackagesServicesTable obj) {
		repo.save(obj);
	}

	public void updatePackgesServices(PackagesServicesTable p, int serviceid) {
		PackagesServicesTablePK pst = p.getId();
		pst.setServiceId(serviceid);
		p.setId(pst);
		repo.save(p);
	}

	public PackagesServicesTable getById(Integer id) {

		return repo.getById(id);
	}

	public Optional<PackagesServicesTable> findById(Integer id) {

		return repo.findById(id);
	}

	public void deleteById(Integer id) {
		repo.deleteById(id);

	}

	public void delete(PackagesServicesTable entity) {
		repo.delete(entity);

	}

	public void deleteAll() {
		repo.deleteAll();

	}

}
