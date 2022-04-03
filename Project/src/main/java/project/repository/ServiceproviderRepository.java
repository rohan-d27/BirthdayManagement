package project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import project.entities.ServiceProviderInfoTable;

@Repository
public interface ServiceproviderRepository extends JpaRepository<ServiceProviderInfoTable, Integer> {
	@Query(value = "select * from service_provider_info_table where service_provider_username=:uname and service_provider_password=:pass", nativeQuery = true)
	List<ServiceProviderInfoTable> validateServiceProviderQ(@Param(value = "uname") String uname,
			@Param(value = "pass") String pass);

	public List<ServiceProviderInfoTable> findByserviceProviderUsername(String serviceProviderUsername);

	public List<ServiceProviderInfoTable> findByserviceProviderEmail(String serviceProviderEmail);
}
