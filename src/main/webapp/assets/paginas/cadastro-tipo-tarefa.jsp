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
<style><%@include file="../../assets/css/estilo.css"%></style></head>
<body>

<%@include file="../../assets/paginas/menu.jsp"%>

	<div class="divPrincipal">
		<div>
			<div>
				<h1>Cadastro Tipo Tarefa</h1>
				<a href="home">Voltar</a>
			</div>
			<div>
				<form action="inserir-tipo-tarefa">
					<div>
						<label>Nome</label> <input type="text" name="nome">
					</div>
					<div>
						<label>desc</label> <input type="text" name="desc">
					</div>
		
					<div>
						<input type="submit" value="Adicionar">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>