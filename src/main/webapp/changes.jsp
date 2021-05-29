<%@ page language="java" contentType="text/html; charset=Cp1251"
    pageEncoding="Cp1251"%>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Изменение ставки</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<header class="header container">
        <h1 class="header__name">Измена ставки по кредиту</h1>
    </header>
    <div class="main">
        <form action="${pageContext.request.contextPath}/JavaChange" method="post" class="main__forms">
            <div class="main__form">
                <label for="size" class="main__text"> Новая ставка готового жилья (${stavkaRH}) : </label>
                <input type="text" name="StReadyHouse" id="StReadyHouse" value="${StReadyHouse}" class="main__input">
                <label for="size" class="main__text"> Новая ставка новостройки (${stavkaNH}) : </label>
                <input type="text" name="StNewHouse" id="StNewHouse" value="${StNewHouse}" class="main__input">
                <label for="size" class="main__text"> Новая ставка коммерческая (${stavkaC}) : </label>
                <input type="text" name="StComercial" id="StComercial" value="${StComercial}" class="main__input">
                <input type="submit" name="sign" value="Ввод" class="main__submit">
            </div>
        </form>
    </div>
</body>
</html>