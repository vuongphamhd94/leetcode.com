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
 * Servlet implementation class OrderManagementControler
 */
@WebServlet("/qldh")
public class OrderManagementControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderManagementControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String statusStr = request.getParameter("status");
		String idStr = request.getParameter("id");
		OrderDao od = new OrderDao();
		HttpSession session = request.getSession();
		Account acc =(Account) session.getAttribute("acc");
		int sumPr = acc != null ? od.totalProductCart(acc.getUserEmail()) : 0;
		
		if(statusStr != null && idStr != null) {
			int id = Integer.valueOf(idStr);
			int status = Integer.valueOf(statusStr);
			od.changeOrderStatu(id, status);
		}
		
		List<Orders> orders = acc!=null? od.GetAllOrde(): null;
		
		request.setAttribute("sumPr", sumPr);
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("qldh.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
