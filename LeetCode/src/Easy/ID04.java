package Easy;

public class ID04 {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;
		if(n+ m == 0)
			return 0; 
		
		int[] arrMerged = new int[n+m];
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < n + m) {
			if(j == n) {
				arrMerged[i++] = nums2[k++];
				continue;
			}
			
			if(k==m) {
				arrMerged[i++] = nums1[j++];
				continue;
			}
				
			arrMerged[i++] = nums1[j] >nums2[k]? nums2[k++]:nums1[j++];
		}
		
		if(n+ m == 1)
			return arrMerged[0];
		
		double rs = (n + m) %2 == 1? arrMerged[(n + m) /2] * 1.0 : 
			(arrMerged[(n + m) /2] + arrMerged[(n + m) /2 - 1] ) / 2.0;
		
		return rs;
		
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2 };
		int[] b = new int[] { 3, 4 };
		System.out.println(findMedianSortedArrays(a, b));
	}
}
