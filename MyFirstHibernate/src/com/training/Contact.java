package com.training;
// Generated Nov 24, 2015 3:35:57 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;

/**
 * Contact generated by hbm2java
 */
public class Contact implements java.io.Serializable {

	private int contactId;
	private Date dob;
	private String email;
	private String firstName;
	private String lastName;
	private String mobile;

	public Contact() {
	}

	public Contact(Date dob, String email, String firstName, String lastName, String mobile) {
		this.dob = dob;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
	}

	public int getContactId() {
		return this.contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
