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

	<div class="box1">受講者ページ</div>

	 <!-- メイン -->
	 <main>
	 	<h1>診断結果</h1>


	 <form method="POST" action="/Checker_man/User_ResultServlet">
	 	<h2> ${resultList.icon_path}</h2>
	 </form>


	<div class = "answer_notes">
		<p>1=当てはまらない　2=やや当てはまらない　 3=どちらともいえない　 4=やや当てはまる　 5=当てはまる </p>
	</div>
		<!-- 質問内容と回答 -->
		<div class = user_result>
	 		<div class = user_result2>
				<c:forEach var="e" items="${questionList}" >
					<form method="POST" action="/Checker_man/User_ResultServlet">
					<table class = "question_table">
						<tr>
							<td width ="150">${e.question}</td>
						</tr>
					</table>
				 	</form>
				</c:forEach>
			</div>


			<div class = user_result3>
				<c:forEach var="e" items="${answerList}" >
					<form method="POST" action="/Checker_man/User_ResultServlet">
					<table class = "answer_table">
					 	<tr>
							<td width = "50" >${e.answer}</td>
					 	</tr>
					 </table>
				 	</form>
				</c:forEach>
			</div>
		</div>
	 	<!-- コメント欄 -->
	 	<div class = "message">
			 	<p>受講者のコメント</p>

			 <form method="POST" action="/Checker_man/User_ResultServlet">
				<textarea class = "user_message" rows="10" cols="100" name="user_message">${resultList.user_comment}</textarea>
				<input type="hidden" name="user_id" value="${result.user_id}">
				<div class = "botton">
					<div class = "regist">
						<input type="submit" name="regist" value="コメント登録"><br>
					</div>
				</div>
			</form>



	 		<p>講師からのコメント</p>
			<form method="POST" action="/Checker_man/User_ResultServlet">
				<textarea class = "admin_message" rows="10" cols="100" readonly name="admin_message">${resultList.admin_comment}</textarea>
			</form>
		</div>



		<div class = "return">
			<a href="/Checker_man/User_TopPageServlet">トップへ戻る</a>
		</div>

	</main>


	<!-- フッター -->
	<footer class="footer">
		<jsp:include page="/WEB-INF/jsp/footer.jsp"/>
	</footer>


	</div>
</body>
</html>