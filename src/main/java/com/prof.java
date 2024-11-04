package com;

public class prof {
	
	private int id;
	private String nom;
	private String prenom;
	private String com;
	private String email;
	private String pass;
	public prof(int id, String nom, String prenom, String com, String email, String pass) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.com = com;
		this.email = email;
		this.pass = pass;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getCom() {
		return com;
	}
	public void setCom(String com) {
		this.com = com;
	}
	@Override
	public String toString() {
		return "prof [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", com=" + com + "]";
	}
	public prof(int id, String nom, String prenom, String email ,String pass) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email=email;
		this.pass=pass;
	}
	public prof(String nom, String prenom, String email ,String pass) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email=email;
		this.pass=pass;
	}
	
	

}
