package com.highpeak.Ediscovery.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
@Table(name="Cases")
public class Cases {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	private String Name;
	private boolean IsActive;
	private Date CreatedDate;
	
	
	public Cases() {
		super();
	}
	
	
	public Cases(int id, String name, boolean isActive, Date createdDate) {
		super();
		this.Id = id;
		this.Name = name;
		this.IsActive = isActive;
		this.CreatedDate = createdDate;
		
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
	public boolean isIsActive() {
		return IsActive;
	}
	public void setIsActive(boolean isActive) {
		IsActive = isActive;
	}
	public Date getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(Date createdDate) {
		CreatedDate = createdDate;
	}

	
}
