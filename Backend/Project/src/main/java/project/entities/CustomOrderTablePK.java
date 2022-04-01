package project.entities;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * The primary key class for the custom_order_table database table.
 * 
 */
//@Embeddable
public class CustomOrderTablePK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "custom_order_id")
	private int customOrderId;

	@Column(name = "service_id", insertable = false, updatable = false)
	private int serviceId;

	public CustomOrderTablePK() {
	}

	public int getCustomOrderId() {
		return this.customOrderId;
	}

	public void setCustomOrderId(int customOrderId) {
		this.customOrderId = customOrderId;
	}

	public int getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CustomOrderTablePK)) {
			return false;
		}
		CustomOrderTablePK castOther = (CustomOrderTablePK) other;
		return (this.customOrderId == castOther.customOrderId) && (this.serviceId == castOther.serviceId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.customOrderId;
		hash = hash * prime + this.serviceId;

		return hash;
	}
}