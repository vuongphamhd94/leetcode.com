package LOGOSYM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input11.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			// nhap mang
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					arr[i][j] = sc.nextInt();
			// chia doi mang
			int mid = n / 2 - 1;
			boolean check = true;
			// chia ngang
			for (int i = 0; i <= mid; i++) {
				if (!check)
					break;

				for (int j = 0; j < n; j++) {
					if (arr[i][j] != arr[n - i - 1][j]) {
						check = false;
						break;
					}
				}
			}
			// chia doc
			for (int i = 0; i < n; i++) {
				if (!check)
					break;

				for (int j = 0; j <= mid; j++) {
					if (arr[i][j] != arr[i][n - j - 1]) {
						check = false;
						break;
					}
				}
			}

			if (check)
				System.out.println("#" + tc + " " + "YES");
			else
				System.out.println("#" + tc + " " + "NO");
		}
	}
}