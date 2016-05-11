<%@include file="../cabecalho.jsp" %>
<div class="row">
	Quantidade de pedidos: ${pedidos.size()}
</div>

<hr/>

<div class="row">
	<div class="col-xs-3 col-sm-3 col-md-2 col-lg-3">Pedido</div>
	<div class="col-xs-3 col-sm-3 col-md-6 col-lg-3">Cliente</div>
	<div class="col-xs-3 col-sm-3 col-md-2 col-lg-3">Total</div>
	<div class="col-xs-3 col-sm-3 col-md-2 col-lg-3">Remover</div>
</div>		

<hr/>

<c:forEach items="${pedidos}" var="pedido">
	<div class="row">
		<div class="col-xs-3 col-sm-3 col-md-2 col-lg-3">${pedido.id}</div>
		<div class="col-xs-3 col-sm-3 col-md-6 col-lg-3">${pedido.cliente.pessoa.nome}</div>
		<div class="col-xs-3 col-sm-3 col-md-2 col-lg-3">${pedido.total}</div>
		<div class="col-xs-3 col-sm-3 col-md-2 col-lg-3">
			<form action="<c:url value='/pedidos/${pedido.id}' />" method="POST">
				<input type="hidden" name="_method" value="DELETE" />
				<button type="submit" class="glyphicon glyphicon-trash btn btn-danger btn-sm">
				
				</button>
			</form>
		</div>
	</div>
	<div class="row" >
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">&nbsp;</div>
	</div>
</c:forEach>
<%@include file="../rodape.jsp" %>