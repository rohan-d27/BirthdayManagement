package project.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the service_provider_info_table database table.
 * 
 */
@Entity
@Table(name = "service_provider_info_table")
//@NamedQuery(name="ServiceProviderInfoTable.findAll", query="SELECT s FROM ServiceProviderInfoTable s")
public class ServiceProviderInfoTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "service_provider_id")
	private int serviceProviderId;

	@Column(name = "service_provider_address")
	private String serviceProviderAddress;

	@Column(name = "service_provider_city")
	private String serviceProviderCity;

	@Column(name = "service_provider_email")
	private String serviceProviderEmail;

	@Column(name = "service_provider_fname")
	private String serviceProviderFname;

	@Column(name = "service_provider_lname")
	private String serviceProviderLname;

	@Column(name = "service_provider_mobno")
	private String serviceProviderMobno;

	@Column(name = "service_provider_password")
	private String serviceProviderPassword;

	@Column(name = "service_provider_username")
	private String serviceProviderUsername;

	@Column(name = "service_provider_zipcode")
	private int serviceProviderZipcode;

	// bi-directional many-to-one association to ServicesInfoTable
	@OneToMany(mappedBy = "serviceProviderInfoTable")
	private List<ServicesInfoTable> servicesInfoTables;

	public ServiceProviderInfoTable() {
	}

	public int getServiceProviderId() {
		return this.serviceProviderId;
	}

	public void setServiceProviderId(int serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}

	public String getServiceProviderAddress() {
		return this.serviceProviderAddress;
	}

	public void setServiceProviderAddress(String serviceProviderAddress) {
		this.serviceProviderAddress = serviceProviderAddress;
	}

	public String getServiceProviderCity() {
		return this.serviceProviderCity;
	}

	public void setServiceProviderCity(String serviceProviderCity) {
		this.serviceProviderCity = serviceProviderCity;
	}

	public String getServiceProviderEmail() {
		return this.serviceProviderEmail;
	}

	public void setServiceProviderEmail(String serviceProviderEmail) {
		this.serviceProviderEmail = serviceProviderEmail;
	}

	public String getServiceProviderFname() {
		return this.serviceProviderFname;
	}

	public void setServiceProviderFname(String serviceProviderFname) {
		this.serviceProviderFname = serviceProviderFname;
	}

	public String getServiceProviderLname() {
		return this.serviceProviderLname;
	}

	public void setServiceProviderLname(String serviceProviderLname) {
		this.serviceProviderLname = serviceProviderLname;
	}

	public String getServiceProviderMobno() {
		return this.serviceProviderMobno;
	}

	public void setServiceProviderMobno(String serviceProviderMobno) {
		this.serviceProviderMobno = serviceProviderMobno;
	}

	public String getServiceProviderPassword() {
		return this.serviceProviderPassword;
	}

	public void setServiceProviderPassword(String serviceProviderPassword) {
		this.serviceProviderPassword = serviceProviderPassword;
	}

	public String getServiceProviderUsername() {
		return this.serviceProviderUsername;
	}

	public void setServiceProviderUsername(String serviceProviderUsername) {
		this.serviceProviderUsername = serviceProviderUsername;
	}

	public int getServiceProviderZipcode() {
		return this.serviceProviderZipcode;
	}

	public void setServiceProviderZipcode(int serviceProviderZipcode) {
		this.serviceProviderZipcode = serviceProviderZipcode;
	}

	public List<ServicesInfoTable> getServicesInfoTables() {
		return this.servicesInfoTables;
	}

	public void setServicesInfoTables(List<ServicesInfoTable> servicesInfoTables) {
		this.servicesInfoTables = servicesInfoTables;
	}

	public ServicesInfoTable addServicesInfoTable(ServicesInfoTable servicesInfoTable) {
		getServicesInfoTables().add(servicesInfoTable);
		servicesInfoTable.setServiceProviderInfoTable(this);

		return servicesInfoTable;
	}

	public ServicesInfoTable removeServicesInfoTable(ServicesInfoTable servicesInfoTable) {
		getServicesInfoTables().remove(servicesInfoTable);
		servicesInfoTable.setServiceProviderInfoTable(null);

		return servicesInfoTable;
	}

}