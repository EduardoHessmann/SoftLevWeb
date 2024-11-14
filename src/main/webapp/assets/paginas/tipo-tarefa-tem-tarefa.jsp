<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Soft Lev Web</title>
	<style><%@include file="../../assets/css/estilo.css"%></style>
</head>
<body>

	<%@include file="../../assets/paginas/menu.jsp"%>
	
	<div class="divPrincipal">
        
        <p>Não é possível deletar esse tipo tarefa, pois ele ainda possui tarefa(s) vinculadas a ele!</p>
        <a href="visualizar-tipos-tarefa">voltar</a>
        
	</div>

</body>
</html>