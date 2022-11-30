package Controler;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class DetailController
 */
@WebServlet("/detail")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("id");
		ProductDao pd = new ProductDao();
		OrderDao od = new OrderDao();
		HttpSession session = request.getSession();
		Account acc =(Account) session.getAttribute("acc");
		if(acc != null) {
			request.setAttribute("sumPr", od.totalProductCart(acc.getUserEmail()));
		}
		Product product = null;
		if(strId != null) {
			int id = Integer.valueOf(strId);
			product = pd.GetById(id);
			request.setAttribute("product", product);
			request.getRequestDispatcher("_detaiProduct.jsp").forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Message ms = null;
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
		PrintWriter out  = response.getWriter();
		OrderDao od = new OrderDao();
		String idStr = request.getParameter("id");
		String amountStr = request.getParameter("amount");
		
		HttpSession session = request.getSession();
		Account acc = (Account)session.getAttribute("acc");
		if(acc == null) {
			return;
		}
		int id = Integer.valueOf(idStr);
		int amount = Integer.valueOf(amountStr);
		int orderId = od.CreateOrder(acc.getUserEmail());
		od.CreateOrderDetail(orderId, id, amount);
		out.print(1 +" " + acc.getUserEmail());
		ms = new Message("success", "Thêm vào giỏ hàng thành công");
		request.setAttribute("ms", ms);
		request.getRequestDispatcher("_message.jsp").forward(request, response);
	}

}
