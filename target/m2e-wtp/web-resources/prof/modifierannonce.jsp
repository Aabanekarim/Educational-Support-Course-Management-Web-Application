<%@page import="com.classe"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.school"%>
<%@page import="com.annonce"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>school center</title>

   <!-- font awesome cdn link  -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">

   <!-- custom css file link  -->
   <link rel="stylesheet" href="../desgin/css/style.css">

</head>
<body>

<% HttpSession sess=request.getSession(); 
school s=new school();
com.prof p = (com.prof)sess.getAttribute("prof");
sess.setAttribute("fval", "modifierannonce");
int ida=Integer.parseInt(request.getParameter("ida"));
	sess.setAttribute("idan", ida);
	sess.setAttribute("role", "prof");
	com.annonce a=s.getannonce(ida);%>

<header class="header">
   
   <section class="flex">

      <a href="accueil.jsp" style="text-decoration: none;" class="logo">school center</a>

      

      <div class="icons">
         <div id="menu-btn" class="fas fa-bars"></div>
         <div id="search-btn" class="fas fa-search"></div>
         <div id="user-btn" class="fas fa-user"></div>
         <div id="use-btn" class="fas fa-power-off" onclick="window.location.href='../traiter?fval=deconnexion';"></div>
         <div id="toggle-btn" class="fas fa-sun"></div>
      </div>

      <div class="profile">
         <img src="../desgin/images/pic-1.jpg" class="image" alt="">
         <h3 class="name"><%=p.getNom() %><%=p.getPrenom() %></h3>
         <p class="role">professeur</p>
         <a href="profile.jsp" style="text-decoration: none;" class="btn">changer pass</a>
         <div class="flex-btn">
            <a href="../traiter?fval=deconnexion" class="option-btn">deconnexion</a>
         </div>
      </div>

   </section>

</header>   

<div class="side-bar">

   <div id="close-btn">
      <i class="fas fa-times"></i>
   </div>

   <div class="profile">
      <img src="../desgin/images/pic-1.jpg" class="image" alt="">
      <h3 class="name"><%=p.getNom() %><%=p.getPrenom() %></h3>
      <p class="role">professeur</p>
      <a href="profile.jsp" style="text-decoration: none;" class="btn">changer pass</a>
   </div>

   <nav class="navbar">
      <a href="javascript:void(0);" onclick="window.location.href='accueil.jsp';"><i class="fas fa-home"></i><span>home</span></a>
      <a href="javascript:void(0);" onclick="window.location.href='ajouterannonce.jsp';"><i class="fas fa-chalkboard-user"></i><span>ajouter annonce</span></a>
   </nav>

</div>

<section class="form-container">

   <form action="../traiter" method="post" >
      <h3>Modifier Annonce</h3>
      <p>Matier</p>
      <input type="text" name="matier" value="<%=a.getMatier() %>" maxlength="50" class="box" required="required">
      <p>Niveau</p>
      <select class="box" name="niveau" aria-label="Default select example">
                      <option selected value="<%=a.getNiveau() %>"><%=a.getNiveau() %></option>
                      <option value="1er annee">1er annee</option>
                      <option value="2eme annee">2eme annee</option>
                      <option value="3eme annee">3eme annee</option>
                      <option value="4eme annee">4eme annee</option>
                      <option value="5eme annee">5eme annee</option>
                      <option value="6eme annee">6eme annee</option>
                    </select>
      <p>Filiere</p>
      <input type="text" name="filiere" value="<%=a.getFiliere() %>" maxlength="20" class="box" required="required">
      <p>Classe</p>
      <select class="box" name="classe" aria-label="Default select example">
                      <option selected value="<%=a.getClasse() %>"><%=a.getClasse() %></option>
                      <option value="primaire"> primaire</option>
                      <option value="college">college</option>
                      <option value="lycee">lycee</option>
                    </select>
      <p>Prix</p>
      <input type="number" name="prix" value="<%=a.getPrix() %>" maxlength="20" class="box" required="required">
      <p>Temps</p>
      <input type="time" name="time" value="<%=a.getJour() %>" class="box" required="required">
      <p>lundi    <input class="box" type="checkbox" name="jour" value="lundi" id="gridCheck1" <%if(a.getSeance().contains("lundi")){ %> checked="checked" <%} %>></p>
      <p>mardi    <input class="box" type="checkbox" name="jour" value="mardi" id="gridCheck1" <%if(a.getSeance().contains("mardi")){ %> checked="checked" <%} %>></p>
      <p>mercredi    <input class="box" type="checkbox" name="jour" value="mercredi" id="gridCheck1" <%if(a.getSeance().contains("mercredi")){ %> checked="checked" <%} %>></p>
      <p>jeudi    <input class="box" type="checkbox" name="jour" value="jeudi" id="gridCheck1" <%if(a.getSeance().contains("jeudi")){ %> checked="checked" <%} %>></p>
      <p>vendredi    <input class="box" type="checkbox" name="jour" value="vendredi" id="gridCheck1" <%if(a.getSeance().contains("vendredi")){ %> checked="checked" <%} %>></p>
      <p>samedi    <input class="box" type="checkbox" name="jour" value="samedi" id="gridCheck1" <%if(a.getSeance().contains("samedi")){ %> checked="checked" <%} %>></p>
                      
      <input type="submit" value="modifierannonce" name="fval" class="btn">
   </form>

</section>
















<!-- custom js file link  -->
<script src="../desgin/js/script.js"></script>

   
</body>
</html>