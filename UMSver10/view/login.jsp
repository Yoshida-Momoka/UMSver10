<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.User" %>

<%
String userid = "";
String password = "";

//ログアウトしてログイン画面に遷移した際の確認
String logoutStr = (String)request.getAttribute("logoutStr");

//ログイン中に起きたエラーの確認
String errorMsg = (String)request.getAttribute("errorMsg");

//クッキー取得
Cookie[] cookie =  request.getCookies();

//cookie有無確認
if(cookie != null){
	for(int i = 0;i < cookie.length; i++){
		if(cookie[i].getName().equals("userid")){
			userid = cookie[i].getValue();
		}
		if(cookie[i].getName().equals("password")){
			password = cookie[i].getValue();
		}
	}
}

if(errorMsg != null){
	userid = "";
	password = "";
}

%>
<html>
	<head>
	<title>ログイン画面</title>
	</head>

	<body>
		<div style="text-align:center">

		<!-- ヘッダー -->
		<%@include file="/common/userHeader.jsp" %>

		<!-- ↓メニューバー -->
		<!-- ログイン画面には必要ないので、画面名のみ表示 -->
		<h2>ログイン</h2>
		<hr style="height:2px; margin-bottom:100px; background-color:#ff0000">

		<!-- ログイン情報入力フォームまで100pxの空白あり -->
		<%


		//ログイン画面で入力値がデータベースにないものだった場合
		//エラー表示を行う
		if(errorMsg != null){
		%>

		<h3 style="color:RED"><%= errorMsg %></h3>

		<%
		}
		%>

		<form action="<%= request.getContextPath() %>/login" method="post">

			<table style="margin:100px auto;">
				<tr>
					<th style="width:150px; background-color:#ff8080">ユーザ</th>
					<td><input type="text" name="userid" value=<%= userid %>></td>
				</tr>
				<tr>
					<th style="background-color:#ff8080">パスワード</th>
					<td><input type="passWord" name="password" value=<%= password %>></td>
				</tr>
			</table>

			<%
			//ログアウトした後の遷移だった場合
			if(logoutStr != null){
			%>

			<div style="margin:50px; color:RED"><%= logoutStr %></div>

			<%
			}
			%>

			<input type="submit" value="ログイン">
		</form>

		<!-- フッター -->
		<%@include file="/common/userFooter.jsp" %>
	</div>
	</body>

</html>