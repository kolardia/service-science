<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:message code="admin.editor.profile.menu.role" var="menuRole" />
<spring:message code="admin.editor.profile.menu.edit" var="menuEdit" />
<spring:message code="admin.editor.profile.menu.deactivation"
	var="menuDeactivation" />
<spring:message code="admin.editor.profile.menu.language"
	var="menuLanguage" />
<spring:message
	code="admin.editor.profile.menu.language.dropdown.show.pl"
	var="LanguageShowPL" />
<spring:message
	code="admin.editor.profile.menu.language.dropdown.show.en"
	var="LanguageShowEN" />

<spring:message code="admin.editor.profile.table.name" var="tableName" />
<spring:message code="admin.editor.profile.table.surname"
	var="tableSurname" />
<spring:message code="admin.editor.profile.table.mail" var="tableEmail" />
<spring:message code="admin.editor.profile.table.phone" var="tablePhone" />
<spring:message code="admin.editor.profile.table.address"
	var="tableAddress" />
<spring:message code="admin.editor.profile.table.city" var="tableCity" />
<spring:message code="admin.editor.profile.table.province"
	var="tableProvince" />
<spring:message code="admin.editor.profile.table.country"
	var="tableCountry" />
<spring:message code="admin.editor.profile.table.account"
	var="tableAccount" />	

	
		<form:form  action="#" onsubmit="return sendRequest();" modelAttribute="profil">
								<table class="table table-bordered" style="width: 100%">>
		<table class="table table-bordered" style="width: 100%">
			<tr>
				<td style="border: 1px solid #FFF;"><b>${tableName}</b></td>
				<td style="border: 1px solid #FFF"><input type="text"
					class="form-control input-sm" id="" name="name"
					placeholder="${editor.name}" value="${editor.name}"> <form:errors
						path="name" cssclass="error" /></td>
			</tr>
			<tr>
				<td style="border: 1px solid #FFF;"><b>${tableSurname}</b></td>
				<td style="border: 1px solid #FFF"><input type="text"
					class="form-control input-sm" id="" name="surname"
					placeholder="${editor.surname}" value="${editor.surname}">
					<form:errors path="surname" cssclass="error" /></td>
			</tr>
			<tr>
				<td style="border: 1px solid #FFF"><b>${tableEmail}</b></td>
				<td style="border: 1px solid #FFF"><input type="text"
					class="form-control input-sm" id="" name="email"
					placeholder="${editor.email}" value="${editor.email}"> <form:errors
						path="email" cssclass="error" /></td>
			</tr>
			<tr>
				<td style="border: 1px solid #FFF"><b>${tablePhone}</b></td>
				<td style="border: 1px solid #FFF"><input type="text"
					class="form-control input-sm" id="" name="phone"
					placeholder="${editor.phone}" value="${editor.phone}"> <form:errors
						path="phone" cssclass="error" /></td>
			</tr>
			<tr>
				<td style="border: 1px solid #FFF"><b>${tableAddress}</b></td>
				<td style="border: 1px solid #FFF"><input type="text"
					class="form-control input-sm" id="" name="address"
					placeholder="${editor.address}" value="${editor.address}">
					<form:errors path="address" cssclass="error" /></td>
			</tr>
			<tr>
				<td style="border: 1px solid #FFF"><b>${tableCity}</b></td>
				<td style="border: 1px solid #FFF"><input type="text"
					class="form-control input-sm" id="" name="city"
					placeholder="${editor.city}" value="${editor.city}"> <form:errors
						path="city" cssclass="error" /></td>
			</tr>
			<tr>
				<td style="border: 1px solid #FFF"><b>${tableProvince}</b></td>
				<td style="border: 1px solid #FFF"><input
					type="${editor.province}" class="form-control input-sm" id=""
					placeholder="" value="${editor.province}" name="province">
					<form:errors path="province" cssclass="error" /></td>
			</tr>
			<tr>
				<td colspan="2" style="border: 1px solid #FFF">+ Wprowadz
					lokalizacje karju</td>
			</tr>

		</table>
		<input type="submit" value="Submit form" />
	</form:form>
