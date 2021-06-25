<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
<link rel="stylesheet" href="/Checker_man/css/user_regist.css">
<link rel="stylesheet" href="/Checker_man/css/user.css">
<script>


	</script>
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


			<form method="POST" action="/Checker_man/User_RegistServlet" onSubmit="return check()">
				<div class="regist-area">
					<h1>新規登録</h1>


					<div class="regist-form">
						<div class="userid">
							ユーザー名　　　<input type="text" id="name" name="NAME" placeholder="ユーザー名入力"><br>
						</div>
						<div class="pw">
							パスワード　　　<input type="password" id="password" name="PW" placeholder="パスワード入力"><br>
						</div>
						<div class="chpw">
							パスワード確認　<input type="password" id="password2" name="CH-PW" placeholder="再度パスワード入力">
						</div>
					</div>
					<input type="checkbox" id="password-check">パスワードを表示する<br>

				</div>
				<input type="submit" name="REGIST" value="登録" class="regist">
				<!-- onclick="submitbtn()"-->
			</form>

			<div class="backmenu">
				<a href="User_LoginServlet">戻る</a>
			</div>

			<p></p>
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



		function check() {
			// ①ユーザーIDとパスワード１，パスワード２が入力されていること
			const name = document.getElementById('name');
			if (name.value == "" || pwd.value == "" || pwd2.value == "") {
				window.alert('ユーザー名とパスワード，パスワード確認を入力してください');
				return false;
			}

			// ②パスワード1とパスワード2が一致している場合はtrue、していない場合はfalseを返す
			if (pwd.value !== pwd2.value) {
				window.alert("パスワードが一致していません");
				return false;
			}
			// ③登録するかしないかの確認、はいを押した場合にtrueを返し、いいえの場合はfalseを押す
				    // 「OK」ボタン押下時
			if (window.confirm('登録しますか？')) {
				return true;
			}
			// 「キャンセル」ボタン押下時
			else {
				return false;
			}
		}

	</script>
</body>
</html>