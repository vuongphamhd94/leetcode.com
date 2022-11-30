package Controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.LoginDao;
import Models.Message;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("Register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String fullName = request.getParameter("fullName");
		String user = request.getParameter("email");
		String pass = request.getParameter("pass");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		Message ms = null;
		
		LoginDao lg = new LoginDao();
		
		if(lg.isUserEmail(user)) {
			try {
				lg.CreateAccount(user, pass, fullName, address, phone);
				ms = new Message("success", "Đăng ký tài khoản thành công!");
			} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
				System.out.println(e);
			}
		}else {
			ms = new Message("errol", "Email đã đăng ký tài khoản!");
		}
		request.setAttribute("ms", ms);
		request.getRequestDispatcher("_message.jsp").forward(request, response);
	}

}
