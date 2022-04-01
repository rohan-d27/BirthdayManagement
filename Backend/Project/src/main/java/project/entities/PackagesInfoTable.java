package project.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the packages_info_table database table.
 * 
 */
@Entity
@Table(name = "packages_info_table")
//@NamedQuery(name="PackagesInfoTable.findAll", query="SELECT p FROM PackagesInfoTable p")
public class PackagesInfoTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "package_id")
	private int packageId;

	@Column(name = "package_desc")
	private String packageDesc;

	@Column(name = "package_name")
	private String packageName;

	@Column(name = "package_price")
	private double packagePrice;

	// bi-directional many-to-one association to OrdersInfoTable
	@OneToMany(mappedBy = "packagesInfoTable")
	private List<OrdersInfoTable> ordersInfoTables;

	// bi-directional many-to-many association to ServicesInfoTable
	@ManyToMany(mappedBy = "packagesInfoTables")
	private List<ServicesInfoTable> servicesInfoTables;

	public PackagesInfoTable() {
	}

	public int getPackageId() {
		return this.packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public String getPackageDesc() {
		return this.packageDesc;
	}

	public void setPackageDesc(String packageDesc) {
		this.packageDesc = packageDesc;
	}

	public String getPackageName() {
		return this.packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public double getPackagePrice() {
		return this.packagePrice;
	}

	public void setPackagePrice(double packagePrice) {
		this.packagePrice = packagePrice;
	}

	public List<OrdersInfoTable> getOrdersInfoTables() {
		return this.ordersInfoTables;
	}

	public void setOrdersInfoTables(List<OrdersInfoTable> ordersInfoTables) {
		this.ordersInfoTables = ordersInfoTables;
	}

	public OrdersInfoTable addOrdersInfoTable(OrdersInfoTable ordersInfoTable) {
		getOrdersInfoTables().add(ordersInfoTable);
		ordersInfoTable.setPackagesInfoTable(this);

		return ordersInfoTable;
	}

	public OrdersInfoTable removeOrdersInfoTable(OrdersInfoTable ordersInfoTable) {
		getOrdersInfoTables().remove(ordersInfoTable);
		ordersInfoTable.setPackagesInfoTable(null);

		return ordersInfoTable;
	}

	public List<ServicesInfoTable> getServicesInfoTables() {
		return this.servicesInfoTables;
	}

	public void setServicesInfoTables(List<ServicesInfoTable> servicesInfoTables) {
		this.servicesInfoTables = servicesInfoTables;
	}

}