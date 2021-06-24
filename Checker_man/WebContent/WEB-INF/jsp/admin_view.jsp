<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<!-- タイトル -->
<title>管理者閲覧ページ</title>

<!-- CSSのURL -->
<link rel="stylesheet" href="/Checker_man/css/admin_view.css">
<link rel="stylesheet" href="/Checker_man/css/admin.css">

</head>

<body>
	<!-- 全体 -->
	<div class="wrapper">

		<!-- ヘッダ -->
		<header class="header">
			<jsp:include page="/WEB-INF/jsp/admin_header.jsp" />
		</header>

		<div class="box1">閲覧ページ</div>
		<main>
		<p></p>
			<!-- 個人名表示 -->

		<h2>
				<c:out value="${result.user_name}"></c:out>
		</h2>

			<h3>＜診断結果＞</h3>
			<form method="POST" action="/Checker_man/User_ResultServlet">
				<h3>${resultList.icon_path}</h3>
			</form>


			<!-- 質問内容 -->
			<div class="result">
				<div class="result2">
					<c:forEach var="e" items="${questionList}">
						<form method="POST" action="/Checker_man/User_ResultServlet">
							<table class="question_table">
								<tr>
									<td><input type="text" size = 50 readonly name="QUESTION" value="${e.question}"></td>
								</tr>
							</table>
						</form>
					</c:forEach>
				</div>

				<!-- 回答 -->
				<div class="result3">
					<c:forEach var="e" items="${answerList}">
						<form method="POST" action="/Checker_man/User_ResultServlet">
							<table class="answer_table">
								<tr>
									<td><input type="text" size = 10 readonly name="ANSWER" value="${e.answer}"></td>
								</tr>
							</table>
						</form>
					</c:forEach>
				</div>
			</div>

			<!-- 受講者コメント(閲覧用) -->
			<div class="comment">
				<p>受講者コメント</p>
				<form method="POST" action="/Checker_man/User_ResultServlet">
					<textarea rows="10" cols="100" readonly name="user_message">${resultList.user_comment}</textarea>
				</form>
			</div>

			<!-- 管理者コメント(書き込み可能) -->
			<div class="comment">
				<p>管理者コメント</p>
				<form method="POST" action="/Checker_man/Admin_ViewServlet">
					<textarea rows="10" cols="100" name="admin_message">${resultList.admin_comment}</textarea>
					<input type="hidden" name="user_id" value="${result.user_id}">
					<div class="botton">
						<div class="regist">
							<input type="submit" name="regist" class = "button" value="コメント登録"><br>
						</div>
					</div>
				</form>
			</div>

			<!-- 画面上部に戻るボタン -->
			<button id="topScroll" class="topScroll"></button>


			<!-- トップページに戻るボタン -->
			<div class="toppage">
				<a href="/Checker_man/Admin_TopPageServlet" class="btn">トップページに戻る</a>
			</div>

		</main>

	</div>



	<!-- フッター -->
	<footer class="footer">
		<jsp:include page="/WEB-INF/jsp/footer.jsp" />
	</footer>

	<script>
	const topScrollBtn = document.querySelector('#topScroll');
	topScrollBtn.addEventListener('click', () => {
	  window.scrollTo({
	    top: 0,
	    behavior: "smooth"
	  });
	});
	</script>

</body>
</html>