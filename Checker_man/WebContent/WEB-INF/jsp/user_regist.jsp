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
		<div class="main">
			<p></p>
			<div class="regist-area">
				<h1>新規登録</h1>
				<form method="POST" action="/Checker_man/User_RegistServlet">
					<div class="regist-form">
						ユーザーID<input type="text" name="NAME" placeholder="ユーザーID入力"><br>
						パスワード<input type="password" id="password" name="PW" placeholder="パスワード入力"><br>
						パスワード確認<input type="password" id="password2" name="CH-PW" placeholder="再度パスワード入力">
					</div>
					<input type="checkbox" id="password-check">パスワードを表示する
					<input type="submit" name="REGIST" value="登録" onclick="submitbtn()">
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
		const pwd2 = document.getElementById('password2');
		const pwdCheck = document.getElementById('password-check');
		pwdCheck.addEventListener('change', function() {
			if (pwdCheck.checked) {
				pwd.setAttribute('type', 'text');
				pwd2.setAttribute('type', 'text');
			} else {
				pwd.setAttribute('type', 'password');
				pwd2.setAttribute('type', 'password');
			}
		}, false);


		'use strict';
			function submitbtn() {
		    // 「OK」ボタン押下時
		    if (confirm('登録しますか？')) {
		        alert('OK');
		    }
		    // 「キャンセル」ボタン押下時
		    else {
		         alert('キャンセル');
		    }
			}


		   /* function check() {
		        	if (!(pwd === pwd2))) {
		    			windows.alert("パスワードが一致していません");
		                     return false;
		        	}
		    } */

	</script>
</body>
</html>