<!DOCTYPE html>

<%@ page import="it.unirc.twd.beans.*"%>
<%@ page import="java.util.*"%>

<html lang="en">
<head>

<title>Area Riservata Utente</title>

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
	String stato = (String) session.getAttribute("stato");
	System.out.println("stato " + stato);
Utente u = (Utente) session.getAttribute("utente");
System.out.println("utente: " + u.toString());
Dati_fisici df = (Dati_fisici) session.getAttribute("dati_fisici");
System.out.println("Dati_fisici: " + df.toString());
Pagamento p = (Pagamento) session.getAttribute("pagamento");
System.out.println("pagamento: " + p.toString());
Scheda_allenamento s = (Scheda_allenamento) session.getAttribute("scheda");
System.out.println("scheda: " + s.toString());
String username = u.getUsername().toUpperCase();
System.out.println(username.toString());
String nome = u.getNome().toUpperCase();
System.out.println(nome.toString());
String cognome = u.getCognome().toUpperCase();
System.out.println(cognome.toString());
Vector<Corsi> corsi = (Vector<Corsi>) session.getAttribute("lista_corsi");
System.out.println(corsi.toString());
Vector<Iscrizioni> lista_iscrizioni = (Vector<Iscrizioni>) session.getAttribute("lista_iscrizioni");
System.out.println(lista_iscrizioni.toString());
     %>



	<!-- HERO -->
	<section
		class="hero d-flex flex-column justify-content-center align-items-center"
		id="home">

		<div class="bg-overlay"></div>

		<div class="container">


			<div class="col-lg-8 col-md-10 mx-auto col-12">
				<div class="hero-text mt-5 text-center">
					<% if(stato == null) {  %>
					
					<%} else if(stato.equals("aggiunta iscrizione")) {
						%>
					<div class="alert alert-success" role="alert">
 	Iscritto con successo!
</div>
					<%} else if(stato.equals("errore iscrizione")){ %>
					<div class="alert alert-danger" role="alert">
  C'� stato un problema con l'iscrizione, riprova.
</div>
					<%} else { }
						%>
					
					
					<h1 class="text-white" data-aos="fade-up" data-aos-delay="500">
						BENTORNATO
						<%= nome %> <%= cognome %>
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
				
				
				
				<br><br>
						
					<h4 data-aos="fade-up" data-aos-delay="200" > Ricordati di cambiare la password la prima volta che ti colleghi </h4>

					<h2 data-aos="fade-up" data-aos-delay="200">I tuoi Dati
						Personali</h2>
						
		
						
				</div>
				
				
				
	
				<div class="col-lg-4 col-md-6 col-12" data-aos="fade-up"
					data-aos-delay="400">
					<div class="class-thumb">


						<div class="class-info">
							<h3 class="mb-1">Dati fisici</h3>
							<ul class="list-group list-group-flush">
								<li class="list-group-item">Altezza= <%= df.getAltezza() %>
									cm
								</li>
								<li class="list-group-item">Peso= <%= df.getPeso() %> kg
								</li>
								<li class="list-group-item">Valore Plicometrico= <%= df.getPlicometria() %>
									mm
								</li>
							</ul>

						</div>
					</div>
				</div>

				<div class="mt-5 mt-lg-0 mt-md-0 col-lg-4 col-md-6 col-12"
					data-aos="fade-up" data-aos-delay="500">
					<div class="class-thumb">


						<div class="class-info">
							<h3 class="mb-1">Scheda allenamento</h3>


							<ul class="list-group list-group-flush">
								<li class="list-group-item">Tipologia= <%= s.getTipologia() %>
								</li>
								<li class="list-group-item">Durata= <%= s.getDurata() %> giorni
								</li>
								<li class="list-group-item"><a href="<%= s.getLink() %>" target="_blank">Visualizza
										scheda allenamento</a></li>
							</ul>


						</div>
					</div>
				</div>

<div class="mt-5 mt-lg-0 col-lg-4 col-md-6 col-12"
					data-aos="fade-up" data-aos-delay="600"
					>
					<div class="class-thumb">

						<div class="class-info">
							<h3 class="mb-1">Iscriviti ad un Corso</h3>
							<ul class="list-group list-group-flush">
								
								<li class="list-group-item"><a href="#" data-toggle="modal"
									data-target="#addIscrizioneForm"
									style="background-color: transparent; color: black !important">Iscriviti</a></li>
								
								<li class="list-group-item"><a href="#" data-toggle="modal"
									data-target="#visualizzaCorsi"
									style="background-color: transparent; color: black !important">Visualizza corsi esistenti
										</a></li>
								<li class="list-group-item"><a href="#" data-toggle="modal"
									data-target="#listaIscrizioni"
									style="background-color: transparent; color: black !important">Visualizza iscrizioni
										</a></li>		
							</ul>
						</div>
					</div>
				</div>

				<div class="mt-5 mt-lg-0 col-lg-4 col-md-6 col-12"
					data-aos="fade-up" data-aos-delay="600"
					style="margin-top: 30px !important">
					<div class="class-thumb">

						<div class="class-info">
							<h3 class="mb-1">Ultimo Pagamento</h3>
							<ul class="list-group list-group-flush">
								
								
								<li class="list-group-item">Data= <%= p.getData() %>
									
								</li>
								<li class="list-group-item">Importo= <%= p.getImporto() %>$
								</li>
								<li class="list-group-item">Metodo= <%= p.getMetodo() %>
								
								</li>
							
							</ul>


						</div>
					</div>
				</div>
				
				<div class="mt-5 mt-lg-0 col-lg-4 col-md-6 col-12"
					data-aos="fade-up" data-aos-delay="600"
					style="margin-top: 30px !important">
					<div class="class-thumb">

						<div class="class-info">
							<h3 class="mb-1">Password</h3>
							<ul class="list-group list-group-flush">
								
								<li class="list-group-item"><a href="#" data-toggle="modal"
									data-target="#AggiornaPassword"
									style="background-color: transparent; color: black !important">Aggiorna Password</a></li>

							</ul>
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
						Where you can <span>find us</span>
					</h2>

					<p data-aos="fade-up" data-aos-delay="800">
						<i class="fa fa-map-marker mr-1"></i> 120-240 Rio de Janeiro -
						State of Rio de Janeiro, Brazil
					</p>
					<!-- How to change your own map point
	1. Go to Google Maps
	2. Click on your location point
	3. Click "Share" and choose "Embed map" tab
	4. Copy only URL and paste it within the src="" field below
