package Easy;

import java.util.Stack;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		Stack<Integer> stack = new Stack<>();
		int soDu = 1;
		for(int i = digits.length -1;i >=0; i-- ) {
			stack.add((digits[i] + soDu)%10);
			soDu = (digits[i] + soDu)/10;
		}
		
		if(soDu >0)
			stack.add(soDu);
		
		int n = stack.size();
		int[] rs = new int[n];
		
		for(int i = 0 ;i < n; i++) {
			rs[i] = stack.pop();
		}
		
		return rs;
	}

	public static void main(String[] args) {
		PlusOne p = new PlusOne();

		int[] a = new int[] { 9,8,7,6,5,4,3,2,1,0 };
		int[] b = p.plusOne(a);
		for(int i : b) {
			System.out.println(i);
		}
	}
}
