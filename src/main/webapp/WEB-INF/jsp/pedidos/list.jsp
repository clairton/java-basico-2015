<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pedidos</title>
</head>
<body>
	
	<table>
		<tr>
			<th>Pedido</th>
			<th>Cliente</th>
			<th>Total</th>
		</tr>
		
		<c:forEach items="${pedidoList}" var="pedido">			
			<tr>
				<td>${pedido.id}</td>
				<td>${pedido.cliente.pessoa.nome}</td>
				<td>${pedido.total}</td>
			</tr>
		</c:forEach>		
	</table>
</body>
</html>