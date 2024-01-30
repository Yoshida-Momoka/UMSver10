package servlet;

/*
 *プログラム名  ：ユニフォーム発注管理システム
 *プログラム説明：（管理者メニュー画面の）注文状況確認リンクが押下された場合の処理を提供するサーブレット
 *作成者        ：小倉悠聖
 *作成日        ：2024年1月30日
 *変更履歴      ：STEP1 初期作成
 */

//インポート宣言
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Order;
import bean.User;
import dao.OrderDAO;

public class OrderStatusServelt extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException
	{
		try{
			//オブジェクト宣言
			OrderDAO objDao = new OrderDAO();

			//セッション開始
			HttpSession session = request.getSession();

			//セッションからユーザー情報を取得
			User user = (User)session.getAttribute("user");

			//セッションにオーダオブジェクトリストがあるかチェック
			if(user != null){
				//全ユーザの購入履歴を取得
				ArrayList<Order> list = objDao.selectAll();

				//検索結果を持ってshowHistoryOrderedItem.jspにフォワード
				request.setAttribute("ordered_list", list);
				request.getRequestDispatcher("/view/orderStatusList").forward(request, response);

			}else{
				//セッション切れ
				//エラー情報を持ってerror.jspにフォワード
				String error ="セッション切れの為、購入状況の確認は出来ません。";
				request.setAttribute("error", error);
				request.setAttribute("cmd", "menu");
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}

		} catch (IllegalStateException e) {
			//エラー情報を持ってerror.jspにフォワード
			String error ="DB接続エラーの為、注文状況確認は出来ません。";
			request.setAttribute("error", error);
			request.setAttribute("cmd", "menu");
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);

		} catch(Exception e){
			String error ="予期せぬエラーが発生しました。"+e;
			request.setAttribute("error", error);
			request.setAttribute("cmd", "menu");
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);

		}
	}
}
