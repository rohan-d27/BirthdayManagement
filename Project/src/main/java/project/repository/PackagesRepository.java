package project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import project.entities.PackagesInfoTable;

@Repository
public interface PackagesRepository extends JpaRepository<PackagesInfoTable, Integer> {
	@Query(value = "select service_name from packages_s where package_name=:name", nativeQuery = true)
	public List<PackagesInfoTable> findBypackageName(@Param(value = "name") String name);
}
