<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<p
	style="font-size: 14px; margin-left: 10px; font-weight: 400; line-height: 1.42857; margin-top: -2px">
	${selectedPublications}: <span style="color: #C0C0CA;">${allPublications}</span>
</p>
<table class="table" style="margin-left: 20px; width: 95%;">
	<thead style="color: #C0C0C0;">
		<tr>
			<th>ID</th>
			<th>Forma wydarzenia</th>
			<th>${publicationTitle}</th>
			<th>${publicationStatus}</th>
			<th>Język</th>
			<th>${publicationAction}</th>
		</tr>
	</thead>
	<tr class="accent">
		<td>1</td>
		<td>Wykłady otwarte</td>
		<td>Tytul publikacji -zazwyczaj długi</td>
		<td>Opublikowana</td>
		<td>PL|EN</td>
		<td>
			<button class="btn buttonLink btn-info "
				onclick="location.href='${userUrl}'">przegląd publikacji</button>
			<button class="btn buttonLink btn-success "
				onclick="location.href='${userUrl}'">Redaguj</button>
		</td>
	</tr>
	<tr class="accent">
		<td>1</td>
		<td>Konferencja</td>
		<td>Tytul publikacji -zazwyczaj długi</td>
		<td>Opublikowana</td>
		<td>PL|EN</td>
		<td>
			<button class="btn buttonLink btn-info "
				onclick="location.href='${userUrl}'">przegląd publikacji</button>
			<button class="btn buttonLink btn-success "
				onclick="location.href='${userUrl}'">Redaguj</button>
		</td>
	</tr>
	<tr class="accent">
		<td>1</td>
		<td>Konkurs</td>
		<td>Tytul publikacji -zazwyczaj długi</td>
		<td>Opublikowana</td>
		<td>PL|EN</td>
		<td>
			<button class="btn buttonLink btn-info "
				onclick="location.href='${userUrl}'">przegląd publikacji</button>
			<button class="btn buttonLink btn-success "
				onclick="location.href='${userUrl}'">Redaguj</button>
		</td>
	</tr>
	<tr class="accent">
		<td>1</td>
		<td>Warsztaty</td>
		<td>Tytul publikacji -zazwyczaj długi</td>
		<td>Opublikowana</td>
		<td>PL|EN</td>
		<td>
			<button class="btn buttonLink btn-info "
				onclick="location.href='${userUrl}'">przegląd publikacji</button>
			<button class="btn buttonLink btn-success "
				onclick="location.href='${userUrl}'">Redaguj</button>
		</td>
	</tr>
</table>