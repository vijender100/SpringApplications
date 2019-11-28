package com.sathyatech.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sathyatech.app.model.WhUserType;

public interface WhUserTypeRepository extends JpaRepository<WhUserType,Long>, JpaSpecificationExecutor<WhUserType> {


	public List<WhUserType> findByUserType(String userType);

	//Fetch WhUserType based userCode
	public List<WhUserType> findByUserCodeIn(List<String> userCode);
	
	public WhUserType findByUserCode(String userCode);
}
