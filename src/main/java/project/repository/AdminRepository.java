package project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import project.entities.AdminInfoTable;

@Repository
public interface AdminRepository extends JpaRepository<AdminInfoTable, Integer> {
	@Query(value = "select * from admin_info_table where admin_username=:uname and admin_password=:pass", nativeQuery = true)
	List<AdminInfoTable> validateAdminQ(@Param(value = "uname") String uname, @Param(value = "pass") String pass);

	public List<AdminInfoTable> findByadminUsername(String adminUsername);

	public List<AdminInfoTable> findByadminEmail(String adminEmail);
}
