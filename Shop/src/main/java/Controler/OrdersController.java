package Controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.OrderDao;
import Models.Account;
import Models.Orders;

/**
 * Servlet implementation class OrdersController
 */
@WebServlet("/orders")
public class OrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		OrderDao od = new OrderDao();
		String statusStr = request.getParameter("status");
		Account acc = (Account) session.getAttribute("acc");
		if(acc != null) {
			
			int status = statusStr == null ? 4 : Integer.valueOf(statusStr);
			List<Orders> orders = od.GetAllOrde(acc.getUserEmail(), status);
			request.setAttribute("orders", orders);
			request.setAttribute("sumPr", od.totalProductCart(acc.getUserEmail()));
		}
		request.getRequestDispatcher("Ordered.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
