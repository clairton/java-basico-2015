<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../cabecalho.jsp" %>
	<div class="row">
		<c:if test="${pedido.id}">
			<div class="col-xs-4 col-sm-4 col-md-2 col-lg-4">
				Número do pedido: ${pedido.id}
			</div>
		</c:if>
	</div>		
	
	<div class="row">
		<div class="col-xs-4 col-sm-4 col-md-2 col-lg-4">Descrição</div>
		<div class="col-xs-4 col-sm-4 col-md-8 col-lg-4">Valor</div>
	</div>		
		
	<div class="row">
		<form action="<c:url value='/pedidos/item'/>" method="POST" class="form-inline navbar-form">		
  			<div class="form-group">
				<input type="text" name="item.nome" class="form-control">
				<input type="number" step="any" name="item.valor" class="form-control">
			</div>
			<button type="submit" class="btn btn-default">Adicionar</button>
		</form>
	</div>
	
	
	<c:forEach items="${pedido.items}" var="item">
		<div class="row">
			<div class="col-xs-4 col-sm-4 col-md-2 col-lg-4">${item.nome}</div>
			<div class="col-xs-4 col-sm-4 col-md-8 col-lg-4">${item.valor}</div>
		</div>
	</c:forEach>
	
	<hr/>
	
	<div class="row">		
		<div class="col-xs-4 col-sm-4 col-md-2 col-lg-4">Total:</div>
		<div class="col-xs-4 col-sm-4 col-md-8 col-lg-4">${pedido.total}</div>
		<div class="col-xs-4 col-sm-4 col-md-8 col-lg-4">
			<a class="btn btn-default" href="<c:url value='/pedidos/cliente'/>">
				Pronto
			</a>
		
		</div>
	</div>
<%@ include file="../rodape.jsp" %> 
