<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>チェッカマン</title>
</head>
<body>

	<!-- ヘッダ -->
	<header class="header">
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</header>

	<h1>診断ページ</h1>

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
	</table>

	<a href="/Checker_man/User_ResultServlet">診断結果へ</a>

	<!-- フッター -->
	<footer class="footer">
		<jsp:include page="/WEB-INF/jsp/footer.jsp" />
	</footer>

</body>
</html>