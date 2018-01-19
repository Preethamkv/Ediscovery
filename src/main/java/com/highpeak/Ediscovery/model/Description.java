package com.highpeak.Ediscovery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="description")
public class Description {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String detail;
	private int caseid;
	
	
	public Description() {
		super();
	}

	public Description(int id, String detail, int caseid) {
		super();
		this.id = id;
		this.detail =detail;
		this.caseid=caseid;
		

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String detail() {
		return detail;
	}

	public void setdetail(String detail) {
		this.detail = detail;
	}
	public int getcaseid() {
		return caseid;
	}

	public void setcaseid(int caseid) {
		this.caseid = caseid;
	}

}

