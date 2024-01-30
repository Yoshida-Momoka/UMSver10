<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Product,bean.User"%>
<%
//リクエストから書籍情報を取得
	ArrayList<Product> product_list = (ArrayList<Product>) request.getAttribute("product_list");
%>

<html>
	<head>
		<title>商品一覧</title>
	</head>

	<body>
	 	<!-- インクルードヘッダー -->
	 	<!-- !!!!!!!ヘッダーとフッター、テーブルは
	 												共通用に直す!!!!!!!!!!!!!!!!!!! -->

			<%@include file="/common/userHeader.jsp" %>


			<!-- メニューバー -->
			<!-- 浮動ブロック用いて左上部寄せで固定 -->
			<div style="float:left">
				<a href="<%= request.getContextPath() %>/view/menu.jsp">[メニュー]</a>
				<a href="<%= request.getContextPath() %>/showCart">[カート確認]</a>
			</div>

			<!-- 本文の文章等を真ん中寄せするタグ -->
			<div style="text-align:center">

				<!-- タイトル -->
				<h2 style="clear:left">商品一覧</h2>
				<!-- タイトル下水平線 -->
				<hr style="background-color:#add8e6">


					<!-- ＜＜＜＜↓ここから本文↓＞＞＞＞ -->
					<table style="width:50vw; margin:auto; margin-top:50px; margin-bottom:50px">
					<thead>
					<tr style="background-color:#ff8080 ; text-align:center">
						<th>商品ID</th>
						<th>商品名</th>
						<th>価格</th>
						<th>在庫</th>
						<th>購入数</th>
					</tr>
				</thead>

				<tbody>
					<%
						if (product_list != null) {
							for (Product product : product_list) {
					%>
					<tr style="background-color:#fafaaf ; text-align:center">
						<td><%=product.getProductid()%></a></td>
						<td><%=product.getProductname()%></td>
						<td><%=product.getPrice()%></td>
						<td><%=product.getStock()%></td>
						<td>
							<form  action="<%=request.getContextPath()%>/insertIntoCart">

							<%-- 在庫が0の場合購入できない --%>
								<%
									if (product.getStock() > 0) {
								%>
								<input type="text" name="quantity" style="width:50px">
								<input type="hidden" name="productid" value=<%=product.getProductid()%>>　
								<input type="submit" value="カートに入れる">
								<%
									} else {
								%>
								<p style="color:red">売り切れ</p>
								<%
									}
								%>

							</form>
							<%
							}
						}
							%>
						</td>
					</tr>

				</tbody>
			</table>
					<!-- ＜＜＜＜↑ここまで本文↑＞＞＞＞ -->
			</div>

		<!-- インクルードフッター -->

			<%@include file="/common/userFooter.jsp" %>

	</body>
</html>