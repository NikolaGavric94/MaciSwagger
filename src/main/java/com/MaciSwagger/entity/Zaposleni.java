package com.MaciSwagger.entity;


public class Zaposleni {
	
	private int id;
	private String name;
	private double paycheck;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPaycheck() {
		return paycheck;
	}
	public void setPaycheck(double paycheck) {
		this.paycheck = paycheck;
	}
	
	@Override
	public String toString() {
		return "Zaposleni id=" + id + ", name=" + name + ", paycheck=" + paycheck + "";
	}	
	
}