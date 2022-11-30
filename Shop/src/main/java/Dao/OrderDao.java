package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import Context.Dbcontext;
import Models.Account;
import Models.Message;
import Models.Orders;
import Models.OrdersDetail;
import Models.Product;

public class OrderDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	/*
	 * hàm fomatMoney nhận sao một số đinh float là giá sản phẩm đơn vi triệu đông
	 * hàm trả về đơn vị đồng
	 */
	public String fomatMoney(float n) {
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		return currencyVN.format(n * 1000000);
	}

	/*
	 * ham Order: khi khonf dang nhap: truyen vao: username ham tra ve orderId
	 */
	public int CreateOrder(String userName) {
		LoginDao lg = new LoginDao();
		Account acc = lg.GetByUserName(userName);
		int orderId = 0;
		String query = "select order_id from Orders\r\n" + "where user_mail = ? and order_status = 0";

		try {
			conn = new Dbcontext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, userName);
			rs = ps.executeQuery();

			if (rs.next())
				orderId = rs.getInt(1);

			rs.close();
			ps.close();

			if (orderId != 0) {
				conn.close();
				return orderId;
			}

			query = "insert into Orders\r\n"
					+ "values(?,0,GETDATE (),null,?)\r\n"
					+ "select order_id from Orders\r\n"
					+ "where user_mail = ? and order_status = 0";

			ps = conn.prepareStatement(query);
			ps.setString(1, acc.getUserEmail());
			ps.setString(2, acc.getAddress());
			ps.setString(3, acc.getUserEmail());

			rs = ps.executeQuery();
			if (rs.next())
				orderId = rs.getInt(1);

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return orderId;
	}
	/*
	 * GetAllOrde: truyen vao userEmail va status. tra ve danh sach cac order
	 */

	public List<Orders> GetAllOrde(String userName, int status) {
		List<Orders> orders = new ArrayList<Orders>();
		String query = "\r\n" + "select * from Orders\r\n" 
		+ "where user_mail = ? and order_status >= 1 and order_status <= ?\r\n"
		+ "order by order_status";

		try {
			conn = new Dbcontext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, userName);
			ps.setInt(2, status);

			rs = ps.executeQuery();

			while (rs.next()) {
				Orders order = new Orders(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getString(5),
						rs.getString(6));

				orders.add(order);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return orders;
	}
	
	public List<Orders> GetAllOrde() {
		List<Orders> orders = new ArrayList<Orders>();
		String query = "select * from Orders\r\n"
				+ "where order_status > 0\r\n"
				+ "order by order_status";

		try {
			conn = new Dbcontext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				Orders order = new Orders(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getString(5),
						rs.getString(6));

				orders.add(order);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return orders;
	}

	/*
	 * UpdateOrder: truyenn vao orderId. order khong co sap nao thi xoa. co thi thay
	 * doi thong tin
	 */
	
	public void UpdateOrder(int orderId, String discount, String address) {
		String query = "update Orders\r\n"
				+ "set order_date = GETDATE(),\r\n"
				+ "order_discount_code = ?,\r\n"
				+ "order_address = ?\r\n"
				+ "where order_id = ?";
		
		try {
			conn = new Dbcontext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,discount);
			ps.setNString(2, address);
			ps.setInt(3, orderId);
			ps.executeQuery();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
/*
 * changeOrderStatu(id) tien hanh dat hang
 *
 */
	public void changeOrderStatu(int orderId, int status) {
		String query = "update Orders\r\n"
				+ "set order_status = ?\r\n"
				+ "where order_id = ?";
		try {
			conn = new Dbcontext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, status);
			ps.setInt(2, orderId);
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	/*
	 * UpdateOrderDetail truyen vao id cua oder va id sp vaf so luong. neu so luong
	 * == 0 thi xoa neu sl != thi update lai
	 */
	public void UpdateOrderDetail(int orderId, int producId, int amount) {
		String query;

		if (amount == 0) {
			query = "delete from Orders_detail\r\n" + "where order_id = ? and product_id = ?";
		} else {
			query = "update Orders_detail\r\n"
					+ "set amount_product = ?\r\n"
					+ "where order_id = ? and product_id = ?";
		}

		try {
			conn = new Dbcontext().getConnection();
			ps = conn.prepareStatement(query);

			if (amount == 0) {
				ps.setInt(1, orderId);
				ps.setInt(2, producId);
			} else {
				ps.setInt(1, amount);
				ps.setInt(2, orderId);
				ps.setInt(3, producId);
			}

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void CreateOrderDetail(int orderId, int productId, int amount) {
		ProductDao pd = new ProductDao();
		// lay thong tin product
		Product product = pd.GetById(productId);
		// kiem tra xem product da co trong gio hang chua
		int count = 0;
		String query = "select amount_product from Orders_detail\r\n" + "where order_id = ? and product_id = ?";

		try {
			conn = new Dbcontext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, orderId);
			ps.setInt(2, productId);

			rs = ps.executeQuery();
			if (rs.next())
				count = rs.getInt(1);
			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		// neu san pham da co trong gio hang thi update lai so luong. chua co thi tao
		// moi
		if (count != 0)
			UpdateOrderDetail(orderId, productId, count + amount);
		else {
			query = "insert into Orders_detail\r\n" + "values(?,?,?,?)";
			try {
				conn = new Dbcontext().getConnection();
				ps = conn.prepareStatement(query);
				ps.setInt(1, orderId);
				ps.setInt(2, productId);
				ps.setInt(3, amount);
				float a = product.getPrice();
				ps.setString(4, a+"");

				ps.executeUpdate();

				ps.close();
				conn.close();

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/*
	 * GetAllOrderDetails; truyen vao orderId: tra ve danh sach cac orderdetails
	 */
	public List<OrdersDetail> GetAllOrderDetails(int orderId) {
		String query = "select * from Orders_detail\r\n" + "where order_id = ?";
		List<OrdersDetail> orderDetails = new ArrayList<OrdersDetail>();
		try {
			conn = new Dbcontext().getConnection();
			ps = conn.prepareStatement(query);

			ps.setInt(1, orderId);
			rs = ps.executeQuery();
			while (rs.next()) {
				OrdersDetail odt = new OrdersDetail(orderId, rs.getInt(2), rs.getInt(3), rs.getFloat(4));
				orderDetails.add(odt);
			}
			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return orderDetails;
	}
	/*
	 * GetCart(userEmail) lay ra danh sach cac san pham trong gio hang
	 */
	
	public List<OrdersDetail> GetCart(String userEmail){
		String query = "select order_id from Orders\r\n"
				+ "where user_mail = ? and order_status = 0;";
		List<OrdersDetail> orderDetails = new ArrayList<OrdersDetail>();
		try {
			conn = new Dbcontext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, userEmail);
			rs = ps.executeQuery();
			if(rs.next()) {
				int id = rs.getInt(1);
				orderDetails = GetAllOrderDetails(id);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		ProductDao prs = new ProductDao();
		for(OrdersDetail o : orderDetails) {
			o.setProductName(prs.GetById(o.getProductId()).getName());
		}
		return orderDetails;
	}
	public int totalProductCart(String user) {
		int count = 0;
		String query ="select SUM(amount_product) from Orders_detail as dt\r\n"
				+ "Join Orders as od on od.order_id = dt.order_id\r\n"
				+ "where od.user_mail = ? and od.order_status = 0";
		
		try {
			conn = new Dbcontext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return count;
	}
/*
 * TotalOrder(int id) tra ve tong so tien
 */
	public String TotalOrder(int id) {
		String query = "select SUM(price_product * amount_product) from Orders_detail\r\n"
				+ "where order_id = ?";
		float sum = 0;
		try {
			conn = new Dbcontext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next())
				sum = rs.getFloat(1);
			
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return fomatMoney(sum);
	}
	public Message DeleteOrderDetail(String userEmail, String id) {
		Message ms = null;
		String query = "delete Orders_detail\r\n"
				+ "where order_id = (select order_id from Orders "
				+ "where order_status = 0 and user_mail = ?) "
				+ "and product_id = ?";
		try {
			conn = new Dbcontext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, userEmail);
			ps.setString(2, id);
			ps.executeUpdate();
			ms = new Message("sussecc", "Xóa sản phẩn khỏi giỏ hàng thành công!");
			ps.close();
			conn.close();
		} catch (Exception e) {
			ms = new Message("errol", "Xoa sản phẩn thất bại!");
		}
		return ms;
	}
	/*
	 * ham mani test
	 */
	public static void main(String[] args) {
		OrderDao od = new OrderDao();
		List<Orders> orders = od.GetAllOrde("vuongphamhd94@gmail.com", 14);
		
		System.out.println(od.DeleteOrderDetail("vuongphamhd94@gmail.com", "9").getMessage());

	}
}
