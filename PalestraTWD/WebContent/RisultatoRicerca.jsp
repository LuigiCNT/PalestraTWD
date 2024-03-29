<!DOCTYPE html>
<%@ page import="it.unirc.twd.beans.*"%>
<%@ page import="java.util.*"%>
<html lang="en">
<head>

<title>Risultato Ricerca</title>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="author" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/aos.css">

<!-- MAIN CSS -->
<link rel="stylesheet" href="css/tooplate-gymso-style.css">
<!--
Tooplate 2119 Gymso Fitness
https://www.tooplate.com/view/2119-gymso-fitness
-->
</head>
<body data-spy="scroll" data-target="#navbarNav" data-offset="50">


	<%
Vector<Attrezzi> aa = (Vector<Attrezzi>) session.getAttribute("lista_attrezzi");
Vector<Corsi> corsi = (Vector<Corsi>) session.getAttribute("lista_corsi");

%>


	<!-- MENU BAR -->
	<nav class="navbar navbar-expand-lg fixed-top">
		<div class="container">

			<a class="navbar-brand" href="index.html">Spartan Gym</a>

			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ml-lg-auto">
					<li class="nav-item"><a href="#home"
						class="nav-link smoothScroll">Home</a></li>


					<!--<li class="nav-item"><a href="#class"
						class="nav-link smoothScroll">Servizi</a></li>  -->

					<li class="nav-item"><a href="#attrezzi"
						class="nav-link smoothScroll">Attrezzi</a></li>
					
					<li class="nav-item"><a href="#corsi"
						class="nav-link smoothScroll">Corsi</a></li>


					<li class="nav-item"><a href="#contact"
						class="nav-link smoothScroll">Contatti</a></li>
				</ul>

				<ul class="social-icon ml-lg-3">
					<li><a href="https://fb.com/tooplate" class="fa fa-facebook"></a></li>
					<li><a href="#" class="fa fa-twitter"></a></li>
					<li><a href="#" class="fa fa-instagram"></a></li>
				</ul>
			</div>

		</div>
	</nav>


	<!-- HERO -->
	<section
		class="hero d-flex flex-column justify-content-center align-items-center"
		id="home">

		<div class="bg-overlay"></div>

		<div class="container">
			<div class="row">

				<div class="col-lg-8 col-md-10 mx-auto col-12">
					<div class="hero-text mt-5 text-center">


						<h1 class="text-white" data-aos="fade-up" data-aos-delay="500">Attrezzatura & Corsi</h1>

						<a href="#orario" class="btn custom-btn bordered mt-3"
							data-aos="fade-up" data-aos-delay="700"
							style="color: #f13a11 !important; border: 1px solid #f13a11 !important">Scopri
							di pi�</a>

					</div>
				</div>

			</div>
		</div>
	</section>


	<section class="feature" id="feature">
		<div class="orario" id="orario"></div>
		<div class="container">
			<div class="row">



				<div class="mr-lg-auto mt-3 col-lg-4 col-md-6 col-12">
					<div class="about-working-hours">
						<div>

							<h2 class="mb-4 text-white" data-aos="fade-up"
								data-aos-delay="500">Ore Lavorative</h2>

							<strong class="d-block" data-aos="fade-up" data-aos-delay="600">Domenica
								: Chiuso</strong> <strong class="mt-3 d-block" data-aos="fade-up"
								data-aos-delay="700">Luned� - Venerdi</strong>

							<p data-aos="fade-up" data-aos-delay="800">7:00 AM - 10:00 PM</p>

							<strong class="mt-3 d-block" data-aos="fade-up"
								data-aos-delay="700">Sabato</strong>

							<p data-aos="fade-up" data-aos-delay="800">6:00 AM - 4:00 PM</p>
						</div>
					</div>
				</div>
			</div>

		</div>

	</section>


	<!-- ABOUT -->


	<!-- CLASS -->
	<section class="class section" id="class">
		<div class="container">
			<div class="row">
