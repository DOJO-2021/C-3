<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title>チェッカマン</title>
<link rel="stylesheet" href="/Checker_man/css/admin_toppage.css">
<link rel="stylesheet" href="/Checker_man/css/admin.css">
</head>

<body>

<div class="wrapper">

 <!-- ヘッダ -->
 <header class="header">
 <jsp:include page="/WEB-INF/jsp/header.jsp"/>
 </header>

 <!-- メイン -->
 <main>

         <!--  「受講者の健康診断」のhtml -->
<div class="healthcheck">
現在の受講者健康状態<br>

	<div class="icon">
		<table>
			<tr>
				<th><img src="/Checker_man/images/maru.png">の人：</th>
				<td><div class="maru-number" onclick="show('1')">10人
			  		<span class="sample1" id="idsample1">555</span>
				</div></td>
			</tr>

			<tr>
				<th><img src="/Checker_man/images/sankaku.png">の人：</th>
				<td><div class="sankaku-number" onclick="show('2')">5人
					<span class="sample2" id="idsample2">333</span>
				</div></td>

			</tr>

			<tr>
				<th><img src="/Checker_man/images/batsu.png">の人:</th>
				<td><div class="batu-number" onclick="show('3')">3人
					<span class="sample3" id="idsample3">444</span>
				</div></td>
			</tr>
		</table>
	</div>
</div>

              <!--  「お知らせ」のhtml -->
<div class="notice">
お知らせ<br>
コメントが〇件来ています
</div>

         <!--  「過去のデータボタン」のhtml -->
<div class="admin_toppage_button">
 <input type="submit" id="admin_lastdata" name="admin_lastdata" value="過去のデータ">
</div>

 </main>

 <!-- フッター -->
 <footer class="footer">
 <jsp:include page="/WEB-INF/jsp/footer.jsp"/>
 </footer>

</div>

<!-- javascriptで吹き出し -->
<script type="text/javascript">
function show(key){
	var wObjballoon1 = document.getElementById("idsample1");
	var wObjballoon2 = document.getElementById("idsample2");
	var wObjballoon3 = document.getElementById("idsample3");
	wObjballoon1.className = "sample1";
	wObjballoon2.className = "sample2";
	wObjballoon3.className = "sample3";

	if(key === '1'){
		wObjballoon1.className = "sample10";
	}
	else if(key === '2'){
		wObjballoon2.className = "sample20";
	}
	else if(key === '3'){
		wObjballoon3.className = "sample30";
	}
}


</script>

</body>
</html>