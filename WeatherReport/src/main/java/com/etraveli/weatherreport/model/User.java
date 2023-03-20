package com.etraveli.weatherreport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "use_id", precision = 8)
	private Integer useId;
	
	@Column(name = "use_username", length=40, nullable = false)
	private String useUsername;
	
	@Column(name = "use_password", length=40, nullable = false)
	private String usePassword;
	
	@Column(name = "use_mobile", length=20)
	private String useMobile;
	
	@Column(name = "use_email", length=45)
	private String useEmail;
	
	@Column(name = "use_active")
	private Byte useActive;

	public Integer getUseId() {
		return useId;
	}

	public void setUseId(Integer useId) {
		this.useId = useId;
	}

	public String getUseUsername() {
		return useUsername;
	}

	public void setUseUsername(String useUsername) {
		this.useUsername = useUsername;
	}

	public String getUsePassword() {
		return usePassword;
	}

	public void setUsePassword(String usePassword) {
		this.usePassword = usePassword;
	}

	public String getUseMobile() {
		return useMobile;
	}

	public void setUseMobile(String useMobile) {
		this.useMobile = useMobile;
	}

	public String getUseEmail() {
		return useEmail;
	}

	public void setUseEmail(String useEmail) {
		this.useEmail = useEmail;
	}

	public Byte getUseActive() {
		return useActive;
	}

	public void setUseActive(Byte useActive) {
		this.useActive = useActive;
	}
}
