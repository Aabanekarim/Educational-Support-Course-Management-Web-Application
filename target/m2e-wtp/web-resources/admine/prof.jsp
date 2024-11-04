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
   <!-- Vendor CSS Files -->
  <link href="../NiceAdmin/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="../NiceAdmin/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="../NiceAdmin/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="../NiceAdmin/assets/vendor/quill/quill.snow.css" rel="stylesheet">
  <link href="../NiceAdmin/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
  <link href="../NiceAdmin/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="../NiceAdmin/assets/vendor/simple-datatables/style.css" rel="stylesheet">

   <!-- custom css file link  -->
   <link rel="stylesheet" href="../desgin/css/style.css">

</head>
<body>

<% HttpSession sess=request.getSession(); 
	school s=new school();

com.admine ad =(com.admine)sess.getAttribute("admine");
	%>

<header class="header">
   
   <section class="flex">

      <a href="prof.jsp" style="text-decoration: none;" class="logo">school center</a>

      

      <div class="icons">
         <div id="menu-btn" class="fas fa-bars"></div>
         <div id="search-btn" class="fas fa-search"></div>
         <div id="user-btn" class="fas fa-user" onclick="window.location.href='../traiter?fval=deconnexion';"></div>
         <div id="use-btn" class="fas fa-power-off" onclick="window.location.href='../traiter?fval=deconnexion';"></div>
         <div id="toggle-btn" class="fas fa-sun"></div>
      </div>

      <div class="profile">
         <img src="../desgin/images/pic-1.jpg" class="image" alt="">
         <h3 class="name"><%=ad.getNom() %> <%=ad.getPrenom() %></h3>
         <p class="role">admine</p>
         <a href="profile.jsp" style="text-decoration: none;" class="btn">changer pass</a>
         <div class="flex-btn">
            <a href="../traiter?fval=deconnexion" style="text-decoration: none;" class="option-btn">deconnexion</a>
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
      <h3 class="name"><%=ad.getNom() %> <%=ad.getPrenom() %></h3>
      <p class="role">admine</p>
      <a href="profile.jsp" style="text-decoration: none;" class="btn">changer pass</a>
   </div>

   <nav class="navbar">
      <a href="javascript:void(0);" onclick="window.location.href='accueil.jsp';" style="text-decoration: none;"><i class="fas fa-home"></i><span>Home</span></a>
      <a href="javascript:void(0);" onclick="window.location.href='prof.jsp';" style="text-decoration: none;"><i class="fas fa-home"></i><span>Professeur</span></a>
      <a href="javascript:void(0);" onclick="window.location.href='etudiants.jsp';" style="text-decoration: none;"><i class="fas fa-question"></i><span>Etudiants</span></a>
      <a href="javascript:void(0);" onclick="window.location.href='annonces.jsp';" style="text-decoration: none;"><i class="fas fa-graduation-cap"></i><span>Annonces</span></a>
      <a href="javascript:void(0);" onclick="window.location.href='classe.jsp';" style="text-decoration: none;"><i class="fas fa-chalkboard-user"></i><span>Matieres</span></a>
      <a href="javascript:void(0);" onclick="window.location.href='chercherannonce.jsp';" style="text-decoration: none;"><i class="fas fa-chalkboard-user"></i><span>gestion de paimment</span></a>
      <a href="javascript:void(0);" onclick="window.location.href='afficherabscense.jsp';" style="text-decoration: none;"><i class="fas fa-chalkboard-user"></i><span>afficher abscense</span></a>
   </nav>

</div>

<section class="section">
      <div class="row">
        <div class="col-lg-12 ">

                    
       
          
          
          <div class="card">
            <div class="card-body">
            <div class="d-flex justify-content-between align-items-center">
			  <h1 class="card-title">Gestion des comptes des professeurs</h1>
			  <a href="ajouterprof.jsp" style="text-decoration: none;">
			    <button type="button" class="btn btn-danger rounded-pill" style="width: 200px;"><i class="fas fa-add"></i><span>Professeur</span></button>
			  </a>
			</div>
              <table class="table datatable">
                <thead>
                  <tr>
                    <th scope="col"><h3>#</h3></th>
                    <th scope="col"><h3>Name</h3></th>
                    <th scope="col"><h3>Prenom</h3></th>
                    <th scope="col"><h3>Email</h3></th>
                    <th scope="col"><h3>Password</h3></th>
                  </tr>
                </thead>
                <tbody>
                <%

                ArrayList lp=(ArrayList)s.listprof();
                
int currentPage3 = 1;
if (request.getParameter("currentPage3") != null) {
    currentPage3 = Integer.parseInt(request.getParameter("currentPage3"));
}
int recordsPerPage3 = 5; 

sess.setAttribute("currentPage3", currentPage3);
int start3 = (currentPage3 - 1) * recordsPerPage3;
int end3 = Math.min(start3 + recordsPerPage3, lp.size());

                
                	 
for (int i = start3; i < end3; i++) {
	com.prof p =(com.prof)lp.get(i);
                %>
                  <tr>
                    <th scope="row"><h3><%=p.getId() %></h3></th>
                    <td><h3><%=p.getNom() %></h3></td>
                    <td><h3><%=p.getPrenom() %></h3></td>
                    <td><h3><%=p.getEmail()%></h3></td>
                    <td><h3><%=p.getPass() %></h3></td>
                    <td><a href="admin_modifier_p.jsp?idp=<%=p.getId()%>" style="text-decoration: none;"><button type="button"  class="btn btn-warning rounded-pill" >Modifier</button></a></td>
                    <td><a href="../traiter?fval=supprimerprof&idp=<%=p.getId()%>" style="text-decoration: none;"><button type="button" class="btn btn-danger rounded-pill" >Supprimer</button></a></td>
                    
                  </tr>
                  <%
                  
                  } %>
                </tbody>
              </table>
              <!-- End Table with stripped rows -->
          
  <div class="pagination">
    <form action="prof.jsp" >
      <button name="currentPage3" value="<%= currentPage3 - 1 %>" <% if (currentPage3 <= 1) out.print("disabled"); %> class="btn-previous" onclick="storeScrollPosition()"><h1>Précédent</h1></button>
      <button name="currentPage3" value="<%= currentPage3 + 1 %>" <% if (end3 >= lp.size()) out.print("disabled"); %> class="btn-next" onclick="storeScrollPosition()"><h1>Suivant</h1></button>
    </form>
  </div>
            </div>
          </div>
          
                              
        </div>
      </div>
    </section>












<!-- custom js file link  -->
<script src="../desgin/js/script.js"></script>

   
</body>
</html>