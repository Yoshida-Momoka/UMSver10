<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*,bean.*,util.MyFormat"%>

<html>
<head>
<title>注文状況確認</title>
</head>

<body>
	<!-- インクルードヘッダー -->
	<%@include file="/common/header.jsp"%>

	<!-- メニューバー -->
	<!-- 浮動ブロック用いて左上部寄せで固定 -->
	<div style="float: left">
		<a href="<%=request.getContextPath()%>/view/menu.jsp">[メニュー]</a>
	</div>

	<!-- 本文の文章等を真ん中寄せするタグ -->
	<div style="text-align: center">

		<!-- タイトル -->
		<h2 style="clear: left">注文状況確認</h2>
		<!-- タイトル下水平線 -->
		<hr style="background-color: #add8e6">



		<!-- ＜＜＜＜↓ここから本文↓＞＞＞＞ -->
		<!-- テーブル -->
		<table style="width: 100vw; margin: auto">

			<tr style="background-color: #d9f2d0">
				<th>注文ID</th>
				<th>注文日時</th>
				<th>名前</th>
				<th>合計金額</th>
				<th>入金状況</th>
				<th>発送状況</th>
			</tr>
			<%
			//スコープデータを表示する
				ArrayList<Order> list = (ArrayList<Order>) request.getAttribute("ordered_list");


				for (int i = 0; i < list.size(); i++) {
					Order order = (Order) list.get(i);
			%>
			<tr>
				<td align="center"><%=order.getOrderid()%></td>
				<td align="center"><%=order.getOrderdate()%></td>
				<td align="center"><%=order.getUserid()%></td>
				<td align="center"><%=order.getTotal()%></td>
				<td align="center"><%=order.getPaymentStatus()%></td>
				<td align="center"><%=order.getShippingStatus()%></td>
			</tr>

			<%
				}
			%>

		</table>

		<!-- ＜＜＜＜↑ここまで本文↑＞＞＞＞ -->


	</div>

	<!-- インクルードフッター -->
	<%@include file="/common/footer.jsp"%>

</body>
</html>