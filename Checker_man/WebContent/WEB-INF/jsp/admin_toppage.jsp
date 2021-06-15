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
<p class="icon"><img src="/Checker_man/images/maru.png">の人：
<div class="sample2oya" onclick="showSample()">10人
  <span class="sample2" id="idsample2">吹き出しが表示される</span>
</div>
<img src="/Checker_man/images/sankaku.png">の人：5人<br>
<img src="/Checker_man/images/batsu.png">の人：3人

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
function showSample(){
var wObjballoon	= document.getElementById("idsample2");
if (wObjballoon.className == "sample2"){
wObjballoon.className = "sample20";
}else{
wObjballoon.className = "sample2";
}
}
</script>

</body>
</html>