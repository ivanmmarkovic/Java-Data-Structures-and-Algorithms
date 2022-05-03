package ivanmarkovic.algorithms.recursion;


public class ReverseLinkedListIterative {
	
	class ListNode {
		int val;
		ListNode next;
	}
	
	public static ListNode reverse(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode next = head.next;
		head.next = null;
		while (true) {
			ListNode tmp = next.next;
			next.next = head;
			head = next;
			if(tmp == null)
				break;
			else {
				next = tmp;
			}
		}
		return next;
	}

}
