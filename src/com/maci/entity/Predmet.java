package com.maci.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial") 
@Entity 
@Table(name = "PREDMETI") 
public class Predmet implements Serializable { 
	 
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id; 
	private String naziv;
	private List<Student> studenti;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
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
