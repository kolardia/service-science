<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<p
	style="font-size: 14px; margin-left: 10px; font-weight: 400; line-height: 1.42857; margin-top: -2px">
	${selectedPublications}:${info} <span style="color: #C0C0CA;">${publishedPublications}</span>
</p>
<table class="table" style="margin-left: 20px; width: 95%;">
	<thead style="color: #C0C0C0;">
		<tr>
			<th>ID</th>
			<th>Forma wydarzenia</th>
			<th>${publicationTitle}</th>
			<th>Język</th>
			<th>${publicationAction}</th>
		</tr>
	</thead>
	<tr class="accent">
		<td>1</td>
		<td>Wykłady otwarte</td>
		<td>Tytul publikacji -zazwyczaj długi</td>
		<td>EN</td>
		<td>
			<button class="btn buttonLink btn-info "
				onclick="location.href='${userUrl}'">przegląd publikacji</button>
			<button class="btn buttonLink btn-success "
				onclick="location.href='${userUrl}'">Archiwizuj</button>
		</td>
	</tr>
	<tr class="accent">
		<td>1</td>
		<td>Konferencja</td>
		<td>Tytul publikacji -zazwyczaj długi</td>
		<td>EN</td>
		<td>
			<button class="btn buttonLink btn-info "
				onclick="location.href='${userUrl}'">przegląd publikacji</button>
			<button class="btn buttonLink btn-success "
				onclick="location.href='${userUrl}'">Archiwizuj</button>
		</td>
	</tr>
	<tr class="accent">
		<td>1</td>
		<td>Konkurs</td>
		<td>Tytul publikacji -zazwyczaj długi</td>
		<td>PL</td>
		<td>
			<button class="btn buttonLink btn-info "
				onclick="location.href='${userUrl}'">przegląd publikacji</button>
			<button class="btn buttonLink btn-success "
				onclick="location.href='${userUrl}'">Archiwizuj</button>
		</td>
	</tr>
	<tr class="accent">
		<td>1</td>
		<td>Warsztaty</td>
		<td>Tytul publikacji -zazwyczaj długi</td>
		<td>PL</td>
		<td>
			<button class="btn buttonLink btn-info "
				onclick="location.href='${userUrl}'">przegląd publikacji</button>
			<button class="btn buttonLink btn-success "
				onclick="location.href='${userUrl}'">Archiwizuj</button>
		</td>
	</tr>
</table>