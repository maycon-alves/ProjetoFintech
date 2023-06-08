<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./stylesheet/style-cadastro.css">
</head>
<body>
	<h2>Crie uma conta</h2>
	<img src="./img/cadastro.png">
	<c:if test="${not empty message }">
		<div>${message}</div>
	</c:if>
	<c:if test="${not empty error }">
		<div>${error}</div>
	</c:if>
	<form method="post" action="cadastro">
		<ul>
			<li><label>CPF</label> <input type="text"
				placeholder="xxx.xxx.xxx-xx" name="cpf" class="card"></li>
			<li><label>Apelido</label> <input type="text"
				placeholder="Como gostaria de ser chamado" name="apelido"
				class="card"></li>
			<li><label>Nome</label> <input type="text"
				placeholder="Primeiro Nome" name="nome" class="card"></li>
			<li><label>Senha</label> <input type="text" placeholder="xxxxxx"
				name="senha" class="card"></li>
			<li><label>Confirmar senha</label> <input type="text"
				placeholder="Confirme sua senha" name="confirmarSenha" class="card">
			</li>
			<li><label>Periodicidade do Faturamento?</label>
				<div class="check">
					<input type="checkbox" name="fs">Fixo Semanal
				</div>
				<div class="check">
					<input type="checkbox" name="fm">Fixo Mensal
				</div>
				<div class="check">
					<input type="checkbox" name="fa">Fixo Anual
				</div>
				<div class="check">
					<input type="checkbox" name="vr">Variavel
				</div>
				<div class="check">
					<input type="checkbox" name="mt">Misto
				</div></li>
			<li><label>Possui experiencia com investimentos?</label>
				<div class="check">
					<input type="checkbox" name="experienciaSim">Sim
				</div>
				<div class="check">
					<input type="checkbox" name="experienciaNao">Não
				</div></li>
			<li><label>Oque é mais importante para você?</label>
				<div class="check">
					<input type="checkbox" name="naoAssumeRisco">Saber
					exatamente quando vai ganhar ao final do investimento.
				</div>
				<div class="check">
					<input type="checkbox" name="assumeRisco">Ganhar o maximo
					de rendimento mesmo que tenha algum risco.
				</div></li>
			<li><label>Por quanto tempo você aceitaria guardar seu
					dinheiro sem poder resgatar?</label>
				<div class="check">
					<input type="checkbox" name="1-3">1 ano até 3 anos
				</div>
				<div class="check">
					<input type="checkbox" name="3-5">3 anos até 5 anos
				</div>
				<div class="check">
					<input type="checkbox" name="+5">mais de 5 anos
				</div></li>
			<li><label>Possui investimentos em renda variavel ou de
					alto risco?</label>
				<div class="check">
					<input type="checkbox" name="altoRiscoSim">Sim
				</div>
				<div class="check">
					<input type="checkbox" name="altoRiscoNao">Não
				</div></li>
			<li>
				<div class="btn">
					<input type="submit" value="cadastrar">
				</div>
			</li>
		</ul>
	</form>
	<div class="footer">
		<p>Já possui uma conta?</p>
		<a href="login">Entrar</a>
	</div>
</body>
</html>