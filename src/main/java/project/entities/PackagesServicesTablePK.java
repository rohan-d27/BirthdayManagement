package project.entities;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * The primary key class for the packages_services_table database table.
 * 
 */
//@Embeddable
public class PackagesServicesTablePK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "package_id", insertable = false, updatable = false)
	private int packageId;

	@Column(name = "service_id", insertable = false, updatable = false)
	private int serviceId;

	public PackagesServicesTablePK() {
	}

	public int getPackageId() {
		return this.packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
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
		if (!(other instanceof PackagesServicesTablePK)) {
			return false;
		}
		PackagesServicesTablePK castOther = (PackagesServicesTablePK) other;
		return (this.packageId == castOther.packageId) && (this.serviceId == castOther.serviceId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.packageId;
		hash = hash * prime + this.serviceId;

		return hash;
	}
}