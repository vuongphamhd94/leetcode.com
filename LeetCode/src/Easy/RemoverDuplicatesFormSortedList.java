package Easy;

public class RemoverDuplicatesFormSortedList {
	public static ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        ListNode current = head;
      
        while(current.next != null){
            if(current.val == current.next.val)
            	current.next= current.next.next;
            else
            	current = current.next;
        }

        return head;
    }
	
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		a.next = new ListNode(1);
		ListNode b = a.next;
		b.next = new ListNode(2);
		ListNode c = deleteDuplicates(a);
		
		while(c != null) {
			System.out.println(c.val);
			c=c.next;
		}
		
	}
}
