package Controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.LoginDao;
import Dao.OrderDao;
import Models.Account;
import Models.Message;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null && action.equals("logout")) {
			HttpSession session = request.getSession();
			session.removeAttribute("acc");
			response.sendRedirect("home");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		String userName = request.getParameter("email");
		String pass = request.getParameter("pass");
		String remember = request.getParameter("remember");
		Message ms = null;
		
		OrderDao od = new OrderDao();
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
			request.setAttribute("sumPr", od.totalProductCart(acc.getUserEmail()));
			session.setAttribute("acc", acc);
//			ms = new Message("success", "Đăng nhập thành công!");
//			response.sendRedirect("home");
			request.getRequestDispatcher("_headChager.jsp").forward(request, response);;
		}else
		{
			ms = new Message("errol", "Sai thông tin tài khoản hoặc mật khẩu!");
//			request.setAttribute("ms", "Sai thông tin tài khoản hoặc mật khẩu!");
//			request.getRequestDispatcher("Login.jsp").forward(request, response);
			request.setAttribute("ms", ms);
			request.getRequestDispatcher("_message.jsp").forward(request, response);
		}
		

	}

}
