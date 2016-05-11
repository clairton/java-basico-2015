<%@ include file="../cabecalho.jsp" %>
<form method="POST" action="<c:url value='/pedidos/entregar'/>">
	<div class="row">
		<div class="col-md-4">
			<label for="nome">Nome</label>
			<input type="text" name="nome" id="nome" class="form-control">
		</div>
	</div>
	<div class="row">
		<div class="col-md-4">
			<label for="desconto">Desconto</label>
			<input type="text" name="desconto" id="desconto" class="numero form-control"/>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-4">
			<button class="btn btn-primary" type="submit">
				Entregar
			</button>
		</div>
	</div>
</form>
<%@ include file="../rodape.jsp" %>