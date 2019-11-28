package com.sathyatech.app.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.sathyatech.app.model.PurchaseOrder;
import com.sathyatech.app.service.IPurchaseOrderService;
import com.sathyatech.app.util.PurchaseOrderUtil;

public class PurchaseOrderSpecification implements Specification<PurchaseOrder>{
	
	private PurchaseOrder filter;
	
	@Autowired
	private PurchaseOrderUtil poUtil;
	
	@Autowired
	private IPurchaseOrderService poService;
	
	public PurchaseOrderSpecification(PurchaseOrder filter) {
		super();
		this.filter = filter;
	}
	
	@Override
	public Predicate toPredicate(Root<PurchaseOrder> root,
			CriteriaQuery<?> query, CriteriaBuilder cb) {
		Predicate p= cb.conjunction();
		
		if(!StringUtils.isEmpty(filter.getOrderCode())){
			p.getExpressions()
				.add(cb.equal(root.get("orderCode"), filter.getOrderCode()));
		}
		
		if(!StringUtils.isEmpty(filter.getShipmentMode().getShipmentCode())){
			p.getExpressions()
			.add(cb.equal(root.get("shipmentMode"), filter.getShipmentMode()));
		}
		
		return p;
	}
}