<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/Checker_man/css/admin_lastdata.css">
<link rel="stylesheet" href="/Checker_man/css/admin.css">
<title>チェッカマン</title>
</head>
<body>



<header>
<!-- 共通のヘッダー -->
<jsp:include page="/WEB-INF/jsp/header.jsp"/>
</header>

<main>
<h1>今までの受講者の健康状態</h1>

<!-- 月ごとの表 -->
<div class="result-table">
	<div class="table4">
		<h2>4月</h2>
		<table class="a4month" border="1" style="border-collapse: collapse" >
			<tr>
				<td></td>
				<td>〇</td>
				<td>△</td>
				<td>×</td>
		  	</tr>

			<tr>
				<td>1日</td>
				<td>12</td>
				<td>3</td>
				<td>1</td>
			</tr>
			<tr>
				<td>2日</td>
				<td>12</td>
				<td>3</td>
				<td>1</td>
			</tr>
			<tr>
				<td>2日</td>
				<td>12</td>
				<td>3</td>
				<td>1</td>
			</tr>

		</table>
	</div>

	<div class="table5">
		<h2>5月</h2>
		<table class="a5month" border="1" style="border-collapse: collapse" >
			<tr>
				<td></td>
				<td>〇</td>
				<td>△</td>
				<td>×</td>
	  		</tr>

			<tr>
				<td>1日</td>
				<td>12</td>
				<td>3</td>
				<td>1</td>
			</tr>
			<tr>
				<td>2日</td>
				<td>12</td>
				<td>3</td>
				<td>1</td>
			</tr>
			<tr>
				<td>2日</td>
				<td>12</td>
				<td>3</td>
				<td>1</td>
			</tr>

		</table>
	</div>

	<div class="table6">
		<h2>6月</h2>
		<table class="a6month" border="1" style="border-collapse: collapse" >
			<tr>
				<td></td>
				<td>〇</td>
				<td>△</td>
				<td>×</td>
		  	</tr>

			<tr>
				<td>1日</td>
				<td>12</td>
				<td>3</td>
				<td>1</td>
			</tr>
			<tr>
				<td>2日</td>
				<td>12</td>
				<td>3</td>
				<td>1</td>
			</tr>
			<tr>
				<td>2日</td>
				<td>12</td>
				<td>3</td>
				<td>1</td>
			</tr>
		</table>
	</div>

</div>

</main>

<!-- 共通のフッター -->
<footer>
 <jsp:include page="/WEB-INF/jsp/footer.jsp"/>
 </footer>
<div class="wrapper">
</div>
</body>
</html>