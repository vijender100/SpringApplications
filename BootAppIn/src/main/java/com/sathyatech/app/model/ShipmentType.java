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
 * This class is model class for ShipmentType
 * @author ramsSoft
 *
 */

@Entity
@Table(name="shipmenttab")
@EntityListeners(AuditingEntityListener.class)
public class ShipmentType {

	//-----primary key ---------
	@Id
	@Column(name="ship_id")
	@GeneratedValue(generator="ship_gen")
	@GenericGenerator(name="ship_gen",strategy="increment")
	private Long shipmentTypeId;
	
	// -------Dates for Records--------
	@Column(name="c_dte")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date createdOn;
	
	@Column(name="m_dte")
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date modifiedOn;
	
	//--------UI INPUTS-------
	@Column(name="ship_mode")
	private String shipmentMode;
	
	@Column(name="ship_code")
	private String shipmentCode;
	
	@Column(name="enable_ship")
	private String enableShipment;
	
	@Column(name="ship_grade")
	private String shipmentGrade;
	
	@Column(name="ship_desc")
	private String description;

	//----------constructors-----------
	//1. default const
	
	public ShipmentType() {
		 System.out.println("ShipmentType::0-param constructor");
	}
	

	//2. one param PK based const

	public ShipmentType(Long shipmentTypeId) {
		System.out.println("ShipmentType::1-param constructor");
		this.shipmentTypeId = shipmentTypeId;
	}

	//3. multipart Import const

	public ShipmentType(String shipmentMode, String shipmentCode, String enableShipment, String shipmentGrade,
			String description) {
		this.shipmentMode = shipmentMode;
		this.shipmentCode = shipmentCode;
		this.enableShipment = enableShipment;
		this.shipmentGrade = shipmentGrade;
		this.description = description;
	}
	//------------methods----------
	//getters() and setter()
	public Long getShipmentTypeId() {
		return shipmentTypeId;
	}

	public void setShipmentId(Long shipmentTypeId) {
		this.shipmentTypeId = shipmentTypeId;
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

	public String getShipmentMode() {
		return shipmentMode;
	}

	public void setShipmentMode(String shipmentMode) {
		this.shipmentMode = shipmentMode;
	}

	public String getShipmentCode() {
		return shipmentCode;
	}

	public void setShipmentCode(String shipmentCode) {
		this.shipmentCode = shipmentCode;
	}

	public String getEnableShipment() {
		return enableShipment;
	}

	public void setEnableShipment(String enableShipment) {
		this.enableShipment = enableShipment;
	}

	public String getShipmentGrade() {
		return shipmentGrade;
	}

	public void setShipmentGrade(String shipmentGrade) {
		this.shipmentGrade = shipmentGrade;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	//----------toString--------
	@Override
	public String toString() {
		return "ShipmentType [shipmentTypeId=" + shipmentTypeId + ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn
				+ ", shipmentMode=" + shipmentMode + ", shipmentCode=" + shipmentCode + ", enableShipment="
				+ enableShipment + ", shipmentGrade=" + shipmentGrade + ", description=" + description + "]";
	}
}
