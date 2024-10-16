<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Soft Lev Web - Login</title>
<style><%@include file="../../assets/css/estilo.css"%></style></head>
<body>

	<div class="divPrincipal">
		<div>
			<div>
				<h1>Cadastro</h1>
				<a href="tela-principal">Voltar</a>
			</div>
			<div>
				<form action="inserir-tarefa">
					<div>
						<label>Nome</label> <input type="text" name="nome">
					</div>
					<div>
						<label>desc</label> <input type="text" name="desc">
					</div>
					<div>
						<label for="tipo-tarefa">Tipo da Tarefa</label>
						<div class="tipo-tarefa">
							<select name="id">
								<c:forEach var="tipoTarefa" items="${tiposTarefa}">
									<option value="${tipoTarefa.id}">${tipoTarefa.nome}</option>
								</c:forEach>
							</select>
						</div>
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