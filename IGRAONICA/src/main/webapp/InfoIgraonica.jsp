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
				<a class="nav-bar" href="PodaciIgraonice">Podaci o Igraonici</a>
			</li>
			<li>
				<a class="nav-bar" href="Igraonice">Lista paketa i rezervacija</a>
			</li>
			<li>
				<a class="nav-bar" href="DodajPaket">Dodaj Paket</a>
			</li>
			<li>
				<a class="nav-bar" href="LogoutManager">Log out</a>
			</li>
		</ul>
		</nav>
</header>

<div class="about-div">
	<% ArrayList<Igraonica> igraonice=(ArrayList<Igraonica>)request.getAttribute("ListaIgraonica");
	ArrayList<Paket> pakets=(ArrayList<Paket>)request.getAttribute("ListaPaketa");
	ArrayList<Rezervation> rezervations=(ArrayList<Rezervation>)request.getAttribute("ListaRezervacija");%>
</div>

<section id="about" class="about-section">
	<div class="about-div-slika"></div>
	<div class="about-div">
	<% for(Igraonica pom:igraonice){
		%>
		<h2>Informacije o Igraonici: <%=pom.getNaziv() %></h2>
	<%}%>
		<h2>${poruka}</h2>
		<h2>LISTA PAKETA</h2>
		<table>
			<tr>
				<td>Id Paketa</td>
				<td>Naziv</td>
				<td>Opis</td>
				<td>Cena</td>
				<td>Bodovi</td>
				<td></td>
				<td></td>
			</tr>
			<% for(Paket pom:pakets){
				%>
				<tr>
					<td><%=pom.getIdpaket() %></td>
					<td><%=pom.getNaziv() %></td>
					<td><%=pom.getOpis() %></td>
					<td><%=pom.getCena() %></td>
 					<td><%=pom.getBodovi() %></td>
					<td><a href="ManagerIzmenaPaketa?id=<%=pom.getIdpaket()%>">Izmeni</a></td>
					<td><a href="ManagerObrisiPaket?id=<%=pom.getIdpaket()%>">Obrisi</a></td>
				</tr>
			<% } %>
		</table>
		<h2>LISTA REZERVACIJA</h2>
		<table>
			<tr>
				<td>Id Rezervacije</td>
				<td>Datum</td>
				<td>Vreme</td>
				<td>Paket</td>
				<td>Racun</td>
				<td>Korisnik</td>
				<td></td>
				<td></td>
			</tr>
			<% for(Rezervation pom:rezervations){
				%>
				<tr>
					<td><%=pom.getIdrez() %></td>
					<td><%=pom.getDatum() %></td>
					<td><%=pom.getVreme() %></td>
					<td><%=pom.getIdpaket() %></td>
 					<td><%=pom.getRacun() %></td>
 					<td><a href="DetaljiKorisnika?id=<%=pom.getIdkorisnik() %>">Detaljnije</a></td>
					<td><a href="ManagerIzmenaRezervacije?id=<%=pom.getIdrez()%>">Izmeni</a></td>
					<td><a href="ManagerObrisiRezervaciju?id=<%=pom.getIdrez()%>">Obrisi</a></td>
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