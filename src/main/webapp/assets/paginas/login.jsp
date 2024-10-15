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

<body>
	<div>
		<h2>Login</h2>
		<form action="logar" method="post">
			<div>
				<label for="email">E-mail</label>
				<input type="email" id="email" name="email" placeholder="username@email.com" maxlength="65">
			</div>
			<div>
				<label for="senha">Senha</label>
				<input type="password" id="senha" name="senha" placeholder="senha" maxlength="25">
			</div>
			<div>
				<input type="submit" value="Entrar">
				<p>Não tem Conta? <a href="cadastro-usuario">Registre-se</a></p>
			</div>
		</form>
	</div>
</body>

</html>
