package project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import project.entities.FeedbackTable;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedbackTable, Integer> {

	@Query(value = "select * from feedback_table natural join orders_info_table where customer_id=:id", nativeQuery = true)
	public List<FeedbackTable> findBycustomerInfoTable(@Param(value = "id") int id);

}
