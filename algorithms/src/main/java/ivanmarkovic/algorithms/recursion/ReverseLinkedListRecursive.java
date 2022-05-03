package ivanmarkovic.algorithms.recursion;

public class ReverseLinkedListRecursive {
	
	class ListNode {
		int val;
		ListNode next;
	}
	
	public static ListNode reverse(ListNode head) {
		if(head == null)
			return null;
		else if (head.next == null) 
			return head;
		else {
			ListNode next = head.next;
			head.next = null;
			ListNode reversed = reverse(next);
			next.next = head;
			return reversed;
		}
	}

}
