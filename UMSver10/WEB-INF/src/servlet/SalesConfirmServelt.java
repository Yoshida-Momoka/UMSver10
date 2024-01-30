package servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import bean.*;
import dao.*;

public class SalesConfirmServelt extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String cmd = "";

		try {

			// 入力データを取得する
			String month = request.getParameter("month");

			//SaleDAOのオブジェクトを生成
			salesDAO saleDao = new salesDAO();

			//selecBySalesメソッドをSale型の配列に格納
			ArrayList<Sales> saleList = saleDao.selectBySales(month);

			//画面に表示する検索年月を文字列に「○○月」形式で設定する。
			String dispDate = month + "月";

			//各データをリクエストスコープに設定
			request.setAttribute("sale_list", saleList);
			request.setAttribute("dispDate", dispDate);

		} catch (IllegalStateException e) {
			error = "DB接続エラーのため、売り上げ状況の確認はできませんでした。";
		} catch (Exception e) {
			error = "予期せぬエラーが発生しました。<br>" + e;
		} finally {
			if (!error.equals("")) {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response); // error.jspにフォワード
			}
			request.getRequestDispatcher("/view/salesConfirm.jsp").forward(request, response); // salesConfirm.jspにフォワード
		}

	}
}