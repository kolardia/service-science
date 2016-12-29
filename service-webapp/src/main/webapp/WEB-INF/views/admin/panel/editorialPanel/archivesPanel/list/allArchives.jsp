<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:message code="admin.editor.archives.table.date"
	var="archiveDate" />
<spring:message code="admin.editor.archives.table.title"
	var="archiveTitle" />
<spring:message code="admin.editor.archives.table.language"
	var="archiveLanguage" />
<spring:message code="admin.editor.archives.table.action"
	var="archiveAction" />
<spring:message code="admin.editor.archives.table.button.info"
	var="archiveInfo" />
<spring:message code="admin.editor.archives.table.button.delete"
	var="archiveDelete" />
<spring:message code="admin.editor.archives.info.select.all"
	var="infoAll" />
<spring:message code="admin.editor.archives.info.publication"
	var="infoElement" />

<p class="info">
	${infoAll}: <span class="info"> ${infoElement}</span>
</p>
<table class="table list">
	<thead>
		<tr>
			<th>ID</th>
			<th>${archiveDate}</th>
			<th>${archiveTitle}</th>
			<th>${archiveAction}</th>
		</tr>
	</thead>
	<tr class="accent">
		<td>1</td>
		<td>12.12.2015</td>
		<td>Tytul publikacji -zazwyczaj długi</td>
		<td>
			<button class="btn buttonLink btn-info "
				onclick="location.href='${userUrl}'">${archiveInfo}</button>
			<button class="btn buttonLink btn-success "
				onclick="location.href='${userUrl}'">${archiveDelete}</button>
		</td>
	</tr>
</table>