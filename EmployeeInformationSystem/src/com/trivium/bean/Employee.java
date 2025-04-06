package com.trivium.bean;

public class Employee {
	private int eno;
	private String name;
	private float bp;
	
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getBp() {
		return bp;
	}
	public void setBp(float bp) {
		this.bp = bp;
	}
	
	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", name=" + name + ", bp=" + bp + "]";
	}
	

}
