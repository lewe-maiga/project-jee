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
    <link rel="stylesheet" href="styles/style.css" />
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

		<a href="#" class="bloc-link active">
	          <img src="images/server.svg">
	          <span class="nav-links">Database</span>
        </a>
        <a href="/project-jee-school/CreateUserServlet" class="bloc-link">
          <img src="images/dashboard.svg">
          <span class="nav-links">Add User</span>
        </a>
        
        
       
      </nav>

      <main class="main-content">

        <div class="input-control">
          <label for="search">
            <img src="images/search.svg">
          </label>
          <input type="text" id="search" placeholder="Search for an user">
          
        </div>

        <h2 class="main-title">Database Results 
	        <jstl:choose>
	        	<jstl:when test="${persons == null}">
	        		<jstl:out value="Je sui la"></jstl:out>
	        	</jstl:when>
	        </jstl:choose> 
        </h2>

        <div class="table">
          <h3 class="table-title">Name</h3>
          <h3 class="table-title">Email</h3>
          <h3 class="table-title">Phone</h3>
        </div>
		
        <div class="table-results" data-json=${persons}>
			
        </div>
		
      </main>
	<script src="js/script.js"></script>
    </div>




  </body>
</html>
