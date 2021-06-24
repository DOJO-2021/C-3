<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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


	<!-- 管理者ページ共通のヘッダー -->
	<header class="header">
		<jsp:include page="/WEB-INF/jsp/admin_header.jsp" />
	</header>

	<main>
		<p></p>
		<h1>今までの受講者の健康状態</h1>

		<!-- 月ごとの表 -->
		<div class="result-table">

	<!-- 4月の表 -->
	<div class="lastdata_table">
		<table class="table-test4" border="1"
					style="border-collapse: collapse">
		<tr>
						<td width="50px">4月</td>
					</tr>
			<tr bgcolor="#B0D6DA">
				<td></td>
				<th width="50px">〇</th>
				<th width="50px">△</th>
				<th width="50px">×</th>
			</tr>

			<!-- 日付と結果だけ繰り返しの処理 -->
			<c:forEach var="e" items="${resultList4}">
			<tr>
				<th bgcolor="#B0D6DA">${e.date_dis}</th>
				<td bgcolor="#ECECEC">${e.maru_number}</td>
				<td bgcolor="ECECEC">${e.sankaku_number}</td>
				<td class="batsu" bgcolor="ECECEC">${e.batsu_number}</td>
			</tr>
			</c:forEach>
		</table>
	</div>

	<!-- 5月の表 -->
	<div class="lastdata_table">
		<table class="table-test5" border="1"
					style="border-collapse: collapse">
		<tr>
						<td width="50px">5月</td>
					</tr>
			<tr bgcolor="#B0D6DA">
				<td></td>
				<th width="50px">〇</th>
				<th width="50px">△</th>
				<th width="50px">×</th>
			</tr>

			<!-- 日付と結果だけ繰り返しの処理 -->
			<c:forEach var="e" items="${resultList5}">
			<tr>
				<th bgcolor="#B0D6DA">${e.date_dis}</th>
				<td bgcolor="#ECECEC">${e.maru_number}</td>
				<td bgcolor="ECECEC">${e.sankaku_number}</td>
				<td class="batsu" bgcolor="ECECEC">${e.batsu_number}</td>
			</tr>
			</c:forEach>
		</table>
	</div>


	<!-- 6月の表 -->
	<div class="lastdata_table">
		<table class="table-test6" border="1"
					style="border-collapse: collapse">
			<tr>
						<td width="50px">6月</td>
					</tr>
			<tr bgcolor="#B0D6DA">
				<td></td>
				<th width="50px">〇</th>
				<th width="50px">△</th>
				<th width="50px">×</th>
			</tr>

			<!-- 日付と結果だけ繰り返しの処理 -->
			<c:forEach var="e" items="${resultList6}">
			<tr>
				<th bgcolor="#B0D6DA">${e.date_dis}</th>
				<td bgcolor="#ECECEC">${e.maru_number}</td>
				<td bgcolor="ECECEC">${e.sankaku_number}</td>
				<td class="batsu" bgcolor="ECECEC">${e.batsu_number}</td>
			</tr>
			</c:forEach>
		</table>
	</div>

</div>

<div class="clear"></div>

</main>

<!-- 共通のフッター -->
<footer>
 <jsp:include page="/WEB-INF/jsp/footer.jsp" />
 </footer>

 </div>

<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		//$("td")
		//$("td#batsu")
		//$("td#batsu")[0].innerText
//		$("td.batsu")
//			for (var i =0; i< 91; i++){
//
//				$("td.batsu:contains('5')").css("color", "red")
//				$("td.batsu:contains('6')").css("color", "red")
//				$("td.batsu:contains('7')").css("color", "red")
//				$("td.batsu:contains('8')").css("color", "red")
//				$("td.batsu:contains('9')").css("color", "red")
//				$("td.batsu:contains('10')").css("color", "red")
//				$("td.batsu:contains('11')").css("color", "red")
//				$("td.batsu:contains('12')").css("color", "red")
//				$("td.batsu:contains('13')").css("color", "red")
//				$("td.batsu:contains('14')").css("color", "red")
//				$("td.batsu:contains('15')").css("color", "red")
//				$("td.batsu:contains('16')").css("color", "red")
//				$("td.batsu:contains('17')").css("color", "red")
//				$("td.batsu:contains('18')").css("color", "red")
//				$("td.batsu:contains('19')").css("color", "red")
//				$("td.batsu:contains('20')").css("color", "red")
//				$("td.batsu:contains('21')").css("color", "red")
//				$("td.batsu:contains('22')").css("color", "red")
//				$("td.batsu:contains('23')").css("color", "red")
//				$("td.batsu:contains('24')").css("color", "red")
//				$("td.batsu:contains('25')").css("color", "red")
//				$("td.batsu:contains('26')").css("color", "red")
//				$("td.batsu:contains('27')").css("color", "red")
//				$("td.batsu:contains('28')").css("color", "red")
//				$("td.batsu:contains('29')").css("color", "red")
//				$("td.batsu:contains('30')").css("color", "red")
//				$("td.batsu:contains('31')").css("color", "red")
//				$("td.batsu:contains('32')").css("color", "red")
//				$("td.batsu:contains('33')").css("color", "red")
//				$("td.batsu:contains('34')").css("color", "red")
//				$("td.batsu:contains('35')").css("color", "red")
//				$("td.batsu:contains('36')").css("color", "red")
//				$("td.batsu:contains('37')").css("color", "red")
//				$("td.batsu:contains('38')").css("color", "red")
//				$("td.batsu:contains('39')").css("color", "red")
//				$("td.batsu:contains('40')").css("color", "red")
//
//			}

		var array = $("td.batsu");
        for (let i =0; i< array.length; i++){
        	if(array[i].innerText >= 5){
        		$(array[i]).css("color", "red")
				console.log($("td.batsu"));
        	}
		}
	});

</script>

</body>
</html>