package project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.entities.OrdersInfoTable;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersInfoTable, Integer> {

	public List<OrdersInfoTable> findByCustomerId(int id);
}
