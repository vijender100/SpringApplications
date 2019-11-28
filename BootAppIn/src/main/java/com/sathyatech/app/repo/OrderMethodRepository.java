package com.sathyatech.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.sathyatech.app.model.OrderMethod;

public interface OrderMethodRepository extends JpaRepository<OrderMethod, Long>,JpaSpecificationExecutor<OrderMethod> {

	@Query("select count(orderMethdId) from com.sathyatech.app.model.OrderMethod where orderCode=?1 and orderMethd=?2")
	public long countOrderCodeAndMethod(String orderCode,String orderMethd);

	List<OrderMethod> findByOrderMode(String orderMode);

	//Fetch OrderMethod by OrderCode
	public OrderMethod findByOrderCode(String orderCode);
}
