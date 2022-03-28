package project.entities;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the admin_info_table database table.
 * 
 */
@Entity
@Table(name="admin_info_table")
//@NamedQuery(name="AdminInfoTable.findAll", query="SELECT a FROM AdminInfoTable a")
public class AdminInfoTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="admin_id")
	private int adminId;

	@Column(name="admin_email")
	private String adminEmail;

	@Column(name="admin_fname")
	private String adminFname;

	@Column(name="admin_lname")
	private String adminLname;

	@Column(name="admin_mobno")
	private String adminMobno;

	@Column(name="admin_password")
	private String adminPassword;

	@Column(name="admin_username")
	private String adminUsername;

	public AdminInfoTable() {
	}

	public int getAdminId() {
		return this.adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminEmail() {
		return this.adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminFname() {
		return this.adminFname;
	}

	public void setAdminFname(String adminFname) {
		this.adminFname = adminFname;
	}

	public String getAdminLname() {
		return this.adminLname;
	}

	public void setAdminLname(String adminLname) {
		this.adminLname = adminLname;
	}

	public String getAdminMobno() {
		return this.adminMobno;
	}

	public void setAdminMobno(String adminMobno) {
		this.adminMobno = adminMobno;
	}

	public String getAdminPassword() {
		return this.adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminUsername() {
		return this.adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

}