package com.highpeak.Ediscovery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CaseCategory")
public class CaseCategory {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	

	@ManyToOne
	@JoinColumn(name="CategoryId")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="CaseId")
	private Cases cases;

	
	public CaseCategory() {
		super();
	}
	
	
	public CaseCategory(int id, Category category, Cases cases) {
		super();
		this.Id = id;
		this.category = category;
		this.cases = cases;
	}


	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Cases getCases() {
		return cases;
	}

	public void setCases(Cases cases) {
		this.cases = cases;
	}
	
	
}
