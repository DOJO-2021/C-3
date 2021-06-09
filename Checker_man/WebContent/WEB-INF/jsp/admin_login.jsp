<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>チェッカマン</title>
<link rel="stylesheet" href="/Checker_man/css/admin_login.css">
<link rel="stylesheet" href="/Checker_man/css/admin.css">
</head>
<body>

<header>
<!-- 共通のヘッダー -->
<jsp:include page="/WEB-INF/jsp/header.jsp"/>
<a href="" class="link3">受講者ログイン</a>
</header>

<main>
<div class="alogin-area">
	<h1>管理者ログイン</h1>
	<div class="alogin-form">
		ユーザーID<input type="text" name="ID"><br>
	</div>
	<div class="alogin-form">
		パスワード<input type="password" name="PW"><br>
	</div>
	<input type ="submit" name="LOGIN" value="ログイン" class="alogin-bottan" >

</div>

</main>

<!-- 共通のフッター -->
<footer>
 <jsp:include page="/WEB-INF/jsp/footer.jsp"/>
 </footer>


</body>
</html>