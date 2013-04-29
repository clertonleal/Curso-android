package com.curso.android.aula1.domain;

import java.io.Serializable;
import java.util.List;

public class Registry implements Serializable{
	
	private String name;
	
	private String sex;
	
	private List<String> preferences;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<String> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<String> preferences) {
		this.preferences = preferences;
	}
	
}
