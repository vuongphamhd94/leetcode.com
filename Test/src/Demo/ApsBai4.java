package Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ApsBai4 {
	/*n la so muon kiem ta
	 * mang a chua cac so dep
	 * ket qua tra ve la so luong so dep trong n
	 * */
	static int dem(int n, int[] a) {
		int count = 0;
		char[] arr = (n + "").toCharArray();
		for(int i = 0; i < arr.length; i++)
			for(int j = 0; j < a.length; j++)
				if(arr[i] - '0' == a[j]) {
					count++;
					break;
				}
		return count;
	}
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			 int n = sc.nextInt();
			 int c = sc.nextInt();
			 int[] a = new int[n];
			 for(int i = 0; i< n; i++)
				 a[i] = sc.nextInt();
			 int x = sc.nextInt();
			 int y = sc.nextInt();
			 int count =0;
			 
			 for(int i = x; i <=y; i++) {
				 if(c <= dem(i, a))
					 count++;
			 }
			 
			 System.out.println("#" +tc+ " " + count);
		}
	}

}
