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
    
    <div class="divPrincipal">
        <div>
            <div>
                <h1>Cadastro</h1>
                <a href="login">Voltar</a>
            </div>
                <div>
                    <form action="inserir-usuario">
                        <div>
                            <label>Nome</label>
                            <input type="text" name="nome">
                        </div>
                         <div>
                            <label>Email</label>
                            <input type="text" name="email">
                        </div>
                         <div>
                            <label>Senha</label>
                            <input type="password" name="senha">
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
                           <input type="submit" value="Adicionar">
                        </div>
                    </form>
                </div>
            </div> 
    </div>
</body>
</html>