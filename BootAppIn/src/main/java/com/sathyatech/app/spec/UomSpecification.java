package com.sathyatech.app.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.sathyatech.app.model.Uom;

public class UomSpecification implements Specification<Uom> {

	private Uom filter;
	
	public UomSpecification(Uom uom) {
		this.filter = uom;
	}
	
	@Override
	public Predicate toPredicate(Root<Uom> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		
		
		/*
		 * Conjunction for AND operation :: Disjunction for OR operation
		 */
		
		Predicate p = cb.conjunction();
		
		if(!StringUtils.isEmpty(filter.getUomType())) {
			p.getExpressions().add(cb.equal(root.get("uomType"), filter.getUomType()));
		}
		
		if(!StringUtils.isEmpty(filter.getUomModel())) {
			p.getExpressions().add(cb.like(root.get("uomModel").as(String.class),"%"+filter.getUomModel()+"%"));
		}
		
		if(!StringUtils.isEmpty(filter.getDescription())) {
			p.getExpressions().add(cb.like(root.get("description").as(String.class), "%"+filter.getDescription()+"%"));
		}
		
		return p;
	}
}
