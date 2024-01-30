package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.User;
import dao.UserDAO;

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//エラーメッセージ、エラーコマンド決定
		String errorMsg = null;
		String errorCmd = null;

		// 入力パラメータ取得
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");

		// UserDAOのインスタンス化
		UserDAO userDao = new UserDAO();

		try {

			// ユーザー情報をDBから取得し、Userオブジェクトに格納
			User user = userDao.selectByUser(userid, password);

			/*---エラー処理---*/

			// 入力データで情報が取得できない
			if (user == null) {
				errorMsg = "入力データが間違っています。";
				errorCmd = "login";
				return;
			}

			///////////////////

			/* ---クッキーに取得情報を登録--- */
			Cookie cookieInUserid = new Cookie("userid", userid);
			Cookie cookieInPassword = new Cookie("password", password);

			cookieInUserid.setMaxAge(60 * 60 * 24 * 5);
			cookieInPassword.setMaxAge(60 * 60 * 24 * 5);

			response.addCookie(cookieInUserid);
			response.addCookie(cookieInPassword);

			////////////////////////////////////

			// userオブジェクトをセッションスコープに登録
			HttpSession session = request.getSession();
			session.setAttribute("user", user);

		} catch (IllegalStateException e) {

			// DB接続できない
			errorMsg = "DB接続エラーの為、ログインできません。";
			errorCmd = "logout";

		} finally {

			if (errorMsg != null && errorCmd == "login") {

				/* エラーが有った場合 かつ ユーザー情報なし */

				// ログイン画面にフォワード
				request.setAttribute("errorMsg", errorMsg);
				request.getRequestDispatcher("/view/login.jsp").forward(request, response);

			} else if (errorMsg != null && errorCmd == "logout") {

				/* エラーがあった場合 */

				// エラー画面にフォワード
				request.setAttribute("errorMsg", errorMsg);
				request.setAttribute("errorCmd", errorCmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);

			} else {

				/* エラーが無かった場合 */

				// 書籍一覧画面にフォワード
				request.getRequestDispatcher("/view/menu.jsp").forward(request, response);
			}
		}
	}
}
