package project.entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the orders_info_table database table.
 * 
 */
@Entity
@Table(name = "orders_info_table")
//@NamedQuery(name="OrdersInfoTable.findAll", query="SELECT o FROM OrdersInfoTable o")
public class OrdersInfoTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "order_id")
	private int orderId;

	@Temporal(TemporalType.DATE)
	@Column(name = "event_date")
	private Date eventDate;

	@Column(name = "event_time")
	private Time eventTime;

	@Column(name = "event_venue")
	private String eventVenue;

	@Column(name = "number_of_guests")
	private int numberOfGuests;

	@Column(name = "order_amount")
	private double orderAmount;

	@Temporal(TemporalType.DATE)
	@Column(name = "order_date")
	private Date orderDate;

	@Column(name = "order_status")
	private String orderStatus;

	// bi-directional many-to-one association to CustomOrderTable
	@OneToMany(mappedBy = "ordersInfoTable")
	private List<CustomOrderTable> customOrderTables;

	// bi-directional many-to-one association to CustomerInfoTable
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private CustomerInfoTable customerInfoTable;

	// bi-directional many-to-one association to PackagesInfoTable
	@ManyToOne
	@JoinColumn(name = "package_id")
	private PackagesInfoTable packagesInfoTable;

	public OrdersInfoTable() {
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getEventDate() {
		return this.eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public Time getEventTime() {
		return this.eventTime;
	}

	public void setEventTime(Time eventTime) {
		this.eventTime = eventTime;
	}

	public String getEventVenue() {
		return this.eventVenue;
	}

	public void setEventVenue(String eventVenue) {
		this.eventVenue = eventVenue;
	}

	public int getNumberOfGuests() {
		return this.numberOfGuests;
	}

	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	public double getOrderAmount() {
		return this.orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<CustomOrderTable> getCustomOrderTables() {
		return this.customOrderTables;
	}

	public void setCustomOrderTables(List<CustomOrderTable> customOrderTables) {
		this.customOrderTables = customOrderTables;
	}

	public CustomOrderTable addCustomOrderTable(CustomOrderTable customOrderTable) {
		getCustomOrderTables().add(customOrderTable);
		customOrderTable.setOrdersInfoTable(this);

		return customOrderTable;
	}

	public CustomOrderTable removeCustomOrderTable(CustomOrderTable customOrderTable) {
		getCustomOrderTables().remove(customOrderTable);
		customOrderTable.setOrdersInfoTable(null);

		return customOrderTable;
	}

	public CustomerInfoTable getCustomerInfoTable() {
		return this.customerInfoTable;
	}

	public void setCustomerInfoTable(CustomerInfoTable customerInfoTable) {
		this.customerInfoTable = customerInfoTable;
	}

	public PackagesInfoTable getPackagesInfoTable() {
		return this.packagesInfoTable;
	}

	public void setPackagesInfoTable(PackagesInfoTable packagesInfoTable) {
		this.packagesInfoTable = packagesInfoTable;
	}

}