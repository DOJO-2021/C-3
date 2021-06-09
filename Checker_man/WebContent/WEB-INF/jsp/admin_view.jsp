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
		<p>閲覧ページ</p>
	</header>
	<h1><a id="title">名前</a></h1>
	<div class="QA">
	<p>質問内容</p>
	<table class="question">
		<tr><td>問1 よく眠れなかった</td></tr>
		<tr><td>問2 食欲があまりない</td></tr>
		<tr><td>問3 不安に感じることがある</td></tr>
		<tr><td>問4 倦怠感がある</td></tr>
		<tr><td>問5 周囲とのコミュニケーションが取れていないと感じる</td></tr>
		<tr><td>問6 研修への充実感が少ないと感じる</td></tr>
		<tr><td>問7 腹痛、頭痛などがある</td></tr>
		<tr><td>問7 腹痛、頭痛などがある</td></tr>
		<tr><td>問8 イライラをすることが増えたと感じる</td></tr>
		<tr><td>問9 リラックス、息抜きなどが取れていない</td></tr>
		<tr><td>問10 適度な運動をしていない</td></tr>
		<tr><td>問11 辛いと感じることがある</td></tr>
		<tr><td>問12 目が疲れている</td></tr>
		<tr><td>問13 水分補給をあまりしていない</td></tr>
		<tr><td>問14 作業環境が不適切（明るさ、温度など）</td></tr>
		<tr><td>問15 研修内容についていけていないと感じる</td></tr>
	</table>

	<table class="answer">
	<tr><td>回答</td></tr>
		<tr><td>3</td></tr>
		<tr><td>2</td></tr>
		<tr><td>2</td></tr>
		<tr><td>2</td></tr>
		<tr><td>3</td></tr>
		<tr><td>1</td></tr>
		<tr><td>1</td></tr>
		<tr><td>1</td></tr>
		<tr><td>1</td></tr>
		<tr><td>1</td></tr>
		<tr><td>1</td></tr>
		<tr><td>1</td></tr>
		<tr><td>1</td></tr>
		<tr><td>1</td></tr>
		<tr><td>2</td></tr>
	</table>
	</div>
	<p>診断結果</p>
	<table class="result">
		<tr><td>調子よさそうだね！！</td></tr>
	</table>
	<div>
		受講者コメント
	<form method="POST">
    <textarea readonly name="comment">閲覧専用</textarea><br>
    </form>
    </div>
	<form method="POST">
	<div>
		管理者コメント<br>
		<textarea name="comment" action=""></textarea>
		<input type="submit" name="submit" value="書き込む">
	</div>

	</form>
	<a href="#title">画面上部に移動する</a>
	<nav class="nav">
<a href="/Checker_man/Admin_TopPageServlet">トップページに戻る</a>
	</nav>
	<!-- フッター -->
	<footer class="footer">
		<jsp:include page="/WEB-INF/jsp/footer.jsp" />
	</footer>
</body>
</html>