package Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ApsBai15 {

	static int turn(int[] a, int i, int rl) {
		int count = a[i];
		a[i] = 0;
		while (count != 0) {
			i += rl;
			if (i == 12)
				i = 0;

			if (i == -1)
				i = 11;
			a[i]++;
			count--;
		}
		int nextI = i + rl;

		if (nextI == -1)
			nextI = 11;

		if (nextI == 12)
			nextI = 0;

		if (nextI == 5 || nextI == 11 || a[nextI] == 0)
			return quanAn(a, i, rl);

		return turn(a, nextI, rl);

	}

	static int quanAn(int[]a, int i, int rl) {
		int count =0;
		int nextI = i + rl;
		
		if (nextI == -1)
			nextI = 11;
		
		if(nextI == 12)
			nextI = 0;
		
		
		while(a[nextI] == 0 && count <= 5) {
			count++;
			
			nextI = nextI + rl *2;
			
			if (nextI < 0)
				nextI += 12;
			
			if(nextI > 11)
				nextI -= 12;
		}
		int rs = 0;
		for(int j = 1; j <= count; j++) {
			i += 2 * rl;

			if (i < 0)
				i += 12;
			
			if(i > 11)
				i -= 12;
			if(a[i] == 0)
				break;
			
			rs += a[i];
		}
		return rs;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int[] a = new int[n];
			int[] b = new int[n];

			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();

			int max = 0;
			
			 for(int i = 0; i < n; i++) {
				 if(a[i] == 0 || i == 5 || i == 11)
					 continue;
				 
				 for(int j = 0; j <n; j++)
					 b[j] = a[j];
				 
				 int countR = turn(b, i, 1);
				 
				 for(int j = 0; j <n; j++)
					 b[j] = a[j];
				 
				 int countL = turn(b, i, -1);
				 
				 int count = countL > countR ? countL: countR;
				 
				 max = max > count ? max : count;
				 
			 }
			 
			 System.out.println("#" + tc + " " + max);

		}
	}

}
