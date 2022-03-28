package project.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.entities.ServicesInfoTable;
import project.repository.ServicesRepository;

@Repository
public class ServicesDAO {

	@Autowired
	ServicesRepository repo;
	public List<ServicesInfoTable> findAll() {

		return repo.findAll();
	}

	public void insertServices(ServicesInfoTable obj) 
	{		
		repo.save(obj);
	}

	public void updateServices(int id,String name,String desc,int serviceproviderid,double price,byte[] image ) 
	{     
		ServicesInfoTable obj= repo.findById(id).get();
	
		obj.setServiceName(name);
		obj.setServiceDesc(desc);
		obj.setServicePrice(price);
		obj.getServiceImages();
		//obj.setServiceProviderInfoTable(null);
		
		repo.save(obj);	
	}
	
	
	public ServicesInfoTable getById(Integer id) {

		return repo.getById(id);
	}

	public Optional<ServicesInfoTable> findById(Integer id) {

		return repo.findById(id);
	}

	public void deleteById(Integer id) {
		repo.deleteById(id);

	}

	public void delete(ServicesInfoTable entity) {
		repo.delete(entity);

	}

	public void deleteAll() {
		repo.deleteAll();

	}

}
