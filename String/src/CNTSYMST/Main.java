package CNTSYMST;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1 ; tc <= T; tc++) {
			String text = sc.next();
			int l = text.length();
			int count = 0;
			for(int i = 0; i < l; i++ )
				for(int j = 0; j < l - i; j++) {
					String rv = "";
					String subStr = text.substring(j, j + i +1);
					char[] arr = subStr.toCharArray();
					
					for(int k = i; k >= 0; k--)
						rv += arr[k];
					if(subStr.equals(rv))
						count++;
				}
			System.out.println("#" + tc + " " + count);
		}
		
	}

}
