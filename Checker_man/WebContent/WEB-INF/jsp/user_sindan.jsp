<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>チェッカマン</title>
</head>
<link rel="stylesheet" href="/Checker_man/css/user_sindan.css">
<body>

	<div class="wrapper">

		<!-- ヘッダー -->
		<header class="header">
			<jsp:include page="/WEB-INF/jsp/header.jsp" />
		</header>

		<!-- 診断エリア -->
		<div class="shindan-area">
			<!-- 見出し -->
			<h1>診断ページ</h1>

			<p>質問項目に合わせてチェックを入れてください</p>

			<form action="/Checker_man/User_SindanServlet" method="post">

				<!-- ここから診断テーブル -->
				<table style="background-color: #f5f5f5;">
					<tr bgcolor="#B0D6DA">
						<td>質問事項</td>
						<td>当てはまらない</td>
						<td>やや当てはまらない</td>
						<td>どちらともいえない</td>
						<td>やや当てはまる</td>
						<td>当てはまる</td>
					</tr>

					<tr>
						<td><div class="koumoku">問1 よく眠れなかった</div></td>
						<td><input type="radio" name="answer1" value="1"></td>
						<td><input type="radio" name="answer1" value="2"></td>
						<td><input type="radio" name="answer1" value="3" checked>
						</td>
						<td><input type="radio" name="answer1" value="4"></td>
						<td><input type="radio" name="answer1" value="5"></td>
					</tr>

					<tr>
						<td><div class="koumoku">問2 食欲があまりない</div></td>
						<td><input type="radio" name="answer2" value="1"></td>
						<td><input type="radio" name="answer2" value="2"></td>
						<td><input type="radio" name="answer2" value="3" checked>
						</td>
						<td><input type="radio" name="answer2" value="4"></td>
						<td><input type="radio" name="answer2" value="5"></td>
					</tr>

					<tr>
						<td><div class="koumoku">問3 不安に感じる</div></td>
						<td><input type="radio" name="answer3" value="1"></td>
						<td><input type="radio" name="answer3" value="2"></td>
						<td><input type="radio" name="answer3" value="3" checked>
						</td>
						<td><input type="radio" name="answer3" value="4"></td>
						<td><input type="radio" name="answer3" value="5"></td>
					</tr>

					<tr>
						<td><div class="koumoku">問4 倦怠感がある</div></td>
						<td><input type="radio" name="answer4" value="1"></td>
						<td><input type="radio" name="answer4" value="2"></td>
						<td><input type="radio" name="answer4" value="3" checked>
						</td>
						<td><input type="radio" name="answer4" value="4"></td>
						<td><input type="radio" name="answer4" value="5"></td>
					</tr>

					<tr>
						<td><div class="koumoku">問5 周囲とのコミュニケーションが取れていない</div></td>
						<td><input type="radio" name="answer5" value="1"></td>
						<td><input type="radio" name="answer5" value="2"></td>
						<td><input type="radio" name="answer5" value="3" checked>
						</td>
						<td><input type="radio" name="answer5" value="4"></td>
						<td><input type="radio" name="answer5" value="5"></td>
					</tr>

					<tr>
						<td><div class="koumoku">問6 研修への充実感が少ないと感じる</div></td>
						<td><input type="radio" name="answer6" value="1"></td>
						<td><input type="radio" name="answer6" value="2"></td>
						<td><input type="radio" name="answer6" value="3" checked>
						</td>
						<td><input type="radio" name="answer6" value="4"></td>
						<td><input type="radio" name="answer6" value="5"></td>
					</tr>

					<tr>
						<td><div class="koumoku">問7 腹痛、頭痛などがある</div></td>
						<td><input type="radio" name="answer7" value="1"></td>
						<td><input type="radio" name="answer7" value="2"></td>
						<td><input type="radio" name="answer7" value="3" checked>
						</td>
						<td><input type="radio" name="answer7" value="4"></td>
						<td><input type="radio" name="answer7" value="5"></td>
					</tr>

					<tr>
						<td><div class="koumoku">問8 イライラをすることが増えた</div></td>
						<td><input type="radio" name="answer8" value="1"></td>
						<td><input type="radio" name="answer8" value="2"></td>
						<td><input type="radio" name="answer8" value="3" checked>
						</td>
						<td><input type="radio" name="answer8" value="4"></td>
						<td><input type="radio" name="answer8" value="5"></td>
					</tr>

					<tr>
						<td><div class="koumoku">問9 息抜きなどが取れていない</div></td>
						<td><input type="radio" name="answer9" value="1"></td>
						<td><input type="radio" name="answer9" value="2"></td>
						<td><input type="radio" name="answer9" value="3" checked>
						</td>
						<td><input type="radio" name="answer9" value="4"></td>
						<td><input type="radio" name="answer9" value="5"></td>
					</tr>

					<tr>
						<td><div class="koumoku">問10 適度な運動をしていない</div></td>
						<td><input type="radio" name="answer10" value="1"></td>
						<td><input type="radio" name="answer10" value="2"></td>
						<td><input type="radio" name="answer10" value="3" checked>
						</td>
						<td><input type="radio" name="answer10" value="4"></td>
						<td><input type="radio" name="answer10" value="5"></td>
					</tr>

					<tr>
						<td><div class="koumoku">問11 辛いと感じることがある</div></td>
						<td><input type="radio" name="answer11" value="1"></td>
						<td><input type="radio" name="answer11" value="2"></td>
						<td><input type="radio" name="answer11" value="3" checked>
						</td>
						<td><input type="radio" name="answer11" value="4"></td>
						<td><input type="radio" name="answer11" value="5"></td>
					</tr>

					<tr>
						<td><div class="koumoku">問12 目が疲れている</div></td>
						<td><input type="radio" name="answer12" value="1"></td>
						<td><input type="radio" name="answer12" value="2"></td>
						<td><input type="radio" name="answer12" value="3" checked>
						</td>
						<td><input type="radio" name="answer12" value="4"></td>
						<td><input type="radio" name="answer12" value="5"></td>
					</tr>


					<tr>
						<td><div class="koumoku">問13 水分補給をあまりしていない</div></td>
						<td><input type="radio" name="answer13" value="1"></td>
						<td><input type="radio" name="answer13" value="2"></td>
						<td><input type="radio" name="answer13" value="3" checked>
						</td>
						<td><input type="radio" name="answer13" value="4"></td>
						<td><input type="radio" name="answer13" value="5"></td>
					</tr>

					<tr>
						<td><div class="koumoku">問14 作業環境が不適切（明るさ、温度など）</div></td>
						<td><input type="radio" name="answer14" value="1"></td>
						<td><input type="radio" name="answer14" value="2"></td>
						<td><input type="radio" name="answer14" value="3" checked>
						</td>
						<td><input type="radio" name="answer14" value="4"></td>
						<td><input type="radio" name="answer14" value="5"></td>
					</tr>

					<tr>
						<td><div class="koumoku">問15 研修内容についていけていないと感じる</div></td>
						<td><input type="radio" name="answer15" value="1"></td>
						<td><input type="radio" name="answer15" value="2"></td>
						<td><input type="radio" name="answer15" value="3" checked>
						</td>
						<td><input type="radio" name="answer15" value="4"></td>
						<td><input type="radio" name="answer15" value="5"></td>
					</tr>
				</table>
				<!-- 診断テーブルここまで -->

				<br>

				<!-- 診断結果へのリンク -->
				<div class="botton">
					<div class="result">
						<input type="submit" name="regist" value="診断結果へ"><br>
					</div>
				</div>

			</form>

			<!-- 診断エリアここまで -->
		</div>

		<!-- フッター -->
		<footer class="footer">
			<jsp:include page="/WEB-INF/jsp/footer.jsp" />
		</footer>

	</div>

</body>
</html>