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

	});
</script>
</head>
<body>
	<div class="row" style="margin-bottom: 5px; margin-top: 10px">
		<div class=col-md-7>
			<div class="row">
				<div class=col-md-12>

					<div class="btn-group btn-group-justified" role="group"
						aria-label="...">
						<div style="color: #4E84AB; text-align:center;" class="btn-group" role="group">
							<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
							<b>Rola:</b> Redaktor
						</div>
						<div class="btn-group" role="group">
							<button type="button" class="btn btn-default"
								style="border-color: #FFF">
								<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
								Edytuj profil
							</button>
						</div>

						<div class="btn-group" role="group">
							<button type="button" class="btn btn-default"
								style="border-color: #FFF">
								<span class="glyphicon glyphicon-flag" aria-hidden="true"></span>
								Jęyk
							</button>
						</div>
						<div class="btn-group" role="group">
							<button type="button" class="btn btn-default"
								style="border-color: #FFF">
								<span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span>
								Dezaktywacja
							</button>
						</div>
					</div>
					<div class="panel panel-default"></div>

				</div>
				<!-- col-md-12 -->
				<div class=col-md-12>
					<div class="row">
						<div class=col-md-8>
							<h4>"Sed ut perspiciatis unde omnis iste natus error sit</h4>

							<p>voluptatem accusantium doloremque laudantium, totam rem
								aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
								architecto</p>
						</div>
						<div class=col-md-4>
							<img
								src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAANlBMVEXk5ueutLepsLPo6uvj5eavtbjJzc+/xMbp6+yrsbXd4OGnrrK0ubzQ1NXZ3N3O0dO8wcPDyMmu9XhTAAAG40lEQVR4nO2d65qjIAyGleABxdP93+xqbesJJVhawmzeP7vzzHTXbxKSEDEmCcMwDMMwDMMwDMMwDMMwDMMwDMMwDMMwDMMwDMMwfxAASKq26UaatpLTl38IANkOfSpqoR6Mf0n10Mi/ohKqXAuVHhBC51X8IgEao7wZJXSXRK0RIFen8l4ih4g1Qn5uvpXGOlaN0KQIfbMduwglguwFTt9Do65i0wgN0n5vjZGZEQoHA86IPiqJ2tGCDyumMvRlo5Hu8maNsSzGymhApWqVZVrrTNVnSUS0UUg0CFQi7fO2msrvqeSWrbmOi0SiPFy6yKb6c3Pp41ddZtIoqlDXjedgvqIqjT9YGisCQT3cgN4tvkGe+h2YcwptP4ViYxZbVQ1dfRCoSOdFaDZGsceN3QfmT+WEJcrt9db2sAHdcS0iPhaK3SLcXuqUJ6SUyW5XX/bHlZhRNeLB5RaFAFXXZ2Ii65vt4jz6qRqoStw73EshyFzXyzeVWq80yI9+SjRlwGBWCFW/L2CUXn/wGE9TmvFUHq50UjjuhA0K1lkPDCtRtAGFnGG40Hos1gajvjTVi0TTZlkTNOLRhGkt29NWzcpKleGXQNCIx1U4ctWqWS0102+B4Ep03dWr9ychM3ybXNo31SbXLPsko0JyOXFfznyskNweo3LvrVkUEos1psLEwrIOpfm3U5AyoruTroJla1aozK2BQJyY4YLFCc/sTyuauvbw10XLSaBJVR5S0Q4YXAWuemonTkor6Zeuy7BuwP5ZRUghnJTXZ4glnV+UCpR6p47ZcCXwKkapJqCkHW6BZl2QXaUZRajplrsIXFsQ+qvfDZ2cD4WLwJVldg3kPXSCqakPgRFYmvaUK+hs9B1qtq1AS4Ci0zctT6qSa4EWF50IqGkLWuFWoDXFqIv/87cAUqAqlu0C5rSGItMYxirU2DRBTiHSS1e9+hIjkJCX4hSuTj0hgsyDkKI24LLFEvshR9axZLIFKuMvVabpxq8RQhkf43SrvRC2TqejEFV5L/tZdF+OTuWN2j29y2h0jUdp92S6e7S/3PeeqcRulyntgDFdjHfnzHAbzgylLgYmIXavH0a3PEh1ouxb4MXl0AoJhVJMqFkUtlgvpdQRRnT13RXWpG4+2TOAu0JKyxBzd81dIaF8P2ENH84Kid0htbups0JaToo4qaAaeIIogFKCJxXsG4Yif2Jpkj6hVNDM2JO+eoERSKjf/cb9NMYV1OLMhEtr3w6piu0FLoLgoGhCfAMNA0kTJqYT2zehddBk4TInquKNVSDBXPjkqrCpk1fGR3QxqAq8zBj1u6UPNoU0w8zMRa8Xr5BSi+3I+S0lvEKqcfTJ2SE1vEI6N5zO+FAhvYr7gPk5Z6xCWs2ZE8wScQqjeNI5AWPOQCmMQ2Biepwbp7CORWBimhqBUUjmYAKC41kSa9UmtP2fpcRxekv2xiyQdCVjAqR2mcCTxTL0Y81oRuyWOD4DzgAMmElYqSginYQ1AslgnWamivO5EjEASbd+jHsvT2R53Pom4Gyq4ChvaOOfKvgAQDaDrqfBkLNjirrWRfMHhiaugbKU03DPPJ/Ge0oo/5S6/wIwEPqavPAYaDKNnh2Kvp/mfE2Mf+q+GPKnt0ardLz2qsl7nQohTLfUHsNohcr00LUytlU5mqXtiqw+T4QbqdP43T6PZujupG7QAlWubRAiKzryCWTO7vdv0IxFQNHQLXIA2iFzt93RlrqjKBLKtkBvlmyomtwAZZB56vU2/iiyp1Ozjt55GJPkA5HS2HdMIx79mm9hmrkYWiMk1oHdnyF00B7quIX/hnseNIYakAG4geQ+NIbxVei+658bjf3vNULr0g71oHH4be6AxGXguhdU2vxQYol9+Mwrov9VneM2Md+rxt+YEU7nyfxAYv8LgbYxAV9Fpd8uAEDemZjvky+/CgPawPrSL79DwTSc+veo7HsCgy7BNV+qcCBUkjiivhJvUHMefsU3JELoILrF/9EbYgL9SyTlojN+T4j5fNDAG8rjOc0b00l/gj+BDYVEb8DbeWm/z2x5RHl6kPb06HZ4/GwYCYbRBR+nwtHjcsLgYykStmDq4/ETv89NfoGP/RQ9xCIYH/op4Tj6Qnw0p8f9fQAB+Gg0gfVBOgp88n5PqvXojg+MCFEI/MCIUazCiduzaiMIpDO3w2nAGxSO3MyJTjOsw3K3sIlkFaa3q1P3d1aE45abRuSkN1+2hx1/TALV2QUdINudMXLnllss6X7mxouFolqGt+a94Gflk+DGNFfXV8eExn1QZlyB5k6oiaconXHP+TFVNA+cFea1iIraVaD5aTPKuCtkGIZhGIZhGIZhGIZhfsk/F2tfPIOh2xIAAAAASUVORK5CYII="
								alt="..." class="img-thumbnail">
						</div>
					</div>

					<p>"Sed ut perspiciatis unde omnis iste natus error sit
						voluptatem accusantium doloremque laudantium, totam rem aperiam,
						eaque ipsa quae ab illo inventore veritatis et quasi architecto
						beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia
						voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur
						magni dolores eos qui ratione voluptatem sequi nesciunt. Neque
				</div>
				<!-- col-md-12 -->

			</div>
			<!-- row -->

		</div>
		<!-- col-md-6 -->
		<div class="col-md-5">
			<table class="table table-bordered">
				<tr>
					<td>
						<table class="table table-bordered" style="width: 100%">
							<tr>
								<td style="border: 1px solid #FFF;"><b>Nazwa</b></td>
								<td style="border: 1px solid #FFF">Monika Senderecka</td>
							</tr>
							<tr>
								<td style="border: 1px solid #FFF"><b>Email</b></td>
								<td style="border: 1px solid #FFF">kolardia@gmail.com</td>
							</tr>
							<tr>
								<td style="border: 1px solid #FFF"><b>Kraj</b></td>
								<td style="border: 1px solid #FFF">Polska</td>
							</tr>
							<tr>
								<td style="border: 1px solid #FFF"><b>Misto</b></td>
								<td style="border: 1px solid #FFF">Poznań</td>
							</tr>
							<tr>
								<td style="border: 1px solid #FFF"><b>Województwo</b></td>
								<td style="border: 1px solid #FFF">wielkopolskie</td>
							</tr>
							<tr>
								<td style="border: 1px solid #FFF"><b>Adress</b></td>
								<td style="border: 1px solid #FFF">ul. Dombrowskiego</td>
							</tr>
							<tr>
								<td style="border: 1px solid #FFF"><b>Konto</b></td>
								<td style="border: 1px solid #FFF">aktywne</td>
							</tr>
							<tr>
								<td style="border: 1px solid #FFF"><b>Konto</b></td>
								<td style="border: 1px solid #FFF">aktywne</td>
							</tr>
							<tr>
								<td style="border: 1px solid #FFF"><b>Konto</b></td>
								<td style="border: 1px solid #FFF">aktywne</td>
							</tr>
						</table>
					</td>
				<tr>
			</table>
		</div>

	</div>
	<!-- row panel -->
<body>