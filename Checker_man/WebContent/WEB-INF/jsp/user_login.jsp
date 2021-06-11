<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>チェッカマン</title>
<!-- CSSの読み込み -->
<link rel="stylesheet" href="/Checker_man/css/user_login.css">
<link rel="stylesheet" href="/Checker_man/css/user.css">
</head>
<body>

<div class="wrapper">

<header>
<!-- 共通のヘッダー -->
<jsp:include page="/WEB-INF/jsp/header.jsp"/>
</header>

<main>
	<a href="#" class="link1">管理者ログイン</a>
	<div class="ulogin-area">
		<h1>受講者ログイン</h1>
		<div class="ulogin-form">
			ユーザーID<input type="text" name="ID"><br>

		</div>
		<form method="POST" action="/Checker_man/User_LoginServlet">
			<div class="ulogin-form">
				パスワード<input type="password" name="PW"><br>
			</div>
			<input type ="submit" name="LOGIN" value="ログイン" class="login-bottan"><br>
		</form>
		<a href="" class="link2">新規登録はこちらから</a>
	</div>

</main>

<!-- 共通のフッター -->
<footer>
 <jsp:include page="/WEB-INF/jsp/footer.jsp"/>
 </footer>

</div>
</body>
</html>