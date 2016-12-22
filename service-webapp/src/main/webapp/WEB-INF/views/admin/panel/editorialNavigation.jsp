<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
	<spring:message code="admin.panel.editor.nav.publications"
		var="publications" />
	<spring:message code="admin.panel.editor.nav.archives" var="archives" />
	<spring:message code="admin.panel.editor.nav.recruitment"
		var="recruitment" />
	<spring:message code="admin.panel.editor.nav.profile" var="profile" />
	<spring:message code="admin.panel.editor.nav.help" var="help" />
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


			</div>
			<!-- tab-content -->
		</div>
		<!-- panel-body -->
	</div>
	<!--content -->
</body>
</body>