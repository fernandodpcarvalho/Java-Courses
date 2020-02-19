<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:pageTemplate titulo="Cadastro de Produtos">

	<section class="container middle">
	
	<div class="container">
	
	<h1>Cadastro de Produtos</h1>

		<form:form servletRelativeAction="${s:mvcUrl('PC#grava').build() }" method="POST"
			commandName="produto" enctype="multipart/form-data">
			<div class="form-group">
				<label>Titulo</label>
				<!-- <input type="text" name="titulo"> -->
				<%-- <form:errors path="produto.titulo"/> --%>
				<form:input path="titulo" cssClass="form-control"/>
				<form:errors path="titulo" />
			</div>
			<div class="form-group">
				<label>Descrição</label>
				<!-- <textarea rows="10" cols="20" name="descricao"></textarea> -->
				<%-- <form:errors path="produto.descricao"/> --%>
				<form:textarea path="descricao" cssClass="form-control" />
				<form:errors path="descricao" />
			</div class="form-group">
			<div>
				<label>Páginas</label>
				<!-- <input type="text" name="paginas"></input> -->
				<%-- <form:errors path="produto.paginas"/> --%>
				<form:input path="paginas" cssClass="form-control" />
				<form:errors path="paginas" />
			</div>
			<div class="form-group">
				<label>Data de Lançamento</label>
				<!-- <input name ="dataLancamento"></input> -->
				<form:input path="dataLancamento" cssClass="form-control" />
				<form:errors path="dataLancamento" />
			</div>
			<div class="form-group">
				<c:forEach items="${tipos }" var="tipoPreco" varStatus="status">
					<label>${tipoPreco }</label>
					<%-- <input type="text" name="precos[${status.index }].valor"> --%>
					<%-- <input type="hidden" name="precos[${status.index }].tipo" value="${tipoPreco }"> --%>
					<form:input path="precos[${status.index }].valor"  cssClass="form-control" />
					<form:hidden path="precos[${status.index }].tipo"
						value="${tipoPreco }" />
				</c:forEach>
			</div>
			<div>
				<label>Sumário</label> <input name="sumario" type="file" class="form-control"/>
			</div>
			<button type="submit" class="btn btn-primary">Cadastrar</button>
			<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
		</form:form>
	</div>	
	</section>
		
	</tags:pageTemplate>
	
</body>
</html>