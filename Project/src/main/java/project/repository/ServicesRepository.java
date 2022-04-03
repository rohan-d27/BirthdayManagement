package project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import project.entities.ServicesInfoTable;

@Repository
public interface ServicesRepository extends JpaRepository<ServicesInfoTable, Integer> {
	public List<ServicesInfoTable> findByserviceProviderInfoTable(int id);

	@Query(value = "select services_info_table.* from packages_services_table natural join services_info_table where package_id=:id", nativeQuery = true)
	public List<ServicesInfoTable> findBypackageId(@Param(value = "id") int id);
}
