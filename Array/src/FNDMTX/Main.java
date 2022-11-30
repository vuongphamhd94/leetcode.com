package FNDMTX;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * 1. nhap mang
 * 2. khai bao 1 mang 3*(n-m + 1) :
 * 		- dong 1 la gia tri hieu nho nhat cua moi dong
 * 		- dong 2: tri so dong tuong ung vo hieu
 * 		- dong3: tri so cot
 * 3. tim gia tri thoa ma; va in ra
 * 
 * */
public class Main {
	public static void main(String[] args) throws FileNotFoundException  {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1 ; tc <= T; tc++) {
			int N = sc.nextInt(),
				M = sc.nextInt();
			long k = sc.nextLong();
			int[][] arr = new int[N][N];
			// nhap mang
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					arr[i][j] = sc.nextInt();
			
			//2
			long[][] a = new long [3][N - M +1];
			// gan gia tri co mang a
			
			for(int i = 0; i <= N -M; i++) {
				a[1][i] = i;
				long minK, indexK = 0;
				long sum = 0;
				
				for(int n = 0; n < M; n++)
					for(int m = 0; m < M; m++) {
						sum+=arr[i + n ][m];
					}
				
				minK = sum - k;
				
				for(int j = 1; j <= N - M; j++) {
					sum =0;
					
					for(int n = 0; n < M; n++)
						for(int m = 0; m < M; m++) {
							sum+=arr[i + n ][j + m];
						}
					
					if(Math.abs(minK) > Math.abs(sum-k)) {
						minK = sum - k;
						indexK = j;
					}
					
					if(Math.abs(minK) == Math.abs(sum-k))
						if(minK > sum-k) {
							minK = sum - k;
							indexK = j;
						}
				}
				a[0][i]= minK;
				a[2][i]= indexK;
			}
			
			//3. tim gai tri can
			long min = a[0][0];
			int index = 0;
			for(int i = 1 ; i <= N - M; i++) {
				if(Math.abs(min) > Math.abs(a[0][i])) {
					min = a[0][i];
					index = i;
				}
				
				if(Math.abs(min) == Math.abs(a[0][i])){
					if(min > a[0][i]) {
						min = a[0][i];
						index = i;
					}else if(a[1][index] > a[1][i])
						index = i;
				}
						
			}
			
			System.out.println("#" + tc + " " + a[1][index] + " " + a[2][index]);
		}
		
	}
}
