package Controler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.OrderDao;
import Dao.ProductDao;
import Models.Account;
import Models.Message;
import Models.Product;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Message ms = null;
		String strPage = request.getParameter("page");
		String keySeach = request.getParameter("keySeach");
		OrderDao od = new OrderDao();
		HttpSession session = request.getSession();
		Account acc =(Account) session.getAttribute("acc");
		if(acc != null) {
			request.setAttribute("sumPr", od.totalProductCart(acc.getUserEmail()));
		}
		
		int page = 1;
		if (strPage != null) {
			page = Integer.valueOf(strPage);
		}

		List<Product> products = new ArrayList<Product>();
		ProductDao prdDao = new ProductDao();
		if (keySeach == null || keySeach.isBlank()) {
			products = prdDao.SeachByName("", page);
			request.setAttribute("maxPage", prdDao.MaxPage(""));
		}
			
		else {
			keySeach = keySeach.trim();
			request.setAttribute("keySeach", keySeach);
			products = prdDao.SeachByName(keySeach, page);
			request.setAttribute("maxPage", prdDao.MaxPage(keySeach));
		}
		
		ms = (Message) request.getAttribute("ms");
		request.setAttribute("page", page);
		request.setAttribute("products", products);
		

		request.setAttribute("ms", ms);

		request.getRequestDispatcher("Index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
