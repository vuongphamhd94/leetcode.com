package Easy;

public class ID11 {
	public static int maxArea(int[] height) {
		int Vmax = 0;
//		for (int i = 0; i < height.length; i++) {
//			int maxL = 0, maxR = 0;
//			int j;
//
//			for (j = 0; j < i; j++)
//				if (height[j] >= height[i])
//					break;
//
//			maxL = i - j;
//
//			for (j = height.length - 1; j > i; j--)
//				if (height[j] >= height[i])
//					break;
//
//			maxR = j - i;
//
//			int ViMax = maxL > maxR ? maxL * height[i] : maxR * height[i];
//
//			Vmax = Vmax >= ViMax ? Vmax : ViMax;
//		}

		int i = 0, j = height.length - 1;
		while (i < j) {
			int v = 0;
			if (height[i] > height[j]) {
				v = (j - i) * height[j--];
			} else
				v = (j - i) * height[i++];
			Vmax = Vmax > v ? Vmax : v;
		}

		return Vmax;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 1 };
		System.out.println(maxArea(a));
	}
}
