<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../cabecalho.jsp" %>		
	<div class="row">
		<form action="<c:url value='/pedidos/entregar'/>" method="POST">		
			<div class="row">
				<label for="nome">Nome</label>
				<input name="nome" class="form-control" type="text">
			</div>	
			<div class="row">
				<label for="desconto">Desconto</label>
				<input name="desconto" class="form-control" value="0.00" type="number" step="any">
			</div>
			<button type="submit" class="btn btn-default">Entregar</button>
		</form>
	</div>
<%@ include file="../rodape.jsp" %> 
