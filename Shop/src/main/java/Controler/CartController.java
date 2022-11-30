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
 * Servlet implementation class CartController
 */
@WebServlet("/cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartController() {
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
		String action = request.getParameter("action");
		HttpSession sesion = request.getSession();
		Account acc = (Account) sesion.getAttribute("acc");
		OrderDao od = new OrderDao();
		List<OrdersDetail> cart = null;
		if (acc != null) {
			cart = od.GetCart(acc.getUserEmail());
			request.setAttribute("sumPr", od.totalProductCart(acc.getUserEmail()));
		}

		if (!cart.isEmpty()) {
			int orderId = cart.get(0).getOrderId();
			String total = od.TotalOrder(orderId);
			request.setAttribute("orderId", orderId);
			request.setAttribute("total", total);
		} else {
			request.setAttribute("orderId", 0);
			request.setAttribute("total", 0);
		}

		request.setAttribute("cart", cart);
		request.setAttribute("acc", acc);
		if (action == null) {
			request.getRequestDispatcher("_Cart.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("_checkOut.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Message ms = null;
		String orderIdStr = request.getParameter("orderId");
		String fullName = request.getParameter("fullName");
		String address = request.getParameter("address");
		String discountCode = request.getParameter("discountCode");
		if (discountCode.isEmpty()) {
			discountCode = "NULL";
		}
		OrderDao od = new OrderDao();
		int orderId = 0;
		orderId = Integer.valueOf(orderIdStr);

		if (orderId != 0) {
			od.UpdateOrder(orderId, discountCode, address);
			od.changeOrderStatu(orderId, 1);
			ms = new Message("success", "Đặt hàng thành công!");

		} else {
			ms = new Message("errol", "Không có sản phẩm nào trong giỏ hàng!");
		}
		request.setAttribute("ms", ms);
		request.getRequestDispatcher("_message.jsp").forward(request, response);

	}

}
