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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>

<body>

<div class="wrapper">
</div>
 <!-- ヘッダ -->
 <header class="header">
 <jsp:include page="/WEB-INF/jsp/header.jsp"/>
 </header>

 <!-- メイン -->
 <div class ="main">


	<!-- カレンダーのエリア -->
	 <div class="calendar-border">

	          <!-- カレンダーの上にある「前月、現在の月、翌月」のhtml -->
	  <div class="calender-menu">
		  <table class="calender-menu-table">
		  	<tr>
		  		<td><form action="/Checker_man/User_TopPageServlet?diffCount=0" method="GET">
					<input type="submit" id="previous-month" value="前月">
					<input type="hidden" name="diffCount" value="${p_month }">
					</form>
		  		</td>
		 		<th class = "th-month">${title_month }
		 		<td><form action="/Checker_man/User_TopPageServlet?diffCount=0" method="GET">
			    	<input type="submit" id="next-month"  value="翌月">
			    	<input type="hidden" name="diffCount" value="${n_month }">
					</form>
				</td>
			</tr>
	   	</table>
	  </div>

	       <!-- カレンダーの表のhtml -->
	   <h1></h1>
	        <div class="date-head"></div>
	        <table id="calender" class="table table-border table-hover table-sm">
	            <thead class="thead-dark">
	                <tr>
	                    <th>Sun</th>
	                    <th>Mon</th>
	                    <th>Tue</th>
	                    <th>Wed</th>
	                    <th>Thu</th>
	                    <th>Fri</th>
	                    <th>Sat</th>
	                </tr>
	            </thead>
	            <tbody>
	            </tbody>
	        </table>
	       </div>

	        <!-- アイコンの注釈文 -->
	        	<div class="comments">
	        	<div class="icon">
	        	<table><tr>
		        	 <td><img src="/Checker_man/images/maru.png" align="left" ></td><td><p>は健康</p></td>
		        	 <td><img src="/Checker_man/images/sankaku.png" align="left"></td><td><p>は注意</p></td>
		        	 <td><img src="/Checker_man/images/batsu.png" align="left"></td><td><p>は不健康</p></td>
		        	 </tr>
		        	 </table>
		        	 </div>
				</div>



	       <!-- 診断ボタン、診断結果ボタン」のhtml -->
			<div class="user_toppage_button">
				<table class="button-table">
					<tr>
						<td><form action="/Checker_man/User_SindanServlet" method="get">
						<input type="submit" id="user_shindan" name="user_shindan" value="診断" ></form></td>

						<td>　　　　　　　　　　　　　　　　　　　　　　　</td>

						<td><form action="/Checker_man/User_ResultServlet"  method="get">
						 <input type="submit" id="user_result" name="user_result" value="診断結果"> </form></td>
					</tr>
				</table>
			</div>

			<div class="clear"></div>
	</div>

 <!-- フッター -->
 <footer class="footer">
 <jsp:include page="/WEB-INF/jsp/footer.jsp"/>
 </footer>



<!-- カレンダーのjavaScript -->
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script>
        //追加
            let iconDatas = new Map();
            <c:forEach var="e" items="${calenderlist}">
            //iconDatesという変数に、日付とアイコンへのパスをセット
            iconDatas.set('${e.date}','${e.icon_path}');
            </c:forEach>

            var today = new Date();
            var year  = today.getFullYear();
            var month = today.getMonth()+${view_monthlist} ;

        //追加
        //年と月を取得
        //                     2021 + "-" +  "0" +  (             5  + 1) →06       + "-"
        //                                   "0" +  (             9  + 1) →010
           var thisMonthStr = year + "-" + ("0" + (today.getMonth() + ${view_monthlist})).slice(-2) + "-";



            $('.date-head').html(year + "-" + month);
            var last = new Date(today.getFullYear(), today.getMonth() + ${view_monthlist}, 0);
            var last_year  = last.getFullYear();
            var last_month = last.getMonth();
            var last_day   = last.getDate();
            for (var i=1; i<=last_day; i++) {
                var week = new Date(last_year, last_month, i).getDay();
                if (!week || i == 1) {
                    $('table').find('tbody').append('<tr>'+
                                                        '<td></td>' +   //色変える
                                                        '<td></td>' +
                                                        '<td></td>' +
                                                        '<td></td>' +
                                                        '<td></td>' +
                                                        '<td></td>' +
                                                        '<td></td>' + //色変える
                                                    '</tr>');
                }

           //追加 iconLinkを定義
                var iconLink = "";

           		//日付を取得
           		//                  2021-06-     01～31
                if(iconDatas.has( thisMonthStr + ("0" + i).slice(-2) )){
	                iconLink = "<img src="+iconDatas.get(thisMonthStr + ("0" + i).slice(-2))+" width=\"36px\">";
                }


                $('#calender').find('tbody').find('tr').last().find('td').eq(week).html(i + "<br />" + iconLink);
            }
        </script>
</body>
</html>