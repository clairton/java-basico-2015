<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Pedidos</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>	
</head>
<body>
	<div class="container">	
		<div class="row">
			Quantidade de pedidos: ${pedidos.size()}
		</div>
		
		<div class="row">
			<a class="btn btn-default" href="<c:url value='/pedidos/novo'/>">Novo</a>
		</div>
		
		
		
		<div class="row">
			<div class="col-xs-4 col-sm-4 col-md-2 col-lg-4">Pedido</div>
			<div class="col-xs-4 col-sm-4 col-md-8 col-lg-4">Cliente</div>
			<div class="col-xs-4 col-sm-4 col-md-2 col-lg-4">Total</div>
		</div>		
			
		<c:forEach items="${pedidos}" var="pedido">
			<div class="row">
				<div class="col-xs-4 col-sm-4 col-md-2 col-lg-4">${pedido.id}</div>
				<div class="col-xs-4 col-sm-4 col-md-8 col-lg-4">${pedido.cliente.pessoa.nome}</div>
				<div class="col-xs-4 col-sm-4 col-md-2 col-lg-4">${pedido.total}</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>