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
@Table(name = "STUDENTI") 
public class Student implements Serializable { 
	 
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	private String ime;
	private String prezime;
	private List<Predmet> predmeti;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getIme() {
		return ime;
	}
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public List<Predmet> getPredmeti() {
		return predmeti;
	}
	
	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", predmeti=" + predmeti + "]";
	}

}
