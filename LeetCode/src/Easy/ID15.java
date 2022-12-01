package Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ID15 {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> rsL = new ArrayList<>();
		int count0 = 0;
		int index0 = 0;
		int countAm = 0;
		int lngNums = nums.length;
		

		for (int i = 0; i < lngNums - 1; i++) {
			for (int j = i + 1; j < lngNums; j++) {
				if (nums[j] < nums[i]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
		
		for(int i = 0; i < lngNums; i++) {
			if (nums[i] == 0) {
				count0++;
			}

			if (nums[i] < 0) {
				countAm++;
			}
		}
		index0 = countAm + count0;
		
		// nếu có 3 số bằng 0 thì add vào list
		if (count0 >= 3) {
			List<Integer> item = new ArrayList<>();
			item.add(0);
			item.add(0);
			item.add(0);
			rsL.add(item);
		}
		// trường hợp toàn số 0 hoặc không có số dương hoặc không có số âm
		if (count0 == lngNums || count0 + countAm == lngNums || countAm == 0) {

			return rsL;
		}
		// trường hợp có 1 số là số 0
		for (int i = 0; i < countAm; i++) {
			if (i != 0 && nums[i-1] == nums[i])
				continue;
			
			List<Integer> item = new ArrayList<>();
			item.add(0);
			item.add(0);
			item.add(0);
			
			item.set(0, nums[i]);
			for (int j = index0; j < lngNums && nums[j] + nums[i] <=0; j++)
				if (nums[i] == -nums[j]) {
					item.set(2, nums[j]);
					rsL.add(item);
					break;
				}
		}

		// Trường hợp có hai số dương
		for (int i = 0; i < countAm; i++) {
			if (i != 0 && nums[i-1] == nums[i])
				continue;
			
			List<Integer> item = new ArrayList<>();
			item.add(0);
			item.add(0);
			item.add(0);
			
			item.set(0, nums[i]);
			for (int j = index0; j < lngNums && nums[j] < -item.get(0); j++) {
				if (nums[j] == nums[j - 1])
					continue;

				item.set(1, nums[j]);
				for (int k = j + 1; k < lngNums && nums[k] <= -item.get(0) - item.get(1); k++)
					if (item.get(0) + item.get(1) == -nums[k]) {
						item.set(2, nums[k]);
						rsL.add(item);
						break;
					}
			}
		}
		// Trường hợp có hai số âm;
		for (int i = index0 ; i < lngNums; i++) {
			if (nums[i-1] == nums[i])
				continue;
			
			List<Integer> item = new ArrayList<>();
			item.add(0);
			item.add(0);
			item.add(0);
			item.set(2, nums[i]);
			for (int j = index0 - count0 -1; j >= 0 && -nums[j] < nums[i]; j--) {
				if (nums[j] == nums[j + 1])
					continue;

				item.set(1, nums[j]);
				for (int k = j - 1; j >= 0 && -nums[j] <= nums[i]; k--) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						item.set(0, nums[k]);
						rsL.add(item);
						break;
					}
				}
			}
		}
		return rsL;
	}

	public static void main(String[] args) {
		int[] a = new int[] {1,2,-2,-1 };
		List<List<Integer>> l = threeSum(a);
		for (List<Integer> i : l) {
			for (int k : i)
				System.out.print(k + " ");

			System.out.println();
		}
	}
}
