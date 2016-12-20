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
	<div role="tabpanel" class="tab-pane" id="baseAdrress">
		<div class="row" style="margin-bottom: 5px; margin-top: 10px">

			<div class="col-md-7">
				<div class="btn-group btn-group-justified" role="group"
					aria-label="...">
					<div aria-controls="section" class="btn-group" role="tab">
						<a href="#x" type="button" class="btn btn-default"
							data-toggle="tab" style="border-color: #FFF"><span
							class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
							Organizator </a>

					</div>
					<div aria-controls="section" class="btn-group" role="tab">
						<a href="#y" type="button" class="btn btn-default"
							data-toggle="tab" style="border-color: #FFF"><span
							class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
							Administracja </a>

					</div>

					<div aria-controls="section" class="btn-group" role="tab">
						<a href="#z" type="button" class="btn btn-default"
							data-toggle="tab" style="border-color: #FFF"><span
							class="glyphicon  glyphicon-envelope" aria-hidden="true"></span>
							Redaktorzy </a>

					</div>

					<div aria-controls="section" class="btn-group" role="tab">
						<a href="#section" type="button" class="btn btn-default"
							data-toggle="tab" style="border-color: #FFF"><span
							class="glyphicon  glyphicon-plus" aria-hidden="true"></span>
							Dodaj kontakt </a>

					</div>
				</div>
			</div>
			<div class="col-md-5 pull-right">
				<div class="input-group input-group-sm">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">
							<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
						</button>
					</span> <input type="text" class="form-control"
						placeholder="xxxxxxxxxxxxxxxxxxxxxxxx">
				</div>
			</div>
		</div>





		<div role="tabpanel" class="tab-pane" id="baseAdrress">
			<div class="row" style="margin-bottom: 5px; margin-top: 10px">
				<!-- Wykaz tabel -->
				<div class="panel panel-default"></div>
				<div class="row" style="margin-bottom: 5px; margin-top: 10px">
					<div class="col-md-6">
						<p
							style="font-size: 14px; margin-left: 15px; font-weight: 400; line-height: 1.42857; margin-top: -2px">
							Wykaz adresÃÂÃÂ³w: <span style="color: #C0C0CA;">redaktorzy</span>
						</p>
					</div>
					<div class="col-md-3 pull-right">
						<nav style="margin-bottom: -17px; margin-top: -30px">
							<ul class="pagination pagination-sm">
								<li><a href="#" aria-label="Previous"
									style="color: #757575"> <span aria-hidden="true">&laquo;</span>
								</a></li>
								<li><a href="#" style="color: #757575">1</a></li>
								<li><a href="#" style="color: #757575">2</a></li>
								<li><a href="#" style="color: #757575">3</a></li>
								<li><a href="#" style="color: #757575">4</a></li>
								<li><a href="#" style="color: #757575">5</a></li>
								<li><a href="#" aria-label="Next" style="color: #757575">
										<span aria-hidden="true">&raquo;</span>
								</a></li>
							</ul>
						</nav>
					</div>
				</div>
				<table class="table table-striped">
					<thead style="color: #C0C0C0;">
						<tr>
							<th><span style="margin-left: 10px">ID</span></th>
							<th>Name</th>
							<th>Email</th>
							<th>framework</th>
							<th>Action</th>
						</tr>
					</thead>
					<tr>
						<td>Warsztat</td>
						<td>Tytul</td>
						<td>${user.email}</td>
						<td><c:forEach var="framework" items="${user.framework}"
								varStatus="loop">
													${framework}
													<c:if test="${not loop.last}">,</c:if>
							</c:forEach></td>
						<td><spring:url value="/users/${user.id}" var="userUrl" /> <spring:url
								value="/users/${user.id}/delete" var="deleteUrl" /> <spring:url
								value="/users/${user.id}/update" var="updateUrl" />

							<button class="btn btn-info"
								style="color: rgb(89, 89, 89); background-color: rgba(91, 192, 222, 0); border-color: rgb(164, 164, 164);"
								onclick="location.href='${userUrl}'">Query</button></td>
					</tr>
					<tr>
						<td>Szkolenie</td>
						<td>Tytul</td>
						<td>${user.email}</td>
						<td><c:forEach var="framework" items="${user.framework}"
								varStatus="loop">
													${framework}
													<c:if test="${not loop.last}">,</c:if>
							</c:forEach></td>
						<td><spring:url value="/users/${user.id}" var="userUrl" /> <spring:url
								value="/users/${user.id}/delete" var="deleteUrl" /> <spring:url
								value="/users/${user.id}/update" var="updateUrl" />

							<button class="btn btn-info"
								style="color: rgb(89, 89, 89); background-color: rgba(91, 192, 222, 0); border-color: rgb(164, 164, 164);"
								onclick="location.href='${userUrl}'">Query</button></td>
					</tr>
					<tr>
						<td>Szkolenie</td>
						<td>Tytul</td>
						<td>${user.email}</td>
						<td><c:forEach var="framework" items="${user.framework}"
								varStatus="loop">
													${framework}
													<c:if test="${not loop.last}">,</c:if>
							</c:forEach></td>
						<td><spring:url value="/users/${user.id}" var="userUrl" /> <spring:url
								value="/users/${user.id}/delete" var="deleteUrl" /> <spring:url
								value="/users/${user.id}/update" var="updateUrl" />

							<button class="btn btn-info"
								style="color: rgb(89, 89, 89); background-color: rgba(91, 192, 222, 0); border-color: rgb(164, 164, 164);"
								onclick="location.href='${userUrl}'">Query</button></td>
					</tr>
					<tr>
						<td>Szkolenie</td>
						<td>Tytul</td>
						<td>${user.email}</td>
						<td><c:forEach var="framework" items="${user.framework}"
								varStatus="loop">
													${framework}
													<c:if test="${not loop.last}">,</c:if>
							</c:forEach></td>
						<td><spring:url value="/users/${user.id}" var="userUrl" /> <spring:url
								value="/users/${user.id}/delete" var="deleteUrl" /> <spring:url
								value="/users/${user.id}/update" var="updateUrl" />

							<button class="btn btn-info"
								style="color: rgb(89, 89, 89); background-color: rgba(91, 192, 222, 0); border-color: rgb(164, 164, 164);"
								onclick="location.href='${userUrl}'">Query</button></td>
					</tr>
				</table>
			</div>
		</div>
	</div>

</body>
<!--/baza adresowa-->