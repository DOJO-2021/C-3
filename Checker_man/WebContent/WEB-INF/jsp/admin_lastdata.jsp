<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/Checker_man/css/admin_lastdata.css">
<link rel="stylesheet" href="/Checker_man/css/admin.css">
<title>チェッカマン</title>
</head>
<body>
<div class="wrapper">
</div>

<header>
<!-- 共通のヘッダー -->
<jsp:include page="/WEB-INF/jsp/header.jsp"/>
</header>

<main>
<h1>今までの受講者の健康状態</h1>

<!-- 月ごとの表 -->
<div class="result-table">

	<!-- ここにresultListをグルグル表示させる -->
	<c:forEach var="e" items="${resultList}">
	</c:forEach>



	<table class="table-test" border="1" style="border-collapse: collapse">
		<tr bgcolor="#B0D6DA">
			<td></td>
			<th>〇</th>
			<th>△</th>
			<th>×</th>
		</tr>

		<!-- 日付と結果だけ繰り返しの処理 -->
		<c:forEach var="e" items="${resultList}">
		<tr>
			<th bgcolor="#B0D6DA">${e.date_dis}</th>
			<td bgcolor="#ECECEC">${e.maru_number}</td>
			<td bgcolor="ECECEC">${e.sankaku_number}</td>
			<td bgcolor="ECECEC">${e.batsu_number}</td>
		</tr>
		</c:forEach>
	</table>

</div>

<div class="clear"></div>

</main>

<!-- 共通のフッター -->
<footer>
 <jsp:include page="/WEB-INF/jsp/footer.jsp"/>
 </footer>


</body>
</html>