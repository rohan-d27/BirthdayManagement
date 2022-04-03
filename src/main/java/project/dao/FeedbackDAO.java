package project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.entities.FeedbackTable;
import project.repository.FeedbackRepository;

@Repository
public class FeedbackDAO {

	@Autowired
	FeedbackRepository repo;

	public List<FeedbackTable> findAll() {

		return repo.findAll();
	}

	public void insertFeedback(FeedbackTable obj) {
		repo.save(obj);
	}

	public void updateFeedback(int id, String details) {
		FeedbackTable obj = repo.findById(id).get();

		obj.setFeedbackDetails(details);
		repo.save(obj);
	}

	public FeedbackTable getById(Integer id) {

		return repo.getById(id);
	}

	public Optional<FeedbackTable> findById(Integer id) {

		return repo.findById(id);
	}

	public void deleteById(Integer id) {
		repo.deleteById(id);

	}

	public void delete(FeedbackTable entity) {
		repo.delete(entity);

	}

	public void deleteAll() {
		repo.deleteAll();

	}

	public List<FeedbackTable> findByCustomerId(int id) {
		List<FeedbackTable> list = repo.findBycustomerInfoTable(id);
		return list;
	}
}
