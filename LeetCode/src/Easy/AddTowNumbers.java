package Easy;

public class AddTowNumbers {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int soDu = 0;
		ListNode rs = new ListNode(0);
		ListNode temp = rs;
		while (l1 != null || l2 != null || soDu != 0) {
			int sum = soDu;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}

			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}

			soDu = sum / 10;
			temp.next = new ListNode(sum % 10);
			temp = temp.next;
		}
		return rs.next;

	}

	public static void main(String[] args) {
		int[] arr1 = new int[] { 2, 4, 9 };
		int[] arr2 = new int[] { 5, 6, 4, 9 };

		ListNode a = new ListNode(arr1[0]);
		ListNode a1 = a;
		for (int i = 1; i < arr1.length; i++) {
			a1.next = new ListNode(arr1[i]);
			a1 = a1.next;
		}
		ListNode b = new ListNode(arr2[0]);
		ListNode b1 = b;
		for (int i = 1; i < arr2.length; i++) {
			b1.next = new ListNode(arr2[i]);
			b1 = b1.next;
		}

		ListNode rs = addTwoNumbers(a, b);
		while (rs != null) {
			System.out.println(rs.val);
			rs = rs.next;
		}
	}
}
