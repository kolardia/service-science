<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div style="background-color: #D7F4FE;">

	<p class="text-muted"
		style="text-align: center; padding-bottom: 10px; padding-top: 10px;">©
		2016 service</p>
</div>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<spring:url value="/resources/core/js/bootstrap.min.js"
	var="bootstrapJs" />

<script src="${bootstrapJs}"></script>
<script>
	$(document).ready(function() {
		var panel = $.ajax({
			url : "editor/publications",
			success : function(result) {
				$("#pagePanel").html(result);
			}
		});
		$("#pagePanel").html(panel);
		$("#btnService").click(function() {
			$.ajax({
				url : "service/section/pl",
				success : function(result) {
					$("#pagePanel").html(result);
				}
			});
		});
		$("#btnEditor").click(function() {
			$.ajax({
				url : "editor/publications",
				success : function(result) {
					$("#pagePanel").html(result);
				}
			});
		});
	});
</script>