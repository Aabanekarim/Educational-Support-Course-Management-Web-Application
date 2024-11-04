package com;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.jakartaee.commons.io.LineIterator;

public class school implements ischool {

	@Override
	public etu getetu(String email, String pass) {
		etu e=null;
		jdbc.connect();
		ResultSet rs = jdbc.select("select * from etudiant where email like '"+email+"' and pass like '"+pass+"'");
		try {
			if(rs.next()) {
				e = new etu(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jdbc.disconnect();
		return e;
	}

	@Override
	public etu getetu(int id) {
		etu e=null;
		jdbc.connect();
		ResultSet rs = jdbc.select("select * from etudiant where id="+id);
		try {
			if(rs.next()) {
				e = new etu(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jdbc.disconnect();
		return e;
	}

	@Override
	public int ajouteretu(etu e) {
		jdbc.connect();
		int nb = jdbc.Maj("insert into etudiant ( nom, prenom, classe, cne, email, pass)  values ('"+e.getNom()+"', '"+e.getPrenom()+"', '"+e.getClasse()+"','"+e.getCne()+"','"+e.getNom()+e.getPrenom()+"@school.com','"+e.getCne()+"')");
		jdbc.disconnect();
		return nb ;
	}

	@Override
	public List<annonce> listeanounce() {
		List<annonce> l=new ArrayList<annonce>();
		jdbc.connect();
		ResultSet rs = jdbc.select("select * from annonce ");
		try {
			while(rs.next()) {
				annonce e = new annonce(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(9));
				l.add(e);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jdbc.disconnect();
		return l;
	}

	@Override
	public prof getprof(int id) {
		prof e=null;
		jdbc.connect();
		ResultSet rs = jdbc.select("select * from prof where id = "+id);
		try {
			if(rs.next()) {
				e = new prof(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jdbc.disconnect();
		return e;
	}

	@Override
	public int inscrirenannonce(int ida, int ide) {
		jdbc.connect();
		LocalDate d= LocalDate.now();
		int nb = jdbc.Maj("insert into tabinscrir(ida,ide,datepaiment) values ("+ida+", "+ide+", '"+d+"')");
		jdbc.disconnect();
		return nb ;
	}

	@Override
	public int checkinscrir(int ida, int ide) {
		int n=0;
		jdbc.connect();
		ResultSet rs = jdbc.select("select * from tabinscrir where ida = "+ida+" and ide = "+ide);
		try {
			if(rs.next()) {
				n=1;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jdbc.disconnect();
		return n;
	}

	@Override
	public List<annonce> monannonce(int ide) {
		List<annonce> l=new ArrayList<annonce>();
		jdbc.connect();
		ResultSet rs = jdbc.select("select * from tabinscrir where ide = "+ide);
		try {
			while(rs.next()) {
				annonce e=getannonce(rs.getInt(2));
				l.add(e);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jdbc.disconnect();
		return l;
	}

	@Override
	public annonce getannonce(int ida) {
		annonce e=null;
		jdbc.connect();
		ResultSet rs = jdbc.select("select * from annonce where id = "+ida);
		try {
			if(rs.next()) {
				e = new annonce(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(9));
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jdbc.disconnect();
		return e;
	}

	@Override
	public List<annonce> classeannonce(String classe, String niveau ,String filiere) {
		List<annonce> l=new ArrayList<annonce>();
		jdbc.connect();
		ResultSet rs = jdbc.select("select * from annonce where classe like '"+classe+"' and niveau like '"+filiere+"' and filiere like '"+niveau+"'");
		try {
			while(rs.next()) {
				annonce e=getannonce(rs.getInt(1));
				l.add(e);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jdbc.disconnect();
		return l;
	}

	@Override
	public prof getprof(String email, String pass) {
		prof e=null;
		jdbc.connect();
		ResultSet rs = jdbc.select("select * from prof where email like '"+email+"' and pass like '"+pass+"'");
		try {
			if(rs.next()) {
				e = new prof(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jdbc.disconnect();
		return e;
	}

	@Override
	public List<annonce> listeanouncep(int id) {
		List<annonce> l=new ArrayList<annonce>();
		jdbc.connect();
		ResultSet rs = jdbc.select("select * from annonce where idp ="+id);
		try {
			while(rs.next()) {
				annonce e = new annonce(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(9));
				l.add(e);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jdbc.disconnect();
		return l;
	}

	@Override
	public void supprimerannonce(int ida) {
		jdbc.connect();
		int nb = jdbc.Maj("delete from annonce where id="+ida);
		jdbc.disconnect();
		jdbc.connect();
		nb = jdbc.Maj("delete from tabinscrir where ida="+ida);
		jdbc.disconnect();
		jdbc.connect();
		nb = jdbc.Maj("delete from abscence where ida="+ida);
		jdbc.disconnect();
	}

	@Override
	public int ajouterannonce(annonce a) {
		jdbc.connect();
		int nb = jdbc.Maj("insert into annonce ( matier, classe,niveau,filiere, jour, seance, idp , prix)  values ('"+a.getMatier()+"', '"+a.getClasse()+"','"+a.getFiliere()+"','"+a.getNiveau()+"' ,'"+a.getJour()+"','"+a.getSeance()+"',"+a.getProf().getId()+","+a.getPrix()+")");
		jdbc.disconnect();
		jdbc.connect();
		ResultSet rs =jdbc.select("select * from classe where school like '"+a.getClasse()+"' and niveau like '"+a.getNiveau()+"' and filiere like '"+a.getFiliere()+"' and matiere like '"+a.getMatier()+"'");
		try {
			if(rs.next()) {
				
			}else {
				jdbc.disconnect();
				jdbc.connect();
				int k=jdbc.Maj("insert into classe (school,niveau,filiere,matiere,idp) values ('"+a.getClasse()+"','"+a.getNiveau()+"','"+a.getFiliere()+"','"+a.getMatier()+"',"+a.getProf().getId()+")");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jdbc.disconnect();
		return nb ;
	}

	@Override
	public void modifierannonce(annonce a) {
		jdbc.connect();
		int nb = jdbc.Maj("UPDATE annonce SET matier='"+a.getMatier()+"',classe='"+a.getClasse()+"',jour='"+a.getJour()+"',niveau='"+a.getNiveau()+"',filiere ='"+a.getFiliere()+"',seance='"+a.getSeance()+"',idp='"+a.getProf().getId()+"',prix='"+a.getPrix()+"' WHERE id="+a.getId());
		jdbc.disconnect();
		
	}

	@Override
	public List<etu> listetuannonce(int id) {
		List<etu> l=new ArrayList<etu>();
		jdbc.connect();
		ResultSet rs = jdbc.select("select * from tabinscrir where ida ="+id);
		try {
			while(rs.next()) {
				etu e=getetu(rs.getInt(3));
				l.add(e);
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jdbc.disconnect();
		return l;
	}

	@Override
	public void ajouterabscence(int ida, int ide) {
		jdbc.connect();
		int nb = jdbc.Maj("insert into abscence ( ida,ide )  values ("+ida+", "+ide+")");
		jdbc.disconnect();
	}

	@Override
	public int getpayement(int ide,int ida) {
		int n=0;
		jdbc.connect();
		ResultSet rs = jdbc.select("select * from tabinscrir where ida ="+ida+" and ide = "+ide);
		try {
			if(rs.next()) {
				n=rs.getInt(5);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jdbc.disconnect();
		return n;
	}

	@Override
	public List<etu> listetu() {
		List<etu> l=new ArrayList<etu>();
		jdbc.connect();
		ResultSet rs = jdbc.select("select * from etudiant");
		try {
			while(rs.next()) {
				etu e=new etu(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				l.add(e);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jdbc.disconnect();
		return l;
	}

	@Override
	public List<prof> listprof() {
		List<prof> l=new ArrayList<prof>();
		jdbc.connect();
		ResultSet rs = jdbc.select("select * from prof");
		try {
			while(rs.next()) {
				prof e=new prof(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				l.add(e);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jdbc.disconnect();
		return l;
	}

	@Override
	public List<annonce> listannonce() {
		List<annonce> l=new ArrayList<annonce>();
		jdbc.connect();
		ResultSet rs = jdbc.select("select * from annonce");
		try {
			while(rs.next()) {
				annonce e=getannonce(rs.getInt(1));
				l.add(e);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jdbc.disconnect();
		return l;
	}

	@Override
	public void modiferetu(etu e) {
		jdbc.connect();
		int nb = jdbc.Maj("UPDATE etudiant SET nom='"+e.getNom()+"',prenom='"+e.getPrenom()+"',classe='"+e.getClasse()+"',cne='"+e.getCne()+"',email='"+e.getEmail()+"',pass='"+e.getPass()+"' WHERE id="+e.getId());
		jdbc.disconnect();
		
	}

	@Override
	public int supprimeretu(int ide) {
		
		jdbc.connect();
		int nb = jdbc.Maj("delete from etudiant where id="+ide);
		jdbc.disconnect();
		jdbc.connect();
		int n = jdbc.Maj("delete from tabinscrir where ide="+ide);
		jdbc.disconnect();
		jdbc.connect();
		n = jdbc.Maj("delete from abscence where ide="+ide);
		jdbc.disconnect();
		return nb;
	}

	@Override
	public void modifierprof(prof p) {
		jdbc.connect();
		int nb = jdbc.Maj("UPDATE prof SET nom='"+p.getNom()+"',prenom='"+p.getPrenom()+"',com='"+p.getCom()+"',email='"+p.getEmail()+"',pass='"+p.getPass()+"' WHERE id="+p.getId());
		jdbc.disconnect();
		
	}

	@Override
	public List<classe> listeclasse() {
		List<classe> l=new ArrayList<classe>();
		jdbc.connect();
		ResultSet rs = jdbc.select("select * from classe");
		try {
			while(rs.next()) {
				classe e=new classe(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				l.add(e);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jdbc.disconnect();
		return l;
	}
	@Override
	public List<String> listesc() {
		List<String> l=new ArrayList<String>();
		int n=0;
		jdbc.connect();
		ResultSet rs = jdbc.select("select distinct school  from classe");
		try {
			while(rs.next()) {
				
				
					l.add(rs.getString(1));
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jdbc.disconnect();
		return l;
	}

	@Override
	public List<String> listschool(String classe) {
		List<String> l=new ArrayList<String>();
		int n=0;
		jdbc.connect();
		ResultSet rs = jdbc.select("select distinct niveau  from classe where school like '"+classe+"'");
		try {
			while(rs.next()) {
				
				
				
					l.add(rs.getString(1));
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jdbc.disconnect();
		return l;
	}

	@Override
	public List<String> listniveau(String classe, String niveau) {
		List<String> l=new ArrayList<String>();
		int n=0;
		jdbc.connect();
		ResultSet rs = jdbc.select("select distinct filiere from classe where school like '"+classe+"' and niveau like '"+niveau+"'");
		try {
			while(rs.next()) {
				
					l.add(rs.getNString(1));
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jdbc.disconnect();
		return l;
	}

	@Override
	public List<classe> listfiliere(String classe, String niveau ,String filiere) {
		List<classe> l=new ArrayList<classe>();
		int n=0;
		jdbc.connect();
		ResultSet rs = jdbc.select("select * from classe where school like '"+classe+"' and niveau like '"+niveau+"' and filiere like '"+filiere+"'");
		try {
			while(rs.next()) {
				for(classe i : l) {
					if(i.getMatiere()==rs.getString(5)) {
						n=1;
					}
				}
				if(n==0) {
					classe c=new classe(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
					l.add(c);
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jdbc.disconnect();
		return l;
	}

	@Override
	public void supprimerclasse(int idc) {
		
		jdbc.connect();
		classe c=getclasse(idc);
		int nb = jdbc.Maj("delete from annoce where matier like '"+c.getMatiere()+"' and classe like '"+c.getSchool()+"' and niveau like '"+c.getNiveau()+"' and filiere like '"+c.getFiliere()+"'");
		jdbc.disconnect();
		jdbc.connect();
		 nb = jdbc.Maj("delete from classe where id = "+idc);
		jdbc.disconnect();
		
	}

	@Override
	public classe getclasse(int idc) {
		classe e = null;
		jdbc.connect();
		ResultSet rs = jdbc.select("select * from classe where id = "+idc);
		try {
			if(rs.next()) {
				e=new classe(idc, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jdbc.disconnect();
		return e;
	}

	@Override
	public List<annonce> classeannonce(String classe, String niveau) {
		List<annonce> l=new ArrayList<annonce>();
		jdbc.connect();
		ResultSet rs = jdbc.select("select * from annonce where classe like '"+classe+"' and filiere like '"+niveau+"'");
		try {
			while(rs.next()) {
				annonce e=getannonce(rs.getInt(1));
				l.add(e);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jdbc.disconnect();
		return l;
	}

	@Override
	public int supprimerprof(int idp) {
		
		jdbc.connect();
		int nb = jdbc.Maj("delete from prof where id="+idp);
		jdbc.disconnect();
		jdbc.connect();
		int n = jdbc.Maj("delete from annonce where idp="+idp);
		jdbc.disconnect();
		return nb;
	}

	@Override
	public void ajouterprof(prof p) {
		jdbc.connect();
		int nb = jdbc.Maj("insert into prof (nom , prenom , com , email, pass) values ('"+p.getNom()+"','"+p.getPrenom()+"','none','"+p.getEmail()+"','"+p.getPass()+"')");
		jdbc.disconnect();
		
	}

	@Override
	public void ajouterclasse(classe c) {
		jdbc.connect();
		jdbc.Maj("insert into classe (school , niveau , filiere , matiere ,idp) values ('"+c.getSchool()+"','"+c.getNiveau()+"','"+c.getFiliere()+"','"+c.getMatiere()+"', -1)");
		jdbc.disconnect();
		
	}

	@Override
	public void modifierclasse(classe c) {
		int id = -1;
		jdbc.connect();
		if(c.getProf()!=null) {
			id=c.getProf().getId();
		}
		jdbc.Maj("update classe set school = '"+c.getSchool()+"' , niveau = '"+c.getNiveau()+"' , filiere = '"+c.getFiliere()+"' , matiere = '"+c.getMatiere()+"' , idp = "+id+" where id = "+c.getId()+" ");
		jdbc.disconnect();
		
	}

	@Override
	public void setpaiment(int ide, int ida) {
		jdbc.connect();
		LocalDate d= LocalDate.now();
		jdbc.Maj("update tabinscrir set payement = 1 , datepaiment = '"+d+"' where ida = "+ida+" and ide = "+ide);
		jdbc.disconnect();
	}

	@Override
	public Date getdate(int ide, int ida) {
		Date d = null;
		jdbc.connect();
		ResultSet rs = jdbc.select("select * from tabinscrir where ida = "+ida+" and ide ="+ide);
		try {
			if(rs.next()) {
				d=rs.getDate(6);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}

	@Override
	public void setpaimentne(int ide, int ida) {
		jdbc.connect();
		jdbc.Maj("update tabinscrir set payement = 0 where ida = "+ida+" and ide = "+ide);
		jdbc.disconnect();
	}

	@Override
	public int nombre_jour(int ide, int ida) {
		int nd =0;
		jdbc.connect();
		ResultSet rs = jdbc.select("SELECT DATEDIFF(NOW(), datepaiment) AS NombreDeJours "
				+ "FROM tabinscrir "
				+ "WHERE ide = "+ide+" and ida = "+ida);
		try {
			if(rs.next()) {
				nd = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jdbc.disconnect();
		return nd;
	}

	@Override
	public int checkcne(String cne) {
		int n =0;
		jdbc.connect();
		ResultSet rs = jdbc.select("select * from etudiant where cne like '"+cne+"'");
		try {
			if (rs.next()) {
				n=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jdbc.disconnect();
		return n;
	}

	@Override
	public admine getadmin(String email, String pass) {
		admine e=null;
		jdbc.connect();
		ResultSet rs = jdbc.select("select * from admine where email like '"+email+"' and pass like '"+pass+"'");
		try {
			if(rs.next()) {
				e = new admine(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jdbc.disconnect();
		return e;
	}

	@Override
	public admine getadmin(int id) {
		admine e=null;
		jdbc.connect();
		ResultSet rs = jdbc.select("select * from admine where id="+id);
		try {
			if(rs.next()) {
				e = new admine(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jdbc.disconnect();
		return e;
	}

	@Override
	public int changepass(String pass, etu e) {
		int nb=0;
		jdbc.connect();
		nb=jdbc.Maj("update etudiant set pass = '"+pass+"' where id = "+e.getId());
		jdbc.disconnect();
		return nb;
	}

	@Override
	public int changepass(String pass, admine e) {
		int nb=0;
		jdbc.connect();
		nb=jdbc.Maj("update admine set pass = '"+pass+"' where id = "+e.getId());
		jdbc.disconnect();
		return nb;
	}

	@Override
	public int changepass(String pass, prof e) {
		int nb=0;
		jdbc.connect();
		nb=jdbc.Maj("update prof set pass = '"+pass+"' where id = "+e.getId());
		jdbc.disconnect();
		return nb;
	}

	@Override
	public List<abscence> listeabscence() {
		List<abscence> l=new ArrayList<abscence>();
		jdbc.connect();
		ResultSet rs = jdbc.select("select * from abscence ");
		try {
			while(rs.next()) {
				abscence e = new abscence(rs.getInt(1) ,rs.getInt(2), rs.getInt(3), rs.getDate(4));
				l.add(e);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jdbc.disconnect();
		return l;
	}

	@Override
	public void supprimerabscence(int id) {
		jdbc.connect();
		int n = jdbc.Maj("delete from abscence where id="+id);
		jdbc.disconnect();
	}
	@Override
	public int checkpass(String pass , String email) {
		int n =0;
		jdbc.connect();
		ResultSet rs = jdbc.select("select * from prof where pass like '"+pass+"' and email like '"+email+"'");
		try {
			if (rs.next()) {
				n=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jdbc.disconnect();
		return n;
	}

	@Override
	public int checketu(String pass, String email) {
		int n =0;
		jdbc.connect();
		ResultSet rs = jdbc.select("select * from etudiant where pass like '"+pass+"' and email like '"+email+"'");
		try {
			if (rs.next()) {
				n=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jdbc.disconnect();
		return n;
	}

	@Override
	public int quitterannonce(int ida, int ide) {
		jdbc.connect();
		LocalDate d= LocalDate.now();
		int nb = jdbc.Maj("delete from tabinscrir where ide = "+ide+" and ida = "+ida+"");
		jdbc.disconnect();
		return nb ;
	}

	@Override
	public int nb_etudiants() {
		jdbc.connect();
		ResultSet rs = jdbc.select("select count(*) from etudiant");
		try {
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jdbc.disconnect();
		return 0;
	}

	@Override
	public int nb_professeur() {
		jdbc.connect();
		ResultSet rs = jdbc.select("select count(*) from prof");
		try {
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jdbc.disconnect();
		return 0;
	}

	@Override
	public int total_prix() {
		int nb = 0;
		jdbc.connect();
		ResultSet rs = jdbc.select("select * from tabinscrir where payement = 1");
		
		try {
			while(rs.next()) {
				
				ResultSet rd = jdbc.select("select prix from annonce where id ="+rs.getInt(2));
				if(rd.next()) {
					nb+=rd.getInt(1);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jdbc.disconnect();
		return nb;
	}
	

}
