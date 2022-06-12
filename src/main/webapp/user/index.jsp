<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Recherche d'utilisateurs</title>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="styles/user.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Lato:wght@100;300;400;700;900&family=Roboto:wght@100;300;400;500;700;900&display=swap"
      rel="stylesheet"
    />
  </head>
  <body>
    <div class="global-container">
      <nav class="side-nav">
        <div class="nav-logo">
          <img src="images/logo.svg">
          <h1>Users</h1>
        </div>
		<a href="/project-jee-school/GetAllUsersServlet" class="bloc-link">
	          <img src="images/server.svg">
	          <span class="nav-links">Database</span>
        </a>
        <a href="/project-jee-school/CreateUserServlet" class="bloc-link active">
          <img src="images/dashboard.svg">
          <span class="nav-links">Add User</span>
        </a>
    
      </nav>
      <main class="main-content">
      	
        <h2 class="main-title">Database Results 
         <a href="/project-jee-school/DropUserServlet?id=${person.idPerson}" class="drop">Supprimer</a>
        <div class="content">
          
           <span class="image">
            <img src="https://i.pravatar.cc/150?img=${person.idPerson}"/>
           </span>
           <form id="form" action="/project-jee-school/UpdateUserServlet" class="login">
           <input style="display:none;" name="id" type="text" value="${person.idPerson}" />
           <div class="input-control">
             <div class="wrapper active">
               <label for="name">
                 Name
               </label>
               <input value="${person.name}" name="name" id="name" type="text">
             </div>
             <div class="wrapper active">
               <label for="email">
                 Email
               </label>
               <input value="${person.email}" name="email" id="email" type="email">
             </div>
           </div>
           <div class="input-control">
             <div class="wrapper active">
               <label for="phone">
                 Phone
               </label>
               <input value="${person.phone}" name="phone" id="phone" type="tel">
             </div>
             <div class="wrapper active">
               <label for="password">
                 Password
               </label>
               <input id="password"  value="${person.password}" name="password" type="password">
             </div>
           </div>
           <div class="btn-container">
             <button type="submit" id="submit" class="submit">Modifier</button>
           </div>
           </form>
         </div>
     </main>
    </div>




  </body>
</html>
