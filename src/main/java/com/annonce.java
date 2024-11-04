package com;

public class annonce {
	
	private int id;
	private String matier;
	private String classe;
	private String niveau;
	private String filiere;
	private String jour;
	private String seance;
	private prof prof;
	private int prix;
	
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public String getFiliere() {
		return filiere;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMatier() {
		return matier;
	}
	public void setMatier(String matier) {
		this.matier = matier;
	}
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	public String getSeance() {
		return seance;
	}
	public void setSeance(String seance) {
		this.seance = seance;
	}
	public prof getProf() {
		return prof;
	}
	public void setProf(prof prof) {
		this.prof = prof;
	}
	
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	@Override
	public String toString() {
		return "annonce [id=" + id + ", matier=" + matier + ", jour=" + jour + ", seance=" + seance + ", prof=" + prof
				+ "]";
	}
	public annonce(int id, String matier, String test, String niveau,String filiere, String jour, String seance, com.prof prof , int prix) {
		super();
		this.id = id;
		this.matier = matier;
		test.replace('_', ' ');
		this.classe=test;
		this.filiere=niveau;
		this.niveau=filiere;
		this.jour = seance;
		this.seance = jour;
		this.prof = prof;
		this.prix=prix;
		
	}
	
	public annonce(int id, String matier, String test, String niveau, String filiere, String jour, String seance, int idp,int prix) {
		super();
		school s=new school();
		this.id = id;
		this.matier = matier;
		test.replace('_', ' ');
		this.classe=test;
		this.filiere=niveau;
		this.niveau=filiere;
		this.jour = seance;
		this.seance = jour;
		this.prof = s.getprof(idp);
		this.prix=prix;
		
	}
	public annonce( String matier, String test, String niveau,String filiere, String jour, String seance, int idp, int prix) {
		super();
		school s=new school();
		
		this.matier = matier;
		test.replace('_', ' ');
		this.classe=test;
		this.niveau=niveau;
		this.filiere=filiere;
		this.jour = seance;
		this.seance = jour;
		this.prof = s.getprof(idp);
		this.prix=prix;
		
	}
	
	
}
