package com.highpeak.Ediscovery.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "File")
public class File {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String absolutePath;
	private String createdDate;
	private Date modifiedDate;
	private boolean isActive = true;
	private boolean isProcessed = false;
	private String relativePath;

	/*
	 * public static String separator;
	 * 
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="CaseId") private Cases cases;
	 */

	public File() {
		super();
	}

	public File(int id, String name, String absolutePath, String createdDate, Date modifiedDate, boolean isActive,
			boolean isProcessed, String relativePath) {
		super();
		this.id = id;
		this.name = name;
		this.absolutePath = absolutePath;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.isActive = isActive;
		this.isProcessed = isProcessed;
		this.relativePath = relativePath;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbsolutePath() {
		return absolutePath;
	}

	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}

	public String getRelativePath() {
		return relativePath;
	}

	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public boolean isIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isIsProcessed() {
		return isProcessed;
	}

	public void setIsProcessed(boolean isProcessed) {
		this.isProcessed = isProcessed;
	}

}