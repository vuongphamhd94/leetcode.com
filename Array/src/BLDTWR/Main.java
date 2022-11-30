package BLDTWR;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input8.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int m1 = sc.nextInt();
			int m2 = sc.nextInt();
			int[] arr = new int[n];
			
			int max = Math.max(m1, m2);
			int min = Math.min(m1, m2);
			
			int sum = 0;
			int item;
			
			for(int i = 0; i< n ; i++)
				arr[i] = sc.nextInt();
			
			for(int i = 0 ; i < n; i++)
				for(int j = i+1; j< n; j++) {
					if(arr[i] > arr[j]) {
						item = arr[i];
						arr[i] = arr[j];
						arr[j] = item;
					}
				}
			
			for(int i = max; i > min; i--)
				sum += i * arr[max - i] ;
			
			for(int i = min; i >= 1 ; i--)
				sum += i*(arr[2*(min -i) + max -min] + arr[2*(min -i) + 1+ max -min]);
			
			System.out.println("#" + tc + " " + sum);
		}
		
	}

}
