package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LogoutServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// セッション情報クリア
		HttpSession session = request.getSession();
		session.invalidate();

		// ログイン画面に遷移
		// ログイン画面にメッセージ表示
		request.setAttribute("logoutMsg", "ログアウトしました");
		request.getRequestDispatcher("/view/login.jsp").forward(request, response);

	}

}
