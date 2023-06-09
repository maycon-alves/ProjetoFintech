<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Gasto</title>
<link rel="stylesheet" href="./stylesheet/style-cadastro-gasto.css">
</head>
<body>
	<h2>Crie uma conta</h2>
	<img src="./img/cartao.png">
	<form method="post" action="cadastro-gasto">
		<ul>
			<li><label>Titulo do gasto</label> <input type="text"
				placeholder="xxxxxxxx" name="descricaoGasto" class="card"></li>
			<li><label>Data do gasto</label> <input type="text"
				placeholder="xx/xx/xxxx" name="dataGasto" class="card"></li>
			<li><label>Valor</label> <input type="text" placeholder="000"
				name="valorGasto" class="card"></li>

			<li><label>Tipo do gasto?</label>
				<div class="check">
					<input type="checkbox" name="FIXO">Fixo
				</div>
				<div class="check">
					<input type="checkbox" name="MENSAL">Mensal
				</div></li>
			<li><label>Categoria do gasto?</label>
				<div class="check">
					<input type="checkbox" name="ALIMENTACAO">Alimentação
				</div>
				<div class="check">
					<input type="checkbox" name="SAUDE">Saúde
				</div>
				<div class="check">
					<input type="checkbox" name="LAZER">Lazer
				</div>
				<div class="check">
					<input type="checkbox" name="IMPULSO">Impulso
				</div>
				<div class="check">
					<input type="checkbox" name="DESPESA_FIXA">Despesa Fixa
				</div>
				<div class="check">
					<input type="checkbox" name="IMPREVISTO">Imprevisto
				</div></li>
			<li><label>Forma de pagamento</label>
				<div>
					<select name="idFormaPagamento" id="select">
					<option disabled selected>- Selecione -</option>
						<c:forEach items="${formasPagamento }" var="g">
							<option value="${g.idFormaPagamento}">${g.apelidoFormaPagamento}</option>
						</c:forEach>
					</select>
				</div></li>
			<li>
				<div class="btn">
					<input type="submit" value="cadastrar">
				</div>
			</li>
		</ul>
	</form>
	<div class="footer">
		<a href="home">Voltar para a home</a>
	</div>
</body>
</html>