<%@ page language="java" contentType="text/html; charset=Cp1251"
    pageEncoding="Cp1251"%>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>јвторизаци€</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<header class="header container">
        <h1 class="header__name">јвторизаци€</h1>
    </header>
    <div class="main">
        <form action="${pageContext.request.contextPath}/JavaAdmin" method="post" class="main__forms">
            <div class="login__form">
                <label for="login" class="main__text"> ¬ведите логин: </label>
                <input type="text" name="login" id="login" value="${login}" class="main__input">
                <label for="password" class="main__text"> ¬ведите пароль: </label>
                <input type="text" name="password" id="password" value="${password}" class="main__input">
                <input type="submit" name="sign" value="¬вод" class="main__submit">
            </div>
        </form>
        <h2 class="header__incorrect" >${incorrect}</h2>
    </div>
</body>
</html>