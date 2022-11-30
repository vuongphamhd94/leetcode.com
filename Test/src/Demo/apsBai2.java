package Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class apsBai2 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
		int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int Mx = 0, My = 0;
			int[][] a = new int[n][m];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++) {
					a[i][j] = sc.nextInt();
					if (a[i][j] == 2) {
						Mx = i;
						My = j;
					}	
				}
			int count = 0;
			for(int i = 0; i < 8; i++) {
				int x = Mx + dx[i];
				int y = My + dy[i];
				if(a[x][y] != 0)
					count++;
			}
			
			System.out.printf("#%d %d\n", tc, count);
		}
	}

}
