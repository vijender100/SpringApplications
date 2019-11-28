package com.sathyatech.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.sathyatech.app.model.WhUserType;

public interface IWhUserTypeService {

	public Long save(WhUserType whUserType);
	public void update(WhUserType whUserType);
	public void delete(Long whUserTypeId);
	public WhUserType getOne(Long whUserTypeId);
	public boolean isExist(Long whUserTypeId);
	public List<WhUserType> getAll();
	public Page<WhUserType> findAll(Pageable pageable);
	public Page<WhUserType> findAll(Specification<WhUserType> spec,Pageable page);
	public void save(List<WhUserType> WhUserTypes);
	public List<WhUserType> findByUserType(String userType);
	public List<WhUserType> findByUserCodeIn(List<String> userCode);
	
	public WhUserType findByUserCode(String userCode);
}
