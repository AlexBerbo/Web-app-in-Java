<%@page import="beans.Igraonica" %>
<%@page import="beans.Rezervation" %>
<%@page import="beans.Paket" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Alex Games - Pocetna</title>
	<link rel="stylesheet" href="css/style.css">
	<link href="https://fonts.googleapis.com/css?family=Dancing+Script" rel="stylesheet"> 
	<link href="https://fonts.googleapis.com/css?family=Raleway:300,400,500,600,700" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
</head>
<body>

<header class="header">
		<nav>
		<ul>
			<li>
				<a class="logo" href="">Alex Games</a>
			</li>
			<li>
				<a class="nav-bar" href="ListaServlet?ispis=igraonica">Lista Igraonica</a>
			</li>
			<li>
				<a class="nav-bar" href="DodajIgraonicu.jsp">Dodaj Igraonicu</a>
			</li>
			<li>
				<a class="nav-bar" href="ListaServlet?ispis=menadzer">Lista Menadzera</a>
			</li>
			<li>
				<a class="nav-bar" href="DodajMenadzer">Dodaj Menadzera</a>
			</li>
			<li>
				<a class="nav-bar" href="ListaServlet?ispis=korisnik">Lista Korisnika</a>
			</li>
			<li>
				<a class="nav-bar" href="LogoutManager">Log out</a>
			</li>
		</ul>
		</nav>
</header>

<div class="about-div">
	<% ArrayList<Igraonica> igraonice=(ArrayList<Igraonica>)request.getAttribute("Igraonice"); %>
</div>

<section id="about" class="about-section">
	<div class="about-div-slika"></div>
	<div class="about-div">
		<h2>${poruka}</h2>
		<h2>LISTA IGRAONICA</h2>
		<table>
			<tr>
				<td>Id Igraonice</td>
				<td>Naziv</td>
				<td>Adresa</td>
				<td>Telefon</td>
<!-- 				<td>Slika</td> -->
				<td></td>
				<td></td>
			</tr>
			<% for(Igraonica pom:igraonice){
				%>
				<tr>
					<td><%=pom.getIdigraonica() %></td>
					<td><%=pom.getNaziv() %></td>
					<td><%=pom.getAdresa() %></td>
					<td><%=pom.getTelefon() %></td>
<%-- 					<td><img src="css/img/<%=pom.getSlika() %>.jpg" class="slikaJava"></td> --%>
					<td><a href="AdminIzmenaIgraonice?id=<%=pom.getIdigraonica()%>">Izmeni</a></td>
					<td><a href="AdminObrisiIgraonice?id=<%=pom.getIdigraonica()%>">Obrisi</a></td>
				</tr>
			<% } %>
		</table>
	</div>	
</section>

<section class="contact-foot">
	<div class="div-contact-foot">
		<div class="text-foot-contact-1">
			<h3 class="h3-contact">Addresa</h3>
			<p class="p-contact">Stevana Velikog, Broj 16.</p>
			<p class="p-contact">Srbija, Indjija, 22320</p>
		</div>
		
		<div class="text-foot-contact-2">
			<h3 class="h3-contact">Radno Vreme</h3>
			<p class="p-contact">Pon-Cet: 10:00 AM - 02:00 PM</p>
			<p class="p-contact">Pet-Ned: 11:00 AM - 01:00 AM</p>
		</div>
		
		<div class="text-foot-contact-3">
			<h3 class="h3-contact">Contact info</h3>
			<p class="p-contact">Phone: +381 645472355</p>
			<p class="p-contact">Email: berbo997@gmail.com</p>
		</div>
	</div>
	
	<div class="social">
		<div class="icons-social">
			<a class="face" href="https://facebook.com" target="blank"><img src="img/icons/face.png" height="33px" width="35px" alt=""></a>
			<a class="twitter" href="https://twitter.com" target="blank"><img src="img/icons/twitter.png" height="33px" width="35px" alt=""></a>
			<a class="google" href="https://plus.google.com/" target="blank"><img src="img/icons/google.png" height="30px" width="30px" alt=""></a>
			<p class="p-social">© 2022 Alex Games. All rights reserved. Designed by <a class="a-social" href="http://www.instagram.com/alexberbo">alexberbo</a></p>
		</div>
	</div>
</section>



</body>
</html>