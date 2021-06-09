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
	<h1>名前</h1>
	<p>質問内容</p>
	<table id="question">
		<tr><td>問1　よく眠れなかった</td></tr>
		<tr><td>問2　食欲があまりない</td></tr>
		<tr><td>問3　不安に感じることがある</td></tr>
		<tr><td>問4　倦怠感がある</td></tr>
		<tr><td>問5　周囲とのコミュニケーションが取れていないと感じる</td></tr>
		<tr><td>問6　研修への充実感が少ないと感じる</td></tr>
		<tr><td>問7　腹痛、頭痛などがある</td></tr>
		<tr><td>問7　腹痛、頭痛などがある</td></tr>
		<tr><td>問8　イライラをすることが増えたと感じる</td></tr>
		<tr><td>問9　リラックス、息抜きなどが取れていない</td></tr>
		<tr><td>問10　適度な運動をしていない</td></tr>
		<tr><td>問11　辛いと感じることがある</td></tr>
		<tr><td>問12　目が疲れている</td></tr>
		<tr><td>問13　水分補給をあまりしていない</td></tr>
		<tr><td>問14　作業環境が不適切（明るさ、温度など）</td></tr>
		<tr><td>問15　研修内容についていけていないと感じる</td></tr>
	</table>
	<p>回答</p>
	<table class="answer">
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
	<p>診断結果</p>
	<table class="result">
	<tr><td>調子よさそうだね！！</td></tr>
	</table>

	<table class="u_comment">
	<tr><td>閲覧のみ</td></tr>
	</table>


	<!-- フッター -->
	<footer class="footer">
		<jsp:include page="/WEB-INF/jsp/footer.jsp" />
	</footer>
</body>
</html>