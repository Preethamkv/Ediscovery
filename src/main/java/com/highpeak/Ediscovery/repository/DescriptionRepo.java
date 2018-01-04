package com.highpeak.Ediscovery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.highpeak.Ediscovery.bean.DescpModel;




public interface DescriptionRepo extends CrudRepository<DescpModel, Long>{
	@Query(nativeQuery = true, value = "select id,detail,caseid from description where caseid=1;")
	public DescpModel getdetail();


}
