package com.sathyatech.app.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.sathyatech.app.model.WhUserType;

public class WhUserTypeSpecification implements Specification<WhUserType> {

	private WhUserType filter;
	
	public WhUserTypeSpecification(WhUserType whUserType) 
	{
		this.filter = whUserType;
	}


	@Override
	public Predicate toPredicate(Root<WhUserType> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		Predicate p=cb.conjunction();
		
		if(!StringUtils.isEmpty(filter.getUserType()))
		{
			p.getExpressions().add(cb.equal(root.get("userType"), filter.getUserType()));
		}
		
		if(!StringUtils.isEmpty(filter.getUserCode()))
		{
			p.getExpressions().add(cb.like(root.get("userCode"), "%"+filter.getUserCode()+"%"));
		}
		
		
		return p;
	}
}
