package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;

public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// エラー用メッセージの初期化
		String error = "";

		try {

			// ProductDAOをインスタンス化する
			ProductDAO objProductDao = new ProductDAO();

			// 関連メソッドを呼び出し、戻り値としてProductオブジェクトのリストを取得する
			ArrayList<Product> list = objProductDao.selectAll();

			// 取得したListをリクエストスコープに"book_list"という名前で格納する
			request.setAttribute("product_list", list);

		} catch (IllegalStateException e) {
			// DB接続エラーの場合エラー画面にフォワード
			error = "DB接続エラーの為、一覧表示は行えませんでした。";
			request.setAttribute("error", error);
			request.setAttribute("cmd", "menu");
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);
		} finally {
			// 問題がない場合書籍一覧にフォワード
			request.getRequestDispatcher("/view/productList.jsp").forward(request, response);
		}

	}
}
