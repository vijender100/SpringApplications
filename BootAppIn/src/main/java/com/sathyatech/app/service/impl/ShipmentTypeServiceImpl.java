package com.sathyatech.app.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.sathyatech.app.model.ShipmentType;
import com.sathyatech.app.repo.ShipmentTypeRepository;
import com.sathyatech.app.service.IShipmentTypeService;

@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {

	@Autowired
	private ShipmentTypeRepository repo;
	
	@Override
	public Long save(ShipmentType shipmentType) {
	   shipmentType = repo.save(shipmentType);
	   return shipmentType.getShipmentTypeId();
	}

	@Override
	public void update(ShipmentType shipmentType) {
		repo.save(shipmentType);
	}

	@Override
	public void delete(Long shipmentTypeId) {
		repo.delete(shipmentTypeId);
	}

	@Override
	public ShipmentType getOne(Long shipmentTypeId) {
		return repo.findOne(shipmentTypeId);
	}

	@Override
	public boolean isExist(Long shipmentTypeId) {
		return repo.exists(shipmentTypeId);	
	}

	@Override
	public List<ShipmentType> getAll() {
		List<ShipmentType> shipmentTypeList = repo.findAll();
		Collections.sort(shipmentTypeList,new Comparator<ShipmentType>() {

			@Override
			public int compare(ShipmentType o1, ShipmentType o2) {
				return o1.getShipmentTypeId().compareTo(o2.getShipmentTypeId());
			}
		});
		 return shipmentTypeList;
	}

	@Override
	public Page<ShipmentType> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public Page<ShipmentType> findAll(Specification<ShipmentType> spec, Pageable page) {
		return repo.findAll(spec, page);
	}

	@Override
	public boolean isShipmentModeAndCodeExist(String shipmentMode, String shipmentCode) {
		long count =  repo.countShipmentModeAndCode(shipmentMode, shipmentCode);
		if (count==0)
		    return false;
		else 
			return true;
	}

	@Override
	public void save(List<ShipmentType> shipmentTypes) {
		repo.save(shipmentTypes);
	}

	@Override
	public List<ShipmentType> findByEnableShipment(String enabled) {
		return repo.findByEnableShipment(enabled);
	}
	
	public ShipmentType findByShipmentCode(String shipmentCode) {
		return repo.findByShipmentCode(shipmentCode);
	}
}
