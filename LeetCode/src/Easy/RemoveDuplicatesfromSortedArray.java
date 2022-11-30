package Easy;

public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		
		int count = 1;
		int i = 0;
		int j = i +1;
		while(j < nums.length) {
			if(nums[i] < nums[j]) {
				count++;
				nums[i + 1] = nums[j];
				i++;
			}
			j++;
		}
		return count;
	}

	public static void main(String[] args) {
		RemoveDuplicatesfromSortedArray d = new RemoveDuplicatesfromSortedArray();
		int[] a = new int[] {1,2,3};
		int k = d.removeDuplicates(a);
		System.out.println("tong: " + k);
		for(int i = 0; i < k; i++) {
			System.out.println(a[i]);
		}
	}
}
