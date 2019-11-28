package com.sathyatech.app.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * This class is model class for OrderMethod
 * @author ramsSoft
 *
 */

	@Entity
	@Table(name="ordermethodtab")
	@EntityListeners(AuditingEntityListener.class)
	public class OrderMethod {

		//-----primary key ---------
		@Id
		@Column(name="order_Id")
		@GeneratedValue(generator="order_gen")
		@GenericGenerator(name="order_gen",strategy="increment")
		private Long orderMethdId;
		
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
		@Column(name="order_mode")
		private String orderMode;
		
		@Column(name="order_code")
		private String orderCode;
		
		@Column(name="order_methd")
		private String orderMethd;
		
		//-- LIST CONFIGURATION (CHECKBOX)--
		@ElementCollection
		@CollectionTable(name="orderaccepttab",//table
		joinColumns=@JoinColumn(name="order_id")
		)//key column
		@OrderColumn(name="pos")//index column
		@Column(name="order_accept")//element column
		private List<String> orderAccept;
		
		@Column(name="order_desc")
		private String description;

		//----------constructors-----------
		//1. default const

		public OrderMethod() {
			System.out.println("OrderMethod::0-param constructor");
		}
		
		//2. one param PK based const
		public OrderMethod(Long orderMethdId) {
			this.orderMethdId = orderMethdId;
		}
		
		//3. multipart Import const
		public OrderMethod(String orderMode, String orderCode,
				String orderMethd, List<String> orderAccept, String description) {
			super();
			this.orderMode = orderMode;
			this.orderCode = orderCode;
			this.orderMethd = orderMethd;
			this.orderAccept = orderAccept;
			this.description = description;
		}
		//------------methods----------
		//getters() and setter()
		public Long getOrderMethdId() {
			return orderMethdId;
		}

		public void setOrderMethdId(Long orderMethdId) {
			this.orderMethdId = orderMethdId;
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

		public String getOrderMode() {
			return orderMode;
		}

		public void setOrderMode(String orderMode) {
			this.orderMode = orderMode;
		}

		public String getOrderCode() {
			return orderCode;
		}

		public void setOrderCode(String orderCode) {
			this.orderCode = orderCode;
		}

		public List<String> getOrderAccept() {
			return orderAccept;
		}

		public void setOrderAccept(List<String> orderAccept) {
			this.orderAccept = orderAccept;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getOrderMethd() {
			return orderMethd;
		}

		public void setOrderMethd(String orderMethd) {
			this.orderMethd = orderMethd;
		}
		
		//----------toString--------
		@Override
		public String toString() {
			return "OrderModule [orderId=" + orderMethdId + ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn
					+ ", orderMode=" + orderMode + ", orderCode=" + orderCode + ", orderMethd=" + orderMethd
					+ ", orderAccept=" + orderAccept + ", description=" + description + "]";
		}
}
