package com.sathyatech.app.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * This is model class for Item
 * 
 * @author Ram'sSoft
 *
 */
@Entity
@Table(name = "item_tab")
@EntityListeners(AuditingEntityListener.class)
public class Item {

	// -----primary key ---------
	@Id
	@Column(name = "item_id")
	@GeneratedValue(generator = "item_gen")
	@GenericGenerator(name = "item_gen", strategy = "increment")
	private Long itemId;
	
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
	@Column(name = "item_code")	
	private String itemCode;
	
	@Column(name = "item_wdth")
	private Double itemWdth;
	
	@Column(name = "item_lnth")
	private Double itemLnth;
	
	@Column(name = "item_hgth")
	private Double itemHgth;
	
	@Column(name = "item_cost")	
	private Double baseCost;
	
	@Column(name = "bse_curncy")	
	private String baseCurrency;
	
	@Column(name="description")
	private String description;
	
	//Integration With Item--------<>Uom
	//					*-----------1
	@ManyToOne
	@JoinColumn(name="uomIdFK")
	private Uom uom = new Uom();
	
	//Integration with Item----------<>OrderMethod(Sale)
	//					*-------------1
	@ManyToOne
	@JoinColumn(name="omIdSaleFK")
	private OrderMethod omSale = new OrderMethod();

	//Integration with Item----------<>OrderMethod(Purchase)
	//					*-------------1
	@ManyToOne
	@JoinColumn(name="omIdPurchaseFK")
	private OrderMethod omPurchase = new OrderMethod();

	//Integration with Item----------<>WhUserType(Vendors)
	//					*-------------*
	@ManyToMany
	@JoinTable(name="itm_ven_tab",
	joinColumns=@JoinColumn(name="itm_idFK"),
	inverseJoinColumns=@JoinColumn(name="ven_idFK")
	)
	private List<WhUserType> whVendors = new ArrayList<WhUserType>();
	
	//Integration with Item----------<>WhUserType(Customers)
	//					*-------------*
	@ManyToMany
	@JoinTable(name="itm_cust_tab",
	joinColumns=@JoinColumn(name="itm_idFK"),
	inverseJoinColumns=@JoinColumn(name="cust_idFK")
	)
	private List<WhUserType> whCustomers = new ArrayList<WhUserType>();

	// ----------constructors-----------
	// 1. default const
	public Item() {
		System.out.println("Item::0-param constructor");
	}

	// 2. one param PK based const
	public Item(Long itemId) {
		this.itemId = itemId;
	}
	
	//3.Multipart Import Constructor
	public Item(String itemCode, Double itemWdth, Double itemLnth, Double itemHgth, Double baseCost,
			String baseCurrency, Uom uom, OrderMethod omSale, OrderMethod omPurchase, List<WhUserType> whVendors,
			List<WhUserType> whCustomers,String description) {
		this.itemCode = itemCode;
		this.itemWdth = itemWdth;
		this.itemLnth = itemLnth;
		this.itemHgth = itemHgth;
		this.baseCost = baseCost;
		this.baseCurrency = baseCurrency;
		this.uom = uom;
		this.omSale = omSale;
		this.omPurchase = omPurchase;
		this.whVendors = whVendors;
		this.whCustomers = whCustomers;
		this.description = description;
	}
	
	// ------------methods----------
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

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public Double getItemWdth() {
		return itemWdth;
	}

	public void setItemWdth(Double itemWdth) {
		this.itemWdth = itemWdth;
	}

	public Double getItemLnth() {
		return itemLnth;
	}

	public void setItemLnth(Double itemLnth) {
		this.itemLnth = itemLnth;
	}

	public Double getItemHgth() {
		return itemHgth;
	}

	public void setItemHgth(Double itemHgth) {
		this.itemHgth = itemHgth;
	}

	public Double getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(Double baseCost) {
		this.baseCost = baseCost;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public Uom getUom() {
		return uom;
	}

	public void setUom(Uom uom) {
		this.uom = uom;
	}

	public OrderMethod getOmSale() {
		return omSale;
	}

	public void setOmSale(OrderMethod omSale) {
		this.omSale = omSale;
	}

	public OrderMethod getOmPurchase() {
		return omPurchase;
	}

	public void setOmPurchase(OrderMethod omPurchase) {
		this.omPurchase = omPurchase;
	}

	public List<WhUserType> getWhVendors() {
		return whVendors;
	}

	public void setWhVendors(List<WhUserType> whVendors) {
		this.whVendors = whVendors;
	}

	public List<WhUserType> getWhCustomers() {
		return whCustomers;
	}

	public void setWhCustomers(List<WhUserType> whCustomers) {
		this.whCustomers = whCustomers;
	}

	public Long getItemId() {
		return itemId;
	}
	
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn + ", itemCode="
				+ itemCode + ", itemWdth=" + itemWdth + ", itemLnth=" + itemLnth + ", itemHgth=" + itemHgth
				+ ", baseCost=" + baseCost + ", baseCurrency=" + baseCurrency + ", description=" + description
				+ ", uom=" + uom + ", omSale=" + omSale + ", omPurchase=" + omPurchase + ", whVendors=" + whVendors
				+ ", whCustomers=" + whCustomers + "]";
	}
}
