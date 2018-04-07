package com.meeting.model;

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

	@NotEmpty(message = "{com.meeting.notEmpty}")
	private String name;

	@NotEmpty(message = "{com.meeting.notEmpty}")
	private String last;

	@Column(unique = true)
	@Email(message = "{com.meeting.email}")
	@NotEmpty(message = "{com.meeting.notEmpty}")

	private String email;

	@Length(min = 4, message = "{com.meeting.passwordLenght}")
	private String password;

	private String phone;

	private String skype;
	
	@ColumnDefault(value = "false")
	private boolean admin;
	
	@ColumnDefault(value = "false")
	private boolean employee;

	
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
	
	
	public User() {
	}
	
	public User(Long id, String name, String last, String email, String password, String phone,
			String skype) {
		this.id = id;
		this.name = name;
		this.last = last;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.skype = skype;
	}
	
		public User(Long id, String name, String last, boolean admin, String email, String password, String phone,
			String skype, boolean employee) {
		this.id = id;
		this.name = name;
		this.last = last;
		this.employee = employee;
		this.admin = admin;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.skype = skype;
	}
		
	@Override
	public String toString() {
		return "Employees [id=" + id + ", name=" + name + ", last=" + last + ", admin=" + admin + ", email=" + email
				+ ", phone=" + phone + ", skype=" + skype + "]";
	}

	
	
	
}
