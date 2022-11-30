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

			query = "insert into Orders\r\n" + "values(?,0,GETDATE (),null,?)" + "select order_id from Orders"
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
		String query = "\r\n" + "select * from Orders\r\n" + "where user_mail = ? and order_status = ?";

		try {
			conn = new Dbcontext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, userName);
			ps.setInt(2, status);

			rs = ps.executeQuery();

			if (rs.next()) {
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
	 * UpdateOrderDetail truyen vao id cua oder va id sp vaf so luong. neu so luong
	 * == 0 thi xoa neu sl != thi update lai
	 */
	public void UpdateOrderDetail(int orderId, int producId, int amount) {
		String query;

		if (amount == 0) {
			query = "delete from Orders_detail\r\n" + "where order_id = ? and product_id = ?";
		} else {
			query = "update Orders_detail\r\n" + "set amount_product = ?\r\n" + "where order_id = ? and product_id = ?";
		}

		try {
			conn = new Dbcontext().getConnection();
			ps = conn.prepareStatement(query);

			if (amount == 0) {
				ps.setInt(1, orderId);
				ps.setInt(2, producId);
			} else {
				ps.setInt(1, amount);
				ps.setInt(2, producId);
				ps.setInt(3, producId);
			}

			ps.executeQuery();

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
				ps.setFloat(4, product.getPrice());

				rs = ps.executeQuery();

				rs.close();
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
	 * ham mani test
	 */
	public static void main(String[] args) {
		OrderDao od = new OrderDao();

		List<OrdersDetail> list = od.GetAllOrderDetails(2);
		System.out.println(list.size());
		for(OrdersDetail o:list)
			System.out.println(o);

	}
}
