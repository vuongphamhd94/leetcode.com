package Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ApsBai13 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] a = new int[n][m];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < m; j++)
					a[i][j] = sc.nextInt();
			
			int t,r,l,b, count = 0;
			
			for(int i = 0; i<= n - 2; i++) {
				for(int j = 0; j <= m - 2; j++) {
					if(a[i][j] == 1) {
						t = b = i;
						l = r = j;
						// xac dinh vi tri cot ben phai
						while(true) {
							if(r == m - 2) {
								if(a[t][r + 1] == 1)
									r++;
								break;
							}
							
							if(a[t][r + 1] == 1) {
								r++;
							}else {
								break;
							}
						}
						// xac dong ben duoi
						while(true) {
							if(b == n - 2) {
								if(a[b + 1][r] == 1) {
									b++;
									break;
								}
							}
							
							if(a[b + 1][r] == 1) {
								b++;
							}else {
								break;
							}
						}
						
						//kiem tra kich thuoc ma tran
						if(t == b || l == r || t - b > 4 || l - r > 4) {
							continue;
						}
						
						// kiem tra dong ngoai cua ma tran co bang 1 va bao boi 0
						int k;
						for(k = l; k <= r; k++) {
							if(t != 0) {
								if(a[t -1][k] != 0)
									break;
							}
							
							if(b != n - 1) {
								if(a[b + 1][k] != 0)
									break;
							}
							
							if(a[t][k] != 1 || a[b][k] != 1)
								break; 
						}
						
						if(k != r + 1)
							continue;
						
						// kiem tra cot ngoai cua ma tran bang 1 va co bao boi 0
						for(k = t; k <= b; k++) {
							if(l != 0) {
								if(a[k][l - 1] != 0)
									break;
							}
							
							if(r != m - 1) {
								if(a[k][r + 1] != 0)
									break;
							}
							
							if(a[k][l] != 1 || a[k][r] != 1)
								break; 
						}
						
						if(k != b + 1)
							continue;
						
						// neu thoa ma dc dieu kien thi tang count
						count++;
						
					}
				}
			}
			
			System.out.println("#" + tc + " " + count);
		}
	}
}
