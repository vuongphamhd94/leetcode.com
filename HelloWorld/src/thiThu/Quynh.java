package thiThu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Quynh {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			int so_co_phieu = 0;
			int so_tien_du = 0;
			int pos = 0;
			long ans = 0;
			int current_money = m;
			long prev_ans = 0;
			while (pos < n ) {
				int min = a[pos], len_giam = 1;
				int[] day_con_giam = new int[100];
				day_con_giam[0] = a[pos];
				for (int j = pos + 1; j < n; j++) {
					if (a[j] < min) {
						min = a[j];
						day_con_giam[j - pos] = a[j];
						len_giam = j - pos + 1;
					} else
						break;
				}

				so_co_phieu = current_money / day_con_giam[len_giam - 1];
				so_tien_du = current_money - so_co_phieu * day_con_giam[len_giam - 1];
				prev_ans = current_money;
				
				if(len_giam + pos >= n) break;
				int max = a[len_giam + pos], len_con = 1;
				int day_con_tang [] = new int [100];

				day_con_tang[0] = a[len_giam + pos];
				for(int i = pos+len_giam + 1; i < n; i++)
					if(a[i] > max) {
						max = a[i];
						day_con_tang[i - len_giam-pos] = a[i];
						len_con = i - len_giam + 1-pos;
					}else break;
				
				current_money = so_co_phieu * day_con_tang[len_con - 1] + so_tien_du;
				if (current_money < prev_ans) {
					ans = prev_ans;
				}
				else {
					ans = current_money;
				}
				pos += len_con + len_giam;
			}
			System.out.println("#" + tc + " " + (ans - m));
		}
	}
}
