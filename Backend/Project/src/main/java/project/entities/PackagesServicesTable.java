package project.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The persistent class for the packages_services_table database table.
 * 
 */
@Entity
@Table(name = "packages_services_table")
//@NamedQuery(name="PackagesServicesTable.findAll", query="SELECT p FROM PackagesServicesTable p")
public class PackagesServicesTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PackagesServicesTablePK id;

	public PackagesServicesTable() {
	}

	public PackagesServicesTablePK getId() {
		return this.id;
	}

	public void setId(PackagesServicesTablePK id) {
		this.id = id;
	}

}