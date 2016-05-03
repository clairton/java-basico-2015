<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pedidos</title>
</head>
<body>
	
	Quantidade de pedidos: ${pedidos.size()}
	
	<table>
		<tr>
			<th>Pedido</th>
			<th>Cliente</th>
			<th>Total</th>
		</tr>
		
		<c:forEach items="${pedidos}" var="pedido">			
			<tr>
				<td>${pedido.id}</td>
				<td>${pedido.cliente.pessoa}</td>
				<td>${pedido.total}</td>
			</tr>
		</c:forEach>		
	</table>
</body>
</html>