<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>チェッカマン</title>
</head>
<body>

	<!-- ヘッダー -->
	<header class="header">
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</header>

	<h1>診断ページ</h1>

	質問項目に合わせてチェックを入れてください

	<form action="#" method="post">
		<input type="checkbox" name="sindan" value="5"
			style="width: 58px; height: 57px">
	</form>
	<!-- ここから診断テーブル -->
	<table>
		<tr>
			<td>No</td>
			<td>質問事項</td>
			<td>当てはまらない</td>
			<td>やや当てはまらない</td>
			<td>どちらともいえない</td>
			<td>やや当てはまる</td>
			<td>当てはまる</td>
		</tr>
		<tr>
			<td>1</td>
			<td>
				<!-- ここに質問項目 -->
			</td>
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
			<td></td>
		</tr>
	</table>
	<!-- 診断テーブルここまで -->

	<br>
	<a href="/Checker_man/User_ResultServlet">診断結果へ</a>

	<!-- フッター -->
	<footer class="footer">
		<jsp:include page="/WEB-INF/jsp/footer.jsp" />
	</footer>

</body>
</html>