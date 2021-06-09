<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title>チェッカマン</title>
<link rel="stylesheet" href="/Checker_man/css/admin_toppage.css">

</head>

<body>

<div class="wrapper">

 <!-- ヘッダ -->
 <header class="header">
 <jsp:include page="/WEB-INF/jsp/header.jsp"/>
 </header>

 <!-- メイン -->
 <main>

<div class="healthcheck">
現在の受講者健康状態<br>
<p class="icon"><img src="/Checker_man/images/maru.png">の人：１０人<br>
<img src="/Checker_man/images/sankaku.png">の人：5人<br>
<img src="/Checker_man/images/batsu.png">の人：3人</p>

</div>

<div class="notice">
お知らせ<br>
コメントが〇件来ています
</div>

<div class="admin_toppage_button">
 <input type="submit" id="admin_lastdata" name="admin_lastdata" value="過去のデータ">
</div>

 </main>

 <!-- フッター -->
 <footer class="footer">
 <jsp:include page="/WEB-INF/jsp/footer.jsp"/>
 </footer>

</div>

</body>
</html>