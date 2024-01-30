<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.User" %>

<%

User user = (User)session.getAttribute("user");

if(user == null){

	request.setAttribute("errorMsg","セッション切れの為、メニュー画面が表示できませんでした。");
	request.setAttribute("errorCmd","logout");
	request.getRequestDispatcher("/view/error.jsp").forward(request,response);
}
%>

<html>
	<head>
		<title>メニュー</title>
	</head>

	<body>

		<!-- ヘッダー -->
		<% if(user.getAuthority().equals("0")) {%>
			<%@include file="/common/header.jsp" %>
		<% }else if(user.getAuthority().equals("1")){ %>
			<%@include file="/common/userHeader.jsp" %>
		<%} %>

		<!-- ユーザー情報表示 -->
		<!-- <div style="text-align:right">
			<//%@include file="/common/userInfo.jsp" %>
		</div> -->

		<!-- <hr style="background-color:#008015"> -->

		<!-- タイトル -->
		<h2 style="text-align:center">MENU</h2>

		<!-- 水平線、権限によって変更 -->
		<% if(user.getAuthority().equals("0")) {%>
			<hr style="height:2px; margin-bottom:100px; background-color:#00ff00">
		<% }else if(user.getAuthority().equals("1")){ %>
			<hr style="height:2px; margin-bottom:100px; background-color:#ff0000">
		<%} %>

		<div style="text-align:center; margin:auto; line-height:40px;">

			<!-- 各機能リンク(メニュー画面)表示 -->

			<%
			if(user.getAuthority().equals("0")){
			%>
			<table style="text-align:center; margin:auto">
				<tr>
					<td style="width:120px;height:60px; background-color:#d9fa96">
					<a href="<%= request.getContextPath() %>/###">商品一覧</a>
					</td>
				</tr>
				<tr>
					<td style="width:120px;height:60px; background-color:#d9fa96">
						<a href="<%= request.getContextPath() %>/###"">注文状況確認</a><br>
					</td>
				</tr>
				<tr>
					<td style="width:120px;height:60px; background-color:#d9fa96">
						<a href="<%= request.getContextPath() %>/###">売上状況確認</a><br>
					</td>
				</tr>
				<tr>
					<td style="width:120px;height:60px; background-color:#d9fa96">
						<a href="<%= request.getContextPath() %>/###">ログアウト</a><br>
					</td>
				</tr>
			</table>
			<%
			}else if(user.getAuthority().equals("1")){
			%>
			<table style="text-align:center">
				<tr>
					<td style="width:120px;height:60px; background-color:#faafe1">
						<a href="<%= request.getContextPath() %>/###">商品一覧</a><br>
					</td>
				</tr>
				<tr>
					<td style="width:120px;height:60px; background-color:#faafe1">
						<a href="<%= request.getContextPath() %>/###">カート確認</a><br>
					</td>
				</tr>
				<tr>
					<td style="width:120px;height:60px; background-color:#faafe1">
						<a href="<%= request.getContextPath() %>/###">ユーザー登録</a><br>
					</td>
				</tr>
				<tr>
					<td style="width:120px;height:60px; background-color:#faafe1">
						<a href="<%= request.getContextPath() %>/###">ログアウト</a>
					</td>
				</tr>
			</table>

			<%
			}
			%>

		</div>

		<!-- フッター -->
		<% if(user.getAuthority().equals("0")) {%>
			<%@include file="/common/footer.jsp" %>
		<% }else if(user.getAuthority().equals("1")){ %>
			<%@include file="/common/userFooter.jsp" %>
		<%} %>

	</body>
</html>