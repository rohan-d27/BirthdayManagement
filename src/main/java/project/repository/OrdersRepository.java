package project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import project.entities.OrdersInfoTable;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersInfoTable, Integer> {

	public List<OrdersInfoTable> findBycustomerInfoTable(int id);

	@Query(value = "select * from orders_info_table where customer_id=:id", nativeQuery = true)
	public List<OrdersInfoTable> findByCustomerId(@Param(value = "id") int id);
	
	@Query(value = "select orders_info_table.* from project_db.orders_info_table natural join services_info_table where service_provider_id=:id",nativeQuery = true)
	public  List<OrdersInfoTable> findByServiceProvidersId(@Param(value = "id") int id);
}
