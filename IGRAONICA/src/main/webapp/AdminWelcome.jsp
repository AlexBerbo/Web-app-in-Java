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
	<div class="slika">
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
		<div class="zavesa">
			<h1 class="alex-intro">Alex Games</h1>
			<p class="intro-p">Restaurant / Coffee / Igraonica</p>
			<a href="">Pronadji Svoju Igru</a>
		</div>
	</div>	
</header>

<section id="about" class="about-section">
	<div class="about-div-slika"></div>
	<div class="about-div">
		<h2>${poruka}</h2>
		<h2>NASA IGRAONICA</h2>
		<hr>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sed dapibus leo nec ornare diam.
		Sed commodo nibh ante facilisis bibendum dolor feugiat at. Duis sed dapibus leo nec ornare diam
		commodo nibh.</p>
		<h3>Admin</h3>
		<p>Dobrodosao admine!</p>
	</div>	
</section>

<section id="menu" class="fix-slika-menu">
	<div class="menu-text">
		<h2 class="h2-text">Dogadjaji</h2>
		<hr>
		<p class="p-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Doloribus, distinctio.</p>
	</div>
	<div class="menu-menu">
		<div class="breakfast">
			<h2 class="h2-menu-title">PAKETI I OPCIJE</h2>
			<hr class="hr-menu">
			<h2 class="h2-menu">BASIC</h2>
			<h2 class="h2-price">1000$</h2>
			<p class="p-menu">2 Obroka sa picem. 3h trajanje proslave.</p>
			<h2 class="h2-menu">Standard</h2>
			<h2 class="h2-price">1750$</h2>
			<p class="p-menu">3 Obroka sa picem po izboru, 5h trajanje proslave.</p>
			<h2 class="h2-menu">Premium</h2>
			<h2 class="h2-price">4000$</h2>
			<p class="p-menu">4 obroka po izboru, game room, 8h trajanje proslave. Game Room 3h.</p>
			<h2 class="h2-menu">Sigma</h2>
			<h2 class="h2-price">12000$</h2>
			<p class="p-menu">Zakup cele igraonice i svih opcija na 24h</p>
		</div>
		<div class="main-course">
			<h2 class="h2-menu-title">PLAYSTATION SOBA</h2>
			<hr class="hr-menu">
			<h2 class="h2-menu">Sportske igre</h2>
			<h2 class="h2-price">50$</h2>
			<p class="p-menu">Sportske igre poput FIFA, NBA, Virtual tennis i ostale.</p>
			<h2 class="h2-menu">FPS igre</h2>
			<h2 class="h2-price">80$</h2>
			<p class="p-menu">Najpoplarnije FPS igre poput Battlefield-a, Call of Duty-a na korsicenje uz proslavu</p>
			<h2 class="h2-menu">Cinema</h2>
			<h2 class="h2-price">50$</h2>
			<p class="p-menu">Home cinema za goste i slavljenike.</p>
			<h2 class="h2-menu">Sim Racing</h2>
			<h2 class="h2-price">1500$</h2>
			<p class="p-menu">Sim Racing setup za 10 osoba, svako ima svoj simulator i omoguceno online trkanje za goste i slavljenike.</p>
		</div>
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