package com.sathyatech.app.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.sathyatech.app.model.ShipmentType;

public class ShipmentTypeSpecification implements Specification<ShipmentType> {

	private ShipmentType filter;

	public ShipmentTypeSpecification(ShipmentType shipmentType) 
	{
		this.filter = shipmentType;
	}
	
	@Override
	public Predicate toPredicate(Root<ShipmentType> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

		/*
		 * Conjunction for AND operation :: Disjunction for OR operation
		 */
		
		Predicate p = cb.conjunction();
		
		if(!StringUtils.isEmpty(filter.getShipmentMode()))
		{
			p.getExpressions().add(cb.equal(root.get("shipmentMode"), filter.getShipmentMode()));
		}
		if(!StringUtils.isEmpty(filter.getShipmentCode()))
		{
			p.getExpressions().add(cb.like(root.get("shipmentCode").as(String.class),"%"+filter.getShipmentCode()+"%"));
		}
		if(!StringUtils.isEmpty(filter.getEnableShipment()))
		{
			p.getExpressions().add(cb.equal(root.get("enableShipment"), filter.getEnableShipment()));
		}
		if(!StringUtils.isEmpty(filter.getShipmentGrade()))
		{
			p.getExpressions().add(cb.equal(root.get("shipmentGrade"), filter.getShipmentGrade()));
		}
		if(!StringUtils.isEmpty(filter.getDescription()))
		{
			p.getExpressions().add(cb.like(root.get("description").as(String.class), "%"+filter.getDescription()+"%"));
		}
		
		return p;
	}

}
