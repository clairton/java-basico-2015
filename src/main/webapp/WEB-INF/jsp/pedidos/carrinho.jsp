<%@include file="../cabecalho.jsp" %>

<div>
	
	<form method="POST" action="<c:url value='/pedidos/item'/>" class="form-inline">
		<div class="form-group">
			<c:if test="${not empty errors.from('item.nome')}">
				<div class="alert alert-danger">
					<span class="glyphicon glyphicon-exclamation-sign"></span>
					${errors.from('item.nome')}				
				</div>
			</c:if>
			<input type="text" name="item.nome" class="form-control"/>
			<c:if test="${not empty errors.from('item.valor')}">
				<div class="alert alert-danger">
					<span class="glyphicon glyphicon-exclamation-sign"></span>
					${errors.from('item.valor')}				
				</div>
			</c:if>
			<input type="text" step="any" name="item.valor" class="numero form-control"/>
			<button class="btn btn-primary" type="submit">Adicionar</button>
		</div>
	</form>
</div>

<c:forEach items="${pedido.items}" var="item">
	<div class="row">
		<div class="col-md-4 col-sm-4">
			${item.nome}
		</div>
		<div class="col-md-4 col-sm-4">
			${item.valor}
		</div>
	</div>
</c:forEach>

<hr/>

<div class="row">
	<div class="col-md-4 col-sm-4">
		Total
	</div>
	<div class="col-md-4 col-sm-4">
		${pedido.total}
	</div>
</div>

<div class="row">
	<div class="col-md-4 col-sm-4">
	</div>
	<div class="col-md-4 col-sm-4">		 
		<a class="btn btn-primary" href="<c:url value='/pedidos/cliente' />">Continuar</a>
	</div>
</div>

<%@include file="../rodape.jsp" %>