package Dao;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Context.Dbcontext;
import Models.Account;

public class LoginDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	private int count;

	/*
	 * ham toMd5 tra ve choi ma hoa
	 */
	public String toMd5(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String md5;
		MessageDigest msd = MessageDigest.getInstance("MD5");
		byte[] srcTextBytes = text.getBytes("UTF-8");
		byte[] enrTextBytes = msd.digest(srcTextBytes);
		BigInteger bigInt = new BigInteger(1, enrTextBytes);
		md5 = bigInt.toString(16);
		return md5;
	}

	/*
	 * ham login truyen vao userEmail và password. nếu đúng thông tin thì trả về acc
	 * đó sai thi tra về null.
	 */
	public Account Login(String userEmail, String password)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Account acc = null;
		String pass = toMd5(password);
		String query = "select * from Account\r\n" + "where user_mail = ? and password= ?";

		try {
			conn = new Dbcontext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, userEmail.trim());
			ps.setString(2, pass);
			rs = ps.executeQuery();
			if (rs.next()) {
				acc = new Account(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return acc;
	}

	/*
	 * hàm iUserEmail truyền vào tên userEmail. kiển tra xem user đã tồn tại chưa đã
	 * có trả về false. chưa có trả về true
	 */
	public boolean isUserEmail(String userEmail) {

		String query = "select count(*) from Account\r\n" + "where user_mail = ?";
		int count = 0;
		try {
			conn = new Dbcontext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, userEmail.trim());
			rs = ps.executeQuery();

			if (rs.next())
				count = rs.getInt(1);

		} catch (Exception e) {
			System.out.println(e);
		}

		return count != 0 ? false : true;
	}

	/*
	 * hàm addAcount truyền vào thông acc tạo mới acc
	 */
	public void CreateAccount(String userEmail, String password, String fullName, String address, String phone)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {

		String pass = toMd5(password);
		int role = 0;
		String query = "insert into Account\r\n" + "values(?,?,?,?,?,?)";
		try {
			conn = new Dbcontext().getConnection();
			ps = conn.prepareStatement(query);

			ps.setString(1, userEmail);
			ps.setString(2, pass);
			ps.setInt(3, role);
			ps.setString(4, fullName);
			ps.setString(5, address);
			ps.setString(6, phone);

			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	/*
	 * GetByUserName: truyen vao userName tra ve thong tin acc
	 */
	
	public Account GetByUserName(String userName) {
		Account acc = null;
		String query = "select * from Account\r\n"
				+ "where user_mail = ?";
		
		try {
			conn = new Dbcontext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				acc = new Account(rs.getString(1), 
						null, rs.getInt(3),
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6));
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return acc;
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		LoginDao lg = new LoginDao();
		Account acc = null;
		try {
			acc = lg.Login("vuongphamhd94@gmail.com", "123456");
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(acc);
	}

}
