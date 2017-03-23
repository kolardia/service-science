<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	<c:forEach varStatus="status" var="element" items="${collection}">
		<tr class="accent">
			<td>1</td>
			<td>${element.date}</td>
			<td>${element.title}</td>
			<td>
				<button class="btn buttonLink btn-info "
					onclick="location.href='${userUrl}'">${archiveInfo}</button>
				<button class="btn buttonLink btn-success "
					onclick="location.href='${userUrl}'">${archiveDelete}</button>
			</td>
		</tr>
	</c:forEach>
</table>