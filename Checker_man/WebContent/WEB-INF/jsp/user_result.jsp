<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>診断結果ページ</title>
<link rel="stylesheet" href="/Checker_man/css/user_result.css">
</head>
<body>

	<!-- ヘッダー -->
	<header class="header">
		<jsp:include page="/WEB-INF/jsp/header.jsp"/>
	</header>

	 <!-- メイン -->
	 <main>
	 	<h1>診断結果</h1>
	 	<h2>（一言診断結果を表示）</h2>

		<!-- 質問内容 -->
	 	<table class = "user_result">
	 		<tr>
	 		<th>（問1　よく眠れなかった）</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 		<tr>
	 		<th>（問2　食欲があまりない）</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 		<tr>
	 		<th>（問3　不安に感じることがある）</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 		<tr>
	 		<th>（問4　倦怠感がある）</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 		<tr>
	 		<th>（問5　周囲とのコミュニケーションが取れていないと感じる）</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 		<tr>
	 		<th>（問6　研修への充実感が少ないと感じる）</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 		<tr>
	 		<th>（問7　腹痛、頭痛などがある）</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 		<tr>
	 		<th>（問8　イライラをすることが増えたと感じる）</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 		<tr>
	 		<th>（問9　リラックス、息抜きなどが取れていない）</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 		<tr>
	 		<th>（問10　適度な運動をしていない）</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 		<tr>
	 		<th>（問11　辛いと感じることがある）</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 		<tr>
	 		<th>（問12　目が疲れている）</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 		<tr>
	 		<th>（問13　水分補給をあまりしていない）</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 		<tr>
	 		<th>（問14　作業環境が不適切（明るさ、温度など））</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 		<tr>
	 		<th>（問15　研修内容についていけていないと感じる）</th>
	 		<td>（回答を表示）</td>
	 		</tr>
	 	</table>

	 	<!-- 備考欄 -->
	 	<div class = "message">
		 	<div class = "user_message">
			 	<p>受講者のコメント</p>
			 	<textarea rows="8" cols="45" name="user_message">コメントする</textarea>
			</div>

			<div class = "admin_message">
		 		<p>講師からのコメント</p>
				<!-- rows="3" cols="54" name="admin_message">${e.admin_message}は仮 -->
				<textarea rows="8" cols="45" name="admin_message">${e.admin_message}</textarea>
			</div>
		</div>

		<div class = "botton">
			<div class = "regist">
				<input type="submit" name="regist" value="コメント登録"><br>
			</div>

			<div class = "return">
				<a href="/Checker_man/User_TopPageServlet">トップへ戻る</a>
			</div>
		</div>

	 </main>

	<!-- フッター -->
	<footer class="footer">
		<jsp:include page="/WEB-INF/jsp/footer.jsp"/>
	</footer>

</body>
</html>