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

<header>
<!-- 共通のヘッダー -->
<jsp:include page="/WEB-INF/jsp/header.jsp"/>
</header>

<main>
<div class="regist-area">
	<h1>新規登録</h1>
	<div class="regist-form">
		ユーザーID<input type="text" name="ID"><br>
		パスワード<input type="password" name="PW">
		パスワード確認<input type="password" name="CH-PW">
	</div>
	<input type ="submit" name="REGIST" value="登録" >
	<a href="">戻る</a>
</div>
</main>

<!-- 共通のフッター -->
<footer>
 <jsp:include page="/WEB-INF/jsp/footer.jsp"/>
 </footer>


</body>
</html>