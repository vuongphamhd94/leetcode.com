package Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ApsBai12 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			sc.nextInt();
			sc.nextInt();
			int[][] a = new int[10][10];
			int[] b = new int[11];
			for(int i = 0; i < 10; i++)
				for(int j = 0; j < 10;  j++)
					a[i][j] = sc.nextInt();	
			
			for(int j = 0; j < 10; j++) {
				int c0 = 0;
				for(int i = 0; i < 10; i++)
					if(a[i][j] == 0)
						c0++;
				b[c0]++;
			}
			
			for(int i = 0; i < 5; i++) {
				if(n <= b[i]) {
					b[i] -= n;
					b[10 - i] += n;
					n = 0;
					break;
				}else {
					b[10 - i] += b[i];
					n -= b[i];
					b[i] = 0;
				}
			}
			int min = 0;
			for(int i = 1; i < 11; i++)
				if(b[i] != 0) {
					min = i;
					break;
				}
					
			
			int rs =0;
			for(int i = 0; i < 11; i++)
				rs += i * b[i];
			
			if(n % 2 == 1) {
				rs += (10 -2*min);
			}
			
			System.out.println("#" + tc + " " + rs);

			
		}
	}

}
