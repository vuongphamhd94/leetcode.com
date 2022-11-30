package Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ApsBai10 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int h = sc.nextInt();
			int[] a = new int [n];
			for(int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			
			// so cay co the thu hoac
			int d = (h / 3) * 2 + 1;
			
			long sumMax = 0;
			long sum;
			
			// neu so cay co nho hon hoac bang so cay co the thu hoac thi bang tong tat ca. neu khogn thi tim max
			if(d >= n) {
				sum = 0;
				for(int item : a)
					sum += item;
				sumMax = sum;
			}else {
				for(int i = 0; i <= n - d; i++) {
					sum = 0;
					for(int j = 0; j < d; j++ )
						sum += a[i + j];
					
					sumMax = sumMax > sum ? sumMax : sum;
				}
			}
			System.out.println("#" + tc + " " + sumMax);
		}
	}

}
