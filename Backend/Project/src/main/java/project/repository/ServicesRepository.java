package project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.entities.ServicesInfoTable;

@Repository
public interface ServicesRepository extends JpaRepository<ServicesInfoTable, Integer> {
	public List<ServicesInfoTable> findByServiceProviderId(int id);
}
