package com.highpeak.Ediscovery.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="Category")
public class Category {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	private String Name;
	private Date ModifiedDate;

	
	public Category() {
		super();
	}

	
	
	public Category(int id, String name, Date modifiedDate) {
		super();
		this.Id = id;
		this.Name = name;
		this.ModifiedDate = modifiedDate;

	}



	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Date getModifiedDate() {
		return ModifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		ModifiedDate = modifiedDate;
	}

	
	
}
