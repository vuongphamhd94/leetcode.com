package Easy;

public class MergeSortedArray {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i1 = m - 1;
		int i2 = n - 1;
		for (int i = nums1.length - 1; i >= 0; i--) {
			if (i1 < 0) {
				nums1[i] = nums2[i2--];
				continue;
			}
			
			if(i2 < 0) {
				nums1[i] = nums1[i1--];
				continue;
			}
			
			if(nums1[i1] > nums2[i2])
				nums1[i] = nums1[i1--];
			else
				nums1[i] = nums2[i2--];

		}
	}

	public static void main(String[] args) {
		int[] nums1 = new int[] { 1 };
		int[] nums2 = new int[] {};

		merge(nums1, 1, nums2, 0);
		for (int i : nums1)
			System.out.print(i + ", ");
	}
}
