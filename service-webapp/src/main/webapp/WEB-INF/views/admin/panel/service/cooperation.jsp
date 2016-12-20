<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("#panelSearchResults").hide();
		$("#panelPartners").hide();
		$("#panelSponsors").hide();
		$("#panelMediaPartners").hide();
		$("#panelNew").hide();

		$("#btnSearchResults").click(function() {
			var panel = $(panelSearchResults).html();
			$("#page").html(panel);
		});

		$("#btnNew").click(function() {
			var panel = $(panelNew).html();
			$("#page").html(panel);
		});

		$("#btnPartners").click(function() {
			var panel = $(panelPartners).html();
			$("#page").html(panel);
		});

		$("#btnSponsors").click(function() {
			var panel = $(panelSponsors).html();
			$("#page").html(panel);
		});

		$("#btnMediaPartners").click(function() {
			var panel = $(panelMediaPartners).html();
			$("#page").html(panel);
		});

	});
</script>
</head>
<body>
	<!-- PANEL: COPPERATION -->
	<div class="row" style="margin-bottom: 5px; margin-top: 10px">

		<div class="col-md-7">
			<div class="btn-group btn-group-justified" role="group"
				aria-label="...">

				<div class="btn-group" role="group">
					<button id="btnNew" type="button" class="btn btn-default"
						style="border-color: #FFF">
						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
						Dodaj
					</button>
				</div>

				<div class="btn-group" role="group">
					<button id="btnPartners" type="button" class="btn btn-default"
						style="border-color: #FFF">
						<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
						Partnerzy
					</button>
				</div>

				<div class="btn-group" role="group">
					<button id="btnSponsors" type="button" class="btn btn-default"
						style="border-color: #FFF">
						<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
						Sponsorzy
					</button>
				</div>
				<div class="btn-group" role="group">
					<button id="btnMediaPartners" type="button" class="btn btn-default"
						style="border-color: #FFF">
						<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
						Patroni medialni
					</button>
				</div>

			</div>
		</div>
		<div class="col-md-5 pull-right">
			<div class="input-group input-group-sm">
				<span class="input-group-btn">
					<button id="btnSearchResults" class="btn btn-default" type="button">
						<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					</button>
				</span> <input type="text" class="form-control"
					placeholder="xxxxxxxxxxxxxxxxxxxxxxxx">
			</div>
		</div>
	</div>


	<div class="panel panel-default"></div>

	<div id="panelSearchResults"><jsp:include
			page="cooperation/list/searchResults.jsp" /></div>

	<div id="panelNew">
		<jsp:include page="cooperation/new.jsp" />
	</div>

	<div id="panelPartners">
		<jsp:include page="cooperation/list/partners.jsp" /></div>

	<div id="panelSponsors"><jsp:include
			page="cooperation/list/sponsors.jsp" /></div>

	<div id="panelMediaPartners">
		<jsp:include page="cooperation/list/mediaPartners.jsp" /></div>



	<div id="page">Panel redakcyjny wszystkie wyniki</div>
</body>