package com.etraveli.weatherreport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "temperature_details")
public class TemperatureDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tmp_id", precision = 8)
	private Integer tmpId;
	
	@Column(name = "tmp_city", length=100, nullable = false)
	private String tmpCity;
	
	@Column(name = "tmp_temperature", nullable = false)
	private Byte tmpTemperature;
	
	@Column(name = "tmp_weather", length=10, nullable = false)
	private String tmpWeather;
	
	@Column(name = "tmp_record_status", length=10, nullable = false)
	private String tmpRecordStatus;

	public Integer getTmpId() {
		return tmpId;
	}

	public void setTmpId(Integer tmpId) {
		this.tmpId = tmpId;
	}

	public String getTmpCity() {
		return tmpCity;
	}

	public void setTmpCity(String tmpCity) {
		this.tmpCity = tmpCity;
	}

	public Byte getTmpTemperature() {
		return tmpTemperature;
	}

	public void setTmpTemperature(Byte tmpTemperature) {
		this.tmpTemperature = tmpTemperature;
	}

	public String getTmpWeather() {
		return tmpWeather;
	}

	public void setTmpWeather(String tmpWeather) {
		this.tmpWeather = tmpWeather;
	}

	public String getTmpRecordStatus() {
		return tmpRecordStatus;
	}

	public void setTmpRecordStatus(String tmpRecordStatus) {
		this.tmpRecordStatus = tmpRecordStatus;
	}
}
