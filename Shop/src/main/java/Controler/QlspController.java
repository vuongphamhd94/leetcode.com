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
import Dao.ProductDao;
import Models.Account;
import Models.Message;
import Models.Product;

/**
 * Servlet implementation class QlspController
 */
@WebServlet("/qlsp")
public class QlspController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QlspController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account acc = (Account) session.getAttribute("acc");
		OrderDao od = new OrderDao();
		ProductDao pr = new ProductDao();
		if(acc != null) {
			int sumPr = od.totalProductCart(acc.getUserEmail());
			request.setAttribute("sumPr", sumPr);
		}
		
		String action = request.getParameter("action");
		if(action != null && action.equals("edit")) {
			String idStr = request.getParameter("id");
			int id = Integer.valueOf(idStr);
			request.setAttribute("product", pr.GetById(id));
			request.setAttribute("isChange", true);
			request.getRequestDispatcher("_addProduct.jsp").forward(request, response);
			return;
		}
		
		if(action != null && action.equals("delete")) {
			String idStr = request.getParameter("id");
			int id = Integer.valueOf(idStr);
//			pr.Delete(id);
			return;
		}
		
		List<Product> products = pr.GetAllProduct();
		request.setAttribute("products", products);
		request.getRequestDispatcher("qlsp.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		String img = request.getParameter("img");
		String name = request.getParameter("name");
		String detail = request.getParameter("detail");
		String type = request.getParameter("type");
		String brand = request.getParameter("brand");
		String priceStr = request.getParameter("price");
		float price = Float.valueOf(priceStr);
		ProductDao pr = new ProductDao();
		if(action!=null && action.equals("add")) {
			pr.Create(name, detail, price, img, type, brand);
			return;
		}
		
		if(action != null && action.equals("change")) {
			String idStr = request.getParameter("id");
			if(idStr == null)
				return;
			int id = Integer.valueOf(idStr);
			pr.Edit(id, name, detail, price, img, type, brand);
//			Message ms = new Message("success", "Cập nhập thông tin sản phẩm thành công");
//			request.setAttribute("ms", ms);
//			request.getRequestDispatcher("_message.jsp").forward(request, response);
			return;
		}
		
	}

}
