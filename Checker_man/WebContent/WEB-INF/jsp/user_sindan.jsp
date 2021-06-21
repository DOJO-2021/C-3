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

					<td>問1 よく眠れなかった</td>
					<form action="#" method="post">
					<td><input type="radio" name="sindan1" value="1"></td>
					<td><input type="radio" name="sindan1" value="2"></td>
					<td><input type="radio" name="sindan1" value="3" checked>
					</td>
					<td><input type="radio" name="sindan1" value="4"></td>
					<td><input type="radio" name="sindan1" value="5"></td>
				</tr>

				<tr>
					<td>問2 食欲があまりない</td>
					<action ="#" method="post">
					<td><input type="radio" name="sindan2" value="1"></td>
					<td><input type="radio" name="sindan2" value="2"></td>
					<td><input type="radio" name="sindan2" value="3" checked>
					</td>
					<td><input type="radio" name="sindan2" value="4"></td>
					<td><input type="radio" name="sindan2" value="5"></td>
				</tr>

				<tr>
					<td>問3 よく眠れなかった</td>
					<action ="#" method="post">
					<td><input type="radio" name="sindan3" value="1"></td>
					<td><input type="radio" name="sindan3" value="2"></td>
					<td><input type="radio" name="sindan3" value="3" checked>
					</td>
					<td><input type="radio" name="sindan3" value="4"></td>
					<td><input type="radio" name="sindan3" value="5"></td>
				</tr>

				<tr>
					<td>問4 食欲があまりない</td>
					<action ="#" method="post">
					<td><input type="radio" name="sindan4" value="1"></td>
					<td><input type="radio" name="sindan4" value="2"></td>
					<td><input type="radio" name="sindan4" value="3" checked>
					</td>
					<td><input type="radio" name="sindan4" value="4"></td>
					<td><input type="radio" name="sindan4" value="5"></td>
				</tr>

				<td>問5 よく眠れなかった</td>
				<action ="#" method="post">
				<td><input type="radio" name="sindan5" value="1"></td>
				<td><input type="radio" name="sindan5" value="2"></td>
				<td><input type="radio" name="sindan5" value="3" checked>
				</td>
				<td><input type="radio" name="sindan5" value="4"></td>
				<td><input type="radio" name="sindan5" value="5"></td>
				</tr>

				<tr>
					<td>問6 食欲があまりない</td>
					<action ="#" method="post">
					<td><input type="radio" name="sindan6" value="1"></td>
					<td><input type="radio" name="sindan6" value="2"></td>
					<td><input type="radio" name="sindan6" value="3" checked>
					</td>
					<td><input type="radio" name="sindan6" value="4"></td>
					<td><input type="radio" name="sindan6" value="5"></td>
				</tr>

				<tr>
					<td>問7 よく眠れなかった</td>
					<action ="#" method="post">
					<td><input type="radio" name="sindan7" value="1"></td>
					<td><input type="radio" name="sindan7" value="2"></td>
					<td><input type="radio" name="sindan7" value="3" checked>
					</td>
					<td><input type="radio" name="sindan7" value="4"></td>
					<td><input type="radio" name="sindan7" value="5"></td>
				</tr>

				<tr>
					<td>問8 食欲があまりない</td>
					<action ="#" method="post">
					<td><input type="radio" name="sindan8" value="1"></td>
					<td><input type="radio" name="sindan8" value="2"></td>
					<td><input type="radio" name="sindan8" value="3" checked>
					</td>
					<td><input type="radio" name="sindan8" value="4"></td>
					<td><input type="radio" name="sindan8" value="5"></td>
				</tr>

				<tr>
					<td>問9 よく眠れなかった</td>
					<action ="#" method="post">
					<td><input type="radio" name="sindan9" value="1"></td>
					<td><input type="radio" name="sindan9" value="2"></td>
					<td><input type="radio" name="sindan9" value="3" checked>
					</td>
					<td><input type="radio" name="sindan9" value="4"></td>
					<td><input type="radio" name="sindan9" value="5"></td>
				</tr>

				<tr>
					<td>問10 食欲があまりない</td>
					<action ="#" method="post">
					<td><input type="radio" name="sindan10" value="1"></td>
					<td><input type="radio" name="sindan10" value="2"></td>
					<td><input type="radio" name="sindan10" value="3" checked>
					</td>
					<td><input type="radio" name="sindan10" value="4"></td>
					<td><input type="radio" name="sindan10" value="5"></td>
				</tr>

				<tr>
					<td>問11 よく眠れなかった</td>
					<action ="#" method="post">
					<td><input type="radio" name="sindan11" value="1"></td>
					<td><input type="radio" name="sindan11" value="2"></td>
					<td><input type="radio" name="sindan11" value="3" checked>
					</td>
					<td><input type="radio" name="sindan11" value="4"></td>
					<td><input type="radio" name="sindan11" value="5"></td>
				</tr>

				<tr>
					<td>問12 食欲があまりない</td>
					<action ="#" method="post">
					<td><input type="radio" name="sindan12" value="1"></td>
					<td><input type="radio" name="sindan12" value="2"></td>
					<td><input type="radio" name="sindan12" value="3" checked>
					</td>
					<td><input type="radio" name="sindan12" value="4"></td>
					<td><input type="radio" name="sindan12" value="5"></td>
				</tr>


				<td>問13 よく眠れなかった</td>
				<action ="#" method="post">
				<td><input type="radio" name="sindan13" value="1"></td>
				<td><input type="radio" name="sindan13" value="2"></td>
				<td><input type="radio" name="sindan13" value="3" checked>
				</td>
				<td><input type="radio" name="sindan13" value="4"></td>
				<td><input type="radio" name="sindan13" value="5"></td>
				</tr>

				<tr>
					<td>問14 食欲があまりない</td>
					<action ="#" method="post">
					<td><input type="radio" name="sindan14" value="1"></td>
					<td><input type="radio" name="sindan14" value="2"></td>
					<td><input type="radio" name="sindan14" value="3" checked>
					</td>
					<td><input type="radio" name="sindan14" value="4"></td>
					<td><input type="radio" name="sindan14" value="5"></td>
				</tr>

				<tr>
					<td>問15 よく眠れなかった</td>
					<action ="#" method="post">
					<td><input type="radio" name="sindan15" value="1"></td>
					<td><input type="radio" name="sindan15" value="2"></td>
					<td><input type="radio" name="sindan15" value="3" checked>
					</td>
					<td><input type="radio" name="sindan15" value="4"></td>
					<td><input type="radio" name="sindan15" value="5"></td>
				</tr>
			</table>
			<!-- 診断テーブルここまで -->

			<br>

			<!-- 診断結果へのリンク -->
			<method="POST">
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