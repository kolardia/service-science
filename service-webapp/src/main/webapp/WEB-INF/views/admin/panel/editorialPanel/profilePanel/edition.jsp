<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
<div id="profilePanel">
	<div class="row" style="margin-bottom: 5px; margin-top: 10px">
		<div class=col-md-7>
			<div class="row">
				<div class=col-md-12>

					<div class="btn-group btn-group-justified" role="group"
						aria-label="...">
						<div class="btn-group" role="group">
							<button id="btnRole" type="button" class="btn btn-default"
								style="border-color: #FFF">
								<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
								<b>${menuRole}:</b> editor
							</button>
						</div>
						<div class="btn-group" role="group">
							<button id="btnProfileEdition" type="button"
								class="btn btn-default" style="border-color: #FFF">
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

				<div class="col-md-12">
					<div class="row">
						<div class="col-md-8">
							<h4>${editor.introduction}</h4>

							<p>${quickIntroduction}</p>
							<textarea class="form-control" rows="3"></textarea>
						</div>
						<div class="col-md-4">
							<img src="${editor.img}" alt="..." class="img-thumbnail">
						</div>
						<div class="col-md-12">
							<p>${editor.description}</p>
							<textarea class="form-control" rows="3"></textarea>
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
					<td><div id="form">
							<form>
								<table class="table table-bordered" style="width: 100%">
									<tr>
										<td style="border: 1px solid #FFF;"><b>${tableName}</b></td>
										<td style="border: 1px solid #FFF"><input type="text"
											class="form-control input-sm" id="" name="name"
											placeholder="${editor.name}" value="${editor.name}">
											<form:errors path="name" cssclass="error" /></td>
									</tr>
									<tr>
										<td style="border: 1px solid #FFF;"><b>${tableSurname}</b></td>
										<td style="border: 1px solid #FFF"><input type="text"
											class="form-control input-sm" id="" name="surname"
											placeholder="${editor.surname}" value="${editor.surname}">
											<form:errors path="surname" cssclass="error" /></td>
									</tr>
									<tr>
										<td style="border: 1px solid #FFF"><b>${tableEmail}</b></td>
										<td style="border: 1px solid #FFF"><input type="text"
											class="form-control input-sm" id="" name="email"
											placeholder="${editor.email}" value="${editor.email}">
											<form:errors path="email" cssclass="error" /></td>
									</tr>
									<tr>
										<td style="border: 1px solid #FFF"><b>${tablePhone}</b></td>
										<td style="border: 1px solid #FFF"><input type="text"
											class="form-control input-sm" id="" name="phone"
											placeholder="${editor.phone}" value="${editor.phone}">
											<form:errors path="phone" cssclass="error" /></td>
									</tr>
									<tr>
										<td style="border: 1px solid #FFF"><b>${tableAddress}</b></td>
										<td style="border: 1px solid #FFF"><input type="text"
											class="form-control input-sm" id="" name="address"
											placeholder="${editor.address}" value="${editor.address}">
											<form:errors path="address" cssclass="error" /></td>
									</tr>
									<tr>
										<td style="border: 1px solid #FFF"><b>${tableCity}</b></td>
										<td style="border: 1px solid #FFF"><input type="text"
											class="form-control input-sm" id="" name="city"
											placeholder="${editor.city}" value="${editor.city}">
											<form:errors path="city" cssclass="error" /></td>
									</tr>
									<tr>
										<td style="border: 1px solid #FFF"><b>${tableProvince}</b></td>
										<td style="border: 1px solid #FFF"><input
											type="${editor.province}" class="form-control input-sm" id=""
											placeholder="" value="${editor.province}" name="province">
											<form:errors path="province" cssclass="error" /></td>
									</tr>
									<tr>
										<td colspan="2" style="border: 1px solid #FFF">+ Wprowadz
											lokalizacje karju</td>
									</tr>

								</table>
								<input type="submit" id="theForm" value="Submit form" />
							</form>
						</div></td>
				<tr>
			</table>
		</div>
	</div>
	<!-- row panel -->
</div>
<!-- profile panel -->
<script>

$("#theForm").ajaxSubmit({url: 'server.php', type: 'post'})

	/*function sendRequest() {
		$.ajax({
			url : 'edition',
			type : 'get',
			contentType : "application/html",
			success : function(resp) {
				$("#form").html(resp);
			},
			error : function() {
				console.log("Error!");
			}
		});
	}*/
	/*
	
	$( "form" ).on( "submit" , function ( event ) {
		 event.preventDefault();
		 console.log( $( this ).serialize() );
		});*/
	

</script>