package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.entities.OrdersInfoTable;
@Repository
public interface OrdersRepository extends JpaRepository<OrdersInfoTable, Integer> {

}
