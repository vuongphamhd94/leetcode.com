package Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BuildCenter {
	static long building(int[][] hire, int n, int k) {
		long sum = 0;
		int m = hire.length;
		for(int i = 0; i < m -1; i++)
			for(int j = i + 1; j < m; j++)
				if(hire[i][3] > hire[j][3])
					for(int t = 0; t < 4; t++) {
						int item =hire[i][t];
						hire[i][t] = hire[j][t];
						hire[j][t] = item;
					}
		for(int i = 0; i < n; i++) {
			int t = k;
			for(int j = 0; j < m; j++) {
				if(t == 0)
					break;
				if(hire[j][0] <= i + 1 && hire[j][1] >= i + 1 ) {
					if(t <= hire[j][2]) {
						sum += t * hire[j][3];
						t = 0;
						break;
					}else {
						sum += hire[j][2] * hire[j][3];
						t -= hire[j][2];
					}
				}
			}
		}
		return sum;
	}
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int m = sc.nextInt();
		int[][] a = new int[m][4];
		for(int i = 0; i < m; i++)
			for(int j = 0; j < 4; j++)
				a[i][j] = sc.nextInt();
	
		System.out.println(building(a, n, k));
		
	}
}
