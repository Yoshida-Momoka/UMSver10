<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List,bean.Order,util."%>

<!-- ここにJAVA処理等記述してください。 -->


<!-- 入金、発送更新確認画面 -->

<html>
<head>
<title>入金、発送更新確認</title>
</head>

<body>

	<!-- ヘッダー -->
	<%@ include file="/common/header.jsp"%>

	<!-- スコープからデータを取得 -->

	<%

		Order order = (Order)request.getAttribute("order_data");
		String payment = (String)request.getAttribute("payment");
		String shipping = (String)request.getAttribute("shipping");

		%>

	<!--以下本文  -->
	<h1 style="text-align: center">入金、発送更新確認</h1>
	<hr
		style="margin-top: 10px; margin-bottom: 50px; background-color: #add8e6">

	<div style="text-align: center; margin-top: 10px; margin-bottom: 50px;">
		<!-- メニューのリンクボタン -->
		<a href="<%= request.getContextPath() %>/view/managermenu.jsp"
			style="color: white; background-color: #4CAF50; padding: 10px 20px;">メニュー</a>
		<!-- 注文詳細画面のリンクボタン -->
		<a href="<%= request.getContextPath() %>/orderStatusDetail"
			style="color: white; background-color: #4CAF50; padding: 10px 20px;">注文詳細</a>
	</div>


	<div style="margin:auto">

		<!-- 更新情報表示フォーム -->
		<form action="<%=request.getContextPath()%>/showCart"
			style="margin: auto;">
			<table style="width: 30%; margin: auto;">
				<tr>
					<th style="background-color: #d9f2d0; padding: 10px;">注文番号</th>
					<th style="background-color: #6699ff; padding: 10px;"><%=order.getOrderid() %>
					</th>
				</tr>
				<tr>
					<th style="background-color: #d9f2d0; padding: 10px;">顧客情報</th>
					<th style="background-color: #6699ff; padding: 10px;"><%=order.getUserid() %>
					</th>
				</tr>
				<tr>
					<th style="background-color: #d9f2d0; padding: 10px;">入金状況</th>
					<th style="background-color: #6699ff; padding: 10px;"><%=payment %></th>
				</tr>
				<tr>
					<th style="background-color: #d9f2d0; padding: 10px;">発送状況</th>
					<th style="background-color: #6699ff; padding: 10px;"><%=shipping %></th>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
			</table>

			<!-- 更新・メール送信完了画面のリンクボタン -->
			<a href="<%= request.getContextPath()%>/view/updateCompletion.jsp"
				style="color: white; background-color: #4CAF50; padding: 10px 20px;">更新</a>
		</form>
	</div>

	<!-- フッター -->
	<%@ include file="/common/footer.jsp"%>

</body>
</html>
