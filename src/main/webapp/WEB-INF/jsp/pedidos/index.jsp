<%@include file="../cabecalho.jsp" %>
<div class="row">
	Quantidade de pedidos: ${pedidos.size()}
</div>

<hr/>

<div class="row">
	<div class="col-xs-4 col-sm-4 col-md-2 col-lg-4">Pedido</div>
	<div class="col-xs-4 col-sm-4 col-md-8 col-lg-4">Cliente</div>
	<div class="col-xs-4 col-sm-4 col-md-2 col-lg-4">Total</div>
</div>		

<hr/>

<c:forEach items="${pedidos}" var="pedido">
	<div class="row">
		<div class="col-xs-4 col-sm-4 col-md-2 col-lg-4">${pedido.id}</div>
		<div class="col-xs-4 col-sm-4 col-md-8 col-lg-4">${pedido.cliente.pessoa.nome}</div>
		<div class="col-xs-4 col-sm-4 col-md-2 col-lg-4">${pedido.total}</div>
	</div>
</c:forEach>
<%@include file="../rodape.jsp" %>