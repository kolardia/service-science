<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:message code="admin.editor.profile.menu.role" var="menuRole" />
<spring:message code="admin.editor.profile.menu.edit" var="menuEdit" />
<spring:message code="admin.editor.profile.menu.deactivation"
	var="menuDeactivation" />
<spring:message code="admin.editor.profile.menu.language"
	var="menuLanguage" />
<spring:message
	code="admin.editor.profile.menu.language.dropdown.show.pl"
	var="LanguageShowPL" />
<spring:message
	code="admin.editor.profile.menu.language.dropdown.show.en"
	var="LanguageShowEN" />

<spring:message code="admin.editor.profile.table.name" var="tableName" />
<spring:message code="admin.editor.profile.table.surname"
	var="tableSurname" />
<spring:message code="admin.editor.profile.table.mail" var="tableEmail" />
<spring:message code="admin.editor.profile.table.phone" var="tablePhone" />
<spring:message code="admin.editor.profile.table.address"
	var="tableAddress" />
<spring:message code="admin.editor.profile.table.city" var="tableCity" />
<spring:message code="admin.editor.profile.table.province"
	var="tableProvince" />
<spring:message code="admin.editor.profile.table.country"
	var="tableCountry" />
<spring:message code="admin.editor.profile.table.account"
	var="tableAccount" />
<div id="MenuProfilePanel">
	<div class="row" style="margin-bottom: 5px; margin-top: 10px">
		<div class=col-md-7>
			<div class="row">
				<div class=col-md-12>

					<div class="btn-group btn-group-justified" role="group"
						aria-label="...">
						<div style="color: #4E84AB; text-align: center;" class="btn-group"
							role="group">
							<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
							<b>${menuRole}:</b> Redaktor
						</div>
						<div class="btn-group" role="group">
							<button type="button" class="btn btn-default"
								style="border-color: #FFF" data-toggle="modal"
								data-target="#exampleModal" data-whatever="@getbootstrap">
								<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
								${menuEdit}
							</button>
						</div>
						<div class="btn-group" role="group">
							<div class="dropdown">
								<button class="btn btn-default dropdown-toggle"
									style="border-color: #FFF" type="button" id="dropdownMenu1"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="true">
									<span class="glyphicon glyphicon-flag" aria-hidden="true"></span>
									${menuLanguage}
								</button>
								<ul class="dropdown-menu" aria-labelledby="dropdownUser">
									<li><a id="btnProfilePL" href="#"><b>PL</b>
											${LanguageShowPL}</a></li>
									<li><a id="btnProfileEN" href="#"><b>EN</b>
											${LanguageShowEN}</a></li>
								</ul>
							</div>
						</div>
						<div id="btnProfileDeactivation" class="btn-group" role="group">
							<button type="button" class="btn btn-default"
								style="border-color: #FFF">
								<span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span>
								${menuDeactivation}
							</button>
						</div>
					</div>
					<div class="panel panel-default"></div>

				</div>
				<!-- col-md-12 -->
				<div class=col-md-12>
					<div class="row">
						<div class=col-md-8>
							<h4>${editor.title}</h4>
							<p>${editor.quickIntroduction}</p>
						</div>
						<div class=col-md-4>
							<img src="${img}" alt="..." class="img-thumbnail">
						</div>
						<div class="col-sm-12">
							<p>${editor.description}</p>
						</div>
					</div>
					<!-- row -->
				</div>
				<!-- col-md-12 -->
			</div>
			<!-- row -->
		</div>
		<!-- col-md-6 -->
		<div id="danePanel" class="col-md-5">
			<h1>${info}</h1>
			<table class="table table-bordered">
				<tr>
					<td>
						<table class="table table-bordered" style="width: 100%">
							<tr>
								<td style="border: 1px solid #FFF;"><b>${tableName}</b></td>
								<td style="border: 1px solid #FFF">${editor.name}</td>
							</tr>
							<tr>
								<td style="border: 1px solid #FFF;"><b>${tableSurname}</b></td>
								<td style="border: 1px solid #FFF">${editor.surname}</td>
							</tr>
							<tr>
								<td style="border: 1px solid #FFF"><b>${tableEmail}</b></td>
								<td style="border: 1px solid #FFF">${editor.email}</td>
							</tr>
							<tr>
								<td style="border: 1px solid #FFF"><b>${tablePhone}</b></td>
								<td style="border: 1px solid #FFF">${editor.phone}</td>
							</tr>
							<tr>
								<td style="border: 1px solid #FFF"><b>${tableAddress}</b></td>
								<td style="border: 1px solid #FFF">${editor.address}</td>
							</tr>
							<tr>
								<td style="border: 1px solid #FFF"><b>${tableCity}</b></td>
								<td style="border: 1px solid #FFF">${editor.city}</td>
							</tr>
							<tr>
								<td style="border: 1px solid #FFF"><b>${tableProvince}</b></td>
								<td style="border: 1px solid #FFF">${editor.province}</td>
							</tr>

							<tr>
								<td style="border: 1px solid #FFF"><b>${tableCountry}</b></td>
								<td style="border: 1px solid #FFF">${editor.country}</td>
							</tr>


							<tr>
								<td style="border: 1px solid #FFF"><b>${tableAccount}</b></td>
								<td style="border: 1px solid #FFF">${editor.account}</td>
							</tr>

						</table>
					</td>
				<tr>
			</table>
		</div>

	</div>
	<!-- row panel -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content" id="modal-content">
				<p id="info">xxxx</p>
				<div id="form">
					<form:form>
						<table class="table table-bordered" style="width: 100%">
							<tr>
								<td style="border: 1px solid #FFF;"><b>${tableName}</b></td>
								<td style="border: 1px solid #FFF"><input type="text"
									class="form-control input-sm" id="" name="name"
									placeholder="${editor.name}" value="${editor.name}"></td>
							</tr>
						</table>
					</form:form>
					<input type="submit" id="theForm" value="Submit form" />
				</div>
			</div>
		</div>
	</div>
	<!-- profile panel -->
	</div>
	<script>
		$(document).ready(function() {
			//$("#theForm").ajaxSubmit({url: 'server.php', type: 'post'})

			$("#theForm").click(function() {
				$.ajax({
					url : "editor/profile/upade",
					success : function(result) {
						$("#info").html(result);
					}
				});
			});

			/*	$.ajax({
					url : "editor/profile",
					success : function(result) {
						$("#danePanel").html(result);
					}
				});*/

			$("#btnProfilePL").click(function() {
				$.ajax({
					url : "editor/profile/pl",
					success : function(result) {
						$("#MenuProfilePanel").html(result);
					}
				});
			});
			$("#btnProfileEN").click(function() {
				$.ajax({
					url : "editor/profile/en",
					success : function(result) {
						$("#MenuProfilePanel").html(result);
					}
				});
			});
			$("#btnProfileEdition").click(function() {
				$.ajax({
					url : "editor/profile/edition",
					success : function(result) {
						$("#MenuProfilePanel").html(result);
					}
				});
			});
			$("#btnProfileDeactivation").click(function() {
				$.ajax({
					url : "editor/profile/deactivation",
					success : function(result) {
						$("#MenuProfilePanel").html(result);
					}
				});
			});
		});
	</script>