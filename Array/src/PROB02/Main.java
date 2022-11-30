package PROB02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input1.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int[] listCua = new int [5];
			int[][] input = new int [m * 4][n];
			
			// gan gia tri cac mang
			
			for(int i = 1; i < 5; i++)
				listCua[i] = 0;
			
			for(int i = 0; i <= 5 * m ; i++) {
				String str = sc.next();
				
				if(i % 5 == 0)
					continue;
				
				for(int j = 0; j < n; j++)
					if(str.charAt(j * 5 + 1) == '.')
						input[i - i /5 - 1][j] = 0;
					else
						input[i - i /5 -1][j] = 1;
			}

			//dem rem cua
			
			for(int i = 0; i < 4 * m ; i += 4) {
				for(int j = 0; j < n; j++) {
					int count = 0;
					
					for(int k = 0; k < 4 ; k++)
						if(input[i + k][j] == 1)
							count++;
					
					listCua[count]++;
				}
			}
			
			System.out.print("#" + tc);
			for(int i = 0; i < 5; i++)
				System.out.print(" " + listCua[i]);
			System.out.println();
				
			
		}
	}
}
