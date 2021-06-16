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

		<main>
			<div class="regist-area">
				<h1>新規登録</h1>
				<div class="regist-form">
					ユーザーID<input type="text" name="ID"><br> パスワード<input
						type="password" name="PW"><br> パスワード確認<input
						type="password" name="CH-PW">
				</div>
				<input type="submit" name="REGIST" value="登録"> <a href="">戻る</a>
			</div>
		</main>

		<!-- 共通のフッター -->
		<footer>
			<jsp:include page="/WEB-INF/jsp/footer.jsp" />
		</footer>

	</div>
</body>
</html>