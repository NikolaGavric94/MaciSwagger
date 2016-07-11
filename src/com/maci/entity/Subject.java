package com.maci.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial") 
public class Subject implements Serializable { 
	 
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id; 
	private String naziv;
	private List<Student> studenti;
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public List<Student> getStudenti() {
		return studenti;
	}
	
	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}
	
	@Override
	public String toString() {
		return "Predmet [id=" + id + ", naziv=" + naziv + ", studenti=" + studenti + "]";
	}

}
