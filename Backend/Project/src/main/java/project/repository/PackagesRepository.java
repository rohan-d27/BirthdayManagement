package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.entities.PackagesInfoTable;

@Repository
public interface PackagesRepository extends JpaRepository<PackagesInfoTable, Integer> {

}
