<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Book,bean.User,util.MyFormat"%>

<%
	//セッションからユーザー情報を取得
	User user = (User) session.getAttribute("user");

	//セッション切れか確認
	if (user == null) {
		//セッション切れならerror.jspへフォワード
		request.setAttribute("error", "セッション切れのため、書籍一覧が表示できませんでした");
		request.setAttribute("cmd", "logout");
		request.getRequestDispatcher("/view/error.jsp").forward(request, response);
		return;
	}

	//リクエストから書籍情報を取得
	ArrayList<Book> book_list = (ArrayList<Book>) request.getAttribute("book_list");

	//フォーマットを呼び出し
	MyFormat format = new MyFormat();
%>

<html>
<head>
<title>書籍一覧</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<!-- ブラウザ全体 -->
	<div id="wrap">

		<!--ヘッダー部分  -->
		<%@ include file="/common/header.jsp"%>

		<!-- メニュー部分 -->
		<div id="menu">
			<div class="container">
				<!-- ナビゲーション  -->
				<div id="nav">
					<ul>
						<li><a href="<%=request.getContextPath()%>/view/menu.jsp">[メニュー]</a></li>
						<li><a href="<%=request.getContextPath()%>/showCart">[カート状況]</a></li>
					</ul>
				</div>

				<!-- ページタイトル -->
				<div id="page_title">
					<h2>書籍一覧</h2>
				</div>
			</div>
		</div>

		<!-- 書籍一覧のコンテンツ部分 -->
		<div id="main" class="container">

			<!-- 検索フォーム -->
			<form class="inline-block"
				action="<%=request.getContextPath()%>/search">
				ISBN <input type="text" name="isbn"> TITLE <input
					type="text" name="title"> 価格 <input type="text"
					name="price"> <input type="submit" value="検索">
			</form>
			<form class="inline-block"
				action="<%=request.getContextPath()%>/list">
				<input type="submit" value="全件表示">
			</form>

			<!-- 書籍情報リスト -->
			<table class="list-table">
				<thead>
					<tr>
						<th>ISBN</th>
						<th>TITLE</th>
						<th>価格</th>
						<!-- ユーザー用画面 -->
						<%
							if (!user.getAuthority().equals("2")) {
						%>
						<th>購入数</th>
						<%
							}
						%>
						<!-- 管理者用画面 -->
						<%
							if (user.getAuthority().equals("2")) {
						%>
						<th>変更/削除</th>
						<%
							}
						%>
					</tr>
				</thead>

				<tbody>
					<%
						if (book_list != null) {
							for (Book book : book_list) {
					%>
					<tr>
						<td><a
							href="<%=request.getContextPath()%>/detail?isbn=<%=book.getIsbn()%>&cmd=detail"><%=book.getIsbn()%></a></td>
						<td><%=book.getTitle()%></td>
						<td><%=format.moneyFormat(book.getPrice())%></td>
						<td>
							<!-- ユーザー用画面 --> <%
 							if (!user.getAuthority().equals("2")) {
							%>
							<form  class="quantity" action="<%=request.getContextPath()%>/insertIntoCart">
							<input type="text" name="quantity">　<input type="hidden" name="isbn" value=<%=book.getIsbn()%>><input type="submit" value="カートに入れる">
							</form>
							<%
								}
							%> <!-- 管理者用画面 --> <%
 							if (user.getAuthority().equals("2")) {
 							%> <a
							href="<%=request.getContextPath()%>/detail?isbn=<%=book.getIsbn()%>&cmd=update">変更</a>
							<a
							href="<%=request.getContextPath()%>/delete?isbn=<%=book.getIsbn()%>">削除</a>
							<%
								}
							%>
						</td>
					</tr>
					<%
						}
						}
					%>
				</tbody>
			</table>
		</div>

		<!-- フッター部分 -->
		<%@ include file="/common/footer.jsp"%>

	</div>
</body>
</html>