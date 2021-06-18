<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>チェッカマン</title>
<link rel="stylesheet" href="/Checker_man/css/user_regist.css">
<link rel="stylesheet" href="/Checker_man/css/user.css">
</head>
<body>

	<div class="wrapper">
		<!-- 共通のヘッダーは「ログアウト」や「トップページに戻る」が入っているのでロゴのみを挿入 -->
		<header>
			<h1 class="keyvisual">
				<img src="/Checker_man/images/header.png">
			</h1>
		</header>

		<div class ="main">
		<p></p>
			<div class="regist-area">
				<h1>新規登録</h1>
				<form method="POST" action="/Checker_man/User_RegistServlet">
					<div class="regist-form">
						ユーザーID<input type="text" name="NAME" placeholder="ユーザーID入力"><br>
						パスワード<input type="password" name="PW" placeholder="パスワード入力"><br>
						パスワード確認<input type="password" name="CH-PW" placeholder="再度パスワード入力">
					</div>
					<input type="checkbox" id="password-check">
					パスワードを表示する
					<input type="submit" name="REGIST" value="登録">
					<a href="User_LoginServlet">戻る</a>
				</form>
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