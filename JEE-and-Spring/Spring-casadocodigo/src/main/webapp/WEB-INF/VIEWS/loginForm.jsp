<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:pageTemplate titulo="Login da Casa do Código">

	<div class="container">
	
	<h1>Login da Casa do Código</h1>

		<form:form servletRelativeAction="/login" method="POST">
			<div class="form-group">
				<label>E-mail</label>
				<input name="username" type="text" cssClass="form-control"/>
			</div>
			<div class="form-group">
				<label>Senha</label>
				<input type="password" name="password" Class="form-control" />
			</div>
			<button type="submit" class="btn btn-primary">Logar</button>
			<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
		</form:form>
	</div>
	
	</tags:pageTemplate>