<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- Theme Made By www.w3schools.com - No Copyright -->
<title>service</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<style>
ul.navLogoSerwis {
	list-style-type: none;
}

li.navInBloc {
	display: inline-block;
}
</style>
</head>
<body>
	<nav>
		<!-- container-fluid-->
		<div class="container-fluid">
			<!--MENU : Show a main menu.-->
			<div class="row">
				<div class=" bg-nav-menu" style="margin-top: 35px;">
					<!--NAV 1: Show a language navigation-->
					<spring:url value="/panel/?language=pl" var="pl" />
					<spring:url value="/panel/?language=en" var="en" />
					<div class="col-md-* pull-left">
						<div class="btn-group" role="group" aria-label="menuLanguage"
							style="padding-left: 35px; padding-right: 0px;">
							<button type="button" class="btn btn-default"
								onClick="location.href='${pl}'">PL</button>
							<button type="button" class="btn btn-default"
								onClick="location.href='${en}'">EN</button>
						</div>
					</div>
					<!--NAV 1: END-->
					<!--NAV 2:  Search an editorial section.-->
					<spring:message code="web.panel.search.section" var="searchSection" />
					<div class="col-md-4"
						style="padding-left: 15px; padding-right: 0px;">
						<div class="input-group">
							<span class="input-group-btn">
								<button class="btn btn-default" type="button">
									<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
								</button>
							</span> <input type="text" class="form-control"
								placeholder="${searchSection}">
						</div>
					</div>
					<!--NAV 2: END-->
					<!--NAV 3: Show an editorial section.-->
					<spring:message code="web.panel.show.section" var="showSection" />
					<div class="col-md-4"
						style="padding-left: 15px; padding-right: 0px;">
						<div class="input-group" style="padding-left: 0px;">
							<button class="btn btn-default dropdown-toggle" type="button"
								data-toggle="collapse" data-target="#collapseSekcje"
								aria-expanded="false" aria-controls="collapseExample"
								style="color: #000">
								<span class="glyphicon glyphicon-eye-open" aria-hidden="true">
								</span> ${showSection}
							</button>
						</div>
					</div>
					<!--NAV 3: END-->
					<!--NAV 4: Show an editorial section.-->
					<spring:message code="web.panel.logout" var="logout" />
					<spring:message code="web.panel.preferences" var="preferences" />
					<spring:message code="web.panel.help" var="help" />
					<div class="col-md-2 pull-right input-group">
						<div class="dropdown">
							<button class="btn btn-default dropdown-toggle" type="button"
								id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="true">
								<span class="glyphicon glyphicon-user"></span>
								kolardia@gmail.com <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" aria-labelledby="dropdownUser">
								<li><a href="#"><span class="glyphicon glyphicon-lock"
										aria-hidden="true"></span> ${logout}</a></li>
								<li><a href="#"><span
										class="glyphicon glyphicon-wrench" aria-hidden="true"></span>
										${preferences}</a></li>
								<li><a href="#"><span class="glyphicon glyphicon-star"
										aria-hidden="true"></span> ${help}</a></li>
							</ul>
						</div>
					</div>
					<!--NAV 4: END -->
				</div>
				<!-- End of that main menu. -->

				<!--NAV BLOK ORGANIZATORA-->
				<div class="col-md-9" style="margin-left: auto; margin-right: auto">
					<div class="collapse" id="collapseSekcje" style="margin-top: 20px;">
						<div class="well">
							<c:forEach varStatus="status" var="category"
								items="${collectionCategory}">
								<spring:url value="/category/${category.id}" var="elementUrl" />
								<button onclick="location.href='${elementUrl}'">Query</button>
		Category:${category.id} : ${category.name}<br />
							</c:forEach>

						</div>
					</div>
				</div>
				<!--NAV BOK -->
			</div>
			<!--END row -->
		</div>
		<!--END container-->
	</nav>


	<div class="row"
		style="margin-top: 25px; margin-right: 20px; margin-left: 20px;">

		<!-- JEDNOSTKA DO WYKAZU PANELU -->
		<div class="col-sm-3 ">
			<div class="thumbnail" style="margin-top: 0px;">
				<img
					src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSzQh6ifPnRZ604ko0s0L6w3bjacB6kMjejmU345OqCDaRGfYXk"
					class="img-responsive img-thumbnail" alt="Responsive image"
					style="margin-top: 30px;">
				<div class="caption text-center">
					<h3>Organizator: Lego</h3>
					<p>
						Marka komercyjna z kategori "dla dzieci"<br>oferujÄca
						asortyment zabawek. <br /> Organizator warsztatÃ³w i konkursÃ³w
						dla dzieci w rÃ³Å¼nej kategori wiekowej.


					</p>
					<div class="btn-group" data-toggle="buttons">
						<label class="btn btn-default active"> <input type="radio"
							name="options" id="option1" autocomplete="off" checked> <span
							class=" glyphicon glyphicon-pencil" aria-hidden="true"></span>
							Konto
						</label> <label class="btn btn-default"> <input type="radio"
							name="options" id="option2" autocomplete="off"> <span
							class="glyphicon glyphicon-globe" aria-hidden="true"></span>
							Serwis
						</label> <label class="btn btn-default"> <input type="radio"
							name="options" id="option3" autocomplete="off"> <span
							class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
							Kontakt
						</label>
					</div>

				</div>
			</div>
		</div>

		<div class="panel-body">
			<div class="panel panel-default">

				<!-- PANEL ADMINISTRACYJNY JEDNOSRKI -->
				<div class="col-sm-9 ">

					<!-- MENU PANELU ADMINISTRACYJNEGO -->
					<ul class="nav nav-tabs" role="tablist" style="margin-top: 25px;">
						<li role="presentation" class="active"><a href="#baza"
							aria-controls="baza" role="tab" data-toggle="tab"
							style="color: #C0C0C0"><b>BAZA ADRESOWA</b></a></li>
						<li role="presentation"><a href="#ogloszenia"
							aria-controls="ogloszenia" role="tab" data-toggle="tab"
							style="color: #C0C0C0"><b>OGLOSZENIA</b></a></li>
						<li role="presentation"><a href="#pomoc"
							aria-controls="pomoc" role="tab" data-toggle="tab"
							style="color: #C0C0C0"><b>POMOC</b></a></li>
					</ul>

					<!-- GLOWNY PANEL ADMINISTRACYJNY -->
					<div class="tab-content">
						<!-- BAZA ADRESOWA -->
						<div role="tabpanel" class="tab-pane active" id="baza">
							<div class="row" style="margin-bottom: 5px; margin-top: 10px">
								<div class="col-md-7">
									<div class="btn-group btn-group-justified" role="group"
										aria-label="...">
										<div class="btn-group" role="group">
											<button type="button" class="btn btn-default"
												style="border-color: #FFF">
												<span class="glyphicon glyphicon-envelope"
													aria-hidden="true"></span> Organizator
											</button>
										</div>
										<div class="btn-group" role="group">
											<button type="button" class="btn btn-default"
												style="border-color: #FFF">
												<span class="glyphicon glyphicon-envelope"
													aria-hidden="true"></span> Administracja
											</button>
										</div>
										<div class="btn-group" role="group">
											<button type="button" class="btn btn-default"
												style="border-color: #FFF">
												<span class="glyphicon  glyphicon-envelope"
													aria-hidden="true"></span> Redaktorzy
											</button>
										</div>
										<div class="btn-group" role="group">
											<button type="button" class="btn btn-default"
												style="border-color: #FFF">
												<span class="glyphicon  glyphicon-envelope"
													aria-hidden="true"></span> Uczestnicy
											</button>
										</div>
									</div>
								</div>
								<div class="col-md-5 pull-right">
									<div class="input-group input-group-sm">
										<span class="input-group-btn">
											<button class="btn btn-default" type="button">
												<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
											</button>
										</span> <input type="text" class="form-control"
											placeholder="ZnajdÅº partnera lub sponsora aby uzyskaÄ do niego dostÄp...">
									</div>
								</div>
							</div>
							<!-- Wykaz tabel -->
							<div class="panel panel-default"></div>
							<div class="row" style="margin-bottom: 5px; margin-top: 10px">
								<div class="col-md-6">
									<p
										style="font-size: 14px; margin-left: 15px; font-weight: 400; line-height: 1.42857; margin-top: -2px">
										Wykaz adresÃ³w: <span style="color: #C0C0CA;">redaktorzy</span>
									</p>
								</div>
								<div class="col-md-3 pull-right">
									<nav style="margin-bottom: -17px; margin-top: -30px">
										<ul class="pagination pagination-sm">
											<li><a href="#" aria-label="Previous"
												style="color: #757575"> <span aria-hidden="true">&laquo;</span>
											</a></li>
											<li><a href="#" style="color: #757575">1</a></li>
											<li><a href="#" style="color: #757575">2</a></li>
											<li><a href="#" style="color: #757575">3</a></li>
											<li><a href="#" style="color: #757575">4</a></li>
											<li><a href="#" style="color: #757575">5</a></li>
											<li><a href="#" aria-label="Next" style="color: #757575">
													<span aria-hidden="true">&raquo;</span>
											</a></li>
										</ul>
									</nav>
								</div>
							</div>
							<table class="table table-striped">
								<thead style="color: #C0C0C0;">
									<tr>
										<th><span style="margin-left: 10px">ID</span></th>
										<th>Name</th>
										<th>Email</th>
										<th>framework</th>
										<th>Action</th>
									</tr>
								</thead>
								<tr>
									<td>Warsztat</td>
									<td>Tytul</td>
									<td>${user.email}</td>
									<td><c:forEach var="framework" items="${user.framework}"
											varStatus="loop">
													${framework}
													<c:if test="${not loop.last}">,</c:if>
										</c:forEach></td>
									<td><spring:url value="/users/${user.id}" var="userUrl" />
										<spring:url value="/users/${user.id}/delete" var="deleteUrl" />
										<spring:url value="/users/${user.id}/update" var="updateUrl" />

										<button class="btn btn-info"
											style="color: rgb(89, 89, 89); background-color: rgba(91, 192, 222, 0); border-color: rgb(164, 164, 164);"
											onclick="location.href='${userUrl}'">Query</button></td>
								</tr>
								<tr>
									<td>Szkolenie</td>
									<td>Tytul</td>
									<td>${user.email}</td>
									<td><c:forEach var="framework" items="${user.framework}"
											varStatus="loop">
													${framework}
													<c:if test="${not loop.last}">,</c:if>
										</c:forEach></td>
									<td><spring:url value="/users/${user.id}" var="userUrl" />
										<spring:url value="/users/${user.id}/delete" var="deleteUrl" />
										<spring:url value="/users/${user.id}/update" var="updateUrl" />

										<button class="btn btn-info"
											style="color: rgb(89, 89, 89); background-color: rgba(91, 192, 222, 0); border-color: rgb(164, 164, 164);"
											onclick="location.href='${userUrl}'">Query</button></td>
								</tr>
								<tr>
									<td>Szkolenie</td>
									<td>Tytul</td>
									<td>${user.email}</td>
									<td><c:forEach var="framework" items="${user.framework}"
											varStatus="loop">
													${framework}
													<c:if test="${not loop.last}">,</c:if>
										</c:forEach></td>
									<td><spring:url value="/users/${user.id}" var="userUrl" />
										<spring:url value="/users/${user.id}/delete" var="deleteUrl" />
										<spring:url value="/users/${user.id}/update" var="updateUrl" />

										<button class="btn btn-info"
											style="color: rgb(89, 89, 89); background-color: rgba(91, 192, 222, 0); border-color: rgb(164, 164, 164);"
											onclick="location.href='${userUrl}'">Query</button></td>
								</tr>
								<tr>
									<td>Szkolenie</td>
									<td>Tytul</td>
									<td>${user.email}</td>
									<td><c:forEach var="framework" items="${user.framework}"
											varStatus="loop">
													${framework}
													<c:if test="${not loop.last}">,</c:if>
										</c:forEach></td>
									<td><spring:url value="/users/${user.id}" var="userUrl" />
										<spring:url value="/users/${user.id}/delete" var="deleteUrl" />
										<spring:url value="/users/${user.id}/update" var="updateUrl" />

										<button class="btn btn-info"
											style="color: rgb(89, 89, 89); background-color: rgba(91, 192, 222, 0); border-color: rgb(164, 164, 164);"
											onclick="location.href='${userUrl}'">Query</button></td>
								</tr>
							</table>
						</div>
						<!--/baza adresowa-->
						<!-- OGLOSZENIA-->
						<div role="tabpanel" class="tab-pane" id="ogloszenia">
							<div class="row" style="margin-bottom: 5px; margin-top: 10px">
								<div class="col-md-7">
									<div class="btn-group btn-group-justified" role="group"
										aria-label="...">
										<div class="btn-group" role="group">
											<button type="button" class="btn btn-default"
												style="border-color: #FFF">
												<span class="glyphicon glyphicon-comment" aria-hidden="true"></span>
												Organizator
											</button>
										</div>
										<div class="btn-group" role="group">
											<button type="button" class="btn btn-default"
												style="border-color: #FFF">
												<span class="glyphicon glyphicon-comment" aria-hidden="true"></span>
												Redaktorzy
											</button>
										</div>
										<div class="btn-group" role="group">
											<button type="button" class="btn btn-default"
												style="border-color: #FFF">
												<span class="glyphicon  glyphicon-plus" aria-hidden="true"></span>
												Ogloszenie
											</button>
										</div>
										<div class="btn-group" role="group">
											<button type="button" class="btn btn-default"
												style="border-color: #FFF">
												<span class="glyphicon glyphicon-calendar"
													aria-hidden="true"></span> Kalendarz
											</button>
										</div>
									</div>
								</div>
								<div class="col-md-5 pull-right">
									<div class="input-group input-group-sm">
										<span class="input-group-btn">
											<button class="btn btn-default" type="button">
												<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
											</button>
										</span> <input type="text" class="form-control"
											placeholder="ZnajdÅº partnera lub sponsora aby uzyskaÄ do niego dostÄp...">
									</div>
								</div>
							</div>
							<!-- Wykaz tabel -->
							<div class="panel panel-default"></div>
							<div class="row" style="margin-bottom: 5px; margin-top: 10px">
								<div class="col-md-6">
									<p
										style="font-size: 14px; margin-left: 15px; font-weight: 400; line-height: 1.42857; margin-top: -2px">
										OgÅoszenia: <span style="color: #C0C0CA;">organizatora</span>
									</p>
								</div>
								<div class="col-md-3"
									style="text-align: right; color: #C0C0CA; margin-top: -2px">
									<p>14.12.2015 - 16-12-2015</p>
								</div>
								<div class="col-md-3 pull-right text-center">
									<nav style="margin-bottom: -17px; margin-top: -30px">
										<ul class="pagination pagination-sm">
											<li><a href="#" aria-label="Previous"
												style="color: #757575"> <span aria-hidden="true">&laquo;</span>
											</a></li>
											<li><a href="#" style="color: #757575">1</a></li>
											<li><a href="#" style="color: #757575">2</a></li>
											<li><a href="#" style="color: #757575">3</a></li>
											<li><a href="#" style="color: #757575">4</a></li>
											<li><a href="#" style="color: #757575">5</a></li>
											<li><a href="#" aria-label="Next" style="color: #757575">
													<span aria-hidden="true">&raquo;</span>
											</a></li>
										</ul>
									</nav>
								</div>
							</div>

							<div class="row" style="margin-top: 10px">
								<div class="col-sm-6 col-md-3">
									<div class="thumbnail ogloszenie">
										<p class="text-ogloszenie text-center"
											style="color: rgb(128, 125, 125); margin-top: 10px">Zmiana
											regulaminu konkursu</p>
										<div class="thumbnail">
											<p class="text-ogloszenie">
												<b>ProszÄ zapoznaÄ siÄ z nowym regulaminem, wytyczne
													dotyczÄ zmian kryteriÃ³w wieku odnaÅnie etapÃ³w
													rekrutacji. </b>
											</p>
											<p class="text-ogloszenie">
												<span class="glyphicon glyphicon-floppy-save"
													aria-hidden="true"></span><span
													style="color: rgba(76, 158, 217, 0.83);">
													regulamin.pdf</span> <br /> <span
													class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
												kolardia@gmail.com
											</p>

										</div>
										<p
											style="color: rgb(128, 125, 125); text-align: right; margin-right: 10px;">
											czytaj wiÄcej...</p>
									</div>
								</div>
								<div class="col-sm-6 col-md-3">
									<div class="thumbnail ogloszenie">
										<p class="text-ogloszenie text-center"
											style="color: rgb(128, 125, 125); margin-top: 10px">Zmiana
											regulaminu konkursu</p>
										<div class="thumbnail">
											<p class="text-ogloszenie">
												<b>ProszÄ zapoznaÄ siÄ z nowym regulaminem, wytyczne
													dotyczÄ zmian kryteriÃ³w wieku odnaÅnie etapÃ³w
													rekrutacji. </b>
											</p>
											<p class="text-ogloszenie">
												<span class="glyphicon glyphicon-floppy-save"
													aria-hidden="true"></span><span
													style="color: rgba(76, 158, 217, 0.83);">
													regulamin.pdf</span> <br /> <span
													class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
												kolardia@gmail.com
											</p>

										</div>
										<p
											style="color: rgb(128, 125, 125); text-align: right; margin-right: 10px;">
											czytaj wiÄcej...</p>
									</div>
								</div>
								<div class="col-sm-6 col-md-3">
									<div class="thumbnail ogloszenie">
										<p class="text-ogloszenie text-center"
											style="color: rgb(128, 125, 125); margin-top: 10px">Zmiana
											regulaminu konkursu</p>
										<div class="thumbnail">
											<p class="text-ogloszenie">
												<b>ProszÄ zapoznaÄ siÄ z nowym regulaminem, wytyczne
													dotyczÄ zmian kryteriÃ³w wieku odnaÅnie etapÃ³w
													rekrutacji. </b>
											</p>
											<p class="text-ogloszenie">
												<span class="glyphicon glyphicon-floppy-save"
													aria-hidden="true"></span><span
													style="color: rgba(76, 158, 217, 0.83);">
													regulamin.pdf</span> <br /> <span
													class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
												kolardia@gmail.com
											</p>

										</div>
										<p
											style="color: rgb(128, 125, 125); text-align: right; margin-right: 10px;">
											czytaj wiÄcej...</p>
									</div>
								</div>
								<div class="col-sm-6 col-md-3">
									<div class="thumbnail ogloszenie">
										<p class="text-ogloszenie text-center"
											style="color: rgb(128, 125, 125); margin-top: 10px">Zmiana
											regulaminu konkursu</p>
										<div class="thumbnail">
											<p class="text-ogloszenie">
												<b>ProszÄ zapoznaÄ siÄ z nowym regulaminem, wytyczne
													dotyczÄ zmian kryteriÃ³w wieku odnaÅnie etapÃ³w
													rekrutacji. </b>
											</p>
											<p class="text-ogloszenie">
												<span class="glyphicon glyphicon-floppy-save"
													aria-hidden="true"></span><span
													style="color: rgba(76, 158, 217, 0.83);">
													regulamin.pdf</span> <br /> <span
													class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
												kolardia@gmail.com
											</p>

										</div>
										<p
											style="color: rgb(128, 125, 125); text-align: right; margin-right: 10px;">
											czytaj wiÄcej...</p>
									</div>
								</div>
							</div>
						</div>
						<!--/ogloszenia -->
						<!-- POMOC -->
						<div role="tabpanel" class="tab-pane" id="pomoc"
							style="padding: 15px">
							<div class="row" style="margin-bottom: 5px; margin-top: 10px">
								<div class="col-md-6">
									<h4 style="color: black">
										<b>Pomoc w obsÅudzÄ serwisu</b>
									</h4>
								</div>
								<div class="col-md-3 pull-right text-center"
									style="text-align: right; color: #C0C0CA; margin-top: -2px">
									<p class="text-ogloszenie">
										<span class="glyphicon glyphicon-floppy-save"
											aria-hidden="true"></span><span
											style="color: rgba(76, 158, 217, 0.83);">
											Instrukcja.pdf</span>
									</p>
								</div>
							</div>
							<p>"Sed ut perspiciatis unde omnis iste natus error sit
								voluptatem accusantium doloremque laudantium, totam rem aperiam,
								eaque ipsa quae</p>
							<p>
								<b>Baza adresowa</b>
							</p>
							<p>"Sed ut perspiciatis unde omnis iste natus error sit
								voluptatem accusantium doloremque laudantium, totam rem aperiam,
								eaque ipsa quae ab illo inventore veritatis et quasi architecto
								beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem
								quia voluptas sit aspernatur aut odit aut fugit, sed quia
								consequuntur magni dolores eos qui ratione voluptatem sequi
								nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor
								sit amet, consectetur, adipisci velit, sed quia non numquam eius
								modi tempora incidunt ut labore et dolore magnam aliquam quaerat
								voluptatem. Ut enim ad minima veniam, quis nostrum
								exercitationem ullam corporis suscipit laboriosam, nisi ut
								aliquid ex ea commodi consequatur? Quis autem vel eum iure
								reprehenderit qui in ea voluptate velit esse quam nihil
								molestiae consequatur, vel illum qui dolorem eum fugiat quo
								voluptas nulla pariatur?"</p>
							<p>
								<b>OgÅoszenia</b>
							</p>
							<p>"Sed ut perspiciatis unde omnis iste natus error sit
								voluptatem accusantium doloremque laudantium, totam rem aperiam,
								eaque ipsa quae ab illo inventore veritatis et quasi architecto
								beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem
								quia voluptas sit aspernatur aut odit aut fugit, sed quia
								consequuntur magni dolores eos qui ratione voluptatem sequi
								nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor
								sit amet, consectetur, adipisci velit, sed quia non numquam eius
								modi tempora incidunt ut labore et dolore magnam aliquam quaerat
								voluptatem. Ut enim ad minima veniam, quis nostrum
								exercitationem ullam corporis suscipit laboriosam, nisi ut
								aliquid ex ea commodi consequatur? Quis autem vel eum iure
								reprehenderit qui in ea voluptate velit esse quam nihil
								molestiae consequatur, vel illum qui dolorem eum fugiat quo
								voluptas nulla pariatur?"</p>

						</div>
					</div>
				</div>
				<!-- /col-sm-9 *glowny panel wszytkich stron -->
			</div>
		</div>

	</div>


</body>
</html>
