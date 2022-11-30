package Easy;

public class ClimbingStairs {
	public int climbStairs(int n) {
		int temp, y =1, rs =1;
		for(int i = 1; i < n; i++) {
			temp = rs;
			rs+= y;
			y = temp;
		}
		
		return rs;
	}
	
	
	public static void main(String[] args) {
		ClimbingStairs c = new ClimbingStairs();
		
		System.out.println(c.climbStairs(2));
		System.out.println(c.climbStairs(3));
		System.out.println(c.climbStairs(4));
		System.out.println(c.climbStairs(5));
		System.out.println(c.climbStairs(6));
		System.out.println(c.climbStairs(7));
		System.out.println(c.climbStairs(8));
		System.out.println(c.climbStairs(9));
		
	}
}
