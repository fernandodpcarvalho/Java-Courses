<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<header id="layout-header">
	<div class="clearfix container">
		<a href="${s:mvcUrl('HC#index').build() }" id="logo"> </a>
		<div id="header-content">
			<nav id="main-nav">

				<ul class="clearfix">

					<security:authorize access="isAuthenticated()">

						<li><a href="${s:mvcUrl('PC#listar').build() }"
							rel="nofollow">Lista de Produtos</a></li>

						<li><a href="${s:mvcUrl('PC#form').build() }" rel="nofollow">Cadastro
								de Produtos</a></li>

						<li><a href="/casadocodigo/logout" rel="nofollow">Logout</a></li>

					</security:authorize>

					<li><a href="${s:mvcUrl('CCC#itens').build() }" rel="nofollow">
							<s:message code="menu.carrinho"
								arguments="${carrinhoCompras.quantidade}" /> <%-- 
							<fmt:message key="menu.carrinho">
								<fmt:param value="${carrinhoCompras.quantidade }"/>
							</fmt:message>
							 --%>
					</a></li>

					<%-- Seu Carrinho (${carrinhoCompras.quantidade })</a></li> --%>
					<input type="hidden" name="${_csrf.parameterName }"
						value="${_csrf.token }">
					<!-- 
						<li><a href="#" rel="nofollow">Sobre Nós</a></li>

						<li><a href="#" rel="nofollow">Perguntas Frequentes</a></li>
						 -->

					<li><a href="?locale=pt" rel="nofollow"> <fmt:message
								key="menu.pt" /></a></li>

					<li><a href="?locale=en_US" rel="nofollow"> <fmt:message
								key="menu.en" />
					</a></li>

				</ul>
			</nav>
		</div>
	</div>
</header>
<nav class="categories-nav">
	<ul class="container">
		<li class="category"><a href="${s:mvcUrl('HC#index').build() }"><fmt:message
					key="navegacao.categoria.home" /> </a></li>
		<li class="category"><a href="#"><fmt:message
					key="navegacao.categoria.agile" /></a></li>
		<li class="category"><a href="#"><fmt:message
					key="navegacao.categoria.front_end" /> </a></li>
		<li class="category"><a href="#"><fmt:message
					key="navegacao.categoria.games" /> </a></li>
		<li class="category"><a href="#"><fmt:message
					key="navegacao.categoria.java" /> </a></li>
		<li class="category"><a href="#"><fmt:message
					key="navegacao.categoria.mobile" /> </a></li>
		<li class="category"><a href="#"><fmt:message
					key="navegacao.categoria.web" /> </a></li>
		<li class="category"><a href="#"><fmt:message
					key="navegacao.categoria.outros" /> </a></li>
	</ul>
</nav>