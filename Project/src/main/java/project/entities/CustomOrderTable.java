package project.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the custom_order_table database table.
 * 
 */
@Entity
@Table(name = "custom_order_table")
//@NamedQuery(name="CustomOrderTable.findAll", query="SELECT c FROM CustomOrderTable c")
public class CustomOrderTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CustomOrderTablePK id;

	// bi-directional many-to-one association to OrdersInfoTable
	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrdersInfoTable ordersInfoTable;

	public CustomOrderTable() {
	}

	// bi-directional many-to-one association to ServicesInfoTable
	@ManyToOne
	@JoinColumn(name = "service_id", insertable = false, updatable = false)
	private ServicesInfoTable servicesInfoTable;

	public CustomOrderTablePK getId() {
		return this.id;
	}

	public void setId(CustomOrderTablePK id) {
		this.id = id;
	}

	public OrdersInfoTable getOrdersInfoTable() {
		return this.ordersInfoTable;
	}

	public void setOrdersInfoTable(OrdersInfoTable ordersInfoTable) {
		this.ordersInfoTable = ordersInfoTable;
	}

	public ServicesInfoTable getServicesInfoTable() {
		return this.servicesInfoTable;
	}

	public void setServicesInfoTable(ServicesInfoTable servicesInfoTable) {
		this.servicesInfoTable = servicesInfoTable;
	}

}