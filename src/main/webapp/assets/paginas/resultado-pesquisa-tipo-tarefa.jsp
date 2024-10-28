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
        <div>
            <div> 
                <h1>Visualizar Tipos Tarefa</h1>
                <a href="visualizar-tipos-tarefa">Voltar para Todos os Tipos Tarefas</a>
            </div>
            <div>
                <form action="resultado-pesquisa-tipo-tarefa" method="GET">
                    <input type="text" placeholder="Pesquisar tipos tarefa..." name="nome">
                    <button type="submit">Pesquisar</button>
                </form>
            </div>
            <table>
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Descrição</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="tipoTarefa" items="${tiposTarefa}">
                        <tr>
                            <td>${tipoTarefa.nome}</td>
                            <td>${tipoTarefa.desc}</td>
                            <td>
                                <a href="editar-tipo-tarefa?id=<c:out value='${tipoTarefa.id}'/>" class="action-button">Editar Tipo Tarefa</a>
                            </td>
                            <td>
                                <a href="deletar-tipo-tarefa?id=<c:out value='${tipoTarefa.id}'/>" class="action-button">Deletar Tipo Tarefa</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
	</div>

</body>
</html>