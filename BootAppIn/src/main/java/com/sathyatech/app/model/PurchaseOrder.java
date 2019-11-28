package com.sathyatech.app.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="po_tab")
@EntityListeners(AuditingEntityListener.class)
public class PurchaseOrder {
	@Id
	@GeneratedValue(generator="pogen")
	@GenericGenerator(name="pogen",strategy="increment")
	@Column(name="po_id")
	private Long orderId;
	
	@Column(name="po_code",unique=true)
	private String orderCode;
	
	@ManyToOne
	@JoinColumn(name="ship_id")
	private ShipmentType shipmentMode=new ShipmentType();

	@ManyToOne
	@JoinColumn(name="ven_id")
	private WhUserType vendor=new WhUserType();
	
	@Column(name="po_refe_num")
	private String refernceNumber;
	@Column(name="po_qlty_chk")
	private String qualityCheck;
	@Column(name="po_status")
	private String status;
	@Column(name="po_desc")
	private String description;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="po_id")
	private List<PurchaseOrderDetails> details=new ArrayList<PurchaseOrderDetails>(0);
	
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
	//----------------------------
	
	public PurchaseOrder() {
		super();
	}
	public PurchaseOrder(String status){
		this.status=status;
	}
	
	
	//Multi
	public PurchaseOrder(String orderCode, ShipmentType shipmentMode,
			WhUserType vendor, String refernceNumber, String qualityCheck,
			String status, String description) {
		super();
		this.orderCode = orderCode;
		this.shipmentMode = shipmentMode;
		this.vendor = vendor;
		this.refernceNumber = refernceNumber;
		this.qualityCheck = qualityCheck;
		this.status = status;
		this.description = description;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public ShipmentType getShipmentMode() {
		return shipmentMode;
	}
	public void setShipmentMode(ShipmentType shipmentMode) {
		this.shipmentMode = shipmentMode;
	}
	public WhUserType getVendor() {
		return vendor;
	}
	public void setVendor(WhUserType vendor) {
		this.vendor = vendor;
	}
	public String getRefernceNumber() {
		return refernceNumber;
	}
	public void setRefernceNumber(String refernceNumber) {
		this.refernceNumber = refernceNumber;
	}
	public String getQualityCheck() {
		return qualityCheck;
	}
	public void setQualityCheck(String qualityCheck) {
		this.qualityCheck = qualityCheck;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<PurchaseOrderDetails> getDetails() {
		return details;
	}
	public void setDetails(List<PurchaseOrderDetails> details) {
		this.details = details;
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
	@Override
	public String toString() {
		return "PurchaseOrder [orderId=" + orderId + ", orderCode=" + orderCode + ", shipmentMode=" + shipmentMode
				+ ", vendor=" + vendor + ", refernceNumber=" + refernceNumber + ", qualityCheck=" + qualityCheck
				+ ", status=" + status + ", description=" + description + ", details=" + details + ", createdOn="
				+ createdOn + ", modifiedOn=" + modifiedOn + "]";
	}
	

	
	
}
