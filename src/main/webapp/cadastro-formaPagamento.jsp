<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Forma de Pagamento</title>
    <link rel="stylesheet" href="./stylesheet/style-cadastro-formaPagamento.css">
</head>
<body>
    <h2>Cadastro de forma de pagamento</h2>
    <img src="./img/cadastroPagamento.png" alt="">
    <form method="post" action="cadastro-formaPagamento">
        <ul>
        <li>
            <label>Apelido do pagamento</label>
            <input type="text" placeholder="xxxxxxxx" name="apelidoFormaPagamento" class="card">
        </li>
        <li>
            <label>Tipo de pagamento</label>
            <input type="text" placeholder="credito/debito" name="tipoFormaPagmento" class="card">
        </li>
        <li>
            <label>Data de abertura</label>
            <input type="text" placeholder="xx/xx/xxxx" name="dataAberturaFatura" class="card">
        </li>
        <li>
            <label>Data de vencimento</label>
            <input type="text" placeholder="xx/xx/xxxx" name="dataVencimentoFatura" class="card">
        </li>
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