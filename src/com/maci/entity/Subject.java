package com.maci.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Subject implements Serializable {

	private Integer id;
	private String naziv;

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

	@Override
	public String toString() {
		return "Predmet [id=" + id + ", naziv=" + naziv + ", studenti=" + "]";
	}

}
