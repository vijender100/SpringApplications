package com.sathyatech.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.sathyatech.app.model.PurchaseOrder;
import com.sathyatech.app.repo.PurchaseOrderRepository;
import com.sathyatech.app.service.IPurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {

	@Autowired
	private PurchaseOrderRepository repo;
	
	@Override
	public long save(PurchaseOrder po) {
		return repo.save(po).getOrderId();
	}

	@Override
	public List<PurchaseOrder> saveMultiple(List<PurchaseOrder> list) {
		return repo.save(list);
	}

	@Override
	public void update(PurchaseOrder po) {
		
		repo.save(po);
	}

	@Override
	public void deleteById(long poId) {
		if(repo.exists(poId)){
			repo.delete(poId);
		}
	}

	@Override
	public PurchaseOrder findOneById(long poId) {
		return repo.findOne(poId);
	}

	@Override
	public List<PurchaseOrder> findAll() {
		List<PurchaseOrder> list=repo.findAll();
		return list;
	}

	@Override
	public Page<PurchaseOrder> findAll(Specification<PurchaseOrder> s, Pageable pageable) {
		Page<PurchaseOrder> page=repo.findAll(s, pageable);
		return page;
	}
	
	public Page<PurchaseOrder> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
	public void saveFile(List<PurchaseOrder> listPo) {
		repo.save(listPo);
	}
	
	//Vali
	public PurchaseOrder findByOrderCode(String orderCode) {
		return repo.findByOrderCode(orderCode);
	}
	
	public Boolean isExist(Long orderId) {
		return repo.exists(orderId);
	}
}