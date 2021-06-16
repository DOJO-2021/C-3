<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title>チェッカマン</title>
<link rel="stylesheet" href="/Checker_man/css/user_toppage.css">
<link rel="stylesheet" href="/Checker_man/css/user.css">

</head>

<body>

<div class="wrapper">

 <!-- ヘッダ -->
 <header class="header">
 <jsp:include page="/WEB-INF/jsp/header.jsp"/>
 </header>

 <!-- メイン -->
 <div class ="main">
 <p></p>

 <div class="calendar-border">

          <!-- カレンダーの上にある「前月、現在の月、翌月」のhtml -->
  <div class="calender-menu">
   <table class="calender-menu-table">
    <tr>
		<th><input type="submit" id="previous-month" name="previous-month" value="前月"></th>
		 <th class = "th-month">2021年6月</th>
    	<th><input type="submit" id="next-month" name="next-month" value="翌月"></th>
    </tr>
   </table>
  </div>

             <!-- カレンダーの表のhtml -->
   <div class="calender">
    <table class="calender-table">
      <tr class = "week">
        <th class = "sunday">日</th>
        <th>月</th>
        <th>火</th>
        <th>水</th>
        <th>木</th>
        <th>金</th>
        <th class = "saturday">土</th>
      </tr>

         <tr>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
      </tr>
        <tr>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
      </tr>
        <tr>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
      </tr>
        <tr>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
      </tr>
        <tr>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
      </tr>
        <tr>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
      </tr>

    </table>
    </div>

</div>

       <!-- 診断ボタン、診断結果ボタン」のhtml -->
<div class="user_toppage_button">
 <input type="submit" id="user_shindan" name="user_shindan" value="診断">
 <input type="submit" id="user_result" name="user_result" value="診断結果">
</div>

<p>テスト（削除しても良い）</p>
<c:forEach var="e" items="${calenderlist}">
<input type="text" value="${e.date}" readonly>
</c:forEach>

 <p></p>
 </div>

 <!-- フッター -->
 <footer class="footer">
 <jsp:include page="/WEB-INF/jsp/footer.jsp"/>
 </footer>

</div>

</body>
</html>