<!-- 
				<div class="col-lg-12 col-12 text-center mb-5">
					<h6 data-aos="fade-up">Migliora il tuo corpo</h6>

					<h2 data-aos="fade-up" data-aos-delay="200">I nostri Servizi</h2>
				</div>

				<div class="col-lg-4 col-md-6 col-12" data-aos="fade-up"
					data-aos-delay="400">
					<div class="class-thumb">
						<img src="images/class/yoga-class.jpg" class="img-fluid"
							alt="Class">

						<div class="class-info">
							<h3 class="mb-1">Allenamento Funzionale</h3>

							<span><strong>Preparatore</strong> - Demetrio</span>



							<p class="mt-3">Tipologia di allenamento strutturato su
								esercizi che mirano a sviluppare la cosiddetta forza funzionale
								ossia la forza in funziona di un determinato movimento o azione
								specifica</p>
						</div>
					</div>
				</div>

				<div class="mt-5 mt-lg-0 mt-md-0 col-lg-4 col-md-6 col-12"
					data-aos="fade-up" data-aos-delay="500">
					<div class="class-thumb">
						<img src="images/class/crossfit-class.jpg" class="img-fluid"
							alt="Class">

						<div class="class-info">
							<h3 class="mb-1">Preparazione Atletica</h3>

							<span><strong>Preparatore</strong> - Luigi</span>



							<p class="mt-3">Preparazione per ogni tipo di sport o
								concorso nazionale (carabinieri/polizia/militari ecc.)</p>
						</div>
					</div>
				</div>

				<div class="mt-5 mt-lg-0 col-lg-4 col-md-6 col-12"
					data-aos="fade-up" data-aos-delay="600">
					<div class="class-thumb">
						<img src="images/class/cardio-class.jpg" class="img-fluid"
							alt="Class">

						<div class="class-info">
							<h3 class="mb-1">Bodybuilding</h3>

							<span><strong>Preparatore</strong> - Giuseppe</span>

							<p class="mt-3">Allenamento mirato alla costruzione di un
								corpo ideale ispirato all'ideale fisico dell'antica Grecia</p>
						</div>
					</div>
				</div>
-->
			</div>
		</div>
	</section>


	<!-- SCHEDULE -->


	<section>
	<div class="col-lg-12 col-12 text-center mb-5">
		<% String stato = (String) session.getAttribute("statoric"); %>
		
		<% if (stato.equals("vettore dot vuoto")){ %>
			<div class="alert alert-danger" role="alert" style="text-align:center !important">
 	Non ci sono attrezzi per quel determinato Corso.
</div>
		
		<%} else if(stato.equals("ricerca dot per corso")) { %>
				
				<% String nomeCorso = (String) session.getAttribute("nomecorso");
					Vector<Dotazione> d = (Vector<Dotazione>) session.getAttribute("vettore dot");
					%>
					
				<h2 data-aos="fade-up" data-aos-delay="200" style="margin-bottom:40px !important">Lista degli attrezzi relativi al corso "<%= nomeCorso %>"</h2>
				<ul class="list-group">
  				<% for(Dotazione dot : d)  { %>
  					<li class="list-group-item"><%= dot.getAttrezzo() %></li>
  				<%} %>
</ul>
		<%} %><!--  sso -->
		</div>
		<center>
	<form action="RedirectAdmin" method="post">
