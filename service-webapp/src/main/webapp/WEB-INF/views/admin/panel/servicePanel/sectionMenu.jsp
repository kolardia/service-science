<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/core/images/gallery.png" var="gallery" />

<spring:message code="admin.service.section.menu.add.gallery"
	var="menuAddGallery" />
<spring:message code="admin.service.section.menu.edit.gallery"
	var="menuEditGallery" />
<spring:message code="admin.service.section.menu.language"
	var="menuLanguage" />
<spring:message
	code="admin.service.section.menu.language.dropdown.show.pl"
	var="LanguageShowPL" />
<spring:message
	code="admin.service.section.menu.language.dropdown.show.en"
	var="LanguageShowEN" />

<spring:message code="admin.service.section.table.name" var="tableName" />
<spring:message code="admin.service.section.table.surname"
	var="tableSurname" />
<spring:message code="admin.service.section.table.mail" var="tableEmail" />
<spring:message code="admin.service.section.table.phone"
	var="tablePhone" />
<spring:message code="admin.service.section.table.address"
	var="tableAddress" />
<spring:message code="admin.service.section.table.city" var="tableCity" />
<spring:message code="admin.service.section.table.province"
	var="tableProvince" />
<spring:message code="admin.service.section.table.country"
	var="tableCountry" />
<spring:message code="admin.service.section.table.account"
	var="tableAccount" />

