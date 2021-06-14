<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<a id=html></a>
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
	<div class = "wrapper">

	<!-- ヘッダ -->
	<header class="header">
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</header>

	<p class="box1">閲覧ページ</p>

	<!-- 個人名表示 -->
	<pre class="name">
		<h1>名前</h1>

		</pre>

	<!-- 質問内容と回答 -->
	<h2>質問内容</h2>
	<table class="question">
		<tr>
	 		<th>（問1　よく眠れなかった）</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 		<tr>
	 		<th>（問2　食欲があまりない）</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 		<tr>
	 		<th>（問3　不安に感じることがある）</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 		<tr>
	 		<th>（問4　倦怠感がある）</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 		<tr>
	 		<th>（問5　周囲とのコミュニケーションが取れていないと感じる）</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 		<tr>
	 		<th>（問6　研修への充実感が少ないと感じる）</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 		<tr>
	 		<th>（問7　腹痛、頭痛などがある）</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 		<tr>
	 		<th>（問8　イライラをすることが増えたと感じる）</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 		<tr>
	 		<th>（問9　リラックス、息抜きなどが取れていない）</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 		<tr>
	 		<th>（問10　適度な運動をしていない）</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 		<tr>
	 		<th>（問11　辛いと感じることがある）</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 		<tr>
	 		<th>（問12　目が疲れている）</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 		<tr>
	 		<th>（問13　水分補給をあまりしていない）</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 		<tr>
	 		<th>（問14　作業環境が不適切（明るさ、温度など））</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 		<tr>
	 		<th>（問15　研修内容についていけていないと感じる）</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 	</table>
	<!-- 診断結果 -->
	<h2>診断結果</h2>
	<form method="POST">
		<div class="result">
			<textarea readonly name="result">
		調子よさそうだね！!
		</textarea>
		</div>
	</form>
	<!-- 受講者コメント(閲覧用) -->
	<form method="POST">
		<div class="u_comment">
			受講者コメント<br>
			<textarea readonly name="comment">閲覧専用</textarea>
		</div>
	</form>

	<!-- 管理者コメント(書き込み可能) -->
	<form method="POST">
		<div class="a_comment">
			管理者コメント<br>
			<textarea name="comment" action=""></textarea>
			<br> <input type="submit" name="submit" value="書き込む">
		</div>

	</form>

	<!-- 画面上部に戻るボタン -->
	<div class="top">
		<a href="#html">画面上部に移動する</a>
	</div>

	<!-- トップページに戻るボタン -->
	<div class="toppage">
		<a href="/Checker_man/Admin_TopPageServlet">トップページに戻る</a>
	</div>

	<!-- フッター -->
	<footer class="footer">
		<jsp:include page="/WEB-INF/jsp/footer.jsp" />
	</footer>

</body>
</html>