-->
					<div class="google-map" data-aos="fade-up" data-aos-delay="900">
						<iframe
							src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3139.358998308237!2d15.645384115285838!3d38.108581679700094!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x13145085e41620c7%3A0x2f7ea858302d53ea!2sVia%20dei%20Filippini%2C%2089125%20Reggio%20Calabria%20RC%2C%20Italia!5e0!3m2!1sit!2sus!4v1611770411115!5m2!1sit!2sus"
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
	   
	   <!-- FORM AGGIORNA PASSWORD -->
    <div class="modal fade" id="AggiornaPassword" tabindex="-1" role="dialog" aria-labelledby="membershipFormLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">

        <div class="modal-content">
          <div class="modal-header">

            <h2 class="modal-title" id="membershipFormLabel">Aggiorna Password</h2>

            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>

          <div class="modal-body">
            <form class="membership-form webform" name="AggiornaPassword" action="AggiornaPassword" onsubmit="document.required()" method="post" role="form">
                
                <input type="text" class="form-control" name="username" value="<%= u.getUsername() %>" disabled required> 
                <input type="text" class="form-control" name="vecchia" placeholder="Passowrd Vecchia" required>

                <input type="text" class="form-control" name="password1" placeholder="Nuova Password" required>
                
                <input type="text" class="form-control" name="password2" placeholder="Conferma Nuova Password" required>
                
                <button type="submit" class="form-control" id="submit-button" name="Accedi" style="background-color:#343a40 !important;color:white !important">Aggiorna</button>
                
               	<div class="alert alert-warning" role="alert">
  <strong>Attenzione:</strong> dopo aver cambiato la password, dovrai di nuovo effettuare il Login! 
</div>
</form>
</div>
                

                </div>
            
          </div>

          <div class="modal-footer"></div>

        </div>
        
        <!-- FINE FORM PASSWORD -->
    
<!-- INIZIO FORM NUOVA ISCRIZIONE -->
<div class="modal fade" id="addIscrizioneForm" tabindex="-1" role="dialog"
		aria-labelledby="membershipFormLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">

			<div class="modal-content">
				<div class="modal-header">

					<h2 class="modal-title" id="membershipFormLabel">Iscriviti ad un corso</h2>

					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-body">
					<form class="membership-form webform" name="CreaIscrizione"
						action="CreaIscrizione" onsubmit="document.required()" method="post"
						role="form">
						
						<input type="text"
							class="form-control" name="nomeCorso" placeholder="Password"
							required> 
						<button type="submit" class="form-control" id="submit-button"
							name="Accedi"
							style="background-color: #343a40 !important; color: white !important">Iscriviti</button>
					</form>

				</div>
			</div>
		</div>
		<div class="modal-footer"></div>
	</div>

<!-- FINE FORM ISCRIZIONE -->

<!-- VISUALIZZA TUTTI I CORSI -->
<div class="modal fade" id="visualizzaCorsi" tabindex="-1"
		role="dialog" aria-labelledby="membershipFormLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">

			<div class="modal-content">
				<div class="modal-header">

					<h2 class="modal-title" id="membershipFormLabel">Lista Corsi</h2>

					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-body">
					<ul class="list-group">

						<%
							for (int i = 0; i < corsi.size(); i++) {
							%>
						<li class="list-group-item" style="font-size: 14px !important">
							<b>Nome Corso: </b> <%=corsi.elementAt(i).getTipologia().toString()%> |
							<b>Coach: </b><%=corsi.elementAt(i).getCoach().toString()%>
							<b>Durata: </b> <%=corsi.elementAt(i).getDurata()%> Giorni

						</li>
						<%
							}
							%>
					</ul>
				</div>
			</div>
		</div>
		<div class="modal-footer"></div>
	</div>
<!--  FINE VISUALIZZA CORSI -->
	

<div class="modal fade" id="listaIscrizioni" tabindex="-1"
		role="dialog" aria-labelledby="membershipFormLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">

			<div class="modal-content">
				<div class="modal-header">

					<h2 class="modal-title" id="membershipFormLabel"><%= username %> - Lista Iscrizioni</h2>

					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-body">
					<ul class="list-group">

						<%
							for (Iscrizioni i : lista_iscrizioni) {
							%>
						<li class="list-group-item" style="font-size: 14px !important">
							<b>Nome Corso: </b> <%=i.getNomeCorso()%> 
							
						</li>
						<%
							}
							%>
					</ul>
				</div>
			</div>
		</div>
		<div class="modal-footer"></div>
	</div>



	<!-- Modal -->

	<!-- SCRIPTS -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/aos.js"></script>
	<script src="js/smoothscroll.js"></script>
	<script src="js/custom.js"></script>

</body>

</html>