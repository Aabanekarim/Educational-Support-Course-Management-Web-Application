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
	com.etu u = (com.etu)sess.getAttribute("etu");
	String classe = request.getParameter("classe");%>

<header class="header">
   
   <section class="flex">

      <a href="accueil.jsp" style="text-decoration: none;" class="logo">school center</a>

      

      <div class="icons">
         <div id="menu-btn" class="fas fa-bars"></div>
         <div id="search-btn" class="fas fa-search"></div>
         <div id="user-btn" class="fas fa-user" onclick="window.location.href='../traiter?fval=deconnexion';"></div>
         <div id="use-btn" class="fas fa-power-off" onclick="window.location.href='../traiter?fval=deconnexion';"></div>
         <div id="toggle-btn" class="fas fa-sun"></div>
      </div>

      <div class="profile active">
         <img src="../desgin/images/pic-1.jpg" class="image" alt="">
         <h3 class="name"><%=u.getNom() %><%=u.getPrenom() %></h3>
         <p class="role">etudiant</p>
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
      <h3 class="name"><%=u.getNom() %><%=u.getPrenom() %></h3>
      <p class="role">etudiant</p>
      <a href="profile.jsp" style="text-decoration: none;" class="btn">changer pass</a>
      
   </div>

   <nav class="navbar">
    <a href="javascript:void(0);" onclick="window.location.href='accueil.jsp';"><i class="fas fa-home"></i><span>home</span></a>
    <a href="javascript:void(0);" onclick="window.location.href='../traiter?fval=monannonce&id=<%=u.getId() %>';"><i class="fas fa-question"></i><span>Mes Annonces</span></a>
    <a href="javascript:void(0);" onclick="window.location.href='consultemp.jsp';"><i class="fas fa-graduation-cap"></i><span>Emploi de temps</span></a>
    <a href="javascript:void(0);" onclick="window.location.href='chercherannonce.jsp';"><i class="fas fa-chalkboard-user"></i><span>chercher annonce</span></a>
</nav>

</div>

<section class="teachers">

   <h1 class="heading">recherche d'annonce</h1>

   

   <div class="box-container">
   
   
   <% if(classe==null){ %>
      
      <div class="box">
         <div>
            <p><a href="chercherannonce.jsp?classe=Lycee" style="text-decoration: none;">Lycee</a></p>
         </div>
      </div>

      <div class="box">
         <div>
            <p><a href="chercherannonce.jsp?classe=College" style="text-decoration: none;">College</a></p>
         </div>
      </div>

      <div class="box">
         <div>
            <p><a href="chercherannonce.jsp?classe=Primaire" style="text-decoration: none;">Primaire</a></p>
         </div>
      </div>
      <%} else{ if(classe.equals("Lycee") || classe.equals("College")){ %>
      
      <div class="box">
         <div>
            <p><a href="classeannonce.jsp?classe=<%=classe %>&niveau=1er annee" style="text-decoration: none;">1er annee</a></p>
         </div>
      </div>

      <div class="box">
         <div>
            <p><a href="classeannonce.jsp?classe=<%=classe %>&niveau=2eme annee" style="text-decoration: none;">2eme annee</a></p>
         </div>
      </div>

      <div class="box">
         <div>
            <p><a href="classeannonce.jsp?classe=<%=classe %>&niveau=3eme annee" style="text-decoration: none;">3eme annee</a></p>
         </div>
      </div>
      <%} else { %>
      
      <div class="box">
         <div>
            <p><a href="classeannonce.jsp?classe=<%=classe %>&niveau=1er annee" style="text-decoration: none;">1er annee</a></p>
         </div>
      </div>

      <div class="box">
         <div>
            <p><a href="classeannonce.jsp?classe=<%=classe %>&niveau=2eme annee" style="text-decoration: none;">2eme annee</a></p>
         </div>
      </div>

      <div class="box">
         <div>
            <p><a href="classeannonce.jsp?classe=<%=classe %>&niveau=3eme annee" style="text-decoration: none;">3eme annee</a></p>
         </div>
      </div>
      <div class="box">
         <div>
            <p><a href="classeannonce.jsp?classe=<%=classe %>&niveau=4eme annee" style="text-decoration: none;">4eme annee</a></p>
         </div>
      </div>

      <div class="box">
         <div>
            <p><a href="classeannonce.jsp?classe=<%=classe %>&niveau=5eme annee" style="text-decoration: none;">5eme annee</a></p>
         </div>
      </div>

      <div class="box">
         <div>
            <p><a href="classeannonce.jsp?classe=<%=classe %>&niveau=6eme annee" style="text-decoration: none;">6eme annee</a></p>
         </div>
      </div>
      <%} }%>
      
   </div>

</section>
















<!-- custom js file link  -->
<script src="../desgin/js/script.js"></script>

   
</body>
</html>