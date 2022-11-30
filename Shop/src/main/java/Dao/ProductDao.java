package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import Context.Dbcontext;
import Models.Product;

public class ProductDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	private int pageSize = 8;
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
	 * hàm getById: truyền vào id sản phẩm và trả về sản phẩm có id trùng với id truyền vào
	 */
	public Product GetById(int id) {
		Product product = null;
		
		String query = "select * from Products\r\n"
				+ "where product_id = ?";
		
		try {
			conn = new Dbcontext().getConnection();
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				product = new Product(id, 
						rs.getString(2), 
						rs.getString(3), 
						rs.getFloat(4), 
						rs.getString(5), 
						rs.getString(6),
						rs.getString(7),
						fomatMoney(rs.getFloat(4)));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return product;
	}
	/*
	 * hàm seachByName: truyền vào text trả về sản phẩm có chứa text đó
	 */
	public List<Product> SeachByName(String name, int page){
		List<Product> products = new ArrayList<Product>();
		String query = "select * from Products\r\n"
				+ "where product_name like ?\r\n"
				+ "order by product_id Desc\r\n"
				+ "offset ? rows fetch next ? rows only";
		
		try {
			conn = new Dbcontext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + name.trim() + "%");
			ps.setInt(2, (page -1) * this.pageSize);
			ps.setInt(3, this.pageSize);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				Product product = new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getFloat(4), 
						rs.getString(5), 
						rs.getString(6),
						rs.getString(7),
						fomatMoney(rs.getFloat(4)));
				
				products.add(product);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return products;
	}
	/*
	 * GetAllProduct(): lay ra tat ca san pam
	 */
	public List<Product> GetAllProduct(){
		List<Product> products = new ArrayList<Product>();
		String query = "select * from Products\r\n"
				+ "order by product_id Desc\r\n";
		
		try {
			conn = new Dbcontext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()){
				Product product = new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getFloat(4), 
						rs.getString(5), 
						rs.getString(6),
						rs.getString(7),
						fomatMoney(rs.getFloat(4)));
				
				products.add(product);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return products;
	}
	/*
	 * hàm createProduct truyền vào thông tin sản phẩm, không trả về giá trị. hàm sẽ thêm mới sản phẩm
	 */
	
	public void Create(String name, String detail, float price, String source, String type, String brand) {
		String query = "insert into Products\r\n"
				+ "values(?,?,?,?,?,?)";
		
		try {
			conn = new Dbcontext().getConnection();
			ps = conn.prepareStatement(query);
			
			ps.setString(1, name);
			ps.setString(2, detail);
			ps.setFloat(3, price);
			ps.setString(4, source);
			ps.setString(5, type);
			ps.setString(6, brand);
			
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	/*
	 * ham Edit: nhan vao id san pham. khong tra ve gia tri, ham se chinh sua thong tin
	 */
	
	public void Edit(int id, String name, String detail, float price, String sourceImg, String type, String brand) {
		String query = "update Products\r\n"
				+ "set product_name = ?,\r\n"
				+ "product_des = ?,\r\n"
				+ "product_price = ?,\r\n"
				+ "product_img_source = ?,\r\n"
				+ "product_type = ?,\r\n"
				+ "product_brand = ?\r\n"
				+ "where product_id = ?";
		
		try {
			conn = new Dbcontext().getConnection();
			ps = conn.prepareStatement(query);
			
			ps.setString(1, name);
			ps.setString(2, detail);
			ps.setFloat(3, price);
			ps.setString(4, sourceImg);
			ps.setString(5, type);
			ps.setString(6, brand);
			ps.setInt(7, id);
			
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	/*
	 * MaxPage: tra ve so trang lon nhat
	 */
	public int MaxPage(String key) {
		int max = 0;
		String query = "select count(*) from Products\r\n"
				+ "where product_name like ?";
		
		try {
			conn = new Dbcontext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + key + "%");
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int count = rs.getInt(1);
				max = count / this.pageSize;
				if(count % this.pageSize != 0)
					max++;
				return max;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return max;
	}
	/*
	 * Delete(id): xoa 1 san pham
	 */
	
	public void Delete(int id) {
		String query ="delete Products\r\n"
				+ "where product_id = ?";
		try {
			conn = new Dbcontext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/*
	 * hàm mani kiem tra
	 */
	public static void main(String[] args) {
		ProductDao prs = new ProductDao();
		
	}
}
