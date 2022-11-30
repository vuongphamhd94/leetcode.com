package Controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import Dao.LoginDao;
import Models.Account;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		String userName = request.getParameter("user");
		String pass = request.getParameter("pass");
		String remember = request.getParameter("remember");

		LoginDao lg = new LoginDao();
		Account acc = null;
		HttpSession session = request.getSession();

		Cookie user = new Cookie("user", userName);
		Cookie password = new Cookie("pass", pass);
		if (remember != null) {
			user.setMaxAge(60 * 60 * 365);
			password.setMaxAge(60 * 60 * 365);
		} else {
			user.setMaxAge(0);
			password.setMaxAge(0);
		}

		try {
			acc = lg.Login(userName, pass);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			System.out.println(e);
		}

		if (acc != null) {
			Account accountSession = (Account) session.getAttribute("acc");
			if (accountSession != null) {
				session.removeAttribute("acc");
			}

			session.setAttribute("acc", acc);

			request.getRequestDispatcher("Index.jsp").forward(request, response);
		}

	}

}
