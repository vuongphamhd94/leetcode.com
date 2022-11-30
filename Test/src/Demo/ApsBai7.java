package Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ApsBai7 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int[] a = new int[n];

			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();

			int i, j, f, max = 0;
			for (i = 0; i < n; i++) {
				j = i;
				f = 0;
				int next = 1;// doi chieu * -1
				while (true) {
					int fNext, fPr;
					// tinh luc diem tiep theo
					if (j + next >= n || j + next < 0) {
						fNext = -1;
					} else {
						fNext = a[j] > a[j + next] ? f + a[j] - a[j + next] : f + 3 * (a[j] - a[j + next]);
					}
					// tinh luc diem phai sau
					if (j - next >= n || j - next < 0) {
						fPr = -1;
					} else {
						fPr = a[j] > a[j - next] ? f + a[j] - a[j - next] : f + 3 * (a[j] - a[j - next]);
					}
					// kiem tra neu du luc thi luot den diem tiep theo
					if (fNext >= 0) {
						j += next;
						f = fNext;
						continue;
					}
					// ko du luc luot tiep va diem phia sau bang diem hien tai dung lai
					if (j - next < n && j - next >= 0)
						if (a[j] == a[j - next])
							break;
					// khong du luc luot tiep. neu du luc luot lai phai sau thi luot nguoc lai doi next = -1
					if (fPr >= 0) {
						next *= -1;
						j += next;
						f = fPr;
						continue;
					}
					// khong du luc luot phai truoc va phai sau thoat
					break;
				}
				int d = j > i ? j - i : i - j;
				max = max < d ? d : max;
			}
			System.out.println("#" + tc + " " + max);
		}

	}

}
