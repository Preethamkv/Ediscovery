package com.highpeak.Ediscovery.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.highpeak.Ediscovery.bean.FileModel;
import com.highpeak.Ediscovery.model.File;

@Component
@Transactional
@Repository
public interface FileRepository extends CrudRepository<FileModel, Long> {

	@Query(nativeQuery = true, value = "select id,name,absolute_path,relative_path,created_date from file where is_processed=false;")
	public List<FileModel> getFiles();

	public File save(File file);

}

/*
 * @Query(nativeQuery = true, value =
 * "select id,name,path,rel_path,created_date,modified_date,is_active,is_processed from file where is_processed=false;"
 * ) public List<File> getFiles();
 */
