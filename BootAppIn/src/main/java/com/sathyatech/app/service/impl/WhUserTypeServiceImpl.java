package com.sathyatech.app.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.sathyatech.app.model.WhUserType;
import com.sathyatech.app.repo.WhUserTypeRepository;
import com.sathyatech.app.service.IWhUserTypeService;

@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService {

	@Autowired
	private WhUserTypeRepository repo;
	
	@Override
	public Long save(WhUserType whUserType) {
		whUserType =  repo.save(whUserType);
		return whUserType.getWhUserTypeId();
	}

	@Override
	public void update(WhUserType whUserType) {
		repo.save(whUserType);
	}

	@Override
	public void delete(Long whUserTypeId) {
		repo.delete(whUserTypeId);
	}

	@Override
	public WhUserType getOne(Long whUserTypeId) {
		return repo.findOne(whUserTypeId);
	}

	@Override
	public boolean isExist(Long whUserTypeId) {
		return repo.exists(whUserTypeId);
		
	}

	@Override
	public List<WhUserType> getAll() {
		List<WhUserType> whUserTypeList = repo.findAll();
		Collections.sort(whUserTypeList,new Comparator<WhUserType>() {

			@Override
			public int compare(WhUserType o1, WhUserType o2) {
				return o1.getWhUserTypeId().compareTo(o2.getWhUserTypeId());
			}
		});
		 return whUserTypeList;
	}

	@Override
	public Page<WhUserType> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public Page<WhUserType> findAll(Specification<WhUserType> spec, Pageable page) {
		return repo.findAll(spec, page);
	}

	@Override
	public void save(List<WhUserType> whUserTypes) {
		repo.save(whUserTypes);
	}
	
	@Override
	public List<WhUserType> findByUserCodeIn(List<String> userCode) {
		return repo.findByUserCodeIn(userCode);
	}
	@Override
	public List<WhUserType> findByUserType(String userType) {
		return repo.findByUserType(userType);
	}
	
	public WhUserType findByUserCode(String userCode) {
		return repo.findByUserCode(userCode);
	}
}
