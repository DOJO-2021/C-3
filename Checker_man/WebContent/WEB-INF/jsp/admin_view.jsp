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
		<p>閲覧ページ</p>

		<!-- 個人名表示 -->
		<h1>
			<a id="name">名前</a>
		</h1>

		<!-- 質問内容と回答 -->
		<p>質問内容</p>
		<table class="question">
			<tr>
				<th>問1</th>
				<th>よく眠れなかった</th>
				<td>(回答を表示)</td>
			</tr>
			<tr>
				<th>問2</th>
				<th>食欲があまりない</th>
				<td>(回答を表示)</td>
			</tr>
			<tr>
				<th>問3</th>
				<th>不安に感じることがある</th>
				<td>(回答を表示)</td>
			</tr>
			<tr>
				<th>問4</th>
				<th>倦怠感がある</th>
				<td>(回答を表示)</td>
			</tr>
			<tr>
				<th>問5</th>
				<th>周囲とのコミュニケーションが取れていないと感じる</th>
				<td>(回答を表示)</td>
			</tr>
			<tr>
				<th>問6</th>
				<th>研修への充実感が少ないと感じる</th>
				<td>(回答を表示)</td>
			</tr>
			<tr>
				<th>問7</th>
				<th>腹痛、頭痛などがある</th>
				<td>(回答を表示)</td>
			</tr>
			<tr>
				<th>問7</th>
				<th>腹痛、頭痛などがある</th>
				<td>(回答を表示)</td>
			</tr>
			<tr>
				<th>問8</th>
				<th>イライラをすることが増えたと感じる</th>
				<td>(回答を表示)</td>
			</tr>
			<tr>
				<th>問9</th>
				<th>リラックス、息抜きなどが取れていない</th>
				<td>(回答を表示)</td>
			</tr>
			<tr>
				<th>問10</th>
				<th>適度な運動をしていない</th>
				<td>(回答を表示)</td>
			</tr>
			<tr>
				<th>問11</th>
				<th>辛いと感じることがある</th>
				<td>(回答を表示)</td>
			</tr>
			<tr>
				<th>問12</th>
				<th>目が疲れている</th>
				<td>(回答を表示)</td>
			</tr>
			<tr>
				<th>問13</th>
				<th>水分補給をあまりしていない</th>
				<td>(回答を表示)</td>
			</tr>
			<tr>
				<th>問14</th>
				<th>作業環境が不適切()明るさ、温度など)</th>
				<td>(回答を表示)</td>
			</tr>
			<tr>
				<th>問15</th>
				<th>研修内容についていけていないと感じる</th>
				<td>(回答を表示)</td>
			</tr>
		</table>

		<!-- 診断結果 -->
		<p>診断結果</p>
		<table class="result">
			<tr>
				<td>調子よさそうだね！！</td>
			</tr>
		</table>

		<!-- 受講者コメント(閲覧用) -->
		<form method="POST">
			<div>
				受講者コメント<br>
				<textarea readonly name="comment">閲覧専用</textarea>
			</div>
		</form>

		<!-- 管理者コメント(書き込み可能) -->
		<form method="POST">
			<div>
				管理者コメント<br>
				<textarea name="comment" action=""></textarea>
				<input type="submit" name="submit" value="書き込む">
			</div>

		</form>

		<!-- 画面上部に戻るボタン -->
		<div class="top">
			<a href="#name">画面上部に移動する</a>
		</div>

		<!-- トップページに戻るボタン -->
		<div class="toppage">
			<a href="/Checker_man/Admin_TopPageServlet">トップページに戻る</a>
		</div>

		<!-- フッター -->
		<footer class="footer">
			<jsp:include page="/WEB-INF/jsp/footer.jsp" />
		</footer>

	</div>
</body>
</html>