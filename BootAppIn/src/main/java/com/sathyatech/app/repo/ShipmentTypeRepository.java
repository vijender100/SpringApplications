package com.sathyatech.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.sathyatech.app.model.ShipmentType;

public interface ShipmentTypeRepository extends JpaRepository<ShipmentType, Long>,JpaSpecificationExecutor<ShipmentType> {
	
	@Query("select count(shipmentTypeId) from com.sathyatech.app.model.ShipmentType where shipmentMode=?1 and shipmentCode=?2")
	public long countShipmentModeAndCode(String shipmentMode,String shipmentCode);
	
	public List<ShipmentType> findByEnableShipment(String enableShipment);
	
	public ShipmentType findByShipmentCode(String shipmentCode);
}
