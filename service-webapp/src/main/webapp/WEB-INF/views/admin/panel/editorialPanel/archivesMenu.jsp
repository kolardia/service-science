<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<script>
	$(document).ready(function() {
		$("#EADateBox").hide();
		$("#EAAllBox").hide();
		$("#EASeachBox").hide();
		$("#EANewBox").hide();
		$("#EADetailsBox").hide();

		$("#btnEADate").click(function() {
			var panel = $(EADateBox).html();
			$("#EAPage").html(panel);
		});

		$("#btnEAAll").click(function() {
			var panel = $(EAAllBox).html();
			$("#EAPage").html(panel);
		});

		$("#btnEASeach").click(function() {
			var panel = $(EASeachBox).html();
			$("#EAPage").html(panel);
		});

		$("#btnEANew").click(function() {
			var panel = $(EANewBox).html();
			$("#EAPage").html(panel);
		});

		$("#btnEADetails").click(function() {
			var panel = $(EADetailsBox).html();
			$("#EAPage").html(panel);
		});

	});
</script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

</head>
<body>
	<spring:message code="admin.editor.archives.menu.add" var="menuAdd" />
	<spring:message code="admin.editor.archives.menu.all" var="menuAll" />
	<spring:message code="admin.editor.archives.menu.search.archive"
		var="menuSearchArchive" />
	<spring:message code="admin.editor.archives.menu.search.from.the.date"
		var="menuSearchFromDate" />
	<spring:message code="admin.editor.archives.menu.search.up.to.the.date"
		var="menuSearchUpToDate" />
	<div class="row" style="margin-bottom: 5px; margin-top: 10px">
		<div class="col-md-5 ">
			<form id="btnEADate">
				<div class="input-group input-group-sm">
					<input type="text" class="form-control"
						placeholder="${menuSearchFromDate }"> <span
						class="input-group-btn">
						<button id="btnSearchResults" class="btn btn-default"
							type="button">
							<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
						</button>
					</span> <input type="text" class="form-control"
						placeholder="${menuSearchUpToDate }">
				</div>
			</form>
		</div>
		<div class="col-md-3 ">
			<div class="btn-group" role="group">
				<button id="btnEANew" type="button" class="btn btn-default"
					style="border-color: #FFF">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
					${menuAdd}
				</button>
			</div>
			<div class="btn-group" role="group">
				<button id="btnEAAll" type="button" class="btn btn-default"
					style="border-color: #FFF">
					<span class="glyphicon glyphicon-book" aria-hidden="true"></span>
					${menuAll}
				</button>
			</div>
		</div>
		<div class="col-md-4 pull-right">
			<div class="input-group input-group-sm">
				<span class="input-group-btn">
					<button id="btnEASeach" class="btn btn-default" type="button">
						<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					</button>
				</span> <input type="text" class="form-control"
					placeholder="${menuSearchArchive}">
			</div>
		</div>
	</div>
	<div class="panel panel-default"></div>
	<div id="EAPage"><jsp:include page="archivesPanel/list/allArchives.jsp" /></div>
	<div id="EAAllBox"><jsp:include page="archivesPanel/list/allArchives.jsp" /></div>
	<div id="EADateBox"><jsp:include page="archivesPanel/list/dateArchive.jsp" /></div>
	<div id="EASeachBox"><jsp:include page="archivesPanel/list/seachArchive.jsp" /></div>
	<div id="EANewBox"><jsp:include page="archivesPanel/new.jsp" /></div>
	<div id="EADetailsBox"><jsp:include page="archivesPanel/details.jsp" /></div>

</body>