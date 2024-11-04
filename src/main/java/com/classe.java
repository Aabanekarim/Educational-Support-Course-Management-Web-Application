package com;

public class classe {
	private int id;
	private String school;
	private String niveau;
	private String filiere;
	private String matiere;
	private prof prof;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public String getFiliere() {
		return filiere;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	public prof getProf() {
		return prof;
	}
	public classe(String school, String niveau, String filiere, String matiere) {
		super();
		school s=new school();
		this.school = school;
		this.niveau = niveau;
		this.filiere = filiere;
		this.matiere = matiere;
	}
	public classe(String school, String niveau, String filiere, String matiere, int idp) {
		super();
		school s=new school();
		this.school = school;
		this.niveau = niveau;
		this.filiere = filiere;
		this.matiere = matiere;
		this.prof = s.getprof(idp);
	}
	public classe(int id, String school, String niveau, String filiere, String matiere, com.prof prof) {
		super();
		this.id = id;
		this.school = school;
		this.niveau = niveau;
		this.filiere = filiere;
		this.matiere = matiere;
		this.prof = prof;
	}
	public classe(int id, String school, String niveau, String filiere, String matiere) {
		super();
		this.id = id;
		this.school = school;
		this.niveau = niveau;
		this.filiere = filiere;
		this.matiere = matiere;
	}
	public classe(int id, String school, String niveau, String filiere, String matiere, int idp) {
		super();
		school s=new school();
		this.id = id;
		this.school = school;
		this.niveau = niveau;
		this.filiere = filiere;
		this.matiere = matiere;
		this.prof = s.getprof(idp);
	}
	public void setProf(prof prof) {
		this.prof = prof;
	}
}
