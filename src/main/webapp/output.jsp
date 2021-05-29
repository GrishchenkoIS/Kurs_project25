<%@ page language="java" contentType="text/html; charset=Cp1251"
    pageEncoding="Cp1251"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="Cp1251">
	<title>Ипотечный калькулятор для юридических лиц</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<header class="header container">
        <h1 class="header__name">Результаты вычислений</h1>
    </header>
    <div class="result container">
        <p class="result__text text"><strong>Размер ипотеки: </strong>${first_result}</p>
        <p class="result__text text"><strong>Первый взнос: </strong>${second_result}</p>
        <p class="result__text text"><strong>Количество месяцев: </strong>${data_result}</p>
        <p class="result__text text"><strong>Валюта: </strong>${currency_result}</p>
        <p class="result__text text"><strong>Страховка: </strong>${strahovka_result}</p>
        <p class="result__text text"><strong>Цель кредита: </strong>${target_result}</p>
        <p class="result__result text">Ресультат: ${result} ${currency_for_result}</p>
        <form action="${pageContext.request.contextPath}/Back" method="post" class="result__form">
            <input type="submit" name="sign" value="Назад">
        </form> 
        <a href="Check.pdf"> Открыть PDF-файл</a>
		<a href="Check.pdf" download> Скачать PDF-файл</a>
    </div>
</body>
</html>