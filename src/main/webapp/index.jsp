<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ипотечный калькулятор для юридических лиц</title>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <header class="header container">
        <h1 class="header__name">Ипотечный калькулятор для юридических лиц</h1>
    </header>
    <div class="main">
        <form action="${pageContext.request.contextPath}/JavaCalc" method="post" class="main__forms">
            <div class="main__form">
                <label for="size" class="main__text"> Размер ипотеки: </label>
                <input type="text" name="sizeMortgage" id="sizeMortgage" value="${sizeMortgage}" class="main__input">
                <label for="firstPay" class="main__text"> Первый взнос: </label>
                <input type="text" name="firstPay" id="firstPay" value="${firstPay}" class="main__input">
                <label for="data" class="main__text"> Количество месяцев: </label>
                <input  type="text" name="data" id="data" value="${data}" class="main__input">
                <label for="" class="main__text"> Валюта </label>
                <select name="currency" id="currency" value="${currency}">
                    <option value="dollar">доллар</option>
                    <option value="rub">рубль</option>
                    <option value="euro">евро</option>
                </select>
                <label for="" class="main__text"> Страховка </label>
                <select name="strahovka" id="strahovka" value="${strahovka}">
                    <option value="dollar">нет</option>
                    <option value="rub">есть</option>
                </select>
                <label for="" class="main__text"> Цель кредита </label>
                <select name="target" id="target" value="${target}">
                    <option value="ready houese">Готовое жилье</option>
                    <option value="new house">Новостройка</option>
                    <option value="commercial">Коммерческая</option>
                </select>
                <input type="submit" name="sign" value="Расчитать" class="main__submit">
            </div>
        </form>
    </div>
</body>
</html>