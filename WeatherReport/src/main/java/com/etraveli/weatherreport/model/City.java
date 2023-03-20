package com.etraveli.weatherreport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cities")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cti_id", precision = 8)
	private Integer ctiId;
	
	@Column(name = "cti_city", length=100, nullable = false, unique=true)
	private String ctiCity;

	public Integer getCtiId() {
		return ctiId;
	}

	public void setCtiId(Integer ctiId) {
		this.ctiId = ctiId;
	}

	public String getCtiCity() {
		return ctiCity;
	}

	public void setCtiCity(String ctiCity) {
		this.ctiCity = ctiCity;
	}
}
