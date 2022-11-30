package Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ApsBai9 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int[] a = new int[n];
			int[] rs = new int[n];
			// nhap mang
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();

			for (int i = 0; i < n; i++) {
				int j = 1, L = 0, R = 0, qL = a[i], qR = a[i], aL = 0, aR = 0;

				while (true) {
					if (i - j >= 0 && qL > 0) {
						if (qL >= a[i - j] * 2) {
							qL += a[i - j];
							aL += a[i - j];
						} else {
							aL += qL > a[i - j] ? a[i - j] : qL;
							qL -= a[i - j];

						}
					} else {
						qL = -1;
					}

					if (i + j < n && qR > 0) {
						if (qR >= a[i + j] * 2) {
							qR += a[i + j];
							aR += a[i + j];
						} else {
							aR += qR > a[i + j] ? a[i + j] : qR;
							qR -= a[i + j];

						}
					}else {
						qR = -1;
					}

					j++;
					if ((i - j < 0 && i + j == n) || (qL <= 0 && qR <= 0))
						break;
				}

				rs[i] = aL > aR ? aL : aR;
			}

			System.out.print("#" + tc);
			for (int item : rs)
				System.out.print(" " + item);
			System.out.println();
		}
	}
}