<div class="row" style="margin-bottom: 5px; margin-top: 10px">
	<div class=col-md-7>
		<div class="row">
			<div class=col-md-12>

				<div class="btn-group btn-group-justified" role="group"
					aria-label="...">
					<div style="color: #4E84AB; text-align: center;" class="btn-group"
						role="group">
						<span class="glyphicon glyphicon-bullhorn" aria-hidden="true"></span>
						<b>Instytucja</b>
					</div>
					<div class="btn-group" role="group">
						<button type="button" class="btn btn-default"
							style="border-color: #FFF">
							<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
							${menuAddGallery}
						</button>
					</div>


					<div class="btn-group" role="group">
						<button type="button" class="btn btn-default"
							style="border-color: #FFF">
							<span class="glyphicon glyphicon-picture" aria-hidden="true"></span>
							${menuEditGallery}
						</button>
					</div>
					<div class="btn-group" role="group">
						<div class="dropdown">
							<button class="btn btn-default dropdown-toggle"
								style="border-color: #FFF" type="button" id="dropdownSection"
								data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
								<span class="glyphicon glyphicon-flag" aria-hidden="true"></span>
								${menuLanguage}
							</button>
							<ul class="dropdown-menu" aria-labelledby="dropdownSection">
								<li><a href="#"><b>PL</b> ${LanguageShowPL}</a></li>
								<li><a href="#"><b>EN</b> ${LanguageShowEN}</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="panel panel-default"></div>

			</div>
			<!-- col-md-12 -->
			<div class=col-md-12>
				<div class="row">
					<div class=col-md-12>
						<p>"Sed ut perspiciatis unde omnis iste natus error sit
							voluptatem accusantium doloremque laudantium, totam rem aperiam,
							eaque ipsa quae ab illo inventore veritatis et quasi architecto
							beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem
							quia voluptas sit aspernatur aut odit aut fugit, sed quia
							consequuntur magni dolores eos qui ratione voluptatem sequi
							nesciunt. NequeSed ut perspiciatis unde omnis iste natus error
							sit voluptatem accusantium doloremque laudantium, totam rem
							aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
							architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam
							voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed
							quia consequuntur magni dolores eos qui ratione voluptatem sequi
							nesciunt. Neque</p>
					</div>
					<div class="col-md-3 col-sm-3">
						<img src="${gallery}" alt="..." class="img-thumbnail">
					</div>
					<div class="col-md-3 col-sm-3">
						<img src="${gallery}" alt="..." class="img-thumbnail">
					</div>
					<div class="col-md-3 col-sm-3">
						<img src="${gallery}" alt="..." class="img-thumbnail">
					</div>
					<div class="col-md-3 col-sm-3">
						<img src="${gallery}" alt="..." class="img-thumbnail">
					</div>
				</div>
				<br />
			</div>
			<!-- col-md-12 -->

		</div>
		<!-- row -->

	</div>
	<!-- col-md-6 -->
	<div class="col-md-5">

		<div class="panel-group" id="accordion" role="tablist"
			aria-multiselectable="true" style="margin-top: -5px;">
			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="headingOne">
					<h4 class="panel-title">
						<a role="button" data-toggle="collapse" data-parent="#accordion"
							href="#collapseOne" aria-expanded="false "
							aria-controls="collapseOne"> Instytucja publiczna :
							xxxxxxxxxxxxxxxxxxxxxx </a>
					</h4>
				</div>
				<div id="collapseOne" class="panel-collapse collapse in"
					role="tabpanel" aria-labelledby="headingOne">
					<div class="panel-body">
						<table class="table table-bordered" style="width: 100%;">
							<tr>
								<td style="border: 1px solid #FFF"><b>${tablePhone}</b></td>
								<td style="border: 1px solid #FFF">884-382-856</td>
							</tr>
							<tr>
							<tr>
								<td style="border: 1px solid #FFF"><b>${tableEmail}</b></td>
								<td style="border: 1px solid #FFF">sekretariat@gmail.com</td>
							</tr>
							<tr>
								<td style="border: 1px solid #FFF"><b>${tableAddress}</b></td>
								<td style="border: 1px solid #FFF">ul. Dombrowskiego</td>
							</tr>
							<tr>
								<td style="border: 1px solid #FFF"><b>${tableCity}</b></td>
								<td style="border: 1px solid #FFF">Poznań</td>
							</tr>
							<tr>
								<td style="border: 1px solid #FFF"><b>${tableProvince}</b></td>
								<td style="border: 1px solid #FFF">wielkopolskie</td>
							</tr>

							<tr>
								<td style="border: 1px solid #FFF"><b>${tableCountry}</b></td>
								<td style="border: 1px solid #FFF">Polska</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="headingTwo">
					<h4 class="panel-title">
						<a class="collapsed" role="button" data-toggle="collapse"
							data-parent="#accordion" href="#collapseTwo" aria-expanded="true"
							aria-controls="collapseTwo"> Dane do organizatora </a>
					</h4>
				</div>
				<div id="collapseTwo" class="panel-collapse collapse"
					role="tabpanel" aria-labelledby="headingTwo">
					<div class="panel-body">
						<table class="table table-bordered" style="width: 100%">

							<tr>

								<td style="border: 1px solid #FFF;"><b>${tableName}</b></td>
								<td style="border: 1px solid #FFF">Monike</td>
							</tr>
							<tr>
								<td style="border: 1px solid #FFF;"><b>${tableSurname}</b></td>
								<td style="border: 1px solid #FFF">Senderecka</td>
							</tr>
							<tr>
								<td style="border: 1px solid #FFF"><b>${tableEmail}</b></td>
								<td style="border: 1px solid #FFF">kolardia@gmail.com</td>
							</tr>
							<tr>
								<td style="border: 1px solid #FFF"><b>${tablePhone}</b></td>
								<td style="border: 1px solid #FFF">884-382-856</td>
							</tr>
							<tr>
								<td style="border: 1px solid #FFF"><b>${tableAccount}</b></td>
								<td style="border: 1px solid #FFF">aktywne</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="headingThree">
					<h4 class="panel-title">
						<a class="collapsed" role="button" data-toggle="collapse"
							data-parent="#accordion" href="#collapseThree"
							aria-expanded="false" aria-controls="collapseThree">
							Centrala: xxxxxxxxxxxxxxxxxxxxxxxx </a>
					</h4>
				</div>
				<div id="collapseThree" class="panel-collapse collapse"
					role="tabpanel" aria-labelledby="headingThree">
					<div class="panel-body">
						<table class="table table-bordered" style="width: 100%">
							<tr>
								<td style="border: 1px solid #FFF"><b>${tablePhone}</b></td>
								<td style="border: 1px solid #FFF">884-382-856</td>
							</tr>
							<tr>
							<tr>
								<td style="border: 1px solid #FFF"><b>${tableEmail}</b></td>
								<td style="border: 1px solid #FFF">sekretariat@gmail.com</td>
							</tr>
							<tr>
								<td style="border: 1px solid #FFF"><b>${tableAddress}</b></td>
								<td style="border: 1px solid #FFF">ul. Dombrowskiego</td>
							</tr>
							<tr>
								<td style="border: 1px solid #FFF"><b>${tableCity}</b></td>
								<td style="border: 1px solid #FFF">Poznań</td>
							</tr>
							<tr>
								<td style="border: 1px solid #FFF"><b>${tableProvince}</b></td>
								<td style="border: 1px solid #FFF">wielkopolskie</td>
							</tr>

							<tr>
								<td style="border: 1px solid #FFF"><b>${tableCountry}</b></td>
								<td style="border: 1px solid #FFF">Polska</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>
<!-- row panel -->