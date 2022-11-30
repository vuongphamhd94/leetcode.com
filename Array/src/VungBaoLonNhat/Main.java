package VungBaoLonNhat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input2.txt"));
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int a = 0; a < tc; a++) {
			int h = sc.nextInt(), w = sc.nextInt(), m = sc.nextInt(), n = sc.nextInt();
			int[][] arr = new int[m][n];
			int sum, maxSum = 0;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i <= m - h; i++) {
				for (int j = 0; j <= n - w; j++) {
					sum = 0;
					for (int k = 0; k < h; k++) {
						for (int l = 0; l < w; l++) {
							if (k == 0 || k == h - 1 || l == 0 || l == w - 1) {
								if (arr[i + k][j + l] % 2 == 0) {
									sum += arr[i + k][j + l];
								}
							}
						}
					}
					if (sum > maxSum) {
						maxSum = sum;
					}
				}
			}
			System.out.println("#" + (a + 1) + " " + maxSum);
		}
	}
}
