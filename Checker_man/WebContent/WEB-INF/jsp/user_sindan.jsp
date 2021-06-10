<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>チェッカマン</title>
</head>
<link rel="stylesheet" href="/Checker_man/css/user_sindan.css">
<body>

	<div class="wrapper">

		<!-- ヘッダー -->
		<header class="header">
			<jsp:include page="/WEB-INF/jsp/header.jsp" />
		</header>

		<!-- 見出し -->
		<h1>診断ページ</h1>

		質問項目に合わせてチェックを入れてください

		<!-- ここから診断テーブル -->
		<table>
			<tr>
				<td>質問事項</td>
				<td>当てはまらない</td>
				<td>やや当てはまらない</td>
				<td>どちらともいえない</td>
				<td>やや当てはまる</td>
				<td>当てはまる</td>
			</tr>
			<tr>
				<td>問1</td>
				<td><form action="#" method="post">
						<input type="checkbox" name="sindan" value="1">
					</form></td>
				<td><form action="#" method="post">
						<input type="checkbox" name="sindan" value="2">
					</form></td>
				<td><form action="#" method="post">
						<input type="checkbox" name="sindan" value="3">
					</form></td>
				<td><form action="#" method="post">
						<input type="checkbox" name="sindan" value="4">
					</form></td>
				<td><form action="#" method="post">
						<input type="checkbox" name="sindan" value="5">
					</form></td>
			</tr>
		</table>
		<!-- 診断テーブルここまで -->

		<br>

		<!-- 診断結果へのリンク -->
		<a href="/Checker_man/User_ResultServlet">診断結果へ</a>

		<!-- フッター -->
		<footer class="footer">
			<jsp:include page="/WEB-INF/jsp/footer.jsp" />
		</footer>

	</div>

</body>
</html>