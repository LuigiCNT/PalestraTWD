<!DOCTYPE html>
<%@ page import="it.unirc.twd.beans.*"%>
<%@ page import="java.util.*"%>
<html lang="en">
<head>

<title>Area Riservata Admin</title>

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


					<li class="nav-item"><a href="#class"
						class="nav-link smoothScroll">Dati Personali</a></li>


					<li class="nav-item"><a href="#contact"
						class="nav-link smoothScroll">Contatti</a></li>


					<form action="Logout" method="post">
						<input type="submit" value="Logout">
					</form>
				</ul>

				<ul class="social-icon ml-lg-3">
					<li><a href="https://fb.com/tooplate" class="fa fa-facebook"></a></li>
					<li><a href="#" class="fa fa-twitter"></a></li>
					<li><a href="#" class="fa fa-instagram"></a></li>
				</ul>
			</div>

		</div>
	</nav>

	<%
	String username = (String) session.getAttribute("username");
	String stato = (String) session.getAttribute("stato");
	username = username.toUpperCase();
	Vector<Utente> v = (Vector<Utente>) session.getAttribute("listautenti");
	Vector<Utente> clienti = (Vector<Utente>) session.getAttribute("listaClienti");
	Vector<Attrezzi> la = (Vector<Attrezzi>) session.getAttribute("lista_attrezzi");
	int numeroClienti = (int) session.getAttribute("numeroClienti");
	int numeroAdmin = (int) session.getAttribute("numeroAdmin");
	int numeroAttrezzi = (int) session.getAttribute("numeroAttrezzi");
	%>
	<!-- HERO -->
	<section
		class="hero d-flex flex-column justify-content-center align-items-center"
		id="home">

		<div class="bg-overlay"></div>

		<div class="container">


			<div class="col-lg-8 col-md-10 mx-auto col-12">
				<div class="hero-text mt-5 text-center">


					<%
					if (stato == null || stato.equals("login")) {

					} else if (stato.equals("aggiunto utente")) {
					%>
					<div class="alert alert-success" role="alert">Utente aggiunto
						con successo!</div>
					<%
					} else if (stato.equals("errore aggiunta utente")) {
					%>

					<div class="alert alert-danger" role="alert">C'è stato un
						errore con l'aggiunta dell'utente!</div>
					<%
					} else if (stato.equals("utente elimina")) {
					%>
					<div class="alert alert-success" role="alert">Utente eliminato
						con successo!</div>
					<%} else if(stato.equals("errore utente non eliminato")){%>
						<div class="alert alert-danger" role="alert">C'è stato un
						errore con l'eliminazione dell'utente!</div>

					<%} else if(stato.equals("risultato funzione inc/dec")) {
					
					%>
					<div class="alert alert-success" role="alert">Nell anno precedente a quello immesso c'è stato un incremento/decremento di <%=(int) session.getAttribute("numeroinc")%> iscrizioni</div>
						
						<%} else{
							
						}
							%>
					
					<h1 class="text-white" data-aos="fade-up" data-aos-delay="500">
						BENTORNATO
						<%=username%>
						!
					</h1>


				</div>
			</div>

		</div>

	</section>





	<!-- ABOUT -->


	<!-- CLASS -->
	<section class="class section" id="class">
		<div class="container">
			<div class="row">

				<div class="col-lg-12 col-12 text-center mb-5">


					<h2 data-aos="fade-up" data-aos-delay="200">Spartan Gym</h2>
				</div>

				<div class="col-lg-4 col-md-6 col-12" data-aos="fade-up"
					data-aos-delay="400">
					<div class="class-thumb">


						<div class="class-info">
							<h3 class="mb-1">Dati Palestra</h3>
							<ul class="list-group list-group-flush">

								<li class="list-group-item">Numero Clienti = <%=numeroClienti%>
								</li>
								<li class="list-group-item">Numero Amministratori = <%=numeroAdmin%></li>
							</ul>

						</div>
					</div>
				</div>

				<div class="mt-5 mt-lg-0 mt-md-0 col-lg-4 col-md-6 col-12"
					data-aos="fade-up" data-aos-delay="500">
					<div class="class-thumb">


						<div class="class-info">
							<h3 class="mb-1">Iscrizioni</h3>


							<ul class="list-group list-group-flush">
								<li class="list-group-item"><a href="#" data-toggle="modal"
									data-target="#membershipForm"
									style="background-color: transparent; color: black !important">Nuovo
										Membro</a></li>

								<li class="list-group-item"><a href="#" data-toggle="modal"
									data-target="#mostraUtentiForm"
									style="background-color: transparent; color: black !important">Lista
										Membri</a></li>

								<li class="list-group-item"><a href="#" data-toggle="modal"
									data-target="#updateUtenteForm"
									style="background-color: transparent; color: black !important">Modifica
										Valori Cliente</a></li>

								<li class="list-group-item"><a href="#" data-toggle="modal"
									data-target="#EliminaUtenteForm"
									style="background-color: transparent; color: black !important">Elimina
										Membro</a></li>

							</ul>


						</div>
					</div>
				</div>

				<div class="mt-5 mt-lg-0 col-lg-4 col-md-6 col-12"
					data-aos="fade-up" data-aos-delay="600">
					<div class="class-thumb">

						<div class="class-info">
							<h3 class="mb-1">Attrezzatura</h3>
							<ul class="list-group list-group-flush">
								<li class="list-group-item"><a href="#" data-toggle="modal"
									data-target="#addAttrezziForm"
									style="background-color: transparent; color: black !important">Nuovo
										Attrezzo</a></li>
								<li class="list-group-item"><a href="#" data-toggle="modal"
									data-target="#getAllAttrezziForm"
									style="background-color: transparent; color: black !important">Mostra
										Attrezzi</a></li>
							</ul>


						</div>
					</div>
				</div>


