<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
        <title>Manage client</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="style.css" />
        <script src="./app.js" defer></script>
	 </head>
	<body>
		
        <form id="form" class="login" action="/project-jee-school/LoginServlet">
        	<% 
			Integer tentative = (Integer) session.getAttribute("tentative");
			if( tentative != null && tentative > 0 ) {%>
				<div class="retry">Reesasyer s'il vous plait <jstl:out value="${tentative}"></jstl:out></div>
			<%} 
		%>
            <div class="wrapper">
                <label for="email">Email</label>
                <input
                    id="email"
                    name="email"
                    class="email"
                    type="email"
                    required
                />
                <span class="message">ex: example@.test </span>
            </div>
            <div class="wrapper">
                <label for="password">Password</label>
                <input
                    id="password"
                    name="password"
                    class="password"
                    type="password"
                    required
                />
                <label for="switch" class="switch" checked="false">
                    <input id="switch" type="checkbox" />
                    <span class="slider round"></span>
                </label>
                <span class="message"
                    >minimum 8 characteres avec une lettre majuscule, miniscule,
                    charactere et chiffre</span>
            </div>
            <button id="submit" class="submit" type="submit">
                Se connecter
            </button>
        </form>
    </body>
</html>