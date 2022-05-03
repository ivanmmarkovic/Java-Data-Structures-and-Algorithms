package ivanmarkovic.algorithms.recursion;

import java.util.Stack;

public class ReverseLinkedListIterativeStack {
	
	static class ListNode {
		int val;
		ListNode next;
	}
	
	public static ListNode reverse(ListNode head) {
		if(head == null || head.next == null)
			return head;
		Stack<ListNode> stack = new Stack<>();
		while (head != null) {
			stack.push(head);
			head = head.next;
		}
		
		ListNode node = new ListNode(), n = node;
		while (!stack.isEmpty()) {
			n.next = stack.peek();
			n = stack.pop();
		}
		n.next = null;
		return node.next;
		
	}

}
