package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.entities.FeedbackTable;
@Repository
public interface FeedbackRepository  extends JpaRepository<FeedbackTable, Integer>{

}
