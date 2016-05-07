<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../cabecalho.jsp" %>	

<div class="row">
	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		Quantidade de pedidos: ${pedidos.size()}
	</div>
</div>

<hr/>

<div class="row">
	<div class="col-md-2">Pedido</div>
	<div class="col-md-6">Cliente</div>
	<div class="col-md-2">Total</div>
	<div class="col-md-2">Remover</div>
</div>		
	
<hr/>

<c:forEach items="${pedidos}" var="pedido">
	<div class="row">
		<div class="col-md-2">${pedido.id}</div>
		<div class="col-md-6">${pedido.cliente.pessoa.nome}</div>
		<div class="col-sm-2">${pedido.total}</div>
		<div class="col-sm-2">
			<form action="<c:url value='/pedidos/${pedido.id}'/>" method="POST">
				<input name="_method" type="hidden" value="DELETE" />
				<button class="btn btn-danger" type="submit">
					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
				</button>
			</form>
		</div>
	</div>
</c:forEach>	
<%@ include file="../rodape.jsp" %> 
