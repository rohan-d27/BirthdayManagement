package project.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.entities.CustomOrderTable;
import project.repository.CustomOrderRepository;
@Repository
public class CustomOrderDAO {

	@Autowired
	CustomOrderRepository repo;
	public List<CustomOrderTable> findAll() {

		return repo.findAll();
	}

	public void insertCustomOrder(CustomOrderTable obj) 
	{		
		repo.save(obj);
	}

	
	public CustomOrderTable getById(Integer id) {

		return repo.getById(id);
	}

	public Optional<CustomOrderTable> findById(Integer id) {

		return repo.findById(id);
	}

	public void deleteById(Integer id) {
		repo.deleteById(id);

	}

	public void delete(CustomOrderTable entity) {
		repo.delete(entity);

	}

	public void deleteAll() {
		repo.deleteAll();

	}

}
