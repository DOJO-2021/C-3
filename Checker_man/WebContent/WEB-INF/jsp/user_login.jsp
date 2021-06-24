<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<!-- 共通のヘッダーは「ログアウト」や「トップページに戻る」が入っているのでロゴのみを挿入 -->
			<h1 class="keyvisual">
				<img src="/Checker_man/images/header.png">
			</h1>
		</header>

		<div class="main">
			<p></p>
			<div class="link1-button">
				<a href="/Checker_man/Admin_LoginServlet" class="link1">管理者ログイン</a>
			</div>
			<div class="ulogin-area">
				<h1>受講者ログイン</h1>

				<div class="ulogin-subarea">
				<form method="POST" action="/Checker_man/User_LoginServlet">

					<div class="ulogin-form">
						ユーザー名　<input type="text" name="ID" placeholder="ユーザー名"><br>
					</div>

					<div class="ulogin-form">
						パスワード　<input type="password" id="password" name="PW"
							placeholder="パスワード"><br>
					</div>

					<input type="checkbox" id="password-check"> パスワードを表示する <input
						type="submit" name="LOGIN" value="ログイン" class="login-bottan"><br>
				</form>

				<a href="User_RegistServlet" class="link2">新規登録はこちらから</a>

				</div>
			</div>

			<!-- エラーメッセージ -->
			<div class="errormsg">
				<p>
					<c:out value="${result.message}" />
				</p>
			</div>


		</div>

		<!-- 共通のフッター -->
		<footer>
			<jsp:include page="/WEB-INF/jsp/footer.jsp" />
		</footer>

	</div>

	<script>
		const pwd = document.getElementById('password');
		const pwdCheck = document.getElementById('password-check');
		pwdCheck.addEventListener('change', function() {
			if (pwdCheck.checked) {
				pwd.setAttribute('type', 'text');
			} else {
				pwd.setAttribute('type', 'password');
			}
		}, false);
	</script>

</body>
</html>