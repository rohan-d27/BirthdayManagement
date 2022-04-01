package project.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the services_info_table database table.
 * 
 */
@Entity
@Table(name = "services_info_table")
//@NamedQuery(name="ServicesInfoTable.findAll", query="SELECT s FROM ServicesInfoTable s")
public class ServicesInfoTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "service_id")
	private int serviceId;

	@Column(name = "service_desc")
	private String serviceDesc;

	@Lob
	@Column(name = "service_images")
	private byte[] serviceImages;

	@Column(name = "service_name")
	private String serviceName;

	@Column(name = "service_price")
	private double servicePrice;

	// bi-directional many-to-one association to CustomOrderTable
	@OneToMany(mappedBy = "servicesInfoTable")
	private List<CustomOrderTable> customOrderTables;

	// bi-directional many-to-many association to PackagesInfoTable
	@ManyToMany
	@JoinTable(name = "packages_services_table", joinColumns = {
			@JoinColumn(name = "service_id") }, inverseJoinColumns = { @JoinColumn(name = "package_id") })
	private List<PackagesInfoTable> packagesInfoTables;

	// bi-directional many-to-one association to ServiceProviderInfoTable
	@ManyToOne
	@JoinColumn(name = "service_provider_id")
	private ServiceProviderInfoTable serviceProviderInfoTable;

	public ServicesInfoTable() {
	}

	public int getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceDesc() {
		return this.serviceDesc;
	}

	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}

	public byte[] getServiceImages() {
		return this.serviceImages;
	}

	public void setServiceImages(byte[] serviceImages) {
		this.serviceImages = serviceImages;
	}

	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public double getServicePrice() {
		return this.servicePrice;
	}

	public void setServicePrice(double servicePrice) {
		this.servicePrice = servicePrice;
	}

	public List<CustomOrderTable> getCustomOrderTables() {
		return this.customOrderTables;
	}

	public void setCustomOrderTables(List<CustomOrderTable> customOrderTables) {
		this.customOrderTables = customOrderTables;
	}

	public CustomOrderTable addCustomOrderTable(CustomOrderTable customOrderTable) {
		getCustomOrderTables().add(customOrderTable);
		customOrderTable.setServicesInfoTable(this);

		return customOrderTable;
	}

	public CustomOrderTable removeCustomOrderTable(CustomOrderTable customOrderTable) {
		getCustomOrderTables().remove(customOrderTable);
		customOrderTable.setServicesInfoTable(null);

		return customOrderTable;
	}

	public List<PackagesInfoTable> getPackagesInfoTables() {
		return this.packagesInfoTables;
	}

	public void setPackagesInfoTables(List<PackagesInfoTable> packagesInfoTables) {
		this.packagesInfoTables = packagesInfoTables;
	}

	public ServiceProviderInfoTable getServiceProviderInfoTable() {
		return this.serviceProviderInfoTable;
	}

	public void setServiceProviderInfoTable(ServiceProviderInfoTable serviceProviderInfoTable) {
		this.serviceProviderInfoTable = serviceProviderInfoTable;
	}

}