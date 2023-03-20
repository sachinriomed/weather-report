package com.etraveli.weatherreport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "config")
public class Config {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cfg_id", precision = 8)
	private Integer cfgId;
	
	@Column(name = "cfg_use_id", precision = 8)
	private Integer cfgUseId;
	
	@Column(name = "cfg_city", length=100, nullable = false)
	private String cfgCity;
	
	@Column(name = "cfg_temperature", nullable = false)
	private Byte cfgTemperature;
	
	@Column(name = "cfg_notification_ype", length=10, nullable = false)
	private String cfgNotificationType;
	
	@Column(name = "cfg_record_status", length=10, nullable = false)
	private String cfgRecordStatus;

	public Integer getCfgId() {
		return cfgId;
	}

	public void setCfgId(Integer cfgId) {
		this.cfgId = cfgId;
	}

	public Integer getCfgUseId() {
		return cfgUseId;
	}

	public void setCfgUseId(Integer cfgUseId) {
		this.cfgUseId = cfgUseId;
	}

	public String getCfgCity() {
		return cfgCity;
	}

	public void setCfgCity(String cfgCity) {
		this.cfgCity = cfgCity;
	}

	public Byte getCfgTemperature() {
		return cfgTemperature;
	}

	public void setCfgTemperature(Byte cfgTemperature) {
		this.cfgTemperature = cfgTemperature;
	}

	public String getCfgNotificationType() {
		return cfgNotificationType;
	}

	public void setCfgNotificationType(String cfgNotificationType) {
		this.cfgNotificationType = cfgNotificationType;
	}

	public String getCfgRecordStatus() {
		return cfgRecordStatus;
	}

	public void setCfgRecordStatus(String cfgRecordStatus) {
		this.cfgRecordStatus = cfgRecordStatus;
	}
}
