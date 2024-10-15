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
	<style><%@include file="../../assets/css/estilo.css"%></style>
</head>
<body class="flex flex-col min-h-screen bg-orchidBlossom font-poppins">
    
    <%@include file="../../../assets/paginas/menu.jsp"%>
    
    <div>
        <div>
            <div>
                <h1>Adicionar Máquina</h1>
                <a href="home">Voltar</a>
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
                           <input type="submit" value="Adicionar">
                        </div>
                    </form>
                </div>
            </div> 
    </div>
</body>
</html>