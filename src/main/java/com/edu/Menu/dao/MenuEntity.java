package com.edu.Menu.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MenuEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private String jsonModel;


	public MenuEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MenuEntity(Integer id, String jsonModel) {
		super();
		this.id = id;
		this.jsonModel = jsonModel;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getJsonModel() {
		return jsonModel;
	}


	public void setJsonModel(String jsonModel) {
		this.jsonModel = jsonModel;
	}


	@Override
	public String toString() {
		return "Assignment [id=" + id + ", jsonModel=" + jsonModel + "]";
	}
	
	
	

}
