package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.entities.PackagesServicesTable;

@Repository
public interface PackagesServicesRepository extends JpaRepository<PackagesServicesTable, Integer> {

}
