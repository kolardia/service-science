<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<style>
a.list-group-item, button.list-group-item {
	color: #62A9DD;
}
</style>

</head>
<spring:message code="admin.service.help.title" var="title" />
<spring:message code="admin.service.help.introduction"
	var="introduction" />
<spring:message code="admin.service.help.subtitle" var="subtitle" />

<spring:message code="admin.service.help.section" var="section" />
<spring:message code="admin.service.help.description.section"
	var="descriptionSection" />
	
<spring:message code="admin.service.help.publications"
	var="publications" />
<spring:message code="admin.service.help.profile" var="profile" />
<spring:message code="admin.service.help.description.archives"
	var="descriptionArchives" />

<spring:message code="admin.service.help.description.profile"
	var="descriptionProfile" />
<body>
	<div role="tabpanel" class="tab-pane" id="help" style="padding: 15px">
		<div class="row" style="margin-bottom: 5px; margin-top: 10px">
			<div class="col-md-6">
				<h4 style="color: black">
					<b>${title}</b>
				</h4>
			</div>
			<div class="col-md-3 pull-right text-center"
				style="text-align: right; color: #C0C0CA; margin-top: -2px">
				<p class="text-ogloszenie">
					<span class="glyphicon glyphicon-floppy-save" aria-hidden="true"></span><span
						style="color: rgba(76, 158, 217, 0.83);"> Instrukcja.pdf</span>
				</p>
			</div>
		</div>

		<p>${introduction}</p>
		<p>
			<b>${subtitle} </b>
		</p>
		<div class="list-group">
			<button type="button" class="list-group-item">

				<p>

					<b> ${section} </b> ${descriptionPublications}
				</p>
			</button>
			<button type="button" class="list-group-item">
				<p>

					<b> ${archives} </b> ${descriptionArchives}
				</p>
			</button>
			<button type="button" class="list-group-item">
				<p>
					<b> ${profile} </b> ${descriptionProfile}
				</p>
			</button>
		</div>

	</div>
</body>