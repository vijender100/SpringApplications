package com.sathyatech.app.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.sathyatech.app.model.Uom;
import com.sathyatech.app.repo.UomRepository;
import com.sathyatech.app.service.IUomService;

@Service
public class UomServiceImpl implements IUomService {

	@Autowired
	private UomRepository repo;

	@Override
	public Long save(Uom uom) {
		uom = repo.save(uom);//save or update
		return uom.getUomId();
	}
	
	@Override
	public void save(List<Uom> uoms) {
		repo.save(uoms);
	}
	
	@Override
	public Page<Uom> findAll(Specification<Uom> spec, Pageable page) {
		 	return repo.findAll(spec,page);
	}

	@Override
	public void update(Uom uom) {
		repo.save(uom); //save or update
	}

	@Override
	public void delete(Long uomId) {
		repo.delete(uomId);
	}

	@Override
	public Uom getOne(Long uomId) {
		Uom uom = repo.findOne(uomId);
		return uom;
	}

	@Override
	public boolean isExist(Long uomId) {
		return repo.exists(uomId);
	}

	@Override
	public List<Uom> getAll() {
		List<Uom> uomList = repo.findAll();
		Collections.sort(uomList,new Comparator<Uom>() {

			@Override
			public int compare(Uom o1, Uom o2) {
				return o1.getUomModel().compareToIgnoreCase(o2.getUomModel());
			}
		});
		 return uomList;
	}
	
	@Override
	public boolean isUomTypeAndModelExist(String uomTypes, String uomModel) {
		long count = repo.countUomTypeAndModel(uomTypes, uomModel);
		if(count==0)
			return false;
		else
			return true;
	}

	@Override
	public Page<Uom> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public Uom findByUomModel(String uomModel) {
		return repo.findByUomModel(uomModel);
	}
}//class
