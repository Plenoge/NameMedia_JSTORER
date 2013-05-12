package jstorer.namemediaproject.entities;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

/**
 * The persistent class for the DOMAINS database table.
 * 
 */
@Entity
@Table(name="DOMAINS", uniqueConstraints={@UniqueConstraint(columnNames="name")})
public class Domain {
	@Id	private String name;
	@Column	private String price;
	@Column	private String status;

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

}