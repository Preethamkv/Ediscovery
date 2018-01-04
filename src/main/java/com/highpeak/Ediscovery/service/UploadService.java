package com.highpeak.Ediscovery.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.highpeak.Ediscovery.bean.DescpModel;
import com.highpeak.Ediscovery.bean.FileModel;

@Component
public interface UploadService {

	/* public List<File> getFiles(); */

	public List<FileModel> getFiles();

	public String fileUpload(final MultipartFile[] files) throws Exception;
	 public DescpModel getdetail();
}