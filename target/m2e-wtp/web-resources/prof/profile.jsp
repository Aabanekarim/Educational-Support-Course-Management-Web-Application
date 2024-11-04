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
sess.setAttribute("fval", "changerpass");
String msg = (String)sess.getAttribute("msgpass");%>

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
      <h3>changer mot de pass</h3>
      <p>ancienne mot de pass</p>
      <input type="password" name="dpass" placeholder="entrer l'ancienne mot de pass" maxlength="50" class="box" required="required">
      <p>nouveau mot de pass</p>
      <input type="password" name="npass" placeholder="entrer nouveau mot de pass" maxlength="20" class="box" required="required">
      <p>confirmer mot de pass</p>
      <input type="password" name="cpass" placeholder="confirmer mot de pass" maxlength="20" class="box" required="required">
      
                      
      <input type="submit" value="changerpass" name="fval" class="btn">
      <%if(msg!=null){ %>
      <p><%=msg %></p>
      <%} %>
   </form>

</section>
















<!-- custom js file link  -->
<script src="../desgin/js/script.js"></script>

   
</body>
</html>