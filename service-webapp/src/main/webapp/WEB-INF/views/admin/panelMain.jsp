<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<jsp:include page="panel/header.jsp" />
<spring:url value="/static/images/logo.jpeg" var="logo" />
<div id="contents">
	<div class="row"
		style="margin-top: 25px; margin-right: 20px; margin-left: 20px;">

		<div class="col-md-3">
			<div class="thumbnail">

				<div class="caption text-center">
					<div class="row">
						<div class="col-md-12 col-sm-4">
							<img src="${logo}">
						</div>
						<div class="col-md-12 col-sm-7">
							<h3>voluptatem sequi</h3>
							<div id="map" style="height: 100px; width: 100%;"></div>
							<p>
								s qui ratione voluptatem sequi nesciunt. Neque porro quisquam
								est, qui dolorem ipsum quia dolor sit amet, consectetur,
								adipisci veniam, quis nostrum exer <br /> <a href="#">
									Nequeporro@quisquam.com</a>
							</p>
							<spring:message code="admi.nav.editorial.work"
								var="editorialWork" />
							<spring:message code="admi.nav.service" var="service" />
							<div class="btn-group" role="group" aria-label="menuSection"
								style="margin-bottom: 25px;">
								<a id="btnEditor" type="button" class="btn btn-default"><span
									class=" glyphicon glyphicon-pencil" aria-hidden="true"></span>
									${editorialWork} </a> <a id="btnService" type="button"
									class="btn btn-default"> <span
									class="glyphicon glyphicon-globe" aria-hidden="true"></span>
									${service}
								</a>
							</div>

						</div>
					</div>
				</div>

			</div>
		</div>

		<div id="pagePanel" class="col-md-9 "></div>
		<!--col-sm-9-->
	</div>
</div>
<jsp:include page="panel/footer.jsp" />

</body>
</html>
