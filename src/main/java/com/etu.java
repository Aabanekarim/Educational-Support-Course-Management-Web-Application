package com;

public class etu {
	private int id;
	private String nom;
	private String prenom;
	private String classe;
	private String cne;
	private String email;
	private String pass;
	

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

	public etu(int id, String nom, String prenom, String classe, String cne, String email, String pass) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.classe = classe;
		this.cne = cne;
		this.email = email;
		this.pass = pass;
	}
	public etu(int id, String nom, String prenom, String classe, String email, String pass) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.classe = classe;
		this.email = email;
		this.pass = pass;
	}

	public etu(int id, String nom, String prenom, String classe, String cne) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.classe = classe;
		this.cne = cne;
	}
	
	public etu( String nom, String prenom, String classe, String cne) {
		super();
		
		this.nom = nom;
		this.prenom = prenom;
		this.classe = classe;
		this.cne = cne;
	}
	
	@Override
	public String toString() {
		return "etu [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", classe=" + classe + ", cne=" + cne + "]";
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


	public String getClasse() {
		return classe;
	}


	public void setClasse(String classe) {
		this.classe = classe;
	}


	public String getCne() {
		return cne;
	}


	public void setCne(String cne) {
		this.cne = cne;
	}
	
	
}
