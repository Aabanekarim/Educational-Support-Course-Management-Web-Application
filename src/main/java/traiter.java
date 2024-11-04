

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.swing.plaf.InternalFrameUI;

import com.admine;
import com.annonce;
import com.prof;

import java.io.InputStreamReader;

/**
 * Servlet implementation class traiter
 */
@WebServlet("/traiter")
public class traiter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public traiter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		com.ischool s=new com.school();
		String fval=request.getParameter("fval");
		HttpSession sess = request.getSession();
		if(fval==null) {
			fval = (String)sess.getAttribute("fval");
		}
		switch (fval) {
		case "login":
			String email=request.getParameter("email");
			String pass=request.getParameter("pass");
			if(email.contains("@adm.school.com")) {
					admine ad = s.getadmin(email, pass);
					if(ad!=null) {
						List<com.etu> l=s.listetu();
						sess.setAttribute("listetudiants", l);
						for(com.etu e : s.listetu()) {
							for(annonce a: s.monannonce(e.getId())) {
					        	if(s.getpayement(e.getId(), a.getId())==1) {
					        		int n = s.nombre_jour(e.getId(), a.getId());
						        	if(n>28) {
						        		s.setpaimentne(e.getId(), a.getId());
						        	}
					        	}
					        }
						}
						sess.setAttribute("admine", ad);
						response.sendRedirect("admine/accueil.jsp");
					}else {
					
					response.sendRedirect("login.html");
					}
				
			}else {
			if(email.contains("@ens.")) {
				com.prof p =s.getprof(email,pass);
				if(p!=null) {
					sess.setAttribute("prof", p);
					response.sendRedirect("prof/accueil.jsp");
				}else {
					response.sendRedirect("login.html");
				}
			}else {
				
				
				
				com.etu e = null;
				e=s.getetu(email, pass);

		        
				if(e!=null) {
					
					sess.setAttribute("etu", e);
					List<annonce> l=s.listeanounce();
					sess.setAttribute("lannonce", l);
					
			        for(annonce a: s.monannonce(e.getId())) {
			        	if(s.getpayement(e.getId(), a.getId())==1) {
			        		int n = s.nombre_jour(e.getId(), a.getId());
				        	if(n>28) {
				        		s.setpaimentne(e.getId(), a.getId());
				        	}
			        	}
			        }
					
					response.sendRedirect("etudiant/accueil.jsp");
				}else {
					response.sendRedirect("login.html");
				}
			}
			
		}
			break;
		case "createacount":
			String nom=request.getParameter("nom");
			String prenom=request.getParameter("prenom");
			String classe=request.getParameter("classe");
			String cne=request.getParameter("cne");
			com.etu e=new com.etu(nom, prenom, classe, cne);
			if(s.checkcne(cne)==0) {
				s.ajouteretu(e);
				response.sendRedirect("login.html");
			}else {
				sess.setAttribute("msg", "compte deja existe");
				response.sendRedirect("createacount.html");
			}
			break;
		case "inscrirannonce":
			
			int ida=Integer.parseInt(request.getParameter("ida"));
			com.etu et=(com.etu)sess.getAttribute("etu");
			s.inscrirenannonce(ida, et.getId());
			response.sendRedirect("etudiant/accueil.jsp");
			break;
		case "quitterannonce":
			int idaaa=Integer.parseInt(request.getParameter("ida"));
			com.etu eett=(com.etu)sess.getAttribute("etu");
			s.quitterannonce(idaaa,eett.getId());
			response.sendRedirect("etudiant/accueil.jsp");
			break;
		case "deconnexion" :
			sess.invalidate();
			response.sendRedirect("login.html");
			break;
		case "monannonce" :
			List<annonce> l=s.monannonce(Integer.parseInt(request.getParameter("id")));
			sess.setAttribute("monliste", l);
			response.sendRedirect("etudiant/monannounce.jsp");
			break;
		case "chercherannonce" :
			String classee = request.getParameter("classe");
			String niveaue = request.getParameter("niveau");
			String filieree = request.getParameter("filiere");
			List<annonce> le=s.classeannonce(classee,niveaue,filieree);
			sess.setAttribute("classeannonce", le);
			response.sendRedirect("etudiant/classeannonce.jsp");
			break;
		case "deleteannonce" :
			s.supprimerannonce(Integer.parseInt(request.getParameter("ida")));
			com.prof pro = (com.prof)sess.getAttribute("prof");
			if(pro==null) {
				response.sendRedirect("admine/annonces.jsp");
			}else {
				response.sendRedirect("prof/accueil.jsp");
			}
			break;
		case "ajouterannonce" :
			String matier=request.getParameter("matier");
			String classse=request.getParameter("classe");
			String niveau=request.getParameter("niveau");
			String filiere=request.getParameter("filiere");
			String temp=request.getParameter("time");
			int prix=Integer.parseInt(request.getParameter("prix"));
			com.prof p=(com.prof)sess.getAttribute("prof");
			int idp=p.getId();
			String[] jour=request.getParameterValues("jour");
			String seance="";
			String test="";
			for(String j : jour) {
				test+=j+" - ";
			}
			char[] c=test.toCharArray();
			for(int i =0;i<c.length-3;i++) {
				seance+=c[i];
			}
			annonce a =new annonce(matier, classse,niveau,filiere, temp, seance, idp,prix);
			s.ajouterannonce(a);
			
			response.sendRedirect("prof/accueil.jsp");
			break;
		case "modifierannonce" :
			int idpr=-1;
			String matiere=request.getParameter("matier");
			String clsse=request.getParameter("classe");
			String niveau1=request.getParameter("niveau");
			String filiere1=request.getParameter("filiere");
			String temps=request.getParameter("time");
			int prixe=Integer.parseInt(request.getParameter("prix"));
			if(request.getParameter("idprof")==null) {
				com.prof pr=(com.prof)sess.getAttribute("prof");
				idpr=pr.getId();
			}else {
				idpr=Integer.parseInt(request.getParameter("idprof"));
			}
			String[] jourr=request.getParameterValues("jour");
			String sseance="";
			String testt="";
			for(String jj : jourr) {
				testt+=jj+" - ";
			}
			char[] cc=testt.toCharArray();
			for(int i =0;i<cc.length-3;i++) {
				sseance+=cc[i];
			}
			int idaa =(int)(sess.getAttribute("idan"));
			com.annonce aa=new com.annonce(idaa,matiere, clsse,niveau1,filiere1, sseance, temps, idpr, prixe);
			s.modifierannonce(aa);
			sess.setAttribute("idan", idaa);
			String role = (String) sess.getAttribute("role");
			if(role.equals("prof")) {
				response.sendRedirect("prof/accueil.jsp");
			}else {
				response.sendRedirect("admine/annonces.jsp");
			}
			break;
		case "abscence" :
			int iida = Integer.parseInt(request.getParameter("ida"));
			List<com.etu> letuu=s.listetuannonce(iida);
			sess.setAttribute("listetu", letuu);
			sess.setAttribute("idannonce", iida);
			response.sendRedirect("prof/listabsence.jsp");
			break;
		case "modifieretu":
			int eide = (int)sess.getAttribute("ide");
			String enom = request.getParameter("nom");
			String eprenom = request.getParameter("prenom");
			String eclasse = request.getParameter("classe");
			if(eclasse==null) {
				eclasse = s.getetu(eide).getClasse();
			}
			String eemail = request.getParameter("email");
			String epass = request.getParameter("pass");
			if(s.checketu(epass, eemail)==0) {
				com.etu eee=new com.etu(eide, enom, eprenom, eclasse, eemail, epass);
				s.modiferetu(eee);
				response.sendRedirect("admine/etudiants.jsp");
			}else {
				sess.setAttribute("testpass", "compte deja existe");
				response.sendRedirect("admine/admine_modifier_e.jsp");
			}
			break;
		case "ajouterabscence" :
			String[] names=request.getParameterValues("etus");
			int idda = (int)sess.getAttribute("idannonce");
			for(String ee : names) {
				int idd = Integer.parseInt(ee);
				s.ajouterabscence(idda, idd);
			}
			response.sendRedirect("prof/accueil.jsp");
			break;
		case "supprimeretu" :
			int iide = Integer.parseInt(request.getParameter("ide"));
			int nbr=s.supprimeretu(iide);
			if(nbr!=0) {
				response.sendRedirect("admine/etudiants.jsp");
			}
			break;
		case "modifierprof" :
			String pnom = request.getParameter("nom");
			String pprenom = request.getParameter("prenom");
			String pemail = request.getParameter("email");
			String ppass = request.getParameter("pass");
			String ppass2 = request.getParameter("pass2");
			String pcom = request.getParameter("com");
			int pidp = (int)sess.getAttribute("idp");
			if(ppass2.equals(ppass)) {
				if(pcom==null) {
					com.prof prof_com = s.getprof(pidp);
					pcom=prof_com.getCom();
				}
				if(s.checkpass(ppass2, pemail)==0) {
					com.prof pp =new com.prof(pidp, pnom, pprenom, pcom, pemail, ppass);
					s.modifierprof(pp);
					response.sendRedirect("admine/prof.jsp");
				}else {
					sess.setAttribute("testpass", "compte deja existe");
					response.sendRedirect("admine/admin_modifier_p.jsp");
				}
			}
			else {
				sess.setAttribute("testpass", "mot de pass est irronnee");
				response.sendRedirect("admine/admin_modifier_p.jsp");
			}
			break;
		case "supprimerprof" :
			int iidp = Integer.parseInt(request.getParameter("idp"));
			int nbrr=s.supprimerprof(iidp);
			if(nbrr!=0) {
				response.sendRedirect("admine/prof.jsp");
			}
			
			break;
		case "ajouterprof" :
			String ppnom = request.getParameter("nom");
			String ppprenom = request.getParameter("prenom");
			String pppass = request.getParameter("pass");
			String pppass2 = request.getParameter("pass2");
			if(pppass.equals(pppass2)) {
				if(s.checkpass(pppass2,ppnom+ppprenom+"@ens.school.com")==0) {
					com.prof po=new prof(ppnom, ppprenom, ppnom+ppprenom+"@ens.school.com", pppass2);
					s.ajouterprof(po);
					sess.setAttribute("testpass", ppnom+" ete ajouter");
					response.sendRedirect("admine/ajouterprof.jsp");
				}else {
					sess.setAttribute("testpass", "compte deja existe");
					response.sendRedirect("admine/ajouterprof.jsp");
				}
			}
			else {
				sess.setAttribute("testpass", "mot de pass est irronnee");
				response.sendRedirect("admine/ajouterprof.jsp");
			}
			
			
			break;
		case "modifierclasse" :
			int idcc = (int)sess.getAttribute("idc");
			String c1 = request.getParameter("matier");
			String c2 = request.getParameter("classe");
			String c3 = request.getParameter("filier");
			int idcp = Integer.parseInt(request.getParameter("idprof"));
			String c4 = request.getParameter("niveau");
			com.classe clc =new com.classe(idcc,c2, c4, c3, c1, idcp);
			s.modifierclasse(clc);
			response.sendRedirect("admine/classe.jsp");
			break;
		case "ajouterclasse" :
			
			String c11 = request.getParameter("matier");
			String c22 = request.getParameter("classe");
			String c33 = request.getParameter("filiere");;
			String c44 = request.getParameter("niveau");
			com.classe clcc =new com.classe(c22, c44, c33, c11);
			s.ajouterclasse(clcc);
			sess.setAttribute("testpass", c11+" ete ajouter");
			response.sendRedirect("admine/ajoutermatiere.jsp");
			break;
		case "paiment":
			int idap =Integer.parseInt(request.getParameter("ida"));
			int idep =Integer.parseInt(request.getParameter("ide"));
			s.setpaiment(idep, idap);
			response.sendRedirect("admine/chercherannonce.jsp");
			
			break;
		case "changerpass" :
			String dpass = request.getParameter("dpass");
			String npass = request.getParameter("npass");
			String cpass = request.getParameter("cpass");
			com.etu ett = (com.etu)sess.getAttribute("etu");
			com.prof proff = (com.prof)sess.getAttribute("prof");
			com.admine admin = (com.admine)sess.getAttribute("admine");
			if(ett!=null) {
				if(dpass.equals(ett.getPass())) {
					if(npass.equals(cpass)) {
						s.changepass(cpass, ett);
						response.sendRedirect("etudiant/accueil.jsp");
					}else {
						sess.setAttribute("msgpass","le nouveau mot de pass n'egale pas confirmation mot de pass" );
						response.sendRedirect("etudiant/profile.jsp");
					}
				}else {
					sess.setAttribute("msgpass","l'ancienne mot de pass erroner" );
					response.sendRedirect("etudiant/profile.jsp");
				}
			}else {
				if(proff!=null) {
					if(dpass.equals(proff.getPass())) {
						if(npass.equals(cpass)) {
							s.changepass(cpass, proff);
							response.sendRedirect("prof/accueil.jsp");
						}else {
							sess.setAttribute("msgpass","le nouveau mot de pass n'egale pas confirmation mot de pass" );
							response.sendRedirect("prof/profile.jsp");
						}
					}else {
						sess.setAttribute("msgpass","l'ancienne mot de pass erroner" );
						response.sendRedirect("prof/profile.jsp");
					}
				}else {
					if(admin!=null) {
						if(dpass.equals(admin.getPass())) {
							if(npass.equals(cpass)) {
								s.changepass(cpass, admin);
								response.sendRedirect("admine/prof.jsp");
							}else {
								sess.setAttribute("msgpass","le nouveau mot de pass n'egale pas confirmation mot de pass" );
								response.sendRedirect("admine/profile.jsp");
							}
						}else {
							sess.setAttribute("msgpass","l'ancienne mot de pass erroner" );
							response.sendRedirect("admine/profile.jsp");
						}
					}
				}
			}
			
			break;
		case "supprimerclasse" :
			int iidc = Integer.parseInt(request.getParameter("idc"));
			s.supprimerclasse(iidc);
			response.sendRedirect("admine/classe.jsp");
			
			break;
		case "supprimerabscence":
			int idab = Integer.parseInt(request.getParameter("idab"));
			s.supprimerabscence(idab);
			response.sendRedirect("admine/afficherabscense.jsp");
			break;
		default:
			sess.invalidate();
			response.sendRedirect("login.html");
		}										
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
