package Easy;

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		if (nums.length == 0)
			return 0;
		int count = 0;
		int i = -1;
		int j = i + 1;
		while (j < nums.length) {
			if (nums[j] != val) {
				nums[++i] = nums[j];
				count++;
			}
			j++;
		}
		return count;
	}

	public static void main(String[] args) {
		RemoveElement r = new RemoveElement();
		int[] a = new int[] { 0,1,2,2,3,0,4,2 };
		
		int k = r.removeElement(a, 2);
		
		System.out.println(k);
		for(int i = 0; i < k; i++) {
			System.out.print(a[i] + ", ");
		}
	}

}
