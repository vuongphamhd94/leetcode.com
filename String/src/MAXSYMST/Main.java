package MAXSYMST;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void in (int[][] a, int l, String text) {
		System.out.println(text);
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String text = sc.next();
			int l = text.length();
			int[][] a = new int[l][l];
			int max = 0;
			for (int i = 0; i < l; i++)
				a[i][i] = 1;
			for (int i = 1; i < l; i++) {
				if (i == 1)
					for (int j = 0; j < l - 1; j++)
						if (text.charAt(j) == text.charAt(j + i)) {
							max = i;
							a[j][j + i] = 1;

						} else
							a[j][j + i] = 0;
				
			if(i > 1)
				for (int j = 0; j < l - i; j++)
					if (text.charAt(j) == text.charAt(j + i) && a[j + 1][i + j - 1] == 1) {
						max = i;
						a[j][j + i] = 1;

					} else
						a[j][j + i] = 0;
			}
			System.out.println("#" + tc + " " +( max +1));
		}
	}
}

