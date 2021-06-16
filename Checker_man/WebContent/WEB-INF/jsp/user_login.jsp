<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<div class = "main">
	<p></p>
	<div class = "link1-button">
		<a href="/Checker_man/Admin_LoginServlet" class = "link1">管理者ログイン</a>
	</div>
	<div class="ulogin-area">
		<h1>受講者ログイン</h1>
		<form method="POST" action="/Checker_man/User_LoginServlet">
			<div class="ulogin-form">
					ユーザーID<input type="text" name="ID" placeholder="ユーザーID"><br>
			</div>
			<!--
			<form method="POST" action="/Checker_man/User_LoginServlet">
			-->
					<div class="ulogin-form">
						パスワード<input type="password" id="password" name="PW" placeholder="パスワード"><br>
					</div>
					<input type="checkbox" id="password-check">
					パスワードを表示する
					<input type ="submit" name="LOGIN" value="ログイン" class="login-bottan"><br>
		</form>

		<a href="" class="link2">新規登録はこちらから</a>
	</div>

	<!-- エラーメッセージ -->
	<div class = "errormsg">
		<p><c:out value="${result.message}" /></p>
	</div>


</div>

<!-- 共通のフッター -->
<footer>
 <jsp:include page="/WEB-INF/jsp/footer.jsp"/>
 </footer>

</div>

<script>
 const pwd = document.getElementById('password');
 const pwdCheck = document.getElementById('password-check');
 pwdCheck.addEventListener('change', function() {
     if(pwdCheck.checked) {
         pwd.setAttribute('type', 'text');
     } else {
         pwd.setAttribute('type', 'password');
     }
 }, false);
 </script>

</body>
</html>