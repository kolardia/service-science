<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:message code="admin.editor.archives.menu.add" var="menuAdd" />
<spring:message code="admin.editor.archives.menu.all" var="menuAll" />
<spring:message code="admin.editor.archives.menu.search.archive"
	var="menuSearchArchive" />
<spring:message code="admin.editor.archives.menu.search.from.the.date"
	var="menuSearchFromDate" />
<spring:message code="admin.editor.archives.menu.search.up.to.the.date"
	var="menuSearchUpToDate" />
<div class="row" style="margin-bottom: 5px; margin-top: 10px; padding-left:8px">
	<div class="col-md-3 col-sm-4 ">
		<div class="btn-group" role="group">
			<button id="btnEAAll" type="button" class="btn btn-default"
				style="border-color: #FFF">
				<span class="glyphicon glyphicon-book" aria-hidden="true"></span>
				${menuAll}
			</button>
		</div>
		<div class="btn-group" role="group">
			<button id="btnEANew" type="button" class="btn btn-default"
				style="border-color: #FFF">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
				${menuAdd}
			</button>
		</div>
	</div>
	<div id="calendar" class="col-md-5 ">
		<form id="btnEADate">
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
		</form>
	</div>

	<div class="col-md-4 col-sm-8 pull-right">
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
<div id="archivesPanel"></div>
<script>
	$(document).ready(function() {
		$.ajax({
			url : "editor/archives",
			success : function(result) {
				$("#archivesPanel").html(result);
			}
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
		$("#btnEAAll").click(function() {
			$.ajax({
				url : "editor/archives",
				success : function(result) {
					$("#archivesPanel").html(result);
				}
			});
		});
	});
</script>