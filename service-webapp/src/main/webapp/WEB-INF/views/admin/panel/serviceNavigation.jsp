<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:message code="admin.panel.service.nav.section" var="section" />
<spring:message code="admin.panel.service.nav.news" var="news" />
<spring:message code="admin.panel.service.nav.resources" var="resources" />
<spring:message code="admin.panel.service.nav.baseAdrress"
	var="baseAdrress" />
<spring:message code="admin.panel.service.nav.cooperation"
	var="cooperation" />
<spring:message code="admin.panel.service.nav.help" var="help" />
<div class="panel-body">
	<!-- 	<div class="panel panel-default"></div>  -->
	<ul class="nav nav-tabs" role="tablist">

		<!--admin.panel.service.nav.section -->
		<li role="presentation" class="active"><a href="#section"
			aria-controls="section" role="tab" data-toggle="tab"
			style="color: #C0C0C0"><b>${section}</b></a></li>

		<!--admin.panel.service.nav.news -->
		<li role="presentation"><a href="#news" aria-controls="news"
			role="tab" data-toggle="tab" style="color: #C0C0C0"><b>${news}</b></a></li>

		<!--admin.panel.service.nav.cooperation -->
		<li role="presentation"><a href="#cooperation"
			aria-controls="cooperation" role="tab" data-toggle="tab"
			style="color: #C0C0C0"><b>${cooperation}</b></a></li>

		<!--admin.panel.service.nav.base_adrress -->
		<li role="presentation"><a href="#baseAdrress"
			aria-controls="baseAdrress" role="tab" data-toggle="tab"
			style="color: #C0C0C0"><b>${baseAdrress}</b></a></li>

		<!--admin.panel.service.nav.help -->
		<li role="presentation"><a href="#help" aria-controls="help"
			role="tab" data-toggle="tab" style="color: #C0C0C0"><b>${help}</b></a></li>

	</ul>


	<div class="tab-content">
		<!--admin.panel.service.section -->
		<div role="tabpanel" class="tab-pane active" id="section">
			<jsp:include page="servicePanel/sectionMenu.jsp" />
		</div>

		<!--admin.panel.service.base_adrress -->
		<div role="tabpanel" class="tab-pane" id="baseAdrress">
			<jsp:include page="servicePanel/baseAddressMenu.jsp" />
		</div>

		<!--admin.panel.service.news -->
		<div role="tabpanel" class="tab-pane" id="news">
			<jsp:include page="servicePanel/newsMenu.jsp" /></div>

		<!--admin.panel.service.cooperation -->
		<div role="tabpanel" class="tab-pane" id="cooperation">
			<jsp:include page="servicePanel/cooperationMenu.jsp" /></div>

		<!--admin.panel.service.help -->
		<div role="tabpanel" class="tab-pane" id="help">
			<jsp:include page="servicePanel/helpMenu.jsp" /></div>

	</div>
	<!-- tab-content -->
</div>
<!-- panel-body -->