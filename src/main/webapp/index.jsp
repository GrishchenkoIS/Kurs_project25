<%@ page language="java" contentType="text/html; charset=Cp1251"
    pageEncoding="Cp1251"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Ипотечный калькулятор для юридических лиц</title>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

    <header class="header container" >
    <form action="${pageContext.request.contextPath}/JavaExit" method="post" class="header__admin">
            ${admin}
        </form>
        
        
        
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
                    <option value="dollar">Доллар</option>
                    <option value="rub">Рубль</option>
                    <option value="euro">Евро</option>
                </select>
                <label for="" class="main__text"> Страховка </label>
                <select name="strahovka" id="strahovka" value="${strahovka}">
                    <option value="No">Нет</option>
                    <option value="Exist">Есть</option>
                </select>
                <label for="" class="main__text"> Цель кредита </label>
                <select name="target" id="target" value="${target}">
                    <option value="ready house">Готовое жилье</option>
                    <option value="new house">Новостройка</option>
                    <option value="commercial">Коммерческая</option>
                </select>
                <input type="submit" name="sign" value="Рассчитать" class="main__submit">
            </div>
        </form>
    </div>
    <div class="changes container" >
        <div class="changes__changes">
        	<p style = "color:red">${incChanges}</p>
            <form action="${pageContext.request.contextPath}/JavaToChange" method="post" class="changes__form">
           		${changes}
            </form>
        </div>
    </div>
    
</body>
</html>