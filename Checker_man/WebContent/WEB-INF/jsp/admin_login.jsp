<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>チェッカマン</title>
<link rel="stylesheet" href="/Checker_man/css/admin_login.css">
<link rel="stylesheet" href="/Checker_man/css/admin.css">
</head>
<body>

<div class="wrapper">

<header>
<!-- 共通のヘッダー -->
<jsp:include page="/WEB-INF/jsp/header.jsp"/>
</header>

<div class ="main">
	<p></p>
	<div class = "link3-button">
		<a href="/Checker_man/User_LoginServlet" class="link3">受講者ログイン</a>
	</div>
		<div class="alogin-area">
		<h1>管理者ログイン</h1>
		<form method="POST" action="/Checker_man/Admin_LoginServlet">
			<div class="alogin-form">
					ユーザーID<input type="text" name="ID"  placeholder="ユーザーID"><br>
			</div>
			<div class="alogin-form">
				パスワード<input type="password" id="password" name="PW" placeholder="パスワード"><br>
			</div>
			<input type="checkbox" id="password-check">
			パスワードを表示する
			<input type ="submit" name="LOGIN" value="ログイン" class="alogin-bottan" >
		</form>
	</div>
	<!-- エラーメッセージ -->
	<div class = "errormsg">
		<p><c:out value="${result.message}" /></p>	</div>
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