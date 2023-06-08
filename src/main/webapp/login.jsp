<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./stylesheet/style-login.css">
</head>
<body>
	<h2>Acesse sua conta</h2>
	<img src="./img/login.png">
	<c:if test="${not empty message }">
		<div>${message}</div>
	</c:if>
	<c:if test="${not empty error }">
		<div>${error}</div>
	</c:if>
	<form method="post" action="login">
		<ul>
			<li><label>CPF</label> <input type="text"
				placeholder="xxx.xxx.xxx-xx" name="cpf" class="card"></li>
			<li><label>Senha</label> <input type="text" placeholder="xxxxxx"
				name="senha" class="card"></li>
			<li class="invert"><a>Esqueceu sua senha?</a></li>
			<li>
				<div class="btn">
					<input type="submit" value="Entrar">
				</div>
			</li>
		</ul>


	</form>
	<div class="footer">
		Não possui uma conta?<a href="./cadastro.jsp">Cadastre-se</a>
	</div>


</body>
</html>