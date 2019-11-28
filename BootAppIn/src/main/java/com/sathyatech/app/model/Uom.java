
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
 * This is model class for Uom[Unit of Measurement]
 * 
 * @author Ram'sSoft
 *
 */

@Entity
@Table(name = "uom_tab")
@EntityListeners(AuditingEntityListener.class)
public class Uom {

	// -----primary key ---------
	@Id
	@Column(name = "u_id")
	@GeneratedValue(generator = "uom_gen")
	@GenericGenerator(name = "uom_gen", strategy = "increment")
	private Long uomId;

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

	// --------UI INPUTS-------
	@Column(name = "u_type")
	private String uomType;

	@Column(name = "u_model")
	private String uomModel;

	@Column(name = "u_desc")
	private String description;

	// ----------constructors-----------
	// 1. default const
	public Uom() {
		System.out.println("Uom::default-constructor");
	}

	// 2. one param PK based const
	public Uom(Long uomId) {
		System.out.println("Uom::1-param constructor");
		this.uomId = uomId;
	}

	// 3. multipart Import const
	public Uom(String uomType, String uomModel, String description) {
		this.uomType = uomType;
		this.uomModel = uomModel;
		this.description = description;
	}

	// ------------methods----------
	public Long getUomId() {
		return uomId;
	}

	public void setUomId(Long uomId) {
		this.uomId = uomId;
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

	public String getUomType() {
		return uomType;
	}

	public void setUomType(String uomType) {
		this.uomType = uomType;
	}

	public String getUomModel() {
		return uomModel;
	}

	public void setUomModel(String uomModel) {
		this.uomModel = uomModel;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// ----------toString--------
	@Override
	public String toString() {
		return "Uom [uomId=" + uomId + ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn + ", uomType="
				+ uomType + ", uomModel=" + uomModel + ", description=" + description + "]";
	}// method
}// class
