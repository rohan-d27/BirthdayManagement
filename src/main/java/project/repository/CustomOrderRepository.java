package project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import project.entities.CustomOrderTable;
import project.entities.ServicesInfoTable;

@Repository
public interface CustomOrderRepository extends JpaRepository<CustomOrderTable, Integer> {
	@Query(value = "select * from custom_order_table where order_id=:id", nativeQuery = true)
	public List<ServicesInfoTable> findByORderId(@Param(value = "id") int id);
}
