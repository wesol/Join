package com.join.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String configurationId;
	
	@NotEmpty(message = "{com.join.notEmpty}")
	private String name;

	private String last;

	@Column(unique = true)
	@Email(message = "{com.join.email}")
	@NotEmpty(message = "{com.join.notEmpty}")
	private String email;

	@Length(min = 4, message = "{com.join.passwordLenght}")
	private String password;

	private String phone;

	@NotEmpty(message = "{com.join.notEmpty}")
	private String skype;

	@ColumnDefault(value = "false")
	private boolean admin;

	@ColumnDefault(value = "false")
	private boolean employee;

	@ColumnDefault(value = "false")
	private boolean activated;

	private LocalDateTime regDate;

	private LocalDateTime lastLogDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public boolean isEmployee() {
		return employee;
	}

	public void setEmployee(boolean employee) {
		this.employee = employee;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public LocalDateTime getLastLogDate() {
		return lastLogDate;
	}

	public void setLastLogDate(LocalDateTime lastLogDate) {
		this.lastLogDate = lastLogDate;
	}

	public String getConfigurationId() {
		return configurationId;
	}

	public void setConfigurationId(String configurationId) {
		this.configurationId = configurationId;
	}
	
	public User() {
	}

	public User(Long id, String name, String last, String email, String password, String phone, String skype) {
		this.id = id;
		this.name = name;
		this.last = last;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.skype = skype;
	}

	public User(Long id, String configurationId, String name, String last, String email, String password, String phone,
			String skype, boolean admin, boolean employee, boolean activated, LocalDateTime regDate,
			LocalDateTime lastLogDate) {
		this.id = id;
		this.configurationId = configurationId;
		this.name = name;
		this.last = last;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.skype = skype;
		this.admin = admin;
		this.employee = employee;
		this.activated = activated;
		this.regDate = regDate;
		this.lastLogDate = lastLogDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", last=" + last + ", email=" + email + ", password=" + password
				+ ", phone=" + phone + ", skype=" + skype + ", admin=" + admin + ", employee=" + employee
				+ ", activated=" + activated + ", regDate=" + regDate + ", lastLogDate=" + lastLogDate + "]";
	}

	

}
