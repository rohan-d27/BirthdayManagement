package project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import project.entities.CustomerInfoTable;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerInfoTable, Integer> {
	@Query(value = "select * from customer_info_table where customer_username=:uname and customer_password=:pass", nativeQuery = true)
	List<CustomerInfoTable> validateCustomerQ(@Param(value = "uname") String uname, @Param(value = "pass") String pass);

	public List<CustomerInfoTable> findByUsername(String name);
}
