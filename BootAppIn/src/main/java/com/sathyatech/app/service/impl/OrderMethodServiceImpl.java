package com.sathyatech.app.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.sathyatech.app.model.OrderMethod;
import com.sathyatech.app.repo.OrderMethodRepository;
import com.sathyatech.app.service.IOrderMethodService;

@Service
public class OrderMethodServiceImpl implements IOrderMethodService {

	@Autowired
	private OrderMethodRepository repo;
	
	@Override
	public void save(List<OrderMethod> orderMethod) {
		repo.save(orderMethod);
	}
	
	@Override
	public Long save(OrderMethod orderMethod) {
	 orderMethod = repo.save(orderMethod);
	 return orderMethod.getOrderMethdId();
	}

	@Override
	public void update(OrderMethod orderMethod) {
		 repo.save(orderMethod);

	}

	@Override
	public void delete(Long orderMethdId) {
		repo.delete(orderMethdId);
	}

	@Override
	public OrderMethod getOne(Long orderMethdId) {
		return repo.findOne(orderMethdId);
	}

	@Override
	public boolean isExist(Long orderMethdId) {
		return repo.exists(orderMethdId);
	}

	@Override
	public List<OrderMethod> getAll() {
		List<OrderMethod> orderMethodList = repo.findAll();
		Collections.sort(orderMethodList,new Comparator<OrderMethod>() {

			@Override
			public int compare(OrderMethod o1, OrderMethod o2) {
				return o1.getOrderMethdId().compareTo(o2.getOrderMethdId());
			}
		});
		 return orderMethodList;
	}

	@Override
	public Page<OrderMethod> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public Page<OrderMethod> findAll(Specification<OrderMethod> spec, Pageable page) {
		 return repo.findAll(spec, page);
	}

	@Override
	public boolean isOrderCodeAndMethodExist(String orderCode, String orderMethd) {
		long count = repo.countOrderCodeAndMethod(orderCode, orderMethd);
		if (count==0)
			return false;
		else 
			return true;
	}

	@Override
	public OrderMethod findByOrderCode(String orderCode) {
		return repo.findByOrderCode(orderCode);
	}

	@Override
	public List<OrderMethod> findByOrderMode(String orderMode) {
		return repo.findByOrderMode(orderMode);
	}
}