<div class="mt-5 mt-lg-0 mt-md-0 col-lg-4 col-md-6 col-12"
					data-aos="fade-up" data-aos-delay="500">
					<div class="class-thumb">


						<div class="class-info">
							<h3 class="mb-1">Corsi</h3>


							<ul class="list-group list-group-flush">
								<li class="list-group-item"><a href="#" data-toggle="modal"
									data-target="#addCorsiForm"
									style="background-color: transparent; color: black !important">Nuovo
										Corso</a></li>

								<li class="list-group-item"><a href="#" data-toggle="modal"
									data-target="#"
									style="background-color: transparent; color: black !important">Lista
										Corsi</a></li>


							</ul>


						</div>
					</div>
				</div>

				<div class="mt-5 mt-lg-0 col-lg-4 col-md-6 col-12"
					data-aos="fade-up" data-aos-delay="600"
					style="margin-top: 30px !important">
					<div class="class-thumb">

						<div class="class-info">
							<h3 class="mb-1">Pagamenti</h3>
							<ul class="list-group list-group-flush">
								<li class="list-group-item"><a href="#" data-toggle="modal"
									data-target="#addPagamentiForm"
									style="background-color: transparent; color: black !important">Registra
										Pagamento</a></li>
								<li class="list-group-item"><a href="#" target="_blank">Da
										pagare</a></li>
								<li class="list-group-item"><a href="#" target="_blank">Già
										pagati</a></li>

							</ul>
						</div>
					</div>
				</div>

				<div class="mt-5 mt-lg-0 col-lg-4 col-md-6 col-12"
					data-aos="fade-up" data-aos-delay="600"
					style="margin-top: 30px !important">
					<div class="class-thumb">

						<div class="class-info">
							<h3 class="mb-1">Schede Allenamento</h3>
							<ul class="list-group list-group-flush">

								<li class="list-group-item"><a href="#" data-toggle="modal"
									data-target="#addSchedaForm"
									style="background-color: transparent; color: black !important">Carica
										Scheda</a></li>

							</ul>
						</div>
					</div>
				</div>
				<div class="mt-5 mt-lg-0 col-lg-4 col-md-6 col-12"
					data-aos="fade-up" data-aos-delay="600"
					style="margin-top: 30px !important">
					<div class="class-thumb">

						<div class="class-info">
							<h3 class="mb-1">Inc/Dec Iscrizioni</h3>
							Verfica un aumento o decremento delle iscrizioni rispetto
							all'anno precedente a quello immesso
							<form class="membership-form webform" name="AumentoIscrizioni"
								action="/AumentoIscrizioni" method="post" role="form">
								<input type="text" name="anno" placeholder="Anno" required>
								<button type="submit" class="form-control" 
									id="submit-button"
									name="Accedi"
									style="background-color: #343a40 !important; color: white !important">Verifica</button>
								<ul class="list-group list-group-flush">
								</ul>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


	<!-- SCHEDULE -->



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
						<i class="fa fa-map-marker mr-1"></i>Palizzi Marina
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
							width="600" height="450" frameborder="0" style="border: 0;"
							allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
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

					<h2 class="modal-title" id="membershipFormLabel">Nuovo Membro</h2>

					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-body">
					<form class="membership-form webform" name="CreaUtente"
						action="CreaUtente" onsubmit="document.required()" method="post"
						role="form">
						<input type="text" class="form-control" name="username"
							placeholder="Username" required> <input type="password"
							class="form-control" name="password" placeholder="Password"
							required> <input type="text" class="form-control"
							name="autorita" placeholder="Cliente/Admin" required> <input
							type="text" class="form-control" name="nome" placeholder="Nome"
							required> <input type="text" class="form-control"
							name="cognome" placeholder="Cognome" required> <input
							type="text" class="form-control" name="anno"
							placeholder="Anno iscrizione" required>

						<button type="submit" class="form-control" id="submit-button"
							name="Accedi"
							style="background-color: #343a40 !important; color: white !important">Crea</button>
					</form>

				</div>
				<!--  
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="signup-agree">
                    <label class="custom-control-label text-small text-muted" for="signup-agree">Accetto i <a href="#">Termini &amp; Condizioni</a>
                    </label>
                    -->
			</div>

		</div>

		<div class="modal-footer"></div>

	</div>

	<div class="modal fade" id="addSchedaForm" tabindex="-1" role="dialog"
		aria-labelledby="membershipFormLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">

			<div class="modal-content">
				<div class="modal-header">

					<h2 class="modal-title" id="membershipFormLabel">Aggiungi Scheda</h2>

					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-body">
					<form class="membership-form webform" name="AggiungiScheda"
						action="AggiungiScheda" onsubmit="document.required()" method="post"
						role="form">
						<input type="text" class="form-control" name="username"
							placeholder="Username" required> 
							
							<input type="text" class="form-control"
							name="tipologia" placeholder="Tipologia allenamento" required> 
							<input
							type="text" class="form-control" name="durata" placeholder="Durata (Giorni)"
							required> 
							<input type="text" class="form-control"
							name="link" placeholder="Link Dropbox/Google Drive" required> 

						<button type="submit" class="form-control" id="submit-button"
							name="Accedi"
							style="background-color: #343a40 !important; color: white !important">Aggiungi</button>
					</form>

				</div>
				<!--  
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="signup-agree">
                    <label class="custom-control-label text-small text-muted" for="signup-agree">Accetto i <a href="#">Termini &amp; Condizioni</a>
                    </label>
                    -->
			</div>

		</div>

		<div class="modal-footer"></div>

	</div>


