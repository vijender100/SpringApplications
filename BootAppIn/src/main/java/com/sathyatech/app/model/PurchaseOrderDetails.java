package com.sathyatech.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ordr_dtls_tab")
public class PurchaseOrderDetails {
	@Id
	@GeneratedValue(generator="ordrdtls")
	@GenericGenerator(name="ordrdtls",strategy="increment")
	@Column(name="dtl_id")
	private Long dtlId;

	@Column(name="poHdr_Id")
	private Long poHdrId;

	@Column(name="dtl_slno")
	private int slno;

	@ManyToOne
	@JoinColumn(name="item_id_fk")
	private Item itemDetails;

	@Column(name="bs_cost")
	private Double baseCost;
	@Column(name="itm_qty")
	private Long itemsQty;
	@Column(name="line_val")
	private Double lineValue;

	public PurchaseOrderDetails() {
		super();
	}

	public PurchaseOrderDetails(int slno, Item itemDetails, Double baseCost, 
			Long itemsQty, Double lineValue) {
		super();
		this.slno = slno;
		this.itemDetails = itemDetails;
		this.baseCost = baseCost;
		this.itemsQty = itemsQty;
		this.lineValue = lineValue;
	}

	public Long getDtlId() {
		return dtlId;
	}

	public void setDtlId(Long dtlId) {
		this.dtlId = dtlId;
	}

	public int getSlno() {
		return slno;
	}

	public void setSlno(int slno) {
		this.slno = slno;
	}

	public Item getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(Item itemDetails) {
		this.itemDetails = itemDetails;
	}

	public Double getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(Double baseCost) {
		this.baseCost = baseCost;
	}

	public Long getItemsQty() {
		return itemsQty;
	}

	public void setItemsQty(Long itemsQty) {
		this.itemsQty = itemsQty;
	}

	public Double getLineValue() {
		return lineValue;
	}

	public void setLineValue(Double lineValue) {
		this.lineValue = lineValue;
	}

	public Long getPoHdrId() {
		return poHdrId;
	}

	public void setPoHdrId(Long poHdrId) {
		this.poHdrId = poHdrId;
	}

}
