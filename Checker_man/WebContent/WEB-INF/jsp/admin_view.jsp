<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<!-- タイトル -->
<title>チェッカマン</title>

<!-- CSSのURL -->
<link rel="stylesheet" href="/Checker_man/css/admin_view.css">
<link rel="stylesheet" href="/Checker_man/css/admin.css">

</head>

<body>
	<!-- 全体 -->
	<div class="wrapper">

		<!-- ヘッダ -->
		<header class="header">
			<jsp:include page="/WEB-INF/jsp/header.jsp" />
		</header>

		<div class="box1">閲覧ページ</div>

		<!-- 個人名表示 -->
		<pre class="name">
		<h1>
				<c:out value="${user_names}"></c:out>
			</h1>

		</pre>
		<h2>診断結果</h2>
		<form method="POST" action="/Checker_man/User_ResultServlet">
			<h2>${resultList.icon_path}</h2>
		</form>


		<!-- 質問内容 -->
		<div class="result">
			<div class=user_result>
				<c:forEach var="e" items="${questionList}">
					<form method="POST" action="/Checker_man/User_ResultServlet">
						<table class="user_result2">
							<tr>
								<td><input type="text" readonly name="QUESTION"
									value="${e.question}"></td>
							</tr>
						</table>
					</form>
				</c:forEach>

				<!-- 回答 -->
				<c:forEach var="e" items="${answerList}">
					<form method="POST" action="/Checker_man/User_ResultServlet">
						<table class="user_result2">
							<tr>
								<td><input type="text" readonly name="ANSWER"
									value="${e.answer}"></td>
							</tr>
						</table>
					</form>
				</c:forEach>
			</div>
		</div>

		<!-- 受講者コメント(閲覧用) -->
		<div class="u_comment">
			<p>受講者コメント</p>
			<form method="POST" action="/Checker_man/User_ResultServlet">
				<textarea rows="10" cols="100" readonly name="user_message">${resultList.user_comment}</textarea>
			</form>
		</div>

		<!-- 管理者コメント(書き込み可能) -->
		<div class="a_comment">
			<p>管理者コメント</p>
			<form method="POST" action="/Checker_man/Admin_ViewServlet">
				<textarea rows="10" cols="100" name="admin_message">${resultList.admin_comment}</textarea>
				<div class="botton">
					<div class="regist">
						<input type="submit" name="regist" value="コメント登録"><br>
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