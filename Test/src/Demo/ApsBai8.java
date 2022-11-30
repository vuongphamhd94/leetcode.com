package Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ApsBai8 {
	static void in(int[][] a, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.printf("%d ", a[i][j]);
			System.out.println();
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			sc.next();
			int[][] a = new int[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();

			// in kiem tra ket qua
//			System.out.println("#" + tc);
//			in(a, n);
			
			int[] rs = new int[n];
			for (int item : rs) {
				item = 0;
			}

			for (int i = n - 1; i >= 0; i--) {
				for (int j = 0; j < n; j++) {
					if (a[i][j] == 1) {
						rs[j]++;
						a[i][j] = 0;
						if (i == 0) {
							rs[j + 1]++;
							rs[j] = rs[j] > rs[j +1] ? rs[j] : rs[j + 1];
							rs[j + 1] = rs[j];
							a[i][j + 1] = 0;
							continue;
						}

						if (j == n -1) {
							rs[j]++;
							a[i - 1][j] = 0;
							continue;
						}
						
						if(a[i -1][j] == 1) {
							rs[j]++;
							a[i - 1][j] = 0;
							continue;
						}
						
						if(a[i][j+1] == 1) {
							rs[j + 1]++;
							rs[j] = rs[j] > rs[j +1] ? rs[j] : rs[j + 1];
							rs[j + 1] = rs[j];
							a[i][j + 1] = 0;
							continue;
						}
					}
				}
			}
			System.out.print("#" + tc);
			for(int item : rs)
				System.out.print(" "+ item);
			System.out.println();

		}
	}
}
