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
                <h1>Visualizar Tarefas</h1>
                <a href="login">Voltar para o login</a>
            </div>
            <div>
                <form action="resultado-pesquisa-tarefa" method="GET">
                    <input type="text" placeholder="Pesquisar tarefas..." name="nome">
                    <button type="submit">Pesquisar</button>
                </form>
            </div>

            <table>
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Descrição</th>
                        <th>Tipo</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="tarefa" items="${tarefas}">
                        <tr>
                            <td>${tarefa.nome}</td>
                            <td>${tarefa.desc}</td>
                            <td>${tarefa.tipoTarefa.nome}</td>
                            <td>
                                <a href="editar-tarefa?id=<c:out value='${tarefa.id}'/>" class="action-button">Editar Tarefa</a>
                            </td>
                            <td>
                                <a href="deletar-tarefa?id=<c:out value='${tarefa.id}'/>" class="action-button">Deletar Tarefa</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
	</div>

</body>
</html>