<div class="modal fade" id="addCorsiForm" tabindex="-1" role="dialog"
		aria-labelledby="membershipFormLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">

			<div class="modal-content">
				<div class="modal-header">

					<h2 class="modal-title" id="membershipFormLabel">Aggiungi Corso</h2>

					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-body">
					<form class="membership-form webform" name="AggiungiCorso"
						action="AggiungiCorso" onsubmit="document.required()" method="post"
						role="form">
						<input type="text" class="form-control" name="tipologia"
							placeholder="Nome" required> 
							
							<input type="text" class="form-control"
							name="coach" placeholder="Coach" required> 
							<input
							type="text" class="form-control" name="durata" placeholder="Durata (Giorni)"
							required> 
						
						<button type="submit" class="form-control" id="submit-button"
							name="Accedi"
							style="background-color: #343a40 !important; color: white !important">Aggiungi</button>
					</form>

				</div>
				<!--  
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="signup-agree">
                    <label class="custom-control-label text-small text-muted" for="signup-agree">Accetto i <a href="#">Termini &amp; Condizioni</a>
                    </label>
                    -->
			</div>

		</div>

		<div class="modal-footer"></div>

	</div>
	<div class="modal fade" id="EliminaUtenteForm" tabindex="-1" role="dialog"
		aria-labelledby="membershipFormLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">

			<div class="modal-content">
				<div class="modal-header">

					<h2 class="modal-title" id="membershipFormLabel">Elimina Membro</h2>

					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-body">
					<form class="membership-form webform" name="EliminaUtente"
						action="EliminaUtente" onsubmit="document.required()"
						method="post" role="form">
						<input type="text" class="form-control" name="username"
							placeholder="Username" required>


						<button type="submit" class="form-control" id="submit-button"
							name="Accedi"
							style="background-color: #343a40 !important; color: white !important">Elimina</button>
					</form>

				</div>
				<!--  
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="signup-agree">
                    <label class="custom-control-label text-small text-muted" for="signup-agree">Accetto i <a href="#">Termini &amp; Condizioni</a>
                    </label>
                    -->
			</div>

		</div>

		<div class="modal-footer"></div>

	</div>



	<div class="modal fade" id="updateUtenteForm" tabindex="-1"
		role="dialog" aria-labelledby="membershipFormLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">

			<div class="modal-content">
				<div class="modal-header">

					<h2 class="modal-title" id="membershipFormLabel">Aggiorna Dati
						Fisici</h2>

					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-body">

					<form class="membership-form webform" name="ModificaUtente"
						action="/ModificaUtente" method="post" role="form">
						<div class="container"></div>


						<input type="text" class="form-control" name="username"
							placeholder="username" required> <input type="text"
							class="form-control" name="altezza" placeholder="altezza"
							required> <input type="text" class="form-control"
							name="peso" placeholder="peso" required> <input
							type="text" class="form-control" name="plicometria"
							placeholder="plico" required>


						<button type="submit" class="form-control" id="submit-button"
							name="Accedi"
							style="background-color: #343a40 !important; color: white !important">Aggiorna</button>
					</form>

				</div>

				<!--  
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="signup-agree">
                    <label class="custom-control-label text-small text-muted" for="signup-agree">Accetto i <a href="#">Termini &amp; Condizioni</a>
                    </label>
                    -->
			</div>

		</div>

		<div class="modal-footer"></div>



		<!-- Modal -->
		<div class="modal fade" id="addAttrezziForm" tabindex="-1"
			role="dialog" aria-labelledby="membershipFormLabel"
			aria-hidden="true">
			<div class="modal-dialog" role="document">

				<div class="modal-content">
					<div class="modal-header">

						<h2 class="modal-title" id="membershipFormLabel">Nuovo
							Attrezzo</h2>

						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>

					<div class="modal-body">
						<form class="membership-form webform" name="CreaAttrezzo"
							action="CreaAttrezzo" onsubmit="document.required()"
							method="post" role="form">
							<input type="text" class="form-control" name="nome"
								placeholder="Nome Attrezzo" required> <input type="text"
								class="form-control" name="gruppo_muscolare"
								placeholder="Gruppo Muscolare" required>

							<button type="submit" class="form-control" id="submit-button"
								name="Accedi"
								style="background-color: #343a40 !important; color: white !important">Crea</button>
						</form>
					</div>

					<!--  
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="signup-agree">
                    <label class="custom-control-label text-small text-muted" for="signup-agree">Accetto i <a href="#">Termini &amp; Condizioni</a>
                    </label>
                    -->
				</div>

			</div>

			<div class="modal-footer"></div>

		</div>


		<!-- Modal -->
		<div class="modal fade" id="addPagamentiForm" tabindex="-1"
			role="dialog" aria-labelledby="membershipFormLabel"
			aria-hidden="true">
			<div class="modal-dialog" role="document">

				<div class="modal-content">
					<div class="modal-header">

						<h2 class="modal-title" id="membershipFormLabel">Registra
							Pagamento</h2>

						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>

					<div class="modal-body">
						<form class="membership-form webform" name="RegistraPagamento"
							action="RegistraPagamento" onsubmit="document.required()"
							method="post" role="form">
							<input type="text" class="form-control" name="username"
								placeholder="Username" required> <input type="text"
								class="form-control" name="data" placeholder="00-GEN-0000"
								required> <input type="text" class="form-control"
								name="metodo" placeholder="Metodo di pagamento" required>

							<input type="text" class="form-control" name="importo"
								placeholder="Importo" required>
							<button type="submit" class="form-control" id="submit-button"
								name="Accedi"
								style="background-color: #343a40 !important; color: white !important">Crea</button>
						</form>
					</div>

					<!--  
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="signup-agree">
                    <label class="custom-control-label text-small text-muted" for="signup-agree">Accetto i <a href="#">Termini &amp; Condizioni</a>
                    </label>
                    -->
				</div>

			</div>

			<div class="modal-footer"></div>

		</div>


		


		<!-- Modal -->
		<div class="modal fade" id="mostraUtentiForm" tabindex="-1"
			role="dialog" aria-labelledby="membershipFormLabel"
			aria-hidden="true">
			<div class="modal-dialog" role="document">

				<div class="modal-content">
					<div class="modal-header">

						<h2 class="modal-title" id="membershipFormLabel">Lista utenti</h2>

						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>

					<div class="modal-body">
						<ul class="list-group">

							<%
							for (int i = 0; i < v.size(); i++) {
							%>
							<li class="list-group-item" style="font-size: 14px !important">
								<b>Username: </b> <%=v.elementAt(i).getUsername().toString()%> |
								<b>Nome: </b><%=v.elementAt(i).getNome().toString()%> <%=v.elementAt(i).getCognome().toString()%>
								<b>Autorità: </b> <%=v.elementAt(i).getAutorita().toString()%>

							</li>
							<%
							}
							%>
						</ul>
						<!--  
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="signup-agree">
                    <label class="custom-control-label text-small text-muted" for="signup-agree">Accetto i <a href="#">Termini &amp; Condizioni</a>
                    </label>
                    -->

					</div>

				</div>

				<div class="modal-footer"></div>

			</div>
		</div>
	</div>

	

	<div class="modal fade" id="getAllAttrezziForm" tabindex="-1"
		role="dialog" aria-labelledby="membershipFormLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">

			<div class="modal-content">
				<div class="modal-header">

					<h2 class="modal-title" id="membershipFormLabel">Lista
						attrezzi</h2>

					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-body">
					<ul>
						Totale Attrezzi =
						<%=numeroAttrezzi%></ul>
					<ul class="list-group">
						<%
						for (int i = 0; i < la.size(); i++) {
						%>

						<li class="list-group-item" style="font-size: 14px !important">
							<b>Nome: </b> <%=la.elementAt(i).getNome().toString()%> | <b>Gruppo
								Muscolare: </b><%=la.elementAt(i).getGruppo_muscolare().toString()%>
						</li>

						<%
						}
						%>
					</ul>
					<!--  
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="signup-agree">
                    <label class="custom-control-label text-small text-muted" for="signup-agree">Accetto i <a href="#">Termini &amp; Condizioni</a>
                    </label>
                    -->
				</div>

			</div>

			<div class="modal-footer"></div>

		</div>
	</div>




	<!-- SCRIPTS -->
	<script src="js/scripts.js"></script>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/aos.js"></script>
	<script src="js/smoothscroll.js"></script>
	<script src="js/custom.js"></script>

</body>


<!--  
Funzione required()
 -->

</html>