package jstorer.namemediaproject.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

/**
 * The persistent class for the DOMAINS database table.
 * 
 */
@Entity
@Table(name = "DOMAINS", uniqueConstraints = { @UniqueConstraint(columnNames = "name") })
public class Domain {
	@Id
	private String name;
	@Column
	private String price;
	@Column
	private String status;

	public Domain() {
	}

	public String getName() {
		return this.name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return this.price;
	}

	@XmlElement
	public void setPrice(String price) {
		this.price = price;
	}

	public String getStatus() {
		return this.status;
	}

	@XmlElement
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		final Domain other = (Domain) obj;
		if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
			return false;
		}
		if ((this.price == null) ? (other.price != null) : !this.price.equals(other.price)) {
			return false;
		}
		if ((this.status == null) ? (other.status != null) : !this.status.equals(other.status)) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int prime = 31;
		int result = prime + (this.name != null ? this.name.hashCode() : 0);
		result += result * prime + (this.price != null ? this.price.hashCode() : 0);
		return result * prime + (this.status != null ? this.status.hashCode() : 0);
	}
}