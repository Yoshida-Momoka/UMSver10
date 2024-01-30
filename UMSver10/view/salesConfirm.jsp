<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Sales"%>

<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<TITLE>売上状況確認</TITLE>
</HEAD>
<BODY>
	<!-- ヘッダー -->
	<%@ include file="/common/header.jsp"%>
	<%
		//スコープデータを取得する
		ArrayList<Sales> list = (ArrayList<Sales>) request.getAttribute("sales_list");
		String dispDate = (String) request.getAttribute("dispDate");
	%>

	<!-- 以下本文 -->

	<table>
		<h2 style="width:100vw; margin:auto">売上げ状況</h2>
		<form action="<%=request.getContextPath()%>/salesConfirm" method="get">
			<table>
				<select name="month" id="month-select">
					<option value="">--月を選択してください--</option>
					<option value="1">1月</option>
					<option value="2">2月</option>
					<option value="3">3月</option>
					<option value="4">4月</option>
					<option value="5">5月</option>
					<option value="6">6月</option>
					<option value="7">7月</option>
					<option value="8">8月</option>
					<option value="9">9月</option>
					<option value="10">10月</option>
					<option value="11">11月</option>
					<option value="12">12月</option>
				</select>
				<br>
				<input type="submit" value="選択月の売上を表示">
		</form>

		<tr>
			<th
				style="text-align: center; background-color: #d9f2d0; padding: 10px;">売上ID</th>
			<th
				style="text-align: center; background-color: #d9f2d0; padding: 10px;">注文ID</th>
			<th
				style="text-align: center; background-color: #d9f2d0; padding: 10px;">商品名</th>
			<th
				style="text-align: center; background-color: #d9f2d0; padding: 10px;">購入個数</th>
			<th
				style="text-align: center; background-color: #d9f2d0; padding: 10px;">合計金額</th>
			<th
				style="text-align: center; background-color: #d9f2d0; padding: 10px;">注文日付</th>
			<th
				style="text-align: center; background-color: #d9f2d0; padding: 10px;">売上日付</th>

		</tr>

		<%
			//スコープデータを表示する

			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					Sales sale = (Sales) list.get(i);
		%>

		<tr>
			<td style="text-align: center; padding: 10px;">sales.getSalesid()</td>
			<td style="text-align: center; padding: 10px;">sales.getOrderid()</td>
			<td style="text-align: center; padding: 10px;">sales.getProductname()</td>
			<td style="text-align: center; padding: 10px;">sales.getQuantity()</td>
			<td style="text-align: center; padding: 10px;">sales.getTotal()</td>
			<td style="text-align: center; padding: 10px;">sales.getOrderdate()</td>
			<td style="text-align: center; padding: 10px;">sales.getSalesdate()</td>
		</tr>
		<%
			}
			}
		%>

	</table>

	<!-- フッター -->
	<%@ include file="/common/footer.jsp"%>
</body>
</html>