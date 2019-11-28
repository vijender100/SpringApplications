package com.sathyatech.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.sathyatech.app.model.Uom;

public interface IUomService {

	public Long save(Uom uom);
	public void update(Uom uom);
	public void delete(Long uomId);
	public Uom getOne(Long uomId);
	public boolean isExist(Long uomId);
	public List<Uom> getAll();
	public Page<Uom> findAll(Pageable pageable);
	//Specification
	public Page<Uom> findAll(Specification<Uom> spec,Pageable page);
	public boolean isUomTypeAndModelExist(String uomTypes,String uomModel);
	public void save(List<Uom> uoms);
	//Find By UomModel
	public Uom findByUomModel(String uomModel);
	
}