<button type="submit" class="btn btn-secondary" style="width:200px; height:100px">Ritorna all'area riservata</button>
</form>
</center>
		
		
	</section>
	

	<!-- CONTACT -->
	<section class="contact section" id="contact">
		<div class="container">
			<div class="row">

				<div class="ml-auto col-lg-5 col-md-6 col-12">
					<h2 class="mb-4 pb-2" data-aos="fade-up" data-aos-delay="200">Feel
						free to ask anything</h2>

					<form action="#" method="post" class="contact-form webform"
						data-aos="fade-up" data-aos-delay="400" role="form">
						<input type="text" class="form-control" name="cf-name"
							placeholder="Name"> <input type="email"
							class="form-control" name="cf-email" placeholder="Email">

						<textarea class="form-control" rows="5" name="cf-message"
							placeholder="Message"></textarea>

						<button type="submit" class="form-control" id="submit-button"
							name="submit">Send Message</button>
					</form>
				</div>

				<div class="mx-auto mt-4 mt-lg-0 mt-md-0 col-lg-5 col-md-6 col-12">
					<h2 class="mb-4" data-aos="fade-up" data-aos-delay="600">
						Dove puoi <span>trovarci?</span>
					</h2>

					<p data-aos="fade-up" data-aos-delay="800">
						<i class="fa fa-map-marker mr-1"></i> Palizzi Marina
					</p>
					<!-- How to change your own map point
	1. Go to Google Maps
	2. Click on your location point
	3. Click "Share" and choose "Embed map" tab
	4. Copy only URL and paste it within the src="" field below
-->
					<div class="google-map" data-aos="fade-up" data-aos-delay="900">
						<iframe
							src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3432.3255007865355!2d15.982051554645677!3d37.91977085395093!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x754ccbd34c9040a5!2sSpartan%20Gym%20A.S.D.!5e0!3m2!1sit!2sit!4v1613205408654!5m2!1sit!2sit"
							width="1920" height="250" frameborder="0" style="border: 0;"
							allowfullscreen=""></iframe>
					</div>
				</div>

			</div>
		</div>
	</section>


	<!-- FOOTER -->
	<footer class="site-footer">
		<div class="container">
			<div class="row">

				<div class="ml-auto col-lg-4 col-md-5">
					<p class="copyright-text">
						Copyright &copy; 2020 Gymso Fitness Co. <br>Design: <a
							href="https://www.tooplate.com">Tooplate</a>
					</p>
				</div>

				<div
					class="d-flex justify-content-center mx-auto col-lg-5 col-md-7 col-12">
					<p class="mr-4">
						<i class="fa fa-envelope-o mr-1"></i> <a href="#">hello@company.co</a>
					</p>

					<p>
						<i class="fa fa-phone mr-1"></i> 010-020-0840
					</p>
				</div>

			</div>
		</div>
	</footer>

	<!-- Modal -->
	<div class="modal fade" id="membershipForm" tabindex="-1" role="dialog"
		aria-labelledby="membershipFormLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">

			<div class="modal-content">
				<div class="modal-header">

					<h2 class="modal-title" id="membershipFormLabel">Login</h2>

					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-body">
					<form class="membership-form webform" name="Login" action="Login"
						method="post" role="form" id="Login">

						<input type="text" class="form-control" name="username"
							id="username" placeholder="Username" required> <input
							type="password" class="form-control" name="password"
							placeholder="Password" id="password" required>

						<button type="submit" class="form-control" id="submit-button"
							name="Accedi"
							style="background-color: #343a40 !important; color: white !important">Accedi</button>
						<!--  
						<label> Ricorda le mie credenziali per 2 giorni</label>
							<select value="tempo" name="tempo">
							<option value="12ore" name="12ore">12h</option>
							<option value="24ore" name="24ore">24h</option>
							<option value="48ore" name="48ore">48h</option>
						</select>
						
						 <input type="checkbox" name="rememberMe" >
					-->
						<div class="alert alert-info" role="alert">
							<center>Le credenziali verranno ricordate per 48 ore!</center>
						</div>

						<!--  
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="signup-agree">
                    <label class="custom-control-label text-small text-muted" for="signup-agree">Accetto i <a href="#">Termini &amp; Condizioni</a>
                    </label>
                    -->
				</div>
				</form>
			</div>

			<div class="modal-footer"></div>

		</div>
	</div>
	</div>



	<!-- SCRIPTS -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/aos.js"></script>
	<script src="js/smoothscroll.js"></script>
	<script src="js/custom.js"></script>
</html>