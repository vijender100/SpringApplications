package com.sathyatech.app.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.sathyatech.app.model.OrderMethod;

public class OrderMethodSpecification implements Specification<OrderMethod> {

	private OrderMethod filter;

	public OrderMethodSpecification(OrderMethod orderMethod) 
	{
		this.filter = orderMethod;
	}
	@Override
	public Predicate toPredicate(Root<OrderMethod> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		 
		Predicate p=cb.conjunction();


		if(!StringUtils.isEmpty(filter.getOrderMode()))
		{
			p.getExpressions().add(cb.equal(root.get("orderMode"),filter.getOrderMode()));
		}

		if(!StringUtils.isEmpty(filter.getOrderCode()))
		{
			p.getExpressions().add(cb.like(root.get("orderCode").as(String.class),"%"+filter.getOrderCode()+"%"));
		}
		if(!StringUtils.isEmpty(filter.getOrderMethd()))
		{
			p.getExpressions().add(cb.equal(root.get("orderMethd"), filter.getOrderMethd()));
		}
		if(filter.getOrderAccept()!=null && filter.getOrderAccept().size()==1)
		{
			p.getExpressions().add(cb.isMember(filter.getOrderAccept(),root.get("orderAccept")));
		}
		if(!StringUtils.isEmpty(filter.getDescription()))
		{
			p.getExpressions().add(cb.like(root.get("description").as(String.class), "%"+filter.getDescription()+"%"));
		}
		return p;
	}

	
}
