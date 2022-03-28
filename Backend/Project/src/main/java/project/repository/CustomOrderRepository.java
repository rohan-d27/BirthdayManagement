package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.entities.CustomOrderTable;


@Repository
public interface CustomOrderRepository extends JpaRepository<CustomOrderTable, Integer> {

}
