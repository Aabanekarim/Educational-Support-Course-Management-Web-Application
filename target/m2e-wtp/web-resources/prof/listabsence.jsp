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
   
   <!-- Vendor CSS Files -->
  <link href="../Selecao/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="../Selecao/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="../Selecao/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="../Selecao/assets/vendor/quill/quill.snow.css" rel="stylesheet">
  <link href="../Selecao/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
  <link href="../Selecao/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="../Selecao/assets/vendor/simple-datatables/style.css" rel="stylesheet">
   <!-- font awesome cdn link  -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">

   <!-- custom css file link  -->
   <link rel="stylesheet" href="../desgin/css/style.css">

</head>
<body>

<% HttpSession sess=request.getSession(); 
school s=new school();
sess.setAttribute("fval", "ajouterabscence");
com.prof p = (com.prof)sess.getAttribute("prof");
ArrayList l = (ArrayList)sess.getAttribute("listetu");
	int cpt=1;%>

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


<section class="teachers">

<div class="box-container">
<div class="box">

          

          

          <form action="../traiter" method="post">
            
            	<table class="table table-bordered border-primary">
                <thead>
                  <tr>
                    <th ></th>
                    <th ><h1>Nom</h1></th>
                    <th ><h1>Prenom</h1></th>
                    <th ><h1>Absence</h1></th>
                  </tr>
                </thead>
                <tbody>
                <% for(Object o : l){
      			  com.etu e = (com.etu)o;
			  %>
                  <tr>
                    <td><h3><%=cpt %></h3></td>
                    <td><h3><%=e.getNom() %></h3></td>
                    <td><h3><%=e.getPrenom() %></h3></td>
                    <td><input class="box" type="checkbox" name="etus" value="<%=e.getId() %>"  id="gridCheck1"></td>
                    
                  </tr>
                  
                  <%} %>
                </tbody>
              </table>
              <!-- End Primary Color Bordered Table -->
              <input type="submit" value="ajouterabscence" name="fval" class="btn">
              </form>
            </div>
            </div>
          

          

        














</section>


<!-- custom js file link  -->
<script src="../desgin/js/script.js"></script>

   
</body>
</html>