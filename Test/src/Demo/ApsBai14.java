package Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ApsBai14 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int[][] a = new int[m][n];
			// nhap mang
			for (int i = 0; i < m; i++)
				for (int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();

			int s = (m - 3) / 2;

			// tim tong max
			int max = 0;
			for (int j = 0; j < n; j++)
				// cot duoc chon chay tu 0 => 4
				for (int h = 0; h <= 4; h++) {
					int sum = 0;
					// xet moi cot 3 dong moi dong ghi gia tri vao mang a1 de tinh tong
					for (int r = 0; r < 3; r++) {
						int a1[] = new int[n];
						// neu cot trung voi cot dc chon thi bat dau tu h
						for (int k = 0; k < n; k++) {
							int i = j == k ? h + r : s + r;
							a1[k] = a[i][k];
						}

						boolean x3 = true;
						int sum1 = a1[0];

						for (int k = 1; k < n; k++) {
							sum1 += a1[k];
							if (a1[k] != a1[k - 1])
								x3 = false;
						}

						if (x3) {
							if (a1[0] == 7)
								sum1 = 100;
							else
								sum1 = a1[0] * 10;
						}

						sum += sum1;
					}
					max = max > sum ? max : sum;

				}
			System.out.println("#" + tc + " " + max);
		}
	}

}
