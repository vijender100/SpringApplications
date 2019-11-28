package com.sathyatech.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.sathyatech.app.model.ShipmentType;

public interface IShipmentTypeService {

	public Long save(ShipmentType shipmentType);
	public void update(ShipmentType shipmentType);
	public void delete(Long shipmentTypeId);
	public ShipmentType getOne(Long shipmentTypeId);
	public boolean isExist(Long shipmentTypeId);
	public List<ShipmentType> getAll();
	public Page<ShipmentType> findAll(Pageable pageable);
	public Page<ShipmentType> findAll(Specification<ShipmentType> spec,Pageable page);
	public boolean isShipmentModeAndCodeExist(String shipmentMode,String shipmentCode);
	public void save(List<ShipmentType> ShipmentTypes);
	public List<ShipmentType> findByEnableShipment(String enabled);
	
	public ShipmentType findByShipmentCode(String shipmentCode);
}
