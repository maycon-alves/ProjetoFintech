<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Home</title>
    <link rel="stylesheet" href="./stylesheet/style-home.css">
</head>
<body>
    <header>
        <div class="row-center">
            <div class="foto">

            </div>
            <p>Olá, Usuário</p>
        </div>
        <div>
            <img class="burguer" src="./img/burguer.png" id="btn">
            <ul class="nav" id="nav">
                <a href="home">Home</a>
                <a href="cadastro-gasto">Cadastro de Gastos</a>
                <a href="cadastro-formaPagamento">Cadastro de forma de pagamento</a>
            </ul>
        </div>
    </header>
    <main>
        <h3>Gastos Recentes</h3>
    </main>    
    <ul>
        <li>
            <div class="column-center-fs">
                <h3>Titulo/Data</h3>
            </div>
            <div>
                <h3>Tipo Gasto</h3>
            </div>
            <div>
                <h3>Categoria do Gasto</h3>
            </div>
            <div>
                <h3>Forma de Pagamento</h3>
            </div>
            <div>
                <h3>Valor</h3>
            </div>
        </li>
        <c:forEach items="${gastos }" var="g">
            <li class="li">
                <div class="column-center-fs">
                    <h4>${g.descricaoGasto}</h4>
                    <h4>${g.dataGasto}</h4>
                </div>
                <div>
                    <h4>${g.tipoGasto}</h4>
                </div>
                <div>
                    <h4>${g.categoriaGasto}</h4>
                </div>
                <div>
                    <h4>${g.formaPgto}</h4>
                </div>
                <div>
                    <h3>${g.valorGasto}</h3>
                </div>
            </li>
        </c:forEach>
    </ul>
    <script src="./javascript/animation.js"></script>
</body>
</html>