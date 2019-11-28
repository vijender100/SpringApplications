package com.sathyatech.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.sathyatech.app.model.Item;

/*
 * Item Data Access Layer
 */
public interface ItemRepository extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item> {

	@Query("select itm from com.sathyatech.app.model.Item itm inner join itm.whVendors ven where ven.whUserTypeId=?1")
	List<Item> findItemsByVendor(Long vendorId);
	 	
}
