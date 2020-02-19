<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:pageTemplate titulo="Lista de Produtos">

	<section id="index-section" class="container middle">
		
	<div class="container">
		<h1>Lista de Produtos</h1>

		<div>${sucesso }</div>
		<div>${falha }</div>

		<table class="table table-bordered table-hover">
			<tr>
				<th>Título</th>
				<th>Descrição</th>
				<th>Páginas</th>
				<th>Preços</th>
				<th>Data de Lançamento</th>
			</tr>
			<c:forEach items="${produtos }" var="produto">
				<tr>
					<td><a
						href="${s:mvcUrl('PC#detalhe').arg(0,produto.id).build() }">${produto.titulo }</a>
					</td>
					<td>${produto.descricao }</td>
					<td>${produto.paginas }</td>
					<td>${produto.precos }</td>
					<%-- <td>${produto.dataLancamento }</td> --%>
					<td><fmt:formatDate pattern="dd/MM/yyyy"
							value="${produto.dataLancamento.time}" /></td>
				</tr>
			</c:forEach>
			<tr>
				<td>
			</tr>
		</table>
	</div>
	</section>
	
	</tags:pageTemplate>
	
</body>
</html>