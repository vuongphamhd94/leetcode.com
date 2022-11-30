package Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ApsBai3 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
		int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			sc.next();
			int[][] a = new int[n][n];
			int [][] b = new int[2][n*n];
			int c = 0, count = 0;
			
			// nhap mang va dem so quan ma
			for(int i = 0; i< n; i++)
				for(int j = 0; j< n; j++) {
					a[i][j] = sc.nextInt();
					if(a[i][j] == 2) {
						b[0][c] = i;
						b[1][c] = j;
						c++;
					}
				}
			// dem so quan, qua da an dan lai == 0
			for(int i = 0; i < c; i++) {
				int x = b[0][i];
				int y = b[1][i];
				for(int j = 0; j < 8; j++) {
					int Mx = x + dx[j];
					int My = y + dy[j];
					if(Mx < 0 || Mx >= n || My<0 || My>= n)
						continue;
					if(a[Mx][My] != 0 ) {
						count++;
						a[Mx][My] = 0;
					}
						
				}
			}
			
			System.out.printf("#%d %d\n", tc, count);
		}
	}

}
