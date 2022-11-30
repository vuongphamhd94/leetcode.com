package SLTKNGHT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input14.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int m = sc.nextInt();
			int d = sc.nextInt();
			int[][] a = new int [n][n];
			int[][] aK = new int [2][k];
			
			a[0][0] = 0;
			aK[0][0] = 0;
			
			/*
			 * ma = 1;
			 * tot = 2;
			 * ko an = 0;
			 * ko co quan = 0
			 * */
			for(int i = 0; i < k; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				aK[0][i] = r;
				aK[1][i] = c;
				a[r][c] = 1;
			}
			
			for(int i = 0; i< m; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				a[r][c] = 2;
			}
			
			for(int i = 0; i< d; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				a[r][c] = 3;
			}
			
			int max = 0, index = 0, count;
			
			for(int i = 0; i < k; i++ ) {
				count = 0;
				
				if(aK[0][i] - 2 >= 0 && aK[1][i] - 1 >= 0)
					if(a[aK[0][i] - 2][aK[1][i] - 1] != 0)
						count++;
				
				if(aK[0][i] - 2 >= 0 && aK[1][i] + 1 < n )
					if(a[aK[0][i] - 2][aK[1][i] + 1] != 0)
						count++;
				
				if(aK[0][i] - 1 >= 0 && aK[1][i] + 2 < n)
					if( a[aK[0][i] - 1][aK[1][i] + 2] != 0)
						count++;
				
				if(aK[0][i] + 1 < n && aK[1][i] + 2 < n )
					if(a[aK[0][i] + 1][aK[1][i] + 2] != 0)
						count++;
				
				if(aK[0][i] + 2 < n && aK[1][i] + 1 < n )
					if( a[aK[0][i] + 2][aK[1][i] + 1] != 0)
						count++;
				
				if(aK[0][i] + 2 < n && aK[1][i] - 1 >= 0)
					if( a[aK[0][i] + 2][aK[1][i] - 1] != 0)
						count++;
				
				if(aK[0][i] + 1 < n && aK[1][i] -2 >= 0 )
					if(a[aK[0][i] + 1][aK[1][i] - 2] != 0)
						count++;
				
				if(aK[0][i] - 1 >= 0 && aK[1][i] -2 >= 0 )
					if(a[aK[0][i] - 1][aK[1][i] - 2] != 0)
						count++;
				
				if(max < count) {
					max = count;
					index = i;
				}
			}
			
			System.out.println("#" + tc + " " + aK[0][index] + " " + aK[1][index] + " " + max);
		}
	}
}
