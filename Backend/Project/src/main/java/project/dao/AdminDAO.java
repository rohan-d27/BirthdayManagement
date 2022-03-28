package project.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.entities.AdminInfoTable;
import project.repository.AdminRepository;


@Repository
public class AdminDAO  {

	@Autowired
	AdminRepository repo;

	public List<AdminInfoTable> findAll() {

		return repo.findAll();
	}

	public AdminInfoTable validateAdmin(String uname,String pass)
	{
		List<AdminInfoTable>  ls=repo.validateAdminQ(uname,pass);

		if(ls.get(0)!=null)
		{
			return ls.get(0);
		}
		else {
			return null;
		}
	}

	public void insertAdmin(AdminInfoTable obj) 
	{		
		repo.save(obj);
	}

	public void updateAdmin(int id, String fname,String lname, String mobno,String email,String uname,String password) 
	{     
		AdminInfoTable obj= repo.findById(id).get();
		obj.setAdminFname(fname);
		obj.setAdminLname(lname);
		obj.setAdminEmail(email);
		obj.setAdminMobno(mobno);
		obj.setAdminUsername(uname);
		obj.setAdminPassword(password);
		repo.save(obj);	
	}

	public AdminInfoTable getById(Integer id) {

		return repo.getById(id);
	}



	public Optional<AdminInfoTable> findById(Integer id) {

		return repo.findById(id);
	}


	public void deleteById(Integer id) {
		repo.deleteById(id);

	}

	public void delete(AdminInfoTable entity) {
		repo.delete(entity);

	}


	public void deleteAll() {

		repo.deleteAll();
	}

}
