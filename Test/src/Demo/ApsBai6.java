package Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ApsBai6 {
/// H T L U
	static int Count1(int[][] a, int row, int col) {
		int count = 0;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (a[row + i][col + j] == 1)
					count++;
		return count;
	}

	static int check(int[][] a, int row, int col) {
		if (Count1(a, row, col) == 7) {
			if ((a[row][col + 1] == 0 && a[row + 2][col + 1] == 0)
					|| (a[row + 1][col] == 0 && a[row + 1][col + 2] == 0))
				return 1;
		}

		if (Count1(a, row, col) == 5) {
			int i = 0, j = 0;
			// check L
			for (i = 0; i < 2; i++) {
				for (j = 0; j < 2; j++)
					if (a[row + i][col + j] == 0 && a[row + i][col + j + 1] == 0 && a[row + i + 1][col + j] == 0
							&& a[row + i + 1][col + j + 1] == 0)
						break;
				if (j != 2)
					break;
			}

			if (i < 2)
				return 3;

			// check T
			for (i = 0; i < 2; i++)
				if (a[row + i][col] == 0 && a[row + i + 1][col] == 0 && a[row + i][col + 2] == 0
						&& a[row + i + 1][col + 2] == 0)
					break;

			for (j = 0; j < 2; j++)
				if (a[row][col + j] == 0 && a[row][col + j + 1] == 0 && a[row + 2][col + j] == 0
						&& a[row + 2][col + j + 1] == 0)
					break;

			if (i < 2 || j < 2)
				return 2;

			// check U
			for (i = 0; i < 2; i++)
				if (a[row + i][col] == 1 && a[row + i + 1][col] == 1 && a[row + i][col + 2] == 1
						&& a[row + i + 1][col + 2] == 1)
					break;

			for (j = 0; j < 2; j++)
				if (a[row][col + j] == 1 && a[row][col + j + 1] == 1 && a[row + 2][col + j] == 1
						&& a[row + 2][col + j + 1] == 1)
					break;

			if ((i == 0 && a[row + 2][col + 1] == 1) || (i == 1 && a[row][col + 1] == 1)
					|| (j == 0 && a[row + 1][col + 2] == 1) || (j == 1 && a[row + 1][col] == 1))
				return 4;
		}
		return 0;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			sc.next();
			int H = 0, T = 0, L = 0, U = 0;
			int[][] a = new int[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();

			for (int i = 0; i <= n - 3; i++)
				for (int j = 0; j <= n - 3; j++)
					switch (check(a, i, j)) {
					case 1:
						H++;
						break;
					case 2:
						T++;
						break;
					case 3:
						L++;
						break;
					case 4:
						U++;
						break;
					default:
						continue;
					}
			System.out.printf("#%d %d %d %d %d\n", tc, H, T, L, U);
		}
	}

}
