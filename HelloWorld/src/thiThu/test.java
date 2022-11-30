package thiThu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class test {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n, m;
			n = sc.nextInt();
			m = sc.nextInt();
			long rs = m;
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				boolean checkMua = false;
				int vtb = 0, vtm = 0;
				// tim ngayf mua
				for (int j = i; j < n - 1; j++) {
					if (j == 0) {
						if (a[0] < a[1]) {
							vtm = 0;
							checkMua = true;
							break;
						}
						continue;
					}
					if (a[j] < a[j - 1] && a[j] < a[j + 1]) {
						vtm = j;
						checkMua = true;
						break;
					}
				}
				if (!checkMua)
					break; // khong co ngay mua
				// tim ngay ban
				for (int j = vtm + 1; j < n; j++) {
					if (j == n - 1) {
						if (a[n - 1] > a[n - 2]) {
							vtb = n - 1;
							checkMua = false; // da ban
						}
						continue; // break or continue de ko chay cau if ben duoi
					}
					if (a[j] > a[j - 1] && a[j] > a[j + 1]) {
						vtb = j;
						checkMua = false;
						break;
					}
				}
				// kiem tra neu ban co ngay ban thi moi tinh tong
				if (!checkMua) {
					long mua = rs / a[vtm];
					rs = rs % a[vtm];
					rs += mua * a[vtb];
					i = vtb;
				} else
					break;
			}
			rs -= m;
			System.out.println("#" + tc + " " + rs);
		}
	}
}
