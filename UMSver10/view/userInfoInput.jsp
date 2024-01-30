<%@page contentType="text/html; charset=UTF-8"%>

<!-- 各処理に合わせてJAVA処理等記述してください。 -->


<html>
	<head>
		<title>ユーザー登録</title>
	</head>

	<body>
	 	<!-- インクルードヘッダー -->

			<%@include file="/common/userHeader.jsp" %>


			<!-- メニューバー -->
			<!-- 浮動ブロック用いて左上部寄せで固定 -->
			<div style="float:left">
				<a href="<%= request.getContextPath() %>/view/menu.jsp">[メニュー]</a>
			</div>

			<!-- 本文の文章等を真ん中寄せするタグ -->
			<div style="text-align:center">

				<!-- タイトル -->
				<h2 style="clear:left">ユーザー登録</h2>
				<!-- タイトル下水平線 -->
				<hr style="background-color:#add8e6">


					<!-- ＜＜＜＜↓ここから本文↓＞＞＞＞ -->
				<form action="<%=request.getContextPath()%>/userinfoInput">
				<table align="center" style = "margin-top:50px; margin-bottom:50px">
					<tr>
						<th>氏名</th>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<th>メールアドレス</th>
						<td><input type="text" name="mailaddress"></td>
					</tr>
					<tr>
						<th>住所</th>
						<td><input type="text" name="address"></td>
						</td>
					</tr>
				</table>
				<input type="submit" value="登録">
			</form>
			</div>
					<!-- ＜＜＜＜↑ここまで本文↑＞＞＞＞ -->


			</div>

		<!-- インクルードフッター -->

			<%@include file="/common/userFooter.jsp" %>

	</body>
</html>