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
				<a class="nav-bar" href="#about">O nama</a>
			</li>
			<li>
				<a class="nav-bar" href="IzborIgraonica">Igraonice</a>
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

<section id="about" class="about-section">
	<div class="about-div-slika"></div>
	<div class="about-div">
		<h2>${poruka}</h2>
		<h2>NASA IGRAONICA</h2>
		<hr>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sed dapibus leo nec ornare diam.
		Sed commodo nibh ante facilisis bibendum dolor feugiat at. Duis sed dapibus leo nec ornare diam
		commodo nibh.</p>
		<h3><a href="IzborIgraonica">Napravite vasu rezervaciju!</a></h3>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sed dapibus leo nec ornare diam.
		Sed commodo nibh ante facilisis bibendum dolor feugiat at. Duis sed dapibus leo nec ornare diam
		commodo nibh.</p>
	</div>	
</section>

<section id="menu" class="fix-slika-menu">
	<div class="menu-text">
		<h2 class="h2-text">Nasi paketi i opcije</h2>
		<hr>
		<p class="p-text">Ovde mozete pogledati nase opcije, pakete i mozete napraviti rezervaciju.</p>
	</div>
	<div class="menu-menu">
		<div class="breakfast">
			<h2 class="h2-menu-title">PAKETI I OPCIJE</h2>
			<hr class="hr-menu">
			<h2 class="h2-menu">BASIC &nbsp;<a href="IzborIgraonica">Rezervisi</a></h2>
			<h2 class="h2-price">1000$</h2>
			<p class="p-menu">2 Obroka sa picem. 3h trajanje proslave.</p>
			<h2 class="h2-menu">Standard &nbsp;<a href="IzborIgraonica">Rezervisi</a></h2>
			<h2 class="h2-price">1750$</h2>
			<p class="p-menu">3 Obroka sa picem po izboru, 5h trajanje proslave.</p>
			<h2 class="h2-menu">Premium &nbsp;<a href="IzborIgraonica">Rezervisi</a></h2>
			<h2 class="h2-price">4000$</h2>
			<p class="p-menu">4 obroka po izboru, game room, 8h trajanje proslave. Game Room 3h.</p>
			<h2 class="h2-menu">Sigma &nbsp;<a href="IzborIgraonica">Rezervisi</a></h2>
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

<section id="gallery" class="fix-slika-gallery">
	<div class="menu-text">
		<h2 class="h2-text">GALERIJA</h2>
		<hr>
		<p class="p-text">Slike nasih igraonica, opcija i ponuda</p>
	</div>
</section>

<section class="portfolio">
		<div class="slika-1">
			<div class="zavesa-1">
				<a class="dish-name" href="">Igraonica</a>
			</div>
		</div>
		<div class="slika-2">
			<div class="zavesa-2">
				<a class="dish-name" href="">Igraonica</a>
			</div>
		</div>
		<div class="slika-3">
			<div class="zavesa-3">
				<a class="dish-name" href="">Igraonica</a>
			</div>
		</div>
</section>

<section class="portfolio">
		<div class="slika-4">
			<div class="zavesa-4">
				<a class="dish-name" href="">Igraonica</a>
			</div>
		</div>
		<div class="slika-5">
			<div class="zavesa-5">
				<a class="dish-name" href="">Igraonica</a>
			</div>
		</div>
		<div class="slika-6">
			<div class="zavesa-6">
				<a class="dish-name" href="">Igraonica</a>
			</div>
		</div>
</section>

<section class="portfolio">
		<div class="slika-7">
			<div class="zavesa-7">
				<a class="dish-name" href="">Igraonica</a>
			</div>
		</div>
		<div class="slika-8">
			<div class="zavesa-8">
				<a class="dish-name" href="">Igraonica</a>
			</div>
		</div>
		<div class="slika-9">
			<div class="zavesa-9">
				<a class="dish-name" href="">Igraonica</a>
			</div>
		</div>
</section>

<section class="portfolio">
		<div class="slika-10">
			<div class="zavesa-10">
				<a class="dish-name" href="">Igraonica</a>
			</div>
		</div>
		<div class="slika-11">
			<div class="zavesa-11">
				<a class="dish-name" href="">Igraonica</a>
			</div>
		</div>
		<div class="slika-12">
			<div class="zavesa-12">
				<a class="dish-name" href="">Igraonica</a>
			</div>
		</div>
</section>

<section id="contact" class="reservation">
	<div class="number-res">
		<h2 class="h2-res">ZELITE DA NAPRAVITE REZERVACIJU? POZOVITE <strong>+381 645472355</strong> ILI KLIKNITE <a href="IzborIgraonica">OVDE</a></h2>
	</div>
</section>

<section class="section-form">
	<div class="contact-form-text">
		<h2 class="h2-form">Kontakt</h2>
		<hr>
		<p class="p-form">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Doloribus, distinctio.</p>
		<form class="form">
			<input class="prva-forma" type="text" name="ime" placeholder="Name">
			<input class="druga-forma" type="text" name="mail" placeholder="Email">
		</form>
		<form class="form-2">
			<textarea class="treca-forma" type="text" name="msg" placeholder="Message"></textarea>
		</form>
		<div class="div-button">
			<button class="button-send-message">
				<a class="message-send" href="SendMsg">Send message</a>
			</button>
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
			<a class="insta" href="http://www.instagram.com/alexberbo" target="blank"><img src="img/icons/instagram.png" height="33px" width="35px" alt=""></a>
			<a class="twitter" href="https://twitter.com" target="blank"><img src="img/icons/twitter.png" height="33px" width="35px" alt=""></a>
			<a class="google" href="https://plus.google.com/" target="blank"><img src="img/icons/google.png" height="30px" width="30px" alt=""></a>
			<p class="p-social">© 2022 Alex Games. All rights reserved. Designed by <a class="a-social" href="http://www.instagram.com/alexberbo">alexberbo</a></p>
		</div>
	</div>
</section>



</body>
</html>