<%@ page import="beans.Korisnik" %>
<%@ page import="beans.Paket" %>
<%@ page import="beans.Igraonica" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
			<title>Alex Games</title>
				<link rel="stylesheet" href="css/style.css">
				<link href="https://fonts.googleapis.com/css?family=Dancing+Script" rel="stylesheet"> 
				<link href="https://fonts.googleapis.com/css?family=Raleway:300,400,500,600,700" rel="stylesheet">
				<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
	</head>
<body>

<% Korisnik korisnik=(Korisnik)request.getAttribute("KorisnikRez");
	Paket paket=(Paket)request.getAttribute("Paket");
%>

<header class="header">
	<div class="slika">
		<nav>
		<ul>
			<li>
				<a class="logo" href="">Alex Games</a>
			</li>
			<li>
				<a class="nav-bar" href="#about">O nama</a>
			</li>
			<li>
				<a class="nav-bar" href="#menu">Opcije i paketi</a>
			</li>
			<li>
				<a class="nav-bar" href="#igraonice">Igraonice</a>
			</li>
			<li>
				<a class="nav-bar" href="#gallery">Galerija</a>
			</li>
			<li>
				<a class="nav-bar" href="#contact">Contact</a>
			</li>
			<li>
				<a class="nav-bar" href="Logout">Log out</a>
			</li>
			<li>
				<a class="nav-bar" href="MojNalog">Moj Nalog</a>
			</li>
		</ul>
		</nav>
		<div class="zavesa">
			<h1 class="alex-intro">Alex Games</h1>
			<p class="intro-p">Restaurant / Coffee / Igraonica</p>
			<a href="">Pronadji Svoju Igru</a>
		</div>
	</div>	
</header>

<section id="login" class="login-section">
	<div class="login-div">
		<form action="RezervacijaFinalna" method="post">
		<h1>${(poruka!=null) ? poruka : "Dobrodosli!"}</h1>
		<h2>REZERVACIJA</h2>
			<p>Ime: <input readonly type="text" name="ime" value=<%=korisnik.getIme() %> /> <input type="text" readonly name="prezime" value=<%=korisnik.getPrezime() %> /></p>
    		<p>Datum: <input type="date" required  name="datum" /></p>
   			<p>Vreme pocetka rodjendana: <input type="number" name="vreme" value="10" min="0" max="24"/></p>
    		<p>Cena: <input type="text" readonly name="cena" value=<%=paket.getCena() %> /></p>
     		<p>Da li zelite da iskoristite Vase poene? <input type="number" name="poeni" value="0" min="0" max=<%=korisnik.getPoints() %> /></p>
     		<input type="hidden" name="idkorisnik"  value=<%=korisnik.getId() %> />
      		<input type="hidden" name="idpaket"  value=<%=paket.getIdpaket() %> />
     		<input type="hidden" name="idigraonica"  value=<%=paket.getIdigraonica() %> />
    		<input type="hidden" name="poeninovi"  value=<%=paket.getBodovi() %> />
    		<input type="hidden" name="poenistari"  value=<%=korisnik.getPoints() %> />
  			<input type="submit" value="Rezervisi"/>
		</form>	
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