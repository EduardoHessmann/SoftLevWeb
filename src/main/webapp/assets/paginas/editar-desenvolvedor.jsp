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
                <h1>Editar Desenvolvedor</h1>
                <a href="visualizar-desenvolvedores">Voltar</a>
            </div>
                <div>
                    <form action="atualizar-usuario">
                    <input type="hidden" name="id" value="${desenvolvedor.id}">
                        <div>
                            <label>Nome</label>
                            <input type="text" name="nome" value="${desenvolvedor.nome}">
                        </div>
                         <div>
                            <label>Email</label>
                            <input type="text" name="email" value="${desenvolvedor.email}">
                         </div>
                         <div>
                            <label>Qual o seu nível?</label>
                            <select name="nivel">
                            <option value="usu">usu</option> 
                            <option value="dev">dev</option>
                            <option value="adm">adm</option>  
                            </select>
                        </div>
                        <div>
                         <input type="hidden" name="senha" value="${desenvolvedor.senha}">
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