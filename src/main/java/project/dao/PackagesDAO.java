package project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.entities.PackagesInfoTable;
import project.repository.PackagesRepository;

@Repository
public class PackagesDAO {

	@Autowired
	PackagesRepository repo;

	public List<PackagesInfoTable> findAll() {

		return repo.findAll();
	}

	public void insertPackage(PackagesInfoTable obj) {
		repo.save(obj);
	}

	public void updatePackage(int id, String name, String desc, double price) {
		PackagesInfoTable obj = repo.findById(id).get();
		obj.setPackageName(name);
		obj.setPackageDesc(desc);
		obj.setPackagePrice(price);

		repo.save(obj);
	}

	public PackagesInfoTable getById(Integer id) {

		return repo.getById(id);
	}

	public Optional<PackagesInfoTable> findById(Integer id) {

		return repo.findById(id);
	}

	public void deleteById(Integer id) {
		repo.deleteById(id);

	}

	public void delete(PackagesInfoTable entity) {
		repo.delete(entity);

	}

	public void deleteAll() {
		repo.deleteAll();

	}

}
