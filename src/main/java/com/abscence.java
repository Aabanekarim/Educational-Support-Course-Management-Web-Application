package com;

import java.util.Date;

public class abscence {
	private int id;
	private int ide ;
	private int ida ;
	private Date date;
	public int getIde() {
		return ide;
	}
	public void setIde(int ide) {
		this.ide = ide;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIda() {
		return ida;
	}
	public void setIda(int ida) {
		this.ida = ida;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public abscence(int id ,int ida, int ide, Date date) {
		super();
		this.id=id;
		this.ide = ide;
		this.ida = ida;
		this.date = date;
	}
	
}
