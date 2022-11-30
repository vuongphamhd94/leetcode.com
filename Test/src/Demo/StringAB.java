package Demo;

import java.security.DomainCombiner;
import java.util.ArrayList;

public class StringAB {
	static ArrayList<String> a = new ArrayList<>();
	static ArrayList<String> b = new ArrayList<>();

	static String[] stringAB(int n, int k) {
		if(k == 0 || n < k)
			return new String[0];
		
		ArrayList<String> list = new ArrayList<>();
		String s = "";
		for (int i = 0; i < k; i++)
			s += "A";
		if(k == n) {
			String[] rs = {s};
			return rs;
		}
			
		for (int i = 0; i <= n - k; i++) {
			KTDau("", i, k);
			KTSau("", n - k - i, k);
			if (a.size() == 0) {
				for (String item2 : b)
					list.add(s + item2);
			} else
				for (String item1 : a)
					if (b.size() == 0)
						list.add(item1 + s);
					else
						for (String item2 : b)
							list.add(item1 + s + item2);

			a.clear();
			b.clear();
		}
		for (int i = 0; i < list.size() - 1; i++)
			for (int j = i + 1; j < list.size(); j++)
				if (list.get(i).compareTo(list.get(j)) > 0) {
					String item = list.get(i);
					list.set(i, list.get(j));
					list.set(j, item);
				}

		String[] rs = new String[list.size()];
		list.toArray(rs);
		return rs;
	}

	static void KTDau(String str, int n, int k) {
		if (n == 0)
			return;
		if (n == 1) {
			str = str + "B";
			a.add(str);
			return;
		} else {
			boolean c = false;
			if (str.length() < k - 1)
				c = true;
			else
				for (int i = str.length() - 1; i > str.length() - k; i--) {
					if (str.charAt(i) == 'B')
						c = true;
				}

			if (c) {
				KTDau(str + "A", n - 1, k);
				KTDau(str + "B", n - 1, k);
			} else
				KTDau(str + "B", n - 1, k);
		}
	}

	static void KTSau(String str, int n, int k) {
		if (n == 0)
			return;
		if (n == 1) {
			str = "B" + str;
			b.add(str);
			return;
		} else {
			boolean c = false;
			if (str.length() < k - 1)
				c = true;
			else
				for (int i = str.length() - 1; i > str.length() - k; i--) {
					if (str.charAt(i) == 'B')
						c = true;
				}

			if (c) {
				KTSau("A" + str, n - 1, k);
				KTSau("B" + str, n - 1, k);
			} else
				KTSau("B" + str, n - 1, k);
		}
	}

	public static void main(String[] args) {
		String[] l = new String[2];
		l = stringAB(0, 0);
		for (String item : l)
			System.out.printf("\"%s\" ",item);
		System.out.println("ket thuc");
	}
}
