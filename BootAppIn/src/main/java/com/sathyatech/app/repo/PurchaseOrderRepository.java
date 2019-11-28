package com.sathyatech.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.sathyatech.app.model.PurchaseOrder;


public interface PurchaseOrderRepository extends 
 JpaRepository<PurchaseOrder, Long>,JpaSpecificationExecutor<PurchaseOrder>{
	
	public PurchaseOrder findByOrderCode(String orderCode);
	
	//Status
	@Query("select po.status from com.sathyatech.app.model.PurchaseOrder po")
	public List<PurchaseOrder> findByStatus();
}
