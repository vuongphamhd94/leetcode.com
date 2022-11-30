package Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ApsBai5 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][]a = new int[n][m];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < m; j++)
					a[i][j] = sc.nextInt();
			
			int countTG = 0;
			for(int i = 0; i<= n -2; i++)
				for(int j = 0; j<= m -2; j++) {
					int count1 = 0;
					
					for(int k = 0; k < 2; k++)
						for(int h =0; h < 2; h++)
							if(a[i+k][j+h] == 1)
								count1++;
					
					if(count1 == 4)
						countTG +=4;
					
					if(count1 == 3)
						countTG++;
				}
			
			System.out.println("#" + tc + " " + countTG);
					
		}
	}

}
