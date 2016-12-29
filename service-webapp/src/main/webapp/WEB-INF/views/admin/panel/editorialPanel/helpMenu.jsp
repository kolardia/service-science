<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:message code="admin.editor.help.title" var="title" />
<spring:message code="admin.editor.help.introduction" var="introduction" />
<spring:message code="admin.editor.help.subtitle" var="subtitle" />
<spring:message code="admin.editor.help.archives" var="archives" />
<spring:message code="admin.editor.help.publications" var="publications" />
<spring:message code="admin.editor.help.profile" var="profile" />
<spring:message code="admin.editor.help.description.archives"
	var="descriptionArchives" />
<spring:message code="admin.editor.help.description.publications"
	var="descriptionPublications" />
<spring:message code="admin.editor.help.description.profile"
	var="descriptionProfile" />
<div role="tabpanel" class="tab-pane HelpPage">
	<div class="row EHInitialField">
		<div class="col-md-6">

			<h4 class="HTitle">
				<span id="EHBtnBack" class="glyphicon glyphicon-arrow-left HBtnBack"
					aria-hidden="true"></span> <b> ${title}</b>
			</h4>
		</div>
		${message}
		<div class="col-md-3 pull-right text-center HInstructionBox">
			<a> <span class="glyphicon glyphicon-floppy-save"
				aria-hidden="true"> Instrukcja.pdf</span>
			</a>
		</div>
	</div>
	<div id="EHPage">
		<div id="EHMenu">
			<script>
				$(document).ready(function() {
					$("#EHArchivesBox").hide();
					$("#EHProfileBox").hide();
					$("#EHPpublicationsBox").hide();
					$("#EHBtnBack").hide();

					$("#btnArchives").click(function() {
						var panel = $(EHArchivesBox).html();
						$("#EHPage").html(panel);
						$("#EHBtnBack").show();
					});

					$("#btnProfile").click(function() {
						var panel = $(EHProfileBox).html();
						$("#EHPage").html(panel);
						$("#EHBtnBack").show();
					});
					$("#btnPublications").click(function() {
						var panel = $(EHPpublicationsBox).html();
						$("#EHPage").html(panel);
						$("#EHBtnBack").show();
					});

					$("#EHBtnBack").click(function() {
						var panel = $(EHMenu).html();
						$("#EHPage").html(panel);
					});

				});
			</script>
			<p>${introduction}</p>
			<p>
				<b>${subtitle} </b>
			</p>
			<div class="list-group">
				<button id="btnPublications" type="button" class="list-group-item">
					<p>
						<b> ${publications} </b> ${descriptionPublications}
					</p>
				</button>
				<button id="btnArchives" type="button" class="list-group-item">
					<p>
						<b> ${archives} </b> ${descriptionArchives}
					</p>
				</button>
				<button id="btnProfile" type="button" class="list-group-item">
					<p>
						<b> ${profile} </b> ${descriptionProfile}
					</p>
				</button>
			</div>
		</div>
		<div id="EHPpublicationsBox">
			<jsp:include page="helpPanel/publications.jsp" /></div>
		<div id="EHArchivesBox"><jsp:include
				page="helpPanel/archives.jsp" /></div>

		<div id="EHProfileBox">
			<jsp:include page="helpPanel/profile.jsp" /></div>
	</div>
</div>
