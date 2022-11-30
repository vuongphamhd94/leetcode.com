package Controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.OrderDao;
import Models.Account;
import Models.Message;
import Models.OrdersDetail;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession sesion = request.getSession();
		Account acc = (Account) sesion.getAttribute("acc");
		String tager = request.getParameter("tager");
		
		if (acc == null || tager == null)
			return;

		// Trường hợp là xóa sản phẩm order detail
		if (tager.toLowerCase().trim().equals("order")) {
			OrderDao od = new OrderDao();
			List<OrdersDetail> cart = od.GetCart(acc.getUserEmail());
			
			if (!cart.isEmpty()) {
				int orderId = cart.get(0).getOrderId();
				String total = od.TotalOrder(orderId);
				request.setAttribute("total", total);
			} else {
				request.setAttribute("total", 0);
			}

			request.setAttribute("cart", cart);
			request.getRequestDispatcher("_CartTb.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String tager = request.getParameter("tager");
		HttpSession session = request.getSession();
		Account acc = (Account) session.getAttribute("acc");

		Message ms = null;
		if (acc == null || tager == null || id == null)
			return;

		String userEmail = acc.getUserEmail();
		if (tager.toLowerCase().trim().equals("order")) {
			OrderDao od = new OrderDao();
			ms = od.DeleteOrderDetail(userEmail, id);
		}
		request.setAttribute("ms", ms);
		request.getRequestDispatcher("_message.jsp").forward(request, response);

	}

}
