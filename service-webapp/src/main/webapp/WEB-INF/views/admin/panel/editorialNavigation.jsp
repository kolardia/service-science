<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:message code="admin.panel.editor.nav.publications"
	var="publications" />
<spring:message code="admin.panel.editor.nav.archives" var="archives" />
<spring:message code="admin.panel.editor.nav.recruitment"
	var="recruitment" />
<spring:message code="admin.panel.editor.nav.profile" var="profile" />
<spring:message code="admin.panel.editor.nav.help" var="help" />

<spring:url value="/panel/editor/archives" var="btnEArchive" />
<spring:url value="/panel/editor/publications" var="btnEPublications" />
<spring:url value="/panel/editor/profile" var="btnEProfile" />

<div id="content">
	<div class="panel-body">
		<!-- 	<div class="panel panel-default"></div>  -->
		<ul class="nav nav-tabs" role="tablist">

			<!--admin.panel.editor.nav.publications-->
			<li role="presentation" class="active"><a href="#publications"
				aria-controls="publications" role="tab" data-toggle="tab"
				style="color: #C0C0C0"><b>${publications}</b></a></li>

			<!--admin.panel.editor.nav.active-->
			<li role="presentation"><a href="#archives"
				aria-controls="archives" role="tab" data-toggle="tab"
				style="color: #C0C0C0"><b>${archives}</b></a></li>

			<!--admin.panel.editor.nav.profile-->
			<li role="presentation"><a href="#profile"
				aria-controls="profile" role="tab" data-toggle="tab"
				style="color: #C0C0C0"><b>${profile}</b></a></li>

			<!--admin.panel.editor.nav.help-->
			<li role="presentation"><a href="#help" aria-controls="help"
				role="tab" data-toggle="tab" style="color: #C0C0C0"><b>${help}</b></a></li>
		</ul>

		<div class="tab-content">
			<!--admin.panel.editor.publications-->
			<div role="tabpanel" class="tab-pane active" id="publications">
				<jsp:include page="editorialPanel/publicationsMenu.jsp" />
			</div>

			<!--admin.panel.editor.archives-->
			<div role="tabpanel" class="tab-pane" id="archives">

				<jsp:include page="editorialPanel/archivesMenu.jsp" />
			</div>

			<!--admin.panel.editor.profile-->
			<div role="tabpanel" class="tab-pane" id="profile">
				<jsp:include page="editorialPanel/profileMenu.jsp" />
			</div>

			<!--admin.panel.editor.help-->
			<div role="tabpanel" class="tab-pane" id="help">
				<jsp:include page="editorialPanel/helpMenu.jsp" /></div>

			<h1>${info}</h1>
		</div>
		<!-- tab-content -->
	</div>
	<!-- panel-body -->
</div>
<!--content -->
<script>
	$(document).ready(function() {
		
		/*****************************************/
		$.ajax({
			url : "editor/archives/",
			success : function(result) {
				$("#archivesPanel").html(result);
			}
		});
		$.ajax({
			url : "editor/profile",
			success : function(result) {
				$("#profilePanel").html(result);
			}
		});

		$.ajax({
			url : "editor/published",
			success : function(result) {
				$("#publicationsPage").html(result);
			}
		});
		/*****************************************/
		$("#btnEANew").click(function() {
			$.ajax({
				url : "editor/archives/add",
				success : function(result) {
					$("#archivesPanel").html(result);
				}
			});
		});
		$("#btnEADate").click(function() {
			$.ajax({
				url : "editor/archives/search-date",
				success : function(result) {
					$("#archivesPanel").html(result);
				}
			});
		});
		$("#btnEASeach").click(function() {
			$.ajax({
				url : "editor/archives/search-title",
				success : function(result) {
					$("#archivesPanel").html(result);
				}
			});
		});
		$("#btnEAAllEn").click(function() {
			$.ajax({
				url : "editor/archives/en",
				success : function(result) {
					$("#archivesPanel").html(result);
				}
			});
		});
		$("#btnEAAllPl").click(function() {
			$.ajax({
				url : "editor/archives/pl",
				success : function(result) {
					$("#archivesPanel").html(result);
				}
			});
		});
		/*****************************************/
		$("#btnEPPublished").click(function() {
			$.ajax({
				url : "editor/published",
				success : function(result) {
					$("#publicationsPage").html(result);
				}
			});
		});
		$("#btnEPAdd").click(function() {
			$.ajax({
				url : "editor/archives/add",
				success : function(result) {
					$("#publicationsPage").html(result);
				}
			});
		});
		$("#btnEPSketches").click(function() {
			$.ajax({
				url : "editor/published/sketches",
				success : function(result) {
					$("#publicationsPage").html(result);
				}
			});
		});
		$("#btnEPType").click(function() {
			$.ajax({
				url : "editor/published/type",
				success : function(result) {
					$("#publicationsPage").html(result);
				}
			});
		});
		$("#btnEPSearchResults").click(function() {
			$.ajax({
				url : "editor/published/search",
				success : function(result) {
					$("#publicationsPage").html(result);
				}
			});
		});
		$("#btnEPAllPl").click(function() {
			$.ajax({
				url : "editor/published/pl",
				success : function(result) {
					$("#publicationsPage").html(result);
				}
			});
		});
		$("#btnEPAllEn").click(function() {
			$.ajax({
				url : "editor/published/en",
				success : function(result) {
					$("#publicationsPage").html(result);
				}
			});
		});
	});
</script>
