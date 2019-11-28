package com.sathyatech.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * This class is model class for WhUserType
 * @author ramsSoft
 *
 */

@Entity
@Table(name = "whusertab")
@EntityListeners(AuditingEntityListener.class)
public class WhUserType {

	
	//-----primary key ---------

	@Id
	@Column(name = "whuser_Id")
	@GeneratedValue(generator = "whusergen")
	@GenericGenerator(name = "whusergen", strategy = "increment")
	private Long whUserTypeId;

	// -------Dates for Records--------

	@Column(name = "c_dte")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date createdOn;

	@Column(name = "m_dte")
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date modifiedOn;

	
	//--------UI INPUTS-------

	@Column(name = "user_type")
	private String userType;

	@Column(name = "user_code")
	private String userCode;

	@Column(name = "user_for")
	private String userFor;

	@Column(name = "user_email")
	private String userEmail;

	@Column(name = "user_contact")
	private String userContact;

	@Column(name = "userid_type")
	private String userIdType;
	
	@Column(name="other_id")
	private String ifOther;

	@Column(name = "id_number")
	private String idNumber;

	//----------constructors-----------
	//1. default const
	public WhUserType() {
		System.out.println("WhUserType.WhUserType()");
	}

	//2. one param PK based const

	public WhUserType(Long whUserTypeId) {
		super();
		this.whUserTypeId = whUserTypeId;
	}

	//3. multipart Import const
	public WhUserType(String userType, String userCode, String userFor, String userEmail, String userContact,
			String userIdType,String ifOther, String idNumber) {
		super();
		this.userType = userType;
		this.userCode = userCode;
		this.userFor = userFor;
		this.userEmail = userEmail;
		this.userContact = userContact;
		this.userIdType = userIdType;
		this.ifOther = ifOther;
		this.idNumber = idNumber;
	}
	//------------methods----------

	//getters() and setter()
	public Long getWhUserTypeId() {
		return whUserTypeId;
	}

	public void setWhUserTypeId(Long whUserTypeId) {
		this.whUserTypeId = whUserTypeId;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserFor() {
		return userFor;
	}

	public void setUserFor(String userFor) {
		this.userFor = userFor;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserContact() {
		return userContact;
	}

	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

	public String getUserIdType() {
		return userIdType;
	}

	public void setUserIdType(String userIdType) {
		this.userIdType = userIdType;
	}
	
	public String getIfOther() {
		return ifOther;
	}

	public void setIfOther(String ifOther) {
		this.ifOther = ifOther;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	
	//----------toString--------
	@Override
	public String toString() {
		return "WhUserType [whUserTypeId=" + whUserTypeId + ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn
				+ ", userType=" + userType + ", userCode=" + userCode + ", userFor=" + userFor + ", userEmail="
				+ userEmail + ", userContact=" + userContact + ", userIdType=" + userIdType + ", ifOther=" + ifOther
				+ ", IdNumber=" + idNumber + "]";
	}
}
