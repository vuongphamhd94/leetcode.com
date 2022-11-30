package Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Demo {
	static int chot(int[] a, int l, int r) {
		int i = l - 1;
		for (int j = l; j < r; j++)
			if (a[j] > a[r]) {
				i++;
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}

		int temp = a[i + 1];
		a[i + 1] = a[r];
		a[r] = temp;

		return i + 1;
	}

	static void quickSort(int[] a, int l, int r) {
		if (l >= r)
			return;

		int m = chot(a, l, r);

		quickSort(a, l, m - 1);
		quickSort(a, m + 1, r);
	}

	static int Count(int[] a, int x, int l, int r) {
		if (l == r) {
			if (a[l] == x)
				return 1;
			else
				return 0;
		}

		int m = (r + l) / 2;
		return Count(a, x, l, m) + Count(a, x, m + 1, r);

	}
	
	 static String ConvertMd5(String srcText) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String enrText;
		MessageDigest msd = MessageDigest.getInstance("MD5");
		byte[] srcTextBytes = srcText.getBytes("UTF-8");
		byte[] enrTextBytes = msd.digest(srcTextBytes);
		BigInteger bigInt = new BigInteger(1, enrTextBytes);
		enrText = bigInt.toString(16);
		
		return enrText;
	}

	public static void main(String[] args) throws FileNotFoundException, NoSuchAlgorithmException, UnsupportedEncodingException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);

		System.out.println(ConvertMd5("123456"));
	}
}
