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
                <h1>Visualizar Desenvolvedores</h1>
                <a href="home">Voltar</a>
            </div>
            <div>
                <form action="resultado-pesquisa-desenvolvedor" method="GET">
                    <input type="text" placeholder="Pesquisar desenvolvedor por nome..." name="nome">
                    <button type="submit">Pesquisar</button>
                </form>
            </div>

            <table>
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>email</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="desenvolvedor" items="${desenvolvedores}">
                        <tr>
                            <td>${desenvolvedor.nome}</td>
                            <td>${desenvolvedor.email}</td>
                            <td>
                                <a href="editar-desenvolvedor?id=<c:out value='${desenvolvedor.id}'/>" class="action-button">Editar Desenvolvedor</a>
                            </td>
                            <td>
                                <a href="deletar-usuario?id=<c:out value='${desenvolvedor.id}'/>" class="action-button">Deletar Desenvolvedor </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
	</div>

</body>
</html>