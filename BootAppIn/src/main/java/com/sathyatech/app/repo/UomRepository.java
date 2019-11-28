package com.sathyatech.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.sathyatech.app.model.Uom;
/*
 * UOM Data Access Layer
 */
public interface UomRepository extends JpaRepository<Uom, Long>,JpaSpecificationExecutor<Uom> {

	@Query("select count(uomId) from com.sathyatech.app.model.Uom where uomType=?1 and uomModel=?2")
	public long countUomTypeAndModel(String uomType,String uomModel);
	
	//Fetch Uom based on UomModel
	public Uom findByUomModel(String uomModel);
	
}
