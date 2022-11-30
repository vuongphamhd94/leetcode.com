package BTFNUM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input13.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			int[] soDep = new int[n];
			// lay danh sach cac so dep
			for (int i = 0; i < n; i++)
				soDep[i] = sc.nextInt();
			// im so dep max

			int max = soDep[0];
			for (int i = 1; i < n; i++)
				if (max < soDep[i])
					max = soDep[i];
			// mang luu so

			int[] mangLuu = new int[max + 1];

			// vung xet so
			int x = sc.nextInt();
			int y = sc.nextInt();
			int count = 0;

			for (int i = x; i <= y; i++) {
				String str = i + "";

				for (int k = 0; k <= max; k++)
					mangLuu[k] = 0;

				for (int j = 0; j < str.length(); j++)
					if (str.charAt(j) - '0' <= max)
						mangLuu[str.charAt(j) - '0']++;

				int sum = 0;
				for (int j = 0; j < n; j++)
					sum += mangLuu[soDep[j]];

				if (sum >= m)
					count++;
			}

			System.out.println("#" + tc + " " + count);

		}
	}
}
