package com.sathyatech.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.sathyatech.app.model.PurchaseOrder;

public interface IPurchaseOrderService {

	public long save(PurchaseOrder po);
	
	public List<PurchaseOrder> saveMultiple(List<PurchaseOrder> list);
	
	public void update(PurchaseOrder po);
	
	public void deleteById(long poId);
	
	public PurchaseOrder findOneById(long poId);
	
	public List<PurchaseOrder> findAll();
	
	public Page<PurchaseOrder> findAll(Specification<PurchaseOrder> s,Pageable pageable);
	
	public Page<PurchaseOrder> findAll(Pageable pageable);
	
	public void saveFile(List<PurchaseOrder> listPo);
	
	public PurchaseOrder findByOrderCode(String orderCode);
	
	public Boolean isExist(Long orderId);
	
}
