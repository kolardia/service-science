<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
	
</script>
</head>
<body>
<spring:message code="admin.editor.archives.menu.add" var="menuAdd" />
<spring:message code="admin.editor.archives.menu.search.archive" var="menuSearchArchive" />
<spring:message code="admin.editor.archives.menu.search.from.the.date" var="menuSearchFromDate" />
<spring:message code="admin.editor.archives.menu.search.up.to.the.date" var="menuSearchUpToDate" />

	<div class="row" style="margin-bottom: 5px; margin-top: 10px">



		<div class="col-md-5 ">

			<div class="input-group input-group-sm">
				<input type="text" class="form-control"
					placeholder="${menuSearchFromDate }"> <span
					class="input-group-btn">
					<button id="btnSearchResults" class="btn btn-default" type="button">
						<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
					</button>
				</span> <input type="text" class="form-control"
					placeholder="${menuSearchUpToDate }">
			</div>

		</div>
		
		<div class="col-md-2 ">

		
				<div class="btn-group" role="group">
					<button id="btnNew" type="button" class="btn btn-default"
						style="border-color: #FFF">
						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
						${menuAdd}
					</button>
				</div>

		</div>
		
		<div class="col-md-5 pull-right">
			<div class="input-group input-group-sm">
				<span class="input-group-btn">
					<button id="btnSearchResults" class="btn btn-default" type="button">
						<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					</button>
				</span> <input type="text" class="form-control"
					placeholder="${menuSearchArchive}">
			</div>
		</div>

	</div>


	<div class="panel panel-default"></div>



	<div id="page">Panel redakcyjny wszystkie wyniki</div>
</body>