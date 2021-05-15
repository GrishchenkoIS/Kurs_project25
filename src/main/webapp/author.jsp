<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Авторизация</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<header class="header container">
        <h1 class="header__name">Результаты вычислений</h1>
    </header>
    <div class="main">
        <form action="${pageContext.request.contextPath}/JavaAdmin" method="post" class="main__forms">
            <div class="login__form">
                <label for="login" class="main__text"> Введите логин: </label>
                <input type="text" name="login" id="login" value="${login}" class="main__input">
                <label for="password" class="main__text"> Введите пароль: </label>
                <input type="text" name="password" id="password" value="${password}" class="main__input">
                <input type="submit" name="sign" value="Ввод" class="main__submit">
            </div>
        </form>
    </div>
</body>
</html>