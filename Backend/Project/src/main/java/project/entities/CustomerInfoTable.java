package project.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the customer_info_table database table.
 * 
 */
@Entity
@Table(name="customer_info_table")
//@NamedQuery(name="CustomerInfoTable.findAll", query="SELECT c FROM CustomerInfoTable c")
public class CustomerInfoTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="customer_id")
	private int customerId;

	@Column(name="customer_address")
	private String customerAddress;

	@Column(name="customer_city")
	private String customerCity;

	@Column(name="customer_email")
	private String customerEmail;

	@Column(name="customer_fname")
	private String customerFname;

	@Column(name="customer_lname")
	private String customerLname;

	@Column(name="customer_mobno")
	private String customerMobno;

	@Column(name="customer_password")
	private String customerPassword;

	@Column(name="customer_username")
	private String customerUsername;

	@Column(name="customer_zipcode")
	private int customerZipcode;

	//bi-directional many-to-one association to OrdersInfoTable
	@OneToMany(mappedBy="customerInfoTable")
	private List<OrdersInfoTable> ordersInfoTables;

	public CustomerInfoTable() {
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerAddress() {
		return this.customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerCity() {
		return this.customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public String getCustomerEmail() {
		return this.customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerFname() {
		return this.customerFname;
	}

	public void setCustomerFname(String customerFname) {
		this.customerFname = customerFname;
	}

	public String getCustomerLname() {
		return this.customerLname;
	}

	public void setCustomerLname(String customerLname) {
		this.customerLname = customerLname;
	}

	public String getCustomerMobno() {
		return this.customerMobno;
	}

	public void setCustomerMobno(String customerMobno) {
		this.customerMobno = customerMobno;
	}

	public String getCustomerPassword() {
		return this.customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerUsername() {
		return this.customerUsername;
	}

	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}

	public int getCustomerZipcode() {
		return this.customerZipcode;
	}

	public void setCustomerZipcode(int customerZipcode) {
		this.customerZipcode = customerZipcode;
	}

	public List<OrdersInfoTable> getOrdersInfoTables() {
		return this.ordersInfoTables;
	}

	public void setOrdersInfoTables(List<OrdersInfoTable> ordersInfoTables) {
		this.ordersInfoTables = ordersInfoTables;
	}

	public OrdersInfoTable addOrdersInfoTable(OrdersInfoTable ordersInfoTable) {
		getOrdersInfoTables().add(ordersInfoTable);
		ordersInfoTable.setCustomerInfoTable(this);

		return ordersInfoTable;
	}

	public OrdersInfoTable removeOrdersInfoTable(OrdersInfoTable ordersInfoTable) {
		getOrdersInfoTables().remove(ordersInfoTable);
		ordersInfoTable.setCustomerInfoTable(null);

		return ordersInfoTable;
	}

}