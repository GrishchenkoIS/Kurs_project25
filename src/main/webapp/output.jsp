<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<header class="header container">
        <h1 class="header__name">Результаты вычислений</h1>
    </header>
    <div class="result container">
        <p class="result__text text"><strong>Размер ипотеки: </strong>${sizeMortgage}</p>
        <p class="result__text text"><strong>Первый взнос: </strong>${firstPay}</p>
        <p class="result__text text"><strong>Количество месяцев: </strong>${data}</p>
        <p class="result__text text"><strong>Валюта: </strong>${currency}</p>
        <p class="result__text text"><strong>Страховка: </strong>${strahovka}</p>
        <p class="result__text text"><strong>Цель кредита: </strong>${target}</p>
        <p class="result__result text">Ресультат: ${result}</p>
        <form action="${pageContext.request.contextPath}/index.jsp" class="result__form">
            <input type="submit" name="sign" value="Назад">
        </form> 
    </div>
</body>
</html>