package com.highpeak.Ediscovery.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DescpModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	private String detail;
	private int caseid;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getdetail() {
		return detail;
	}

	public void setdetail(String detail) {
		this.detail = detail;
	}

	public int getcaseid() {
		return caseid;
	}
	public void setcaseid(int caseid) {
		this.caseid=caseid;
	}

}
