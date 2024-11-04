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
				<h1>Editar Tarefa</h1>
				<a href="home">Voltar</a>
			</div>
			<div>
				<form action="atualizar-tarefa">
				<input type="hidden" name="id" value="${tarefa.id}">
					<div>
						<label>Nome</label> 
						<input type="text" name="nome" value="${tarefa.nome}">
					</div>
					<div>
						<label>desc</label> 
						<input type="text" name="desc" value="${tarefa.desc}">
					</div>
					<div>
						<label for="tipo-tarefa">Tipo da Tarefa</label>
						<div class="tipo-tarefa">
							<select name="tipoTarefa">
								<c:forEach var="tipoTarefa" items="${tiposTarefa}">
									<option value="${tipoTarefa.id}">${tipoTarefa.nome}</option>
								</c:forEach>
							</select>
							
							<p>Não tem um tipo tarefa? <a href="cadastro-tipo-tarefa">Cadastre-a</a></p>
						</div>
					</div>
					<div>
						<label for="desenvolvedor">Desenvolvedor</label>
						<div class="desenvolvedor">
							<select name="id">
								<c:forEach var="desenvolvedor" items="${desenvolvedores}">
									<option value="${desenvolvedor.id}">${desenvolvedor.nome}</option>
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