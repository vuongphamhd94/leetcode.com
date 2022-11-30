package FSTDUP;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("input7.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int l = 1; l <= tc; l++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			
			for(int i = 0; i< n; i++) {
				arr[i] = sc.nextInt();
			}
			
			int number = arr[0];
			int kc = -1;
			
			for(int i = 0; i<n; i++)
				for(int j = i+1; j < n; j++) {
					if(arr[i] == arr[j]) {
						if(j-i < kc || kc == -1) {
							kc = j-i;
							number = arr[i];
						}
					}
				}
			
			if(kc == -1) {
				System.out.println("#" + l + " " + -1);
			}else {
				System.out.println("#" + l + " " + number);
			}
		}
	}
}
