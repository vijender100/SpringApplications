package com.sathyatech.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.sathyatech.app.model.OrderMethod;

public interface IOrderMethodService {

	public Long save(OrderMethod orderMethod);
	public void update(OrderMethod orderMethod);
	public void delete(Long orderMethdId);
	public OrderMethod getOne(Long orderMethdId);
	public boolean isExist(Long orderMethdId);
	public List<OrderMethod> getAll();
	public Page<OrderMethod> findAll(Pageable pageable);
	public Page<OrderMethod> findAll(Specification<OrderMethod> spec,Pageable page);
	public boolean isOrderCodeAndMethodExist(String orderCode,String orderMethod);
	public void save(List<OrderMethod> orderMethods);
	List<OrderMethod> findByOrderMode(String orderMode);
	public OrderMethod findByOrderCode(String orderCode);
}
