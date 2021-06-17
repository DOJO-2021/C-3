<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>診断結果ページ</title>
<link rel="stylesheet" href="/Checker_man/css/user_result.css">
<link rel="stylesheet" href="/Checker_man/css/user.css">
</head>
<body>
	<div class = "wrapper">

	<!-- ヘッダー -->
	<header class="header">
		<jsp:include page="/WEB-INF/jsp/header.jsp"/>
	</header>

	 <!-- メイン -->
	 <main>
	 	<h1>診断結果</h1>



	 	<h2>（一言診断結果を表示）</h2>

		<!-- 質問内容と回答 -->
 		<div class = user_result>
			<c:forEach var="e" items="${questionList}" >
				<form method="POST" action="/Checker_man/User_ResultServlet">
				<table class = "user_result2">
					<tr>
					<td><input type="text" name="QUESTION" value="${e.question}"></td>
					</tr>
				</table>
			 	</form>
			</c:forEach>

			<c:forEach var="e" items="${answerList}" >
				<form method="POST" action="/Checker_man/User_ResultServlet">
				<table class = "user_result2">
				 	<tr>
				 	<td><input type="text" name="ANSWER" value="${e.answer}"></td>
				 	</tr>
				 </table>
			 	</form>
			</c:forEach>
		</div>
	 	<!-- コメント欄 -->
	 	<div class = "message">
		 	<div class = "user_message">
			 	<p>受講者のコメント</p>
			 	<textarea rows="10" cols="100" name="user_message">コメントする</textarea>
			</div>
		</div>
		<!-- コメント登録ボタン、トップへ戻るボタン -->
		<!--
		<form method="POST">
		-->
		<div class = "botton">
			<div class = "regist">
				<input type="submit" name="regist" value="コメント登録"><br>
			</div>
		</div>

			<div class = "admin_message">
		 		<p>講師からのコメント</p>
		 	</div>

		<form method="POST" action="/Checker_man/User_ResultServlet">
				<textarea rows="10" cols="100" readonly name="admin_message">${resultList.admin_comment}</textarea>
		</form>



			<div class = "return">
				<a href="/Checker_man/User_TopPageServlet">トップへ戻る</a>
			</div>

	</main>
	</div>


	<!-- フッター -->
	<footer class="footer">
		<jsp:include page="/WEB-INF/jsp/footer.jsp"/>
	</footer>


	</div>
</body>
